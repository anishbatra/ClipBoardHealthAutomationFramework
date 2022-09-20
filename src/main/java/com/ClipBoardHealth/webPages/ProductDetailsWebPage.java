package com.ClipBoardHealth.webPages;

import com.ClipBoardHealth.Base.BaseClass;
import com.ClipBoardHealth.utilities.Helpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsWebPage extends BaseClass {

    @FindBy(how = How.XPATH, using = "//ul[@class='a-unordered-list a-vertical a-spacing-mini']//span")
    List<WebElement> aboutItemDetails;

    public ProductDetailsWebPage() {
        PageFactory.initElements(driver, this);
    }

    public void getProductDetails(String brandName) {
        Helpers.switchWindow(2);
        Assert.assertTrue(driver.getCurrentUrl().contains(brandName), "User is viewing Product in another window");
        List<String> productDetails = new ArrayList<>();
        for (int i = 0; i < aboutItemDetails.size(); i++) {
            productDetails.add(aboutItemDetails.get(i).getText());
        }
        logger.info(productDetails);
    }
}


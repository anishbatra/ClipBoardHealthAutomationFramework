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

public class ProductPage extends BaseClass {


    @FindBy(how = How.XPATH, using = "//span[contains(@class,'browse-refinements-indent')]")
    List<WebElement> selectedProduct;

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Brands']/parent::div/following-sibling::ul//a/span")
    List<WebElement> brandNamesList;
    @FindBy(how = How.XPATH, using = "//div[@id='brandsRefinements']//li[@class='a-spacing-micro s-list-item']/following-sibling::li[1]//a/span")
    WebElement selectedBrandName;
    @FindBy(how = How.XPATH, using = "//select[@id='s-result-sort-select']")
    WebElement filterDropdown;

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Sort by:']/following-sibling::span")
    WebElement filteredValue;

    @FindBy(how = How.XPATH, using = "//span[@class='a-price']//span[@class='a-price-symbol']/following-sibling::span")
    List<WebElement> productPricesList;

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public void productPageVisibilityValidation(String product) {
        for (int i = 0; i < selectedProduct.size(); i++) {
            if (selectedProduct.get(i).getText().contains(product)) {
                Assert.assertTrue(true);
                break;
            }
        }
    }


    public void getAndClickOnProductBrandName(String brand) {
        for (int i = 0; i < brandNamesList.size(); i++) {
            if (brandNamesList.get(i).getText().equalsIgnoreCase(brand)) {
                Helpers.clickOn(driver, brandNamesList.get(i), Helpers.EXPLICIT_WAIT);
                Assert.assertTrue(selectedBrandName.getText().equalsIgnoreCase(brand));
                break;
            }

        }
    }

    public void filterProducts(String filterOption) {
        Helpers.selectTextFromDropDown(filterDropdown, filterOption, Helpers.EXPLICIT_WAIT);
        Assert.assertTrue(Helpers.isElementDisplayed(driver, filteredValue, Helpers.EXPLICIT_WAIT));
        Assert.assertTrue(filteredValue.getText().contains(filterOption));

    }

    public void getAndClickOnProductAfterFiltering(int productPlaceValue) {
        List<WebElement> webElements = new ArrayList<WebElement>();
        for (int i = 0; i < productPricesList.size(); i++) {
            WebElement priceValue = productPricesList.get(i);
            //adding prices to web elements list
            webElements.add(priceValue);
        }
        for (int i = 0; i < webElements.size(); i++) {
            if (i == productPlaceValue - 1) {
                // String selectedItemPrice = list.get(i).getText();
                webElements.get(i).click();
                break;
            }
        }

    }
}

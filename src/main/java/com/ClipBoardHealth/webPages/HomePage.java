package com.ClipBoardHealth.webPages;

import com.ClipBoardHealth.Base.BaseClass;
import com.ClipBoardHealth.utilities.Helpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class HomePage extends BaseClass {


    @FindBy(how = How.XPATH, using = "//a[@aria-label='Open Menu']")
    WebElement hamBurgerAllLink;
    @FindBy(how = How.XPATH, using = "//div[@id='hmenu-customer-profile-right']//b[contains(normalize-space(),'Hello')]")
    WebElement welcomeProfileText;

    @FindBy(how = How.CLASS_NAME, using = "hmenu-item")
    List<WebElement> departmentItems;

    @FindBy(how = How.XPATH, using = "//ul[@class='hmenu hmenu-visible hmenu-translateX']//div[normalize-space()='main menu']")
    WebElement mainMenuHeaderText;

    @FindBy(how = How.XPATH, using = "//a[@aria-label='Back to main menu']/ancestor::ul[@class='hmenu hmenu-visible hmenu-translateX']/li/a")
    List<WebElement> products;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    public void HomePageTitleValidation() {

        Assert.assertEquals(driver.getTitle(), inputData.homePageTitle, "Home Page Title Verified");
        logger.info("Home Page Title Verified");

    }


    public void ClicksOnHamBurgerMenuOnHomePage() {
        Helpers.clickOn(driver, hamBurgerAllLink, Helpers.EXPLICIT_WAIT);
        Assert.assertTrue(Helpers.isElementDisplayed(driver, welcomeProfileText, Helpers.EXPLICIT_WAIT), "HamBurger Menu is clicked");


    }

    public void clickOnDepartmentItemUnderShopByDepartment(String departmentMenuItem) {

        for (int i = 0; i < departmentItems.size(); i++) {
            if (departmentItems.get(i).getText().contains(departmentMenuItem)
                    || departmentItems.get(i).getText().equalsIgnoreCase(departmentMenuItem)) {
                Helpers.clickOn(driver, departmentItems.get(i), Helpers.EXPLICIT_WAIT);
                Assert.assertTrue(Helpers.isElementDisplayed(driver, mainMenuHeaderText, Helpers.EXPLICIT_WAIT));
                break;
            }

        }
    }

    public void clickOnProduct(String product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().contains(product)) {
                Helpers.clickOn(driver, products.get(i), Helpers.EXPLICIT_WAIT);
                break;
            }
        }
    }


}

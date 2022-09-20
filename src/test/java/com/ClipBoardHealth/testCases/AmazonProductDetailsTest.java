package com.ClipBoardHealth.testCases;

import com.ClipBoardHealth.Base.BaseClass;
import com.ClipBoardHealth.pages.AllPageObjects;
import com.ClipBoardHealth.utilities.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AmazonProductDetailsTest extends BaseClass {

    public AllPageObjects allPageObjects;

    @Test(priority = 1)
    public void verifyAmazonHomePageTitleTest() {
        allPageObjects = new AllPageObjects();
        allPageObjects.homePage.HomePageTitleValidation();


    }

    @Test(priority = 2)
    public void clickOnHamBurgerLinkTest() {
        allPageObjects = new AllPageObjects();
        allPageObjects.homePage.ClicksOnHamBurgerMenuOnHomePage();


    }


    @Test(dataProvider = "readExcelData", priority = 3)
    public void getProductDetailsTest(String productCategory, String product, String productBrandName, String filterOption) {
        allPageObjects = new AllPageObjects();
        allPageObjects.homePage.clickOnDepartmentItemUnderShopByDepartment(productCategory);
        allPageObjects.homePage.clickOnProduct(product);
        allPageObjects.differentProductsPage.productPageVisibilityValidation(product);
        allPageObjects.differentProductsPage.getAndClickOnProductBrandName(productBrandName);
        allPageObjects.differentProductsPage.filterProducts(filterOption);
        allPageObjects.differentProductsPage.getAndClickOnProductAfterFiltering(2);
        allPageObjects.listOfProductsPage.getProductDetails(productBrandName);


    }

    /**
     * Data Provider to read data and assign
     * them to 2D Object Array
     */
    @DataProvider
    public Object[][] readExcelData() throws IOException {
        String sheetName = "TestData";
        Object data[][] = XLUtils.getTestData(sheetName);
        return data;
    }
}

package com.ClipBoardHealth.pages;

import com.ClipBoardHealth.webPages.ProductPage;
import com.ClipBoardHealth.webPages.HomePage;
import com.ClipBoardHealth.webPages.ProductDetailsWebPage;

public class AllPageObjects {
    public HomePage homePage;
    public ProductDetailsWebPage listOfProductsPage;

    public ProductPage differentProductsPage;

    public AllPageObjects() {
        homePage = new HomePage();
        listOfProductsPage = new ProductDetailsWebPage();
        differentProductsPage = new ProductPage();
    }
}

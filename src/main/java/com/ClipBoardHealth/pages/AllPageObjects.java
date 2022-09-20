package com.ClipBoardHealth.pages;

import com.ClipBoardHealth.webPages.HomePage;
import com.ClipBoardHealth.webPages.ProductDetailsPage;
import com.ClipBoardHealth.webPages.ProductPage;

public class AllPageObjects {
    public HomePage homePage;
    public ProductDetailsPage listOfProductsPage;

    public ProductPage differentProductsPage;

    public AllPageObjects() {
        homePage = new HomePage();
        listOfProductsPage = new ProductDetailsPage();
        differentProductsPage = new ProductPage();
    }
}

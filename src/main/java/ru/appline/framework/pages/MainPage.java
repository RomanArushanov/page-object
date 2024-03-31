package ru.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//h1[text()='Панель быстрого запуска']")
    private WebElement mainPageTitle;

    @FindBy(xpath = "//ul[contains(@class,'main-menu')]/li/a/span[@class='title' and text()='Расходы']")
    private WebElement costsButton;

    @FindBy(xpath = "//span[text()='Командировки']")
    private WebElement businessTripsButton;

    private final String costsListDropDownMenu = "./ancestor::li//ul[@class='dropdown-menu menu_level_1']";

    public MainPage checkMainPageTitle() {
        Assertions.assertTrue(mainPageTitle.isDisplayed(), "На странице отсутствует заголовок 'Панель быстрого запуска'");
        return this;
    }

    public BusinessTrips selectBusinessTripModuleInCostsBlock() {
        waitUtilElementToBeClickable(costsButton).click();
        waitUtilElementToBeVisible(costsButton.findElement(By.xpath(costsListDropDownMenu)));
        waitUtilElementToBeClickable(businessTripsButton).click();
        checkLoadingWindow();
        return pageManager.getBusinessTrips();
    }
}

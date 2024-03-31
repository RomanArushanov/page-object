package ru.appline.framework.managers;

import org.junit.jupiter.api.condition.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.appline.framework.utils.constants.PropertiesConstants.PATH_CHROME_DRIVER_MAC;
import static ru.appline.framework.utils.constants.PropertiesConstants.PATH_CHROME_DRIVER_WINDOWS;

public class DriverManager {

    private WebDriver driver;

    private static DriverManager INSTANCE = null;

    private final PropertiesManager properties = PropertiesManager.getPropertyManager();

    private DriverManager() {
    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private String os() {
        return OS.current().name();
    }

    private void initDriver() {
        String osName = OS.current().name();
        if (osName.equals("WINDOWS")) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty(PATH_CHROME_DRIVER_WINDOWS));
        } else {
            System.setProperty("webdriver.chrome.driver", properties.getProperty(PATH_CHROME_DRIVER_MAC));
        }
        driver = new ChromeDriver();
    }
}
package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.PageOfRegistrationForm;
import guru.qa.utils.FinalActivitiesForReport;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBaseIncludingBeforeAndAfterTests {

    PageOfRegistrationForm pageOfRegistrationForm = new PageOfRegistrationForm();
    DataForTheTest dataForTheTest = new DataForTheTest();

    @BeforeAll
    static void beforeAllTests() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("Allure", new AllureSelenide());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }

    @AfterAll
    static void afterAllTests() {
        FinalActivitiesForReport.attachScreenshot();
        FinalActivitiesForReport.addVideo();
    }
}
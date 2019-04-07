package automationpractice.page;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static automationpractice.data.Url.CONTACT_US_PAGE;
import static automationpractice.data.generator.RandomDataGenerator.getEmail;
import static automationpractice.data.generator.RandomDataGenerator.getRandomNumber;
import static automationpractice.data.generator.RandomDataGenerator.getRandomText;
import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ContactUsPage {
    private static final String SUCCESS_ALERT = "Your message has been successfully sent to our team.";

    public static void sendContactMessage(WebDriver driver) {
        driver.get(CONTACT_US_PAGE.getUrl());

        selectSubjectHeading(driver);

        enterEmail(driver);

        enterOrderReference(driver);

        enterMessage(driver);

        sendMessage(driver);

        validateAlertBanner(driver);
    }

    private static void selectSubjectHeading(WebDriver driver) {
        WebElement subjectHeadingDropdown = driver.findElement(By.id(ElementLocator.SUBJECT_HEADING_DROPDOWN_ID.getLocator()));
        subjectHeadingDropdown.sendKeys("Customer service");
        subjectHeadingDropdown.sendKeys(Keys.RETURN);
    }

    private static void enterEmail(WebDriver driver) {
        WebElement emailAddressField = driver.findElement(By.id(ElementLocator.EMAIL_ADDRESS_FIELD_ID.getLocator()));
        emailAddressField.sendKeys(getEmail());
    }

    private static void enterOrderReference(WebDriver driver) {
        WebElement orderReferenceField = driver.findElement(By.id(ElementLocator.ORDER_REFERENCE_FIELD_ID.getLocator()));
        orderReferenceField.sendKeys(String.valueOf(getRandomNumber(100000, 999999)));
    }

    private static void enterMessage(WebDriver driver) {
        WebElement messageField = driver.findElement(By.id(ElementLocator.MESSAGE_FIELD_ID.getLocator()));
        messageField.sendKeys(getRandomText());
    }

    private static void sendMessage(WebDriver driver) {
        WebElement sendMessageButton = driver.findElement(By.id(ElementLocator.SEND_MESSAGE_BUTTON_ID.getLocator()));
        sendMessageButton.click();
    }

    private static void validateAlertBanner(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement alertBanner = wait.until(visibilityOfElementLocated(By.className(ElementLocator.ALERT_BANNER_CLASS.getLocator())));
        assertEquals(SUCCESS_ALERT, alertBanner.getText());
    }

    @Getter
    @RequiredArgsConstructor(access = PRIVATE)
    private enum ElementLocator {
        SUBJECT_HEADING_DROPDOWN_ID("id_contact"),
        EMAIL_ADDRESS_FIELD_ID("email"),
        ORDER_REFERENCE_FIELD_ID("id_order"),
        MESSAGE_FIELD_ID("message"),
        SEND_MESSAGE_BUTTON_ID("submitMessage"),
        ALERT_BANNER_CLASS("alert");

        private final String locator;
    }
}

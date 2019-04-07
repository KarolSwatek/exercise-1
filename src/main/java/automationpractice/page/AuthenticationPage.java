package automationpractice.page;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static automationpractice.data.Url.AUTHENTICATION_PAGE;
import static automationpractice.data.Url.CREATE_ACCOUNT_PAGE;
import static automationpractice.data.Url.MY_ACCOUNT_PAGE;
import static lombok.AccessLevel.PRIVATE;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class AuthenticationPage {
    public static void initiateRegistration(WebDriver driver, String email) {
        driver.get(AUTHENTICATION_PAGE.getUrl());

        enterEmailAddressOfNewUser(driver, email);

        confirmCreatingAccount(driver);

        verifyRedirectToCreateAccountPage(driver);
    }

    public static void signIn(WebDriver driver, String email, String password) {
        driver.get(AUTHENTICATION_PAGE.getUrl());

        enterEmailAddressOfRegisteredUser(driver, email);

        enterPassword(driver, password);

        confirmSigningIn(driver);

        verifyRedirectToMyAccountPage(driver);
    }

    private static void enterEmailAddressOfNewUser(WebDriver driver, String email) {
        WebElement emailAddressField = driver.findElement(By.id(ElementId.NEW_USER_EMAIL_ADDRESS_FIELD.getId()));
        emailAddressField.sendKeys(email);
    }

    private static void confirmCreatingAccount(WebDriver driver) {
        WebElement createAccountButton = driver.findElement(By.id(ElementId.CREATE_ACCOUNT_BUTTON.getId()));
        createAccountButton.click();
    }

    private static void verifyRedirectToCreateAccountPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(urlToBe(CREATE_ACCOUNT_PAGE.getUrl()));
    }

    private static void enterEmailAddressOfRegisteredUser(WebDriver driver, String email) {
        WebElement emailAddressField = driver.findElement(By.id(ElementId.REGISTERED_USER_EMAIL_ADDRESS_FIELD.getId()));
        emailAddressField.sendKeys(email);
    }

    private static void enterPassword(WebDriver driver, String password) {
        WebElement emailAddressField = driver.findElement(By.id(ElementId.PASSWORD_FIELD.getId()));
        emailAddressField.sendKeys(password);
    }

    private static void confirmSigningIn(WebDriver driver) {
        WebElement signInButton = driver.findElement(By.id(ElementId.SIGN_IN_BUTTON.getId()));
        signInButton.click();
    }

    private static void verifyRedirectToMyAccountPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(urlToBe(MY_ACCOUNT_PAGE.getUrl()));
    }

    @Getter
    @RequiredArgsConstructor(access = PRIVATE)
    private enum ElementId {
        CREATE_ACCOUNT_BUTTON("SubmitCreate"),
        NEW_USER_EMAIL_ADDRESS_FIELD("email_create"),
        PASSWORD_FIELD("passwd"),
        REGISTERED_USER_EMAIL_ADDRESS_FIELD("email"),
        SIGN_IN_BUTTON("SubmitLogin");

        private final String id;
    }
}

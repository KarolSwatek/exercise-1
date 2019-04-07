package automationpractice.page;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

import static automationpractice.data.Url.MY_ACCOUNT_PAGE;
import static automationpractice.data.generator.RandomDataGenerator.getFirstName;
import static automationpractice.data.generator.RandomDataGenerator.getLastName;
import static automationpractice.data.generator.RandomDataGenerator.getMobilePhone;
import static automationpractice.data.generator.RandomDataGenerator.getPassword;
import static automationpractice.data.generator.RandomDataGenerator.getRandomNumber;
import static automationpractice.data.generator.RandomUsAddressGenerator.getCity;
import static automationpractice.data.generator.RandomUsAddressGenerator.getFullAddress;
import static automationpractice.data.generator.RandomUsAddressGenerator.getState;
import static automationpractice.data.generator.RandomUsAddressGenerator.getZipCode;
import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class CrateAccountPage {
    private static final String DEFAULT_ADDRESS_ALIAS = "My address";
    private static final String DEFAULT_COUNTRY = "United States";

    public static void submitPersonalInformation(WebDriver driver, String email) {
        String firstName = getFirstName();
        String lastName = getLastName();
        LocalDate birthDate = LocalDate.now().minusYears(getRandomNumber(18, 70));

        selectGender(driver);

        submitFirstName(driver, firstName);

        submitLastName(driver, lastName);

        verifyEmailAddressAutocomplete(driver, email);

        submitPassword(driver);

        selectDayOfBirth(driver, birthDate);

        selectMonthOfBirth(driver, birthDate);

        selectYearOfBirth(driver, birthDate);

        verifyAddressFirstNameAutocomplete(driver, firstName);

        verifyAddressLastNameAutocomplete(driver, lastName);

        submitAddress(driver);

        submitCity(driver);

        selectState(driver);

        submitPostalCode(driver);

        verifyDefaultCountry(driver);

        submitMobilePhone(driver);

        verifyDefaultAddressAlias(driver);

        registerAccount(driver);

        verifyRedirectToMyAccountPage(driver);
    }

    private static void selectGender(WebDriver driver) {
        WebElement genderMaleRadioButton = driver.findElement(By.id(ElementId.GENDER_MALE_RADIO_BUTTON.getId()));
        genderMaleRadioButton.click();
    }

    private static void submitFirstName(WebDriver driver, String firstName) {
        WebElement firstNameField = driver.findElement(By.id(ElementId.FIRST_NAME_FIELD.getId()));
        firstNameField.sendKeys(firstName);
    }

    private static void submitLastName(WebDriver driver, String lastName) {
        WebElement lastNameField = driver.findElement(By.id(ElementId.LAST_NAME_FIELD.getId()));
        lastNameField.sendKeys(lastName);
    }

    private static void verifyEmailAddressAutocomplete(WebDriver driver, String email) {
        WebElement emailAddressField = driver.findElement(By.id(ElementId.EMAIL_ADDRESS_FIELD.getId()));
        assertEquals(email, emailAddressField.getAttribute("value"));
    }

    private static void submitPassword(WebDriver driver) {
        WebElement passwordField = driver.findElement(By.id(ElementId.PASSWORD_FIELD.getId()));
        passwordField.sendKeys(getPassword());
    }

    private static void selectDayOfBirth(WebDriver driver, LocalDate birthDate) {
        WebElement dayOfBirthDropdown = driver.findElement(By.id(ElementId.DAY_OF_BIRTH_DROPDOWN.getId()));
        dayOfBirthDropdown.sendKeys(String.valueOf(birthDate.getDayOfMonth()));
        dayOfBirthDropdown.sendKeys(Keys.RETURN);
    }

    private static void selectMonthOfBirth(WebDriver driver, LocalDate birthDate) {
        WebElement monthOfBirthDropdown = driver.findElement(By.id(ElementId.MONTH_OF_BIRTH_DROPDOWN.getId()));
        monthOfBirthDropdown.sendKeys(String.valueOf(birthDate.getMonth()));
        monthOfBirthDropdown.sendKeys(Keys.RETURN);
    }

    private static void selectYearOfBirth(WebDriver driver, LocalDate birthDate) {
        WebElement yearOfBirthDropdown = driver.findElement(By.id(ElementId.YEAR_OF_BIRTH_DROPDOWN.getId()));
        yearOfBirthDropdown.sendKeys(String.valueOf(birthDate.getYear()));
        yearOfBirthDropdown.sendKeys(Keys.RETURN);
    }

    private static void verifyAddressFirstNameAutocomplete(WebDriver driver, String firstName) {
        WebElement addressFirstNameField = driver.findElement(By.id(ElementId.ADDRESS_FIRST_NAME_FIELD.getId()));
        assertEquals(firstName, addressFirstNameField.getAttribute("value"));
    }

    private static void verifyAddressLastNameAutocomplete(WebDriver driver, String lastName) {
        WebElement addressLastNameField = driver.findElement(By.id(ElementId.ADDRESS_LAST_NAME_FIELD.getId()));
        assertEquals(lastName, addressLastNameField.getAttribute("value"));
    }

    private static void submitAddress(WebDriver driver) {
        WebElement addressField = driver.findElement(By.id(ElementId.ADDRESS_FIELD.getId()));
        addressField.sendKeys(getFullAddress());
    }

    private static void submitCity(WebDriver driver) {
        WebElement cityField = driver.findElement(By.id(ElementId.CITY_FIELD.getId()));
        cityField.sendKeys(getCity());
    }

    private static void selectState(WebDriver driver) {
        WebElement stateDropdown = driver.findElement(By.id(ElementId.STATE_DROPDOWN.getId()));
        stateDropdown.sendKeys(getState());
        stateDropdown.sendKeys(Keys.RETURN);
    }

    private static void submitPostalCode(WebDriver driver) {
        WebElement postalCodeField = driver.findElement(By.id(ElementId.POSTAL_CODE_FIELD.getId()));
        postalCodeField.sendKeys(getZipCode());
    }

    private static void verifyDefaultCountry(WebDriver driver) {
        WebElement countryDropdown = driver.findElement(By.id(ElementId.COUNTRY_DROPDOWN.getId()));
        Select countrySelect = new Select(countryDropdown);
        assertEquals(DEFAULT_COUNTRY, countrySelect.getFirstSelectedOption().getText());
    }

    private static void submitMobilePhone(WebDriver driver) {
        WebElement mobilePhoneField = driver.findElement(By.id(ElementId.MOBILE_PHONE_FIELD.getId()));
        mobilePhoneField.sendKeys(getMobilePhone());
    }

    private static void verifyDefaultAddressAlias(WebDriver driver) {
        WebElement addressAliasField = driver.findElement(By.id(ElementId.ADDRESS_ALIAS_FIELD.getId()));
        assertEquals(DEFAULT_ADDRESS_ALIAS, addressAliasField.getAttribute("value"));
    }

    private static void registerAccount(WebDriver driver) {
        WebElement registerButton = driver.findElement(By.id(ElementId.REGISTER_BUTTON_FIELD.getId()));
        registerButton.click();
    }

    private static void verifyRedirectToMyAccountPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(urlToBe(MY_ACCOUNT_PAGE.getUrl()));
    }

    @Getter
    @RequiredArgsConstructor(access = PRIVATE)
    private enum ElementId {
        ADDRESS_ALIAS_FIELD("alias"),
        ADDRESS_FIELD("address1"),
        ADDRESS_FIRST_NAME_FIELD("firstname"),
        ADDRESS_LAST_NAME_FIELD("lastname"),
        CITY_FIELD("city"),
        COUNTRY_DROPDOWN("id_country"),
        DAY_OF_BIRTH_DROPDOWN("days"),
        EMAIL_ADDRESS_FIELD("email"),
        FIRST_NAME_FIELD("customer_firstname"),
        GENDER_MALE_RADIO_BUTTON("uniform-id_gender1"),
        LAST_NAME_FIELD("customer_lastname"),
        MOBILE_PHONE_FIELD("phone_mobile"),
        MONTH_OF_BIRTH_DROPDOWN("months"),
        PASSWORD_FIELD("passwd"),
        POSTAL_CODE_FIELD("postcode"),
        REGISTER_BUTTON_FIELD("submitAccount"),
        STATE_DROPDOWN("id_state"),
        YEAR_OF_BIRTH_DROPDOWN("years");

        private final String id;
    }
}

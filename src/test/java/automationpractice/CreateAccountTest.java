package automationpractice;

import automationpractice.page.AuthenticationPage;
import automationpractice.page.CrateAccountPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static automationpractice.data.generator.RandomDataGenerator.getEmail;

public class CreateAccountTest extends BaseTest {

    @Test
    public void createAccount() {
        String email = getEmail();

        WebDriver driver = new ChromeDriver();

        AuthenticationPage.initiateRegistration(driver, email);

        CrateAccountPage.submitPersonalInformation(driver, email);

        driver.quit();
    }
}

package automationpractice;

import automationpractice.page.AuthenticationPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static automationpractice.data.User.USER;

public class SignInTest extends BaseTest {

    @Test
    public void signIn() {
        WebDriver driver = new ChromeDriver();

        AuthenticationPage.signIn(driver, USER.getEmail(), USER.getPassword());

        driver.quit();
    }
}

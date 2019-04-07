package automationpractice;

import automationpractice.page.ContactUsPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendContactMessageTest extends BaseTest {

    @Test
    public void sendContactMessage() {
        WebDriver driver = new ChromeDriver();

        ContactUsPage.sendContactMessage(driver);

        driver.quit();
    }
}

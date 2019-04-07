package automationpractice;

import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void preconditions() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sg0223910\\Downloads\\installation_files\\chromedriver_win32\\chromedriver.exe");
    }

    public static void main(String[] args) {

    }
}

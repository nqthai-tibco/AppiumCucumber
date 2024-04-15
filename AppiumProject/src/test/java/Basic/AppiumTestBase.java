package Basic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTestBase {
    public static AppiumDriver driver;
    public static AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File(System.getenv("APPIUM") + "\\main.js"))
            .withIPAddress("127.0.0.1").usingPort(4723).withArgument(() -> "--base-path", "/wd/hub").build();

    //    @Before
    public static void setup() throws MalformedURLException {
        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File(System.getenv("APPIUM") + "\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).withArgument(() -> "--base-path", "/wd/hub").build();
        service.start();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("automationName", "uiautomator2");
//        Path currentWorkingDir = Paths.get("").toAbsolutePath();
//        capabilities.setCapability("enableMultiWindows", true);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "fitness.online.app");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "fitness.online.app.activity.login.LoginActivity");
        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void tearDown() {
        // Quit the Appium driver
        if (driver != null) {
            driver.quit();
            service.stop();
        }
    }

    public WebElement getElementByXpath(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    public void waitAbit(int miniSeconds) {
        try {
            Thread.sleep(miniSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

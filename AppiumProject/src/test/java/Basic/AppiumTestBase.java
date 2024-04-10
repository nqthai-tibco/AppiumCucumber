package Basic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTestBase {
    protected static AppiumDriver  driver;

    @Before
    public static void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        Path currentWorkingDir = Paths.get("").toAbsolutePath();
        capabilities.setCapability("enableMultiWindows", true);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.apps.docs");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.docs.drive.startup.StartupActivity");
        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void tearDown() {
        // Quit the Appium driver
        if (driver != null) {
            driver.quit();
        }
    }

    WebElement getElementByXpath(String xPath) {
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

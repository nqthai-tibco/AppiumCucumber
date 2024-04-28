package Basic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTestBase {
    public static AppiumDriver driver;

    //    @Before
    public static AppiumDriver setup(String deviceName, String udid, String port, String APP_PACKAGE, String APP_ACTIVITY) throws MalformedURLException {
//        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File(System.getenv("APPIUM") + "\\main.js"))
//                .withIPAddress("127.0.0.1").usingPort(4723).withArgument(() -> "--base-path", "/wd/hub").build();
//        service.start();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("deviceName",deviceName);
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("udid",udid);
        capabilities.setCapability("chromedriverExecutable","D:\\AppiumCucumber\\AppiumProject\\src\\test\\resources\\App\\chromedriver.exe");

//        Path currentWorkingDir = Paths.get("").toAbsolutePath();
//        capabilities.setCapability("enableMultiWindows", true);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
        driver = new AppiumDriver(new URL("http://localhost:"+port+"/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public void tearDown() {
        // Quit the Appium driver
        if (driver != null) {
            driver.quit();
//            service.stop();
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

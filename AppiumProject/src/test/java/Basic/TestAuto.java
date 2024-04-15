package Basic;

import io.appium.java_client.AppiumDriver;
import org.junit.Test;
import pages.Common;

import java.net.MalformedURLException;
import java.util.Set;

public class TestAuto {

    Common common = new Common();

    @Test
    public void getColor() throws MalformedURLException {
        AppiumTestBase.setup();
//        common.getElementByXpath("//android.widget.FrameLayout[@content-desc='Search']").click();
        common.waitAbit(4000);
        Set<String> contextNames = AppiumTestBase.driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);

            if (contextName.contains("WEB"))
                AppiumTestBase.driver.context(contextName);

        }


        common.getElementByText("Sign in").getCssValue("color");

    }

    public static void changeDriverContextToWeb(AppiumDriver driver) {
        Set<String> allContext = driver.getContextHandles();
        for (String context : allContext) {
            if (context.contains("WEBVIEW")) driver.context(context);
        }
    }

}

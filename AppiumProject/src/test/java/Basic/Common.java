package Basic;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Common extends AppiumTestBase {
    String prefix_ID = "fitness.online.app:id/";
    private static final double randomNumber = Math.random();
    public String emailRegister = "test_" + String.valueOf(randomNumber).split("0.")[1] + "@test.com";

    public WebElement verticalToElementWithText(String text) {
        WebElement element = null;
        if (!waitForTextVisible(text)) {
            String selectorString = String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + text + "\"))");
            element = driver.findElement(MobileBy.AndroidUIAutomator(selectorString));

        } else
            element = getElementByText(text);
        return element;
    }

    public WebElement horizontallyToElementWithText(String text) {
        WebElement element = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                + ".setAsHorizontalList().scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
        System.out.println(element.getText());
        return element;

    }

    public void clickElementByText(String text) {
        WebElement element = verticalToElementWithText(text);
        element.click();
    }

    public void clickButton(String text) {
        verticalToElementWithText(text);
        String xPathButton = "//*[@class='android.widget.Button' and @text='" + text + "']";
        WebElement elementButton = getElementByXpath(xPathButton);
        waitAbit(500);
        elementButton.click();
    }

    public void clickElementByID(String id) {
        getElementByXpath("//*[@resource-id='" + prefix_ID + id + "']").click();
    }

    public void verifyPageLoaded(String pageLoader) {
        boolean checkPageLoader = false;
        String[] pageLoaders = pageLoader.split(">");
        String xPathHeaderPage = "//*[@resource-id='" + prefix_ID + "toolbar']//*[@class='android.widget.TextView']";
        WebElement elmHeaderpage = driver.findElement(By.xpath(xPathHeaderPage));
        String headerText = elmHeaderpage.getText();
        for (String s : pageLoaders)
            if (headerText.equals(s)) {
                checkPageLoader = true;
                break;
            }
        Assert.assertTrue(checkPageLoader);
    }

    public void inputValueById(String id, String value) {
        String xPathInput = "//*[@resource-id='" + prefix_ID + id + "']";
        getElementByXpath(xPathInput).sendKeys(value);
    }

    public String getContentMessage() {
        String message = getElementByXpath("//*[@resource-id='android:id/message']").getText().replace("\n", " ");
        System.out.println(message);
        return message;
    }

    public String getTextByID(String id) {

        String xPathElement = "//*[@resource-id='" + prefix_ID + id + "']";
        return getElementByXpath(xPathElement).getText();
    }

    public MobileElement getElementByText(String text) {
        return (MobileElement) getElementByXpath("//*[@text='" + text + "']");
    }

    public boolean waitForTextVisible(String text) {
        String[] texts = text.split(">");
        boolean isPresent = false;
        for (String s : texts) {
            isPresent = driver.findElements(By.xpath("//*[contains(@text,'" + s + "')]")).isEmpty();
            if (!isPresent) {
                System.out.println(s);
                break;
            }
        }
        return !isPresent;
    }

    public void selectNumberPicker(String picker, int numberToSelect) {

        String idParentPicker = prefix_ID + picker;
        String xpTahParentPicker = "//*[@resource-id='" + idParentPicker + "']";
        while (numberToSelect < Integer.parseInt(getElementByXpath(xpTahParentPicker + "//*[@class='android.widget.EditText']").getText())) {
            getElementByXpath(xpTahParentPicker + "//*[@class='android.widget.Button']").click();
        }
        while (numberToSelect > Integer.parseInt(getElementByXpath(xpTahParentPicker + "//*[@class='android.widget.EditText']").getText())) {
            getElementByXpath(xpTahParentPicker + "//*[@class='android.widget.Button'][2]").click();
        }

    }

    public void dragAndDrop(WebElement element) {
        TouchAction touchAction = new TouchAction(driver);
        int cx = element.getRect().getX();
        int cy = element.getRect().getY();
        int width = element.getSize().getWidth();
        System.out.println(cx + "   " + cy + "  " + width);
        touchAction.press(PointOption.point(cx, cy)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(cx + cx + width, cy)).release().perform();


    }
}

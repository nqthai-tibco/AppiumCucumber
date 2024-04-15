package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import io.appium.java_client.touch.WaitOptions;

import java.time.Duration;

public class WorkoutsPages extends Common {
    public void clickOnDialogBackground() {
        waitAbit(500);
        clickElementByID("card_view");
    }

    public int countHistoryRow() {

        return countElementByText("//*[@resource-id='" + prefix_ID + "ll_container']");
    }

    public void swipeToWithTimes(String direction, String time) {
        WebElement bottom = getElementByXpath("//*[@resource-id='" + prefix_ID + "bottom_navigation']");
        int timeNumber = Integer.parseInt(time);
        int num = bottom.getSize().getWidth() + 100;
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        TouchAction action = new TouchAction(driver);
        for (int i = 0; i < timeNumber; i++)
            action.press(PointOption.point(width / 2, height - num)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(width / 2, 100)).release().perform();
    }

    public void completedTheExercise(String exercises) {
        while (countElementByText(exercises) != 0) {
            clickElementByID("count_text");
            clickElementByID("add");
        }
    }

    public void deleteAllHistory() {
        while (countElementById("ll_container") != 0) {
            WebElement historyRows = getElementByID("ll_container");
            TouchAction action = new TouchAction(driver);
            action.longPress(PointOption.point((historyRows.getRect().getX() + historyRows.getSize().getWidth()) / 2, historyRows.getRect().getY() + 10)).release().perform();
            clickElementByText("Delete");
            waitAbit(2000);
        }
    }


    public void clickBackPage() {
        driver.navigate().back();
    }
}

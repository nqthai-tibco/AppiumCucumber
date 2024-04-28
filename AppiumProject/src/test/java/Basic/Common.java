package Basic;

import defs.StartStopDefs;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common extends AppiumTestBase{
    String prefixId="org.coursera.android:id/";
//    StartStopDefs startStopDefs = new StartStopDefs();
    public void clickElementByText(String text){
            String xPath= "//*[@text='"+text+"']";
        driver.findElement(By.xpath(xPath)).click();

    }
    public  void typeInput(String idInput, String value){
        String xPath ="//*[@resource-id ='"+prefixId+idInput+"']";
        driver.findElement(By.xpath(xPath)).sendKeys(value);
    }
    public void verifyTextVisible(String text){
        new WebDriverWait(driver, 10000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='"+text+"']")));
    }
    public  void typeInputInWebView(){

    }
}

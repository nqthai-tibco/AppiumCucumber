package defs;

import Basic.AppiumTestBase;
import Basic.Common;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.net.MalformedURLException;
import java.util.Set;

public class StartStopDefs extends Common implements Runnable{
    AppiumTestBase appiumTestBase = new AppiumTestBase();
    @Given("I start app android")
    public void iStartAppAndroid() throws MalformedURLException {
        String [] test = new String[0];
        TestThreadRunnable.main(test);
    }
    @And("I stop app android")
    public void iStopAppAndroid() {
        appiumTestBase.tearDown();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        if(!Thread.currentThread().getName().contains("0")) {
            try {
                   AppiumTestBase.setup("Pixel1","emulator-5554","4723","org.coursera.android","org.coursera.android.MainActivity");
                clickElementByText("OK");
                clickElementByText("Sign Up Later");
                typeInput("search_src_text","full stack developer");
                verifyTextVisible("Google AI Essentials");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                 AppiumTestBase.setup("Pixel1","emulator-5554","4723","fr.playsoft.vnexpress","fr.playsoft.vnexpress.ActivityMain");
               clickElementByText("Để sau");
                Set<String> contextNames = driver.getContextHandles();

                for (String contextName : contextNames) {
                    System.out.println(contextName);
                    if(contextName.contains("WEBVIEW_fr"))
                        driver.context(contextName);
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
    public  void main(String test[]){
        Runnable r1 = new StartStopDefs();
        Runnable r2 = new StartStopDefs();
        new Thread(r1).start();
        new  Thread(r2).start();
    }
}

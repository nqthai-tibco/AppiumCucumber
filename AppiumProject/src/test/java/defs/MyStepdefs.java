package defs;

import Basic.AppiumTestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.net.MalformedURLException;

public class MyStepdefs {
    static AppiumTestBase appiumTestBase = new AppiumTestBase();
    @Given("I start app android")
    public static void iStartAppAndroid() throws MalformedURLException {

        appiumTestBase.setup();
    }

    @And("I stop app android")
    public void iStopAppAndroid() {
        appiumTestBase.tearDown();
    }
}

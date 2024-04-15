package defs;

import io.cucumber.java.en.And;
import steps.FirstPageSteps;
import steps.LoginStep;

public class FirstDefs {

    FirstPageSteps firstPageSteps = new FirstPageSteps();
    LoginStep loginStep = new LoginStep();
    @And("I click button {string}")
    public void iClickButton(String button) {
        loginStep.clickButton(button);
    }
}

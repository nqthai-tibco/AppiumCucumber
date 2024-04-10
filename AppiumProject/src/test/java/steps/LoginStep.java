package steps;

import pages.LoginPage;

public class LoginStep {
    LoginPage loginPage = new LoginPage();
    public void inputInformation(String email, String password) {
        loginPage.inputInformation(email,password);
    }

    public void clickButton(String button) {
        loginPage.clickButton(button);
    }

    public void verifyError(String typeDisplayed, String content) {
        loginPage.verifyError(typeDisplayed,content);
    }

    public void accessSignInSignUp() {
        loginPage.accessSignInSignUp();
    }

    public void inputInformationRegister(String email, String password, String name, String lastName, String gender) {
        loginPage.inputInformationRegister(email,password,name,lastName,gender);
    }
}

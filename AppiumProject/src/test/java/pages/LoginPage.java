package pages;

import Basic.Common;
import com.google.common.base.Strings;
import org.junit.Assert;

public class LoginPage extends Common {


    public void inputInformation(String email, String password) {
        if (Strings.isNullOrEmpty(email))
            email = "";
        if (Strings.isNullOrEmpty(password))
            password = "";
        inputValueById("login_email", email);
        inputValueById("login_password", password);
    }
    public void verifyError(String typeDisplayed, String content) {
        if (typeDisplayed.equals("Message box")) {
            Assert.assertTrue(getContentMessage().equals(content));
            clickButton("OK");
        } else {
            System.out.println(getTextByID("snackbar_text"));
            Assert.assertTrue(getTextByID("snackbar_text").equals(content));
        }
    }

    public void accessSignInSignUp() {
        clickElementByText("Sign in/Sign up by email");
    }


    public void inputInformationRegister(String email, String password, String name, String lastName, String gender) {
        if (Strings.isNullOrEmpty(email))
            email = "";
        if (Strings.isNullOrEmpty(password))
            password = "";
        if (Strings.isNullOrEmpty(name))
            name = "";
        if (Strings.isNullOrEmpty(lastName))
            lastName = "";
        if (Strings.isNullOrEmpty(gender))
            gender = "";
        inputValueById("register_email", email);
        inputValueById("register_password", password);
        inputValueById("register_name", name);
        inputValueById("register_surname", lastName);
        if (!Strings.isNullOrEmpty(gender))
            clickElementByText(gender);

    }
}

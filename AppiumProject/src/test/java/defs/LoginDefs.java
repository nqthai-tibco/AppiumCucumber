package defs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import steps.LoginStep;

import java.util.List;
import java.util.Map;

public class LoginDefs {
    LoginStep loginStep = new LoginStep();

    @And("I login with accounts have information in the table below")
    public void iLoginWithAccountsHaveInformationInTheTableBelow(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        loginStep.accessSignInSignUp();
        for (Map<String, String> columns : rows) {
            String email = columns.get("Email");
            String password = columns.get("Password");
            String typeDisplayed = columns.get("Display type");
            String content = columns.get("Content");
            loginStep.inputInformation(email, password);
            loginStep.clickButton("SIGN IN");
            loginStep.verifyError(typeDisplayed, content);


        }

    }

    @And("I register accounts with information in the table below")
    public void iRegisterAccountsWithInformationInTheTableBelow(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        loginStep.accessSignInSignUp();
        for (Map<String, String> columns : rows) {
            String email = columns.get("Email");
            String password = columns.get("Password");
            String name = columns.get("Name");
            String lastName = columns.get("Last name");
            String gender = columns.get("Gender");
            String typeDisplayed = columns.get("Display type");
            String content = columns.get("Content");
            loginStep.inputInformationRegister(email, password, name, lastName, gender);
            loginStep.clickButton("SIGN UP");
            loginStep.verifyError(typeDisplayed, content);
        }
    }
}

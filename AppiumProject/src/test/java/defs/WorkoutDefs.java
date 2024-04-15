package defs;

import io.cucumber.datatable.DataTable;
import pages.Common;
import io.cucumber.java.en.And;
import steps.WorkoutsSteps;

import java.util.List;

public class WorkoutDefs extends Common {
    WorkoutsSteps workoutsSteps = new WorkoutsSteps();

    @And("I click to text {string}")
    public void iClickToText(String text) {
        clickElementByText(text);
    }

    @And("I swipe to {string} with {string} times")
    public void iSwipeToWithTimes(String direction, String time) {
        workoutsSteps.swipeToWithTimes(direction, time);
    }

    @And("I verify page {string} loaded")
    public void iVerifyPageLoaded(String pages) {
        workoutsSteps.verifyPageLoaded(pages);
    }

    @And("I click on dialog background")
    public void iClickOnDialogBackground() {
        if (workoutsSteps.countElementById("card_view") != 0)
            workoutsSteps.clickOnDialogBackground();
    }


    @And("I completed the exercise {string}")
    public void iCompletedTheExercise(String exercises) {
        workoutsSteps.completedTheExercise(exercises);
    }

    @And("I delete all history")
    public void iDeleteAllHistory() {
        workoutsSteps.deleteAllHistory();
    }

    @And("I completed the exercises in the list belows")
    public void iCompletedTheExercisesInTheListBelows(DataTable dataTable) {
        List<String> exercises = dataTable.asList(String.class);
        for (int i = 1; i < exercises.size(); i++) {
            clickElementByText(exercises.get(i));
            iClickOnDialogBackground();
            iCompletedTheExercise(exercises.get(i));
            iClickOnDialogBackground();
            workoutsSteps.clickBackButon();
        }
    }
}

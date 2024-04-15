package steps;

import pages.Common;
import pages.WorkoutsPages;

public class WorkoutsSteps {
    WorkoutsPages workoutsPages = new WorkoutsPages();

    public void clickOnDialogBackground() {
        workoutsPages.clickOnDialogBackground();

    }



    public void verifyPageLoaded(String pages) {
        workoutsPages.verifyPageLoaded(pages);
    }

    public void swipeToWithTimes(String direction, String time) {
        workoutsPages.swipeToWithTimes(direction,time);
    }

    public void completedTheExercise(String exercises) {
        workoutsPages.completedTheExercise(exercises);
    }

    public void deleteAllHistory() {
        workoutsPages.deleteAllHistory();
    }

    public void clickBackButon() {
        workoutsPages.clickBackPage();
    }

    public int countElementById(String card_view) {
        return  workoutsPages.countElementById(card_view);
    }
}

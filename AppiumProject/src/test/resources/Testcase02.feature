Feature: Testcase02

  Background:
    Given I start app android

  Scenario: testcase02
    And I click button "SKIP"
    And I verify page "Workouts" loaded
    And I click to text "upper body"
    And I click on dialog background
#    Then I verify page "Exercises" loaded
#
#    And I click to text "Treadmill"
#    And I click on dialog background
##    Then I verify page "1/12 Cardio" loaded
#    And I swipe to "Bottom" with "1" times
#    And I completed the exercise "Treadmill"
#    And I delete all history


    And I completed the exercises in the list belows
      | List                                                   |
      | Treadmill                                              |
      | Hammer strength chest bench press                      |
      | Close-grip front lat pulldown                          |
      | 30-degree incline dumbbell fly                         |
      | Standing rope pullover                                 |
      | Hanging leg raises                                     |
      | Shoulder joint stretch                                 |
      | Chest muscles stretch                                  |
      | Deltoids stretch                                       |
      | Overhead triceps stretch                               |
      | Oblique muscle and latissimus dorsi side reach stretch |
      | Spine extensor muscles stretch                         |

    And I stop app android
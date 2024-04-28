Feature: Testcase01

  Background:
    Given I start app android
    @Test01
  Scenario: testcase03
    And I login with accounts have information in the table below
      | Email    | Password | Display type | Content                                    |
      |          |          | Message box  | Please enter email. Please enter password. |
      | Test     | test1234 | Message box  | Please check your email spelling.          |
      | Test@aaa | test1234 | Toast        | Invalid user account data                  |
      And  I stop app android
    Scenario: testcase01
    And I register accounts with information in the table below
      | Email    | Password | Name | Last name | Gender | Display type | Content                                                                       |
      | Test@aaa | test1234 | Test | Tester    |        | Message box  | Please select gender.                                                         |
      | Test     | test1234 | Test | Tester    | Male   | Message box  | Please check your email spelling.                                             |
      | Test@aaa |          | Test | Tester    | Male   | Message box  | Please enter password.                                                        |
      | Test@aaa | test1234 |      | Tester    | Male   | Message box  | Please enter name.                                                            |
      | Test@aaa | test1234 | Test |           | Male   | Message box  | Please enter last name.                                                       |
      | Test@aaa | test1234 | Test | Tester    | Male   | Toast        | Validation failed: Email This e-mail address is already being used in the app |
    And  I stop app android
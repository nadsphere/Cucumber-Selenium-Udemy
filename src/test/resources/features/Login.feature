Feature: Login Feature
  Description: This feature deals with the login functionality of the application

  Scenario: Login with correct credential
    Given I navigate to login page
    And I enter following for login
      | username | password |
      | admin    | admin123 |
    When I click login button
    Then I should see user form page

  @Debug
  Scenario: Login with correct credential
    Given I navigate to login page
    And I enter following for login
      | username | password |
      | admin    | admin123 |
    When I click login button
    Then I should see user form page wrongly
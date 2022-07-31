Feature: Login Feature
  Description: This feature deals with the login functionality of the application

  Scenario: Login with correct credential
    Given I navigate to login page
    And I enter following for login
      | username | password |
      | admin    | admin123 |
    When I click login button
    Then I should see user form page

  Scenario: Login with incorrect credential
    Given I navigate to login page
    And I enter following for login
      | username | password |
      | admin    | admin123 |
    When I click login button
    Then I should see user form page wrongly

#  Scenario Outline: Login with correct credential using Scenario Outline
#    Given I navigate to login page
#    And I entered <username> and <password>
#    When I click login button
#    Then I should see user form page
#
#    Examples:
#      | username | password  |
#      | wakwaw   | wakwaw123 |
#      | admoon   | momon123  |
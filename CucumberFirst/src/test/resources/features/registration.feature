Feature: Registration

  As a user, I should able to register successfully,
  So that, I can use all user functionality
  @smoke
  Scenario: I should able to regsiter successfully

    Given I am on homepage
    When I click on register button
    And I enter all mandatory registration details
    Then I should able to register successfully and see the registration success message


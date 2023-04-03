@Capstone @LoginStudent
  Feature: Login mentor
    This test case is everything about login mentor

  Scenario: Login student valid json
    Given Student auth with valid json
    When Send request post auth
    Then Status code should 200 OK
    And Response body should be "login success" as message
    And Validate auth json schema

  Scenario: Login student invalid json
    Given Student auth with invalid json
    When Send request post auth
    Then Status code should 400 Bad Request
    And Response body should be "validate: Key: 'Core.Email' Error:Field validation for 'Email' failed on the 'email' tag" as message
    And Validate auth json schema

  Scenario: Login student blank json
    Given Student auth with blank json
    When Send request post auth
    Then Status code should 400 Bad Request
    And Response body should be "validate: Key: 'Core.Email' Error:Field validation for 'Email' failed on the 'required' tag" as message
    And Validate auth json schema
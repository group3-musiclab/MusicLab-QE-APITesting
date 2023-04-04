@Capstone @LoginMentor
  Feature: Login mentor
    This test case is everything about login mentor

  Scenario: Login mentor valid json
    Given Mentor auth with valid json
    When Send request post auth
    Then Status code should 200 OK
    And Response body should be "login success" as message
    And Validate auth json schema

  Scenario: Login mentor invalid json
    Given Mentor auth with invalid json
    When Send request post auth
    Then Status code should 400 Bad Request
    And Response body should be "password not matched" as message
    And Validate auth json schema

  Scenario: Login mentor blank json
    Given Mentor auth with blank json
    When Send request post auth
    Then Status code should 400 Bad Request
    And Response body should be "validate: Key: 'Core.Password' Error:Field validation for 'Password' failed on the 'required' tag" as message
    And Validate auth json schema
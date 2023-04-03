@Capstone @Register
  Feature: Register mentor
    This test case is everything about register mentor

  Scenario: Register mentor valid json
    Given Mentor register with valid json
    When Send request post register
    Then Status code should 201 Created
    And  Response body should be "success create account" as message
    And Validate register json schema

  Scenario: Register mentor with existing json
    Given Mentor register with valid json
    When Send request post register
    Then Status code should 500 Internal Server Error
    And  Response body should be "error insert data" as message
    And Validate register json schema

  Scenario: Register mentor with invalid json
    Given Mentor register with invalid json
    When Send request post register
    Then Status code should 400 Bad Request
    And  Response body should be "validate: Key: 'Core.Email' Error:Field validation for 'Email' failed on the 'email' tag" as message
    And Validate register json schema

  Scenario: Register mentor with blank json
    Given Mentor register with blank json
    When Send request post register
    Then Status code should 400 Bad Request
    And  Response body should be "validate: Key: 'Core.Email' Error:Field validation for 'Email' failed on the 'required' tag" as message
    And Validate register json schema
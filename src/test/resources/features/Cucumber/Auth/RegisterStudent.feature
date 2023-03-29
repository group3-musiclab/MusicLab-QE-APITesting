@Capstone @Register
  Feature: Register student
    This test case is everything about register student

  Scenario: Register student valid data
    Given Student register with valid json data
    When Send request post register
    Then Status code should 201 Created
    And Response body should be "success create account" as message
    And Validate register json schema

  Scenario: Register student with existing json
    Given Student register with valid json data
    When Send request post register
    Then Status code should 500 Internal Server Error
    And Response body should be "error insert data" as message
    And Validate register json schema

  Scenario: Register student invalid data
    Given Student register with invalid json data
    When Send request post register
    Then Status code should 400 Bad Request
    And Response body should be "role must be student or mentor" as message
    And Validate register json schema

  Scenario: Register student blank data
    Given Student register with blank json data
    When Send request post register
    Then Status code should 400 Bad Request
    And Response body should be "validate: Key: 'Core.Role' Error:Field validation for 'Role' failed on the 'required' tag" as message
    And Validate register json schema
@Capstone @PostMentorGenre
  Feature: Mentor post genre
    This test case is everything about mentor post genre

  Scenario: Mentor post genre with valid json
    Given Mentor post genre with valid json
    When Send request post genre
    Then Status code should 201 Created
    And Response body should be "success add mentor genre" as message
    And Validate message genre schema

  Scenario: Mentor post genre invalid json
    Given Mentor post genre with invalid json
    When Send request post genre
    Then Status code should 400 Bad Request
    And Response body should be "input format incorrect" as message
    And Validate message genre schema

  Scenario: Mentor post genre blank json
    Given Mentor post genre with blank json
    When Send request post genre
    Then Status code should 400 Bad Request
    And Response body should be "input format incorrect" as message
    And Validate message genre schema

  Scenario: mentor post genre with no authorization
    Given Mentor post genre with valid json
    When Send request post genre no auth
    Then Status code should 401 Unauthorized
    And Response body should be "missing or malformed jwt" as message
    And Validate message genre schema
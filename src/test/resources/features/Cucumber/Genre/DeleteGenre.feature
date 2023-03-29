@Capstone @DeleteGenre
  Feature: Delete genre
    This test case is everything about deleting genre

  Scenario: Delete valid parameter genre
    Given Delete genre with id 1
    When Send request delete genre
    Then Status code should 200 OK
    And Response body should be "success delete mentor genre" as message
    And Validate message genre schema

  Scenario: Delete invalid parameter genre
    Given Delete genre with id "asfwegw"
    When Send request delete genre
    Then Status code should 500 Internal Server Error
    And Response body should be "internal server error" as message
    And Validate message genre schema

  Scenario: Delete blank parameter genre
    Given Delete genre with blank id
    When Send request delete genre blank parameter
    Then Status code should 405 Method Not Allowed
    And Response body should be "Method Not Allowed" as message
    And Validate message genre schema
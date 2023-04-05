@Capstone @GetMentor
  Feature: Get all data about genre mentor
    This test case is everything about mentor genre

  Scenario: Get mentor genre valid parameter
    Given get data mentor genre with 1 as id mentor
    When Send request get data genre mentor
    Then Status code should 200 OK auth
    And Response body should be "success show all genres" as message
    And Validate get mentor genre json schema

  Scenario: Get mentor genre invalid parameter
    Given get data mentor genre with "asfewf" as id mentor
    When Send request get data genre mentor
    Then Status code should 400 Bad Request auth
    And Response body should be "id param must number" as message
    And Validate message genre schema

  Scenario: Get mentor genre blank parameter
    Given get data mentor genre with "" as id mentor
    When Send request get data genre mentor
    Then Status code should 400 Bad Request auth
    And Response body should be "id param must number" as message
    And Validate message genre schema
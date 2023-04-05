@Capstone @GetAll
  Feature: Get all data genre
    This test case is everything about get all genre data

  Scenario: Get all genre
    Given Get all data about genre mentor
    When Send request get data genre
    Then Status code should 200 OK auth
    And Response body should be "success show all genres" as message
    And Validate get genre json schema
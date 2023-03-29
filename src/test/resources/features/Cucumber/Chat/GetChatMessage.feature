Feature: Get Chat Message

  #  10
  @Capstone @GetChat @PositiveScenario
  Scenario: Get chat contents with valid path
    Given Get chat contents with valid path
    When Send request get chat message
    Then Status code should be 200 OK
    And Respon body message should be "success show mentor transaction history"

    #  11
  @Capstone @GetChat @NegativeScenario
  Scenario: Get chat contents with invalid path
    Given Get chat contents with invalid path
    When Send request get chat message
    Then Status code should be 404 Not Found
    And Respon body message should be "Not Found"
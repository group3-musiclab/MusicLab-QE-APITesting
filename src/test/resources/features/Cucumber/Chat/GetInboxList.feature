Feature: Get Inbox List

  #  12
  @Capstone @GetChat @NegativeScenario
  Scenario: Get all list chat with valid path
  Given Get all list chat with valid path
  When Send request get chat message
  Then Status code should be 200 OK
  And Respon body message should be "success show student transaction history"

    #  13
  @Capstone @GetChat @NegativeScenario
  Scenario: Get all list chat with invalid path
  Given Get all list chat with invalid path
  When Send request get chat message
  Then Status code should be 404 Not Found
  And Respon body message should be "Not Found"
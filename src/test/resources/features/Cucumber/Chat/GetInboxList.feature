Feature: Get Inbox List

  #  12
  @Capstone @GetInbox @PositiveScenario @Chat
  Scenario: Get all list chat with valid path
  Given Get inbox list chat
  When Send request get inbox list
  Then Status code rizki should be 200 OK
  And Respon body message should be "success show chat group by student"


    #  13
  @Capstone @GetInbox @NegativeScenario @Chat
  Scenario: Get all list chat with invalid path
  Given Get inbox list chat with invalid path
  When Send request get inbox invalid path
  Then Status code rizki should be 404 Not Found
  And Respon body message should be "Not Found"
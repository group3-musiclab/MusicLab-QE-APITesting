Feature: Get Chat Message

  #  10
  @Capstone @GetChat @PositiveScenario @Chat
  Scenario Outline: Get chat contents with valid path
    Given Get chat contents mentor <mentor> and student <student>
    When Send request get chat message
    Then Status code rizki should be 200 OK
    And Respon body message should be "success show a chat by id student and id mentor"
    Examples:
      | mentor | student |
      | 1      | 15      |

    #  11
  @Capstone @GetChat @NegativeScenario @Chat
  Scenario Outline: Get chat contents with invalid path
    Given Get chat contents mentor <mentor> and student <student> invalid path
    When Send request get chat message invalid path
    Then Status code rizki should be 404 Not Found
    And Respon body message should be "Not Found"
    Examples:
      | mentor | student  |
      | 1      | 15 |
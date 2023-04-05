Feature: Get Student Transaction

  #  12
  @Capstone @GetStudent @NegativeScenario @Transaction
  Scenario Outline: Get student transaction with valid path
    Given Get student transaction with page <page> and limit <limit>
    When Send request get student transaction
    Then Status code rizki should be 200 OK
    And Respon body message should be "success show student transaction history"
    Examples:
      | page | limit |
      | 1    | 15    |

    #  13
  @Capstone @GetInbox @NegativeScenario @Transaction
  Scenario Outline: Get student transaction with invalid path
    Given Get student transaction with page <page> and limit <limit> invalid path
    When Send request get student transaction invalid path
    Then Status code rizki should be 404 Not Found
    And Respon body message should be "Not Found"
    Examples:
      | page | limit |
      | 1    | 15    |
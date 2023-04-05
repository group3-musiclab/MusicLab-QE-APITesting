Feature: Get Mentor Transaction

  #  10
  @Capstone @GetMentor @PositiveScenario @Transaction
  Scenario Outline: Get mentor transaction with valid path
    Given Get mentor transaction with page <page> and limit <limit>
    When Send request get mentor transaction
    Then Status code rizki should be 200 OK
    And Respon body message should be "success show mentor transaction history"
    Examples:
      | page | limit |
      | 1    | 15    |

    #  11
  @Capstone @GetMentor @NegativeScenario @Transaction
  Scenario Outline: Get mentor transaction with invalid path
    Given Get mentor transaction with page <page> and limit <limit>
    When Send request get mentor transaction invalid path
    Then Status code rizki should be 404 Not Found
    And Respon body message should be "Not Found"
    Examples:
      | page | limit |
      | 1    | 15     |
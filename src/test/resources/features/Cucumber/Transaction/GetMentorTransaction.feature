Feature: Get Mentor Transaction

  #  10
  @Capstone @GetMentor @PositiveScenario
  Scenario: Get mentor transaction with valid path
    Given Get mentor transaction with valid path
    When Send request get mentor transaction
    Then Status code should be 200 OK
    And Respon body message should be "success show mentor profile"

    #  11
  @Capstone @GetMentor @NegativeScenario
  Scenario: Get mentor transaction with invalid path
    Given Get mentor transaction with invalid path
    When Send request get mentor transaction
    Then Status code should be 404 Not Found
    And Respon body message should be "Not Found"
Feature: Post Create Transaction

  #  1
  @Capstone @PostTransaction @PositiveScenario @Transaction
  Scenario: Create transaction with valid parameter on json request body
    Given Create transaction with valid parameter
    When Send request post create transaction
    Then Status code should be 201 Created
    And Respon body message should be "success make transaction"
    And Validate create transaction valid parameter with json schema

    #  2
  @Capstone @PostTransaction @NegativeScenario @Transaction
  Scenario: Create transaction with invalid parameter class_id on json request body
    Given Create transaction with invalid parameter class_id
    When Send request post create transaction
    Then Status code should be 400 Bad Request
    And Respon body message should be "input format incorrect"
    And Validate create transaction invalid parameter class_id with json schema

    #  3
  @Capstone @PostTransaction @NegativeScenario @Transaction
  Scenario: Create transaction with invalid parameter schedule_id on json request body
    Given Create transaction with invalid parameter schedule_id
    When Send request post create transaction
    Then Status code should be 400 Bad Request
    And Respon body message should be "input format incorrect"
    And Validate create transaction invalid parameter schedule_id with json schema

    #  4
  @Capstone @PostTransaction @NegativeScenario @Transaction
  Scenario: Create transaction with invalid parameter start_date on json request body
    Given Create transaction with invalid parameter start_date
    When Send request post create transaction
    Then Status code should be 400 Bad Request
    And Respon body message should be "minimum start date input is today"
    And Validate create transaction invalid parameter start_date with json schema


    #  5
  @Capstone @PostTransaction @NegativeScenario @Transaction
  Scenario: Create transaction with blank or empty parameter on json request body
    Given Create transaction with blank or empty parameter
    When Send request post create transaction
    Then Status code should be 400 Bad Request
    And Respon body message should be "input format incorrect"
    And Validate create transaction blank parameter schedule_id with json schema

    #  6
  @Capstone @PostTransaction @NegativeScenario @Transaction
  Scenario: Create transaction with extra parameter on json request body
    Given Create transaction with extra parameter
    When Send request post create transaction
    Then Status code should be 201 Created
    And Respon body message should be "success make transaction"
    And Validate create transaction extra parameter with json schema

    #  7
  @Capstone @PostTransaction @NegativeScenario @Transaction
  Scenario: Create transaction with 1 parameter only
    Given Create transaction with one parameter
    When Send request post create transaction
    Then Status code should be 400 Bad Request
    And Respon body message should be "minimum start date input is today"
    And Validate create transaction one parameter with json schema

    #  8
  @Capstone @PostTransaction @NegativeScenario @Transaction
  Scenario: Create transaction without request body
    Given Create transaction without request body
    When Send request post create transaction
    Then Status code should be 400 Bad Request
    And Respon body message should be "minimum start date input is today"
    And Validate create transaction without request body with json schema


    #  9 #json schema sama dengan scenario 1
  @Capstone @PostTransaction @NegativeScenario @Transaction @9
  Scenario: Create transaction with invalid path
    Given Create transaction with invalid path
    When Send request post create transaction invalid path
    Then Status code should be 404 Not Found
    And Respon body message should be "Not Found"
    And Validate create transaction invalid parameter with json schema




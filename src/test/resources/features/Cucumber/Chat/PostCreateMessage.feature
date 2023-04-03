Feature: Post Create Message

  #  1
  @Capstone @PostMessage @PositiveScenario @Chat
  Scenario: Create message with valid parameter on json request body
    Given Create message with valid parameter
    When Send request post create message
    Then Status code should be 201 Created
    And Respon body message should be "success send message"
    And Validate create messsage valid parameter with json schema

  #  2
  @Capstone @PostMessage @NegativeScenario @Chat
  Scenario: Create message with invalid parameter mentor_id on json request body
    Given Create message with invalid parameter mentor_id
    When Send request post create message
    Then Status code should be 400 Bad Request
    And Respon body message should be "error bind data"
    And Validate create messsage invalid parameter mentor_id with json schema


    #  3
  @Capstone @PostMessage @NegativeScenario @Chat
  Scenario: Create message with invalid parameter student_id on json request body
    Given Create message with invalid parameter student_id
    When Send request post create message
    Then Status code should be 400 Bad Request
    And Respon body message should be "error bind data"
    And Validate create messsage invalid parameter student_id with json schema

    #  4
  @Capstone @PostMessage @NegativeScenario @Chat
  Scenario: Create message with blank or empty parameter on json request body
    Given Create message with blank or empty parameter
    When Send request post create message
    Then Status code should be 400 Bad Request
    And Respon body message should be "error bind data"
    And Validate create messsage blank parameter student_id with json schema

    #  5
  @Capstone @PostMessage @NegativeScenario @Chat
  Scenario: Create message with extra parameter on json request body
    Given Create message with extra parameter
    When Send request post create message
    Then Status code should be 201 Created
    And Respon body message should be "success send message"
    And Validate create messsage extra parameter with json schema

    #  6
  @Capstone @PostMessage @NegativeScenario @Chat @6
  Scenario: Create message with 1 parameter(only chat contents)
    Given Create message with one parameter only
    When Send request post create message
    Then Status code should be 400 Bad Request
    And Respon body message should be "validate: Key: 'Core.StudentID' Error:Field validation for 'StudentID' failed on the 'required' tag\nKey: 'Core.MentorID' Error:Field validation for 'MentorID' failed on the 'required' tag"
    And Validate create messsage one parameter with json schema

    #  7
  @Capstone @PostMessage @NegativeScenario @Chat
  Scenario: Create messages longer than 500 characters
    Given Create messages longer than five hundred characters
    When Send request post create message
    Then Status code should be 400 Bad Request
    And Respon body message should be "validate: Key: 'Core.Chat' Error:Field validation for 'Chat' failed on the 'max' tag"
    And Validate create messsage five hundred with json schema

    #  8
  @Capstone @PostMessage @NegativeScenario @Chat
  Scenario: Create message without any characters or request body
    Given Create message without characters
    When Send request post create message
    Then Status code should be 400 Bad Request
    And Respon body message should be "validate: Key: 'Core.Chat' Error:Field validation for 'Chat' failed on the 'max' tag"
    And Validate create messsage without request body with json schema

    #  9 #json schema sama dengan scenario 1
  @Capstone @PostMessage @NegativeScenario @Chat
  Scenario: Create message with invalid path
    Given Create message with invalid path
    When Send request post create message invalid path
    Then Status code should be 404 Not Found
    And Respon body message should be "Not Found"
    And Validate create messsage with json schema




Feature: MusicLab API Automation Testing Capstone Project
  @Capstone @Positive @PostMakeClass
  Scenario: Post to make a class with valid parameters of json file
    Given Create a class with valid json
    When Send request post make a class
    Then Status code should be 201 Created class
    And Validate valid post class response body

  @Capstone @Negative @PostMakeClass
  Scenario: Post to make a class with invalid parameters of json file
    Given Create a class with invalid json
    When Send request post make a class
    Then Status code should be 400 Bad Request class
    And Validate invalid post class response body

  @Capstone @Negative @PostMakeClass
  Scenario: Post to make a class with null parameter
    Given Create a class with null parameter
    When Send request post make a class
    Then Status code should be 400 Bad Request class
    And Validate invalid post class response body

  @Capstone @Positive @GetAllClass
  Scenario: Get all class by ID Mentor valid
    Given Get list of all class with valid or listed mentor ID 5 and page id 1
    When Send request get list all class
    Then Status code should be 201 Created class
    And Validate get list all class json schema

  @Capstone @Negative @GetAllClass
  Scenario: Get all class by ID Mentor invalid
    Given Get list of all class with invalid or unlisted mentor ID "abc" and page id 2
    When Send request get list all class
    Then Status code should be 400 Bad Request class
    And Validate get list all class json schema

  @Capstone @Positive @GetMentorClass
  Scenario: Get mentor class detail
    Given Get list of all class with valid or listed mentor ID 2
    When Send request get list all class detail
    Then Status code should be 201 Created class
    And Validate get list all class json schema

  @Capstone @Positive @PutClass
  Scenario: Put or edit a class valid json all parameters
    Given Put edit a class with valid parameters in JSON and class id 3
    When Send request put edit class
    Then Status code should be 201 Created class
    And Validate put update class json schema

  @Capstone @Positive @PutClass
  Scenario: Put or edit a class one parameter
    Given Put edit a class with valid one parameter in JSON and class id 5
    When Send request put edit class one parameter
    Then Status code should be 201 Created class
    And Validate put update class json schema

  @Capstone @Negative @PutClass
  Scenario: Put or edit a class null parameter
    Given Put edit a class with null parameter in JSON body and class id 2
    When Send request put edit class null paramter
    Then Status code should be 400 Bad Request class
    And Validate put update class json schema

  @Capstone @Positive @DeleteClass
  Scenario: Delete a class
    Given Delete class with token and class_id 1
    When Send request delete class
    Then Status code should be 200 OK class
    And Validate put update class json schema
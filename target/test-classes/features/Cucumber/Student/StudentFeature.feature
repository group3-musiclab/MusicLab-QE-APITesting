Feature: MusicLab API Automation Testing Capstone Project
  @Capstone @Positive @GetStudent
  Scenario: Get student data
    Given Get student data
    When Send request get student data
    Then Status code should be 200 OK
    And Validate get student data json schema

  @Capstone @Positive @PutStudentProfile
  Scenario: Put or edit student profile with valid parameters
    Given Put edit student profile with valid parameter in json body
    When Send request put edit student profile
    Then Status code should be 200 OK
    And Validate json schema message

  @Capstone @Positive @PutStudentProfile
  Scenario: Put or edit student profile with invalid parameters
    Given Put edit student profile with invalid parameter in json body
    When Send request put edit student profile
    Then Status code should be 400 Bad Request
    And Validate json schema message

  @Capstone @Negative @PutStudentProfile
  Scenario: Put or edit a class null parameter
    Given Put edit student profile with null parameter in JSON body
    When Send request put edit student profile null parameter
    Then Status code should be 400 Bad Request
    And Validate json schema message

  @Capstone @Positive @DeleteStudent
  Scenario: Deactive student
    Given Delete student to deactive profile
    When Send request delete student
    Then Status code should be 200 OK

  @Capstone @Positive @PutStudentPassword
  Scenario: Put or edit student password with valid parameters
    Given Put edit student password with valid parameter in json body
    When Send request put edit student password
    Then Status code should be 201 Created
    And Validate json schema message

  @Capstone @Negative @PutStudentPassword
  Scenario: Put or edit student password with invalid parameters
    Given Put edit student password with invalid parameter in json body
    When Send request put edit student password
    Then Status code should be 400 Bad Request
    And Validate json schema message

  @Capstone @Negative @PutStudentPassword
  Scenario: Put or edit student password null parameter
    Given Put edit student password with null parameter in JSON body
    When Send request put edit student password null parameter
    Then Status code should be 400 Bad Request
    And Validate json schema message

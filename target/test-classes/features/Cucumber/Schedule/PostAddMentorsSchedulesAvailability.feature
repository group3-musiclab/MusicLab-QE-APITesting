Feature: Music Lab API Automation Testing
  @Capstone @Positive @Schedule
  Scenario: Post add mentor schedule availability with valid json
    Given Post add mentor schedule Availability with valid json
    When Send request post add mentor Availability schedule
    Then Should return status code 201 Created schedule
    And Response body should contain "schedule available"
    And Validate json schema for post add mentor schedule Availability with valid json

  @Capstone @Negative @Schedule
  Scenario: Post add mentor schedule availability with valid json no authorization
    Given Post add mentor schedule Availability with valid json no authorization
    When Send request post add mentor Availability schedule no authorization
    Then Should return status code 401 Unauthorized schedule
    And Response body should contain "missing or malformed jwt"


  @Capstone @Negative @Schedule
  Scenario: Post add mentor schedule availability with empty json
    Given Post add mentor schedule availability with empty json
    When Send request post add mentor Availability schedule empty json
    Then Should return status code 400 Bad Request schedule

  @Capstone @Negative @Schedule
  Scenario: Post add mentor schedule with invalid json
    Given Post add mentor schedule availability with invalid json
    When Send request post add mentor Availability schedule invalid
    Then Should return status code 400 Bad Request schedule





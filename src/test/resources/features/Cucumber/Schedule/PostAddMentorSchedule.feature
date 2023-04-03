Feature: Music Lab API Automation Testing
  @Capstone @Positive @Schedule
  Scenario: Post add mentor schedule with valid json
    Given Post add mentor schedule with valid json
    When Send request post add mentor schedule
    Then Should return status code 201 Created
    And Response body should contain message "message: success post a schedule"
    And Validate json schema for post add mentor schedule with valid json

  @Capstone @Negative @Schedule
  Scenario: Post add mentor schedule availability with valid json no authorization
    Given Post add mentor schedule with valid json no authorization
    When Send request post add mentor schedule no authorization
    Then Should return status code 401 Unauthorized
    And Response body should contain "message: missing or malformed jwt"

  @Capstone @Negative @Schedule
  Scenario: Post add mentor schedule with invalid json
    Given Post add mentor schedule with invalid json
    When Send request post add mentor schedule invalid
    Then Should return status code 400 Bad Request

  @Capstone @Negative @Schedule
  Scenario: Post add mentor schedule with empty json
    Given Post add mentor schedule with empty json
    When Send request post add mentor schedule empty json
    Then Should return status code 400 Bad Request






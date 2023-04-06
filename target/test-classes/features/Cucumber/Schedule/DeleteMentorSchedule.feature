Feature: Music Lab API Automation Testing
  @Capstone @Positive @Schedule
  Scenario: Delete schedule with valid id
    Given Delete schedule with valid id 6
    When Send request Delete schedule
    Then Should return status code 404 Not Found schedule

  @Capstone @Negative @Schedule
  Scenario Outline: Delete schedule with invalid id
    Given Delete schedule with invalid id "<id>"
    When Send request Delete schedule
    Then Should return status code 400 Bad Request schedule
    And Response body should contain message "id param must number"

  Examples:
    | id  |
    | asd |
    | !@# |

  @Capstone @Negative @Schedule
  Scenario: Delete schedule with empty id
    Given Delete schedule with empty id
    When Send request Delete schedule empty id
    Then Should return status code 404 Not Found schedule
    And Response body should contain message "Not Found"



  @Capstone @Negative @Schedule
  Scenario Outline: Delete schedule valid id no authorization
    Given Delete schedule with valid id <id> no authorization
    When Send request Delete schedule
    Then Should return status code 401 Unauthorized schedule
    And Response body should contain message "missing or malformed jwt"

    Examples:
      | id |
      | 1  |
      | 2  |






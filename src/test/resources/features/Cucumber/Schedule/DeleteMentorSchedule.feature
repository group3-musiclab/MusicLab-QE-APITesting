Feature: Music Lab API Automation Testing
  @Capstone @Positive @Schedule
  Scenario Outline: Delete schedule with valid id
    Given Delete schedule with valid id <id>
    When Send request Delete schedule
    Then Should return status code 200 OK
    And Response body should contain message "message: succes delete schedule"
    And Validate json schema for delete schedule valid id
  Examples:
  |id|
  |1 |
  |2 |

  @Capstone @Negative @Schedule
  Scenario Outline: Delete schedule with invalid id
    Given Delete schedule with invalid id "<id>"
    When Send request Delete schedule
    Then Should return status code 400 Bad Request
    And Response body should contain message "message: id param must number"

  Examples:
    | id  |
    | asd |
    | !@# |

  @Capstone @Negative @Schedule
  Scenario: Delete schedule with empty id
    Given Delete schedule with empty id
    When Send request Delete schedule empty id
    Then Should return status code 400 Bad Request
    And Response body should contain message "message: id param must number"



  @Capstone @Negative @Schedule
  Scenario Outline: Delete schedule valid id no authorization
    Given Delete schedule with valid id <id> no authorization
    When Send request Delete schedule
    Then Should return status code 401 Unauthorized
    And Response body should contain message "message: missing or malformed jwt"

    Examples:
      | id |
      | 1  |
      | 2  |






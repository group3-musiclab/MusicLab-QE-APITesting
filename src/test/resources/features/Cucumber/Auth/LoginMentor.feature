@Capstone @LoginMentor
  Feature: Login mentor
    This test case is everything about login mentor

  Scenario: Login mentor valid json
    Given Mentor login with valid json
    When Send request post login
    Then Status code should 200 OK
    And Response body should be "login success" as message
    And Validate login json schema
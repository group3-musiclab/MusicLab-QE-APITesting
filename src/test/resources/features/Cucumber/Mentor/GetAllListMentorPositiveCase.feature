@GetAllListMentors @FeatureInstrument @BilalProject @Capstone @GetAllListMentorsPositiveCase
Feature: [MusicLab-API] Get Feature Mentors

  Scenario: [Positive Case] Get All List Mentors Normal Condition
    Given Get all list mentors
    When Send request get all list mentors
    Then Status code should be 200 OK
    And Validate get all list mentors json schema

  @GetAllListWithParamPos
  Scenario Outline: [Positive Case] Get All List Mentors With Valid Parameters
    Given Get all list mentors with valid parameters "<param>"
    When Send request get all list mentors with parameters
    Then Status code should be 200 OK -Mentors_Instruments
    Examples:
      | param                       |
      | page=1                      |
      | name=aldan                  |
      | limit=6                     |
      | genre=1                     |
      | rating=1                    |
      | qualification=international |
      | instrument=1                |

  Scenario: [Positive Case] Get All List Mentors Top Week
    Given Get list mentors top week
    When Send request get all list mentors top week
    Then Status code should be 200 OK -Mentors_Instruments
    And Validate get all list mentors top week json schema
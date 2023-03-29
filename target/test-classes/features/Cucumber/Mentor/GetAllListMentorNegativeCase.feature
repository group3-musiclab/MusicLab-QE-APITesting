@GetAllListMentors @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Get Feature Mentors

  Scenario Outline: [Negative Case] Get All List Mentors With Invalid Parameters
    Given Get all list mentors with invalid parameters "<page>"
    When Send request get single mentors with invalid id
    Then Status code should be 400 Bad Request
    Examples:
      | page        |
      | %$^$        |
      | 10000000000 |
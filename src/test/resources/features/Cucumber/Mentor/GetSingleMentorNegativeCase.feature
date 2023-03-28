@GetSingleMentors @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Get Feature Mentors

  Scenario Outline: [Negative Case] Get Single List Mentors With Invalid ID
    Given Get single mentors with invalid ID "<mentor_id>"
    When Send request get single mentors with invalid id
    Then Status code should be 400 Bad Request
    Examples:
      | mentor_id         |
      | $^%$^$%^          |
      | chuakzzz          |
      | 10000000000000000 |

  Scenario: [Negative Case] Get Single List Mentors With Blank ID
    Given Get single mentors with blank ID blank
    When Send request get single mentors with blank id
    Then Status code should be 400 Bad Request
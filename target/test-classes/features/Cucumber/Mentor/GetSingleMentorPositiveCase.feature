@GetSingleMentors @FeatureInstrument @BilalProject @Capstone @GetSingleMentorsPositiveCase
Feature: [MusicLab-API] Get Feature Mentors

  Scenario: [Positive Case] Get Single Mentor Profile
    Given Get mentors profile
    When Send request get mentors profile
    Then Status code should be 200 OK

  Scenario: [Positive Case] Get Single List Mentors With Valid ID
    Given Get single mentors with valid ID 1
    When Send request to get single mentors with valid id
    Then Status code should be 200 OK
    And Validate single mentor profile json schema
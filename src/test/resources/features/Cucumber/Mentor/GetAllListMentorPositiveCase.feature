@GetAllListMentors @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Get Feature Mentors

  Scenario: [Positive Case] Get All List Mentors Normal Condition
    Given Get all list mentors
    When Send request get all list mentors
    Then Status code should be 200 OK
    And Validate get all list mentors json schema

  Scenario: [Positive Case] Get All List Mentors With Valid Parameters
    Given Get all list mentors with valid parameters 1
    When Send request get all list mentors with parameter
    Then Status code should be 200 OK

  Scenario: [Positive Case] Get All List Mentors Top Week
    Given Get list mentors top week
    When Send request get all list mentors top week
    Then Status code should be 200 OK
    And Validate get all list mentors top week json schema
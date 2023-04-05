@GetSingleReview @FeatureReview @AlanProject @Capstone
Feature: [MusicLab-API] Get Feature Review

  Scenario : [Negative Case] Get Single List review With valid ID
    Given Get single review with valid ID 5
    When Send request get single mentors with valid id
    Then Status code should be 200 OK -Mentors_Instruments
    And Validate single review json schema


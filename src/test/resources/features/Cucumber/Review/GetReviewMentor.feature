@GetSingleReview @FeatureReview @AlanProject @Capstone
  Feature: [MusicLab-API] Get Feature Review

    Scenario: [Positive Case] Get Single List review With valid ID
      Given Get single review with valid ID 1
      When Send request get single mentors review
      Then Status code should be 200 OK review
      And Validate single review json schema

    Scenario: [Negative Case] Get Single List review With invalid ID
      Given Get single review with invalid ID "sadaf"
      When Send request get single mentors review
      Then Status code should be 400 Bad Request review
      And Validate single review json schema invalid
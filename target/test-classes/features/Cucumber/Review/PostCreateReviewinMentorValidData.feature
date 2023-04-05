@GetSingleReview @FeatureReview @AlanProject @Capstone
Feature: [MusicLab-API] Post Feature Review

  Scenario: [Positive Case] Post Create Review With Valid JSON
    Given Post create Review with valid JSON
    When Send post create Review
    Then Status code should be 201 Create -Mentors_Instruments
    And Validate post create Review json schema




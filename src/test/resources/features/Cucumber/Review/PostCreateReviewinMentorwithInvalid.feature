@GetSingleReview @FeatureReview @AlanProject @Capstone
Feature: [MusicLab-API] Post Feature Review

  Scenario: [Negative Case] Post Create Review With inValid JSON
    Given Post create Review with invalid JSON
    When Send post create Review
    Then Status code should be 201 Create

  Scenario: [Negative Case] Post Create Review With empty comment
    Given Post create Review with empty comment
    When Send post create Review
    Then Status code should be 201 Create




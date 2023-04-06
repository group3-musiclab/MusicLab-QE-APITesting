@GetSingleReview @FeatureReview @AlanProject @Capstone
Feature: [MusicLab-API] Post Feature Review

  Scenario: [Negative Case] Post Create Review With inValid JSON
    Given Post create review with invalid JSON and 49 as id mentor
    When Send post create Review
    Then Status code should be 400 Bad Request review

  Scenario: [Negative Case] Post Create Review With empty comment
    Given Post create review with empty comment and 49 as id mentor
    When Send post create Review
    Then Status code should be 400 Bad Request review
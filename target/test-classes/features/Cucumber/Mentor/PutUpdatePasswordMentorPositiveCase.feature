@PutMentorPassword @FeatureInstrument @BilalProject @Capstone @PutMentorPasswordPositiveCase
Feature: [MusicLab-API] Put Feature Mentors

  Scenario: [Positive Case] Put Update Mentors Password With Valid JSON
    Given Put update mentors password with valid json
    When Send put update mentors Password
    Then Status code should be 200 OK
    And Validate update mentors password json schema
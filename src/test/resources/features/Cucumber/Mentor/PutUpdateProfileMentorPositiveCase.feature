@PutMentorProfile @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Put Feature Mentors

  Scenario: [Positive Case] Put Update Mentors Profile With Valid JSON
    Given Put update mentors profile with valid json
    When Send put update mentors Profile
    Then Status code should be 200 OK
    And Validate update mentors password json schema
@PutMentorPassword @FeatureInstrument @BilalProject @Capstone @PutMentorPasswordNegativeCase
Feature: [MusicLab-API] Put Feature Mentors

  Scenario: [Negative Case] Put Update Mentors Password With Invalid JSON
    Given Put update mentors password with invalid json
    When Send put update mentors Password
    Then Status code should be 400 Bad Request -Mentors_Instruments

  Scenario: [Negative Case] Put Update Mentors Password With Valid JSON No Authorized
    Given Put update mentors password with valid json no auth
    When Send put update mentors Password
    Then Status code should be 401 Unauthorized -Mentors_Instruments
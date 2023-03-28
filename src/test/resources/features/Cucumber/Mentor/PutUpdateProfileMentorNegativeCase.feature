@PutMentorProfile @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Put Feature Mentors

  Scenario: [Negative Case] Put Update Mentors Profile With Invalid JSON
    Given Put update mentors profile with invalid json
    When Send put update mentors Profile
    Then Status code should be 400 Bad Request

  Scenario: [Negative Case] Put Update Mentors Profile With Valid JSON No Authorized
    Given Put update mentors profile with valid json no auth
    When Send put update mentors Profile
    Then Status code should be 401 Unauthorized
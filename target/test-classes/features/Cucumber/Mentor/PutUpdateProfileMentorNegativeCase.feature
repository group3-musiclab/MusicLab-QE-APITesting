@PutMentorProfile @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Put Feature Mentors

  Scenario: [Negative Case] Put Update Mentors Profile With Invalid JSON
    Given Put update mentors profile with invalid json
    When Send put update mentors Profile
    Then Status code should be 400 Bad Request
    And Response should be "message: validate: Key: 'Core.Email' Error:Field validation for 'Email' failed on the 'email' tag\nKey: 'Core.Phone' Error:Field validation for 'Phone' failed on the 'number' tag"

  Scenario: [Negative Case] Put Update Mentors Profile With Valid JSON No Authorized
    Given Put update mentors profile with valid json no auth
    When Send put update mentors Profile
    Then Status code should be 401 Unauthorized
@PutMentorPassword @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Put Feature Mentors

  Scenario: [Negative Case] Put Update Mentors Password With Invalid JSON
    Given Put update mentors password with invalid json
    When Send put update mentors Password
    Then Status code should be 400 Bad Request
    And Response should be "message: validate: Key: 'Core.Email' Error:Field validation for 'Email' failed on the 'email' tag\nKey: 'Core.Phone' Error:Field validation for 'Phone' failed on the 'number' tag"

  Scenario: [Negative Case] Put Update Mentors Password With Valid JSON No Authorized
    Given Put update mentors password with valid json no auth
    When Send put update mentors Password
    Then Status code should be 401 Unauthorized
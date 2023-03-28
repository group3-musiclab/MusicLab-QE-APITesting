@PostMentorsCredential @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Post Feature Mentors

  Scenario: [Negative Case] Post Create Mentors Credential With Invalid JSON
    Given Post create mentor credential with invalid JSON
    When Send post create mentor credential
    Then Status code should be 400 Bad Request
    And Response should be "message: error form file"

  Scenario: [Negative Case] Post Create Mentors Credential With Valid JSON No Auth
    Given Post create mentor credential with valid JSON no Auth
    When Send post create mentor credential
    Then Status code should be 401 Unauthorized
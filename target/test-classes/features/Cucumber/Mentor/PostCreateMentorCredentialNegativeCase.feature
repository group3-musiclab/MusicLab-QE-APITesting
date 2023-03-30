@PostMentorsCredential @FeatureInstrument @BilalProject @Capstone @NegativePostMentorCredential
Feature: [MusicLab-API] Post Feature Mentors

  @PostInvalidJSON
  Scenario: [Negative Case] Post Create Mentors Credential With Invalid JSON
    Given Post create mentor credential with invalid JSON
    When Send post create mentor credential
    Then Status code should be 500 Internal server error
    And Response should be message "message: error form file"
    And Validate post create mentor credential invalid json schema

  @PostValidJSONNoAuth
  Scenario: [Negative Case] Post Create Mentors Credential With Valid JSON No Auth
    Given Post create mentor credential with valid JSON no Auth
    When Send post create mentor credential
    Then Status code should be 401 Unauthorized

  @PostInvalidImage
  Scenario: [Negative Case] Post Create Mentors Credential With Oversize Image
    Given Post create mentor credential with oversize image
    When Send post create mentor credential
    Then Status code should be 500 Internal server error
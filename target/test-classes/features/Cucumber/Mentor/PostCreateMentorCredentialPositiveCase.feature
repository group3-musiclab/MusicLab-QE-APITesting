@PostMentorsCredential @FeatureInstrument @BilalProject @Capstone @PositivePostMentorCredential
Feature: [MusicLab-API] Post Feature Mentors

  Scenario: [Positive Case] Post Create Mentors Credential With Valid JSON
    Given Post create mentor credential with valid JSON
    When Send post create mentor credential
    Then Status code should be 201 Create
    And Validate post create mentor credential json schema
@PostCreateInstrument @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Post Feature Instrument

  Scenario: [Negative Case] Post Create Mentors Instruments Invalid JSON
    Given Post create mentor instrument with invalid JSON
    When Send post create mentor instrument
    Then Status code should be 400 Bad Request -Mentors_Instruments

  Scenario: [Negative Case] Post Create Mentors Instruments No Auth
    Given Post create mentor instrument with valid JSON no Auth
    When Send post create mentor instrument
    Then Status code should be 401 Unauthorized -Mentors_Instruments
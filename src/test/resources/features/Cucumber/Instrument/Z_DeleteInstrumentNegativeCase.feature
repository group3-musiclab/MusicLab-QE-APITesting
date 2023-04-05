@DeleteInstrument @FeatureInstrument @BilalProject
Feature: [MusicLab-API] Delete Feature Instrument

  Scenario: [Negative Case] Delete Instruments Valid ID No Auth
    Given Delete instrument with valid ID 1 no auth
    When Send request delete instrument
    Then Status code should be 401 Unauthorized -Mentors_Instruments

  Scenario: [Negative Case] Delete Instruments Invalid ID
    Given Delete instrument with invalid ID "@#$$"
    When Send request delete instrument not found
    Then Status code should be 404 Not Found -Mentors_Instruments

  Scenario: [Negative Case] Delete Instruments Blank ID
    Given Delete instrument with blank ID blank
    When Send request delete instrument blank
    Then Status code should be 400 Bad Request -Mentors_Instruments
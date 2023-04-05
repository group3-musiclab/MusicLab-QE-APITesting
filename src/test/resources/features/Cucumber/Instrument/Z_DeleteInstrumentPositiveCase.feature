@DeleteInstrument @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Delete Feature Instrument

  Scenario: [Positive Case] Delete Instruments Valid ID
    Given Delete instrument with valid ID 1
    When Send request delete instrument
    Then Status code should be 200 OK -Mentors_Instruments
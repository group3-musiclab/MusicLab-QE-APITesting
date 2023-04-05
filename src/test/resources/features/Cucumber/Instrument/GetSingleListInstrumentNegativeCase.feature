@GetSingleListInstrument @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Get Feature Instrument

  Scenario: [Negative Case] Get Single List Instruments Invalid ID
    Given Get single instrument with invalid ID "%$^%%"
    When Send request get single list instrument
    Then Status code should be 400 Bad Request -Mentors_Instruments
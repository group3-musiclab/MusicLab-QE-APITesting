@GetSingleListInstrument @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Get Feature Instrument

  Scenario: [Positive Case] Get Single List Instruments
    Given Get single instrument with valid ID 1
    When Send request get single list instrument
    Then Status code should be 200 OK
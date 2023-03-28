@GetAllListInstrument @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Get Feature Instrument

    Scenario: [Positive Case] Get All List Instruments
    Given Get all list instrument
    When Send request get all list instrument
    Then Status code should be 200 OK
    And Validate get all list Instrument json schema
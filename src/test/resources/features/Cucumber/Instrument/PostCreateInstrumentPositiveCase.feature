@PostCreateInstrument @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Post Feature Instrument

  Scenario: [Positive Case] Post Create Mentors Instruments Valid JSON
    Given Post create mentor instrument with valid JSON
    When Send post create mentor instrument
    Then Status code should be 201 Create -Mentors_Instruments
    Then Response should be "message: success add mentor instrument" -Mentors_Instruments
    And Validate post create instrument resources json schema
@PutMentorProfile @FeatureInstrument @BilalProject @Capstone @PutMentorProfilePositiveCase
Feature: [MusicLab-API] Put Feature Mentors

  Scenario: [Positive Case] Put Update Mentors Profile With Valid JSON
    Given Put update mentors profile with valid json
    When Send put update mentors Profile
    Then Status code should be 200 OK -Mentors_Instruments
    And Validate update mentors profile json schema
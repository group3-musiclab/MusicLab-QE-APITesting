@DeleteMentors @FeatureInstrument @BilalProject @Capstone @DeleteMentorsNegativeCase
Feature: [MusicLab-API] Delete Feature Mentors

  Scenario: [Positive Case] Delete Mentors Without Authorized
    Given Delete mentors without auth
    When Send request delete mentor
    Then Status code should be 401 Unauthorized
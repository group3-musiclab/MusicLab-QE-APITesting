@DeleteMentors @FeatureInstrument @BilalProject @Capstone
Feature: [MusicLab-API] Delete Feature Mentors

  Scenario: [Positive Case] Delete Mentors With Authorized
    Given Delete mentors with auth
    When Send request delete mentor
    Then Status code should be 200 OK
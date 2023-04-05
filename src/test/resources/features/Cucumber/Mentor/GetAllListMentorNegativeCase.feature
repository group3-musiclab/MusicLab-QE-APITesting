@GetAllListMentors @FeatureInstrument @BilalProject @Capstone @GetAllListMentorsNegativeCase
Feature: [MusicLab-API] Get Feature Mentors

  Scenario Outline: [Negative Case] Get All List Mentors With Invalid Parameters
    Given Get all list mentors with invalid parameters "<param>"
    When Send request get all list mentors with parameters
    Then Status code should be 400 Bad Request -Mentors_Instruments
    Examples:
      | param                  |
      | page=10000000000000000 |
      | name=1231413           |
      | limit=asdasdas         |
      | genre=#%$#$%%          |
      | rating=top             |
      | qualification=^*^*&    |
      | instrument=chuaks      |
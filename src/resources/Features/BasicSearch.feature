Feature: test nr. 7, go to the Google Search page and try searching

  @BasicSearch
  Scenario: go to the Google Search page and try searching data
    Given open Google search page
    When user clicks on 'Search in Google' button
    Then nothing happens and user is still on the same page
    When user inputs search request into search box:
      | relevantSearchRequest     | irrelevantSearchRequest  | notExistingRequest |
      | controller                | controllr                | ++++++             |
    And user clicks on 'Search in Google' button with inserted search request
    Then appears page with results of searching request
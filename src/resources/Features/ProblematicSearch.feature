Feature: test nr. 8, go to the Google Search page and try problematic searching

  @ProblematicSearch
  Scenario: go to the Google Search page and try searching problematic data
    Given open Google main search page
    When user inputs not existing search request into search box:
      | notExistingRequest |
      | ++++++             |
    And user clicks on 'Search in Google' button with inserted not existing search request
    Then appears page that nothing is found
    When user inputs irrelevantSearchRequest into search field:
      | irrelevantSearchRequest  |
      | controllr                |
    And user clicks on 'Search in Google' button with inserted irrelevant search request
    Then appears page with 'did you mean' notification

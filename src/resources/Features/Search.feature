Feature: test nr. 3, go to the page and try search

  @Search
  Scenario: go through service to search section and perform standard searching request
    Given open web-shop page with search field
    When user inputs info to search
    And press search button
    Then appears page with results of search
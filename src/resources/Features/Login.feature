Feature: test nr. 1, go to the page and try to authenticate

  Scenario: go through service to "Sign in" section and perform standard authentication
    Given open web-shop page
    When press button with text 'Sign in'
    Then appears authentication form
    And user logs in with name and email:
      | username     | email                    |
      | filpatterson | filpatterson10@gmail.com |
    And press button with value 'SIGN IN'
    Then appears page with successful authentication
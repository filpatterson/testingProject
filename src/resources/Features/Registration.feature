  Feature: test nr. 2, go to the page and try registration

  @Registration
  Scenario: go through service to "Sign up" section and perform standard registration
    Given open web-shop page for registration
    When press button with text 'Sign up'
    Then appears registration form
    And user inputs name, email, password and confirms password:
      | username     | email                    | password |
      | filpatterson | filpatterson10@gmail.com | 12345678 |
    And press button with value 'SIGN UP'
    Then appears page with successful registration
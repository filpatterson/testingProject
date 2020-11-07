Feature: test nr. 4, go to the page and try to contacting

  Scenario: go through service to contact section and try to send message
    Given open web-shop page contact part and navigate to contact form
    When user inputs name, email, subject and message:
      | username     | email                    | subject         | message                                                |
      | filpatterson | filpatterson10@gmail.com | clothes for men | all clothes are too good for men, where are for women? |
    And press button with value 'SEND'
    Then appears page with notification about successful delivery
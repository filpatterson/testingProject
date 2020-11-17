Feature: test nr. 5, go to the product page and try adding review

  @AddingReview
  Scenario: go through service to product page and try to add a review to it
    Given open web-shop product page with review section
    When user clicks on 'review' field
    And user inputs name, email and message to review form:
      | username     | email                    | message                                                |
      | filpatterson | filpatterson10@gmail.com | all clothes are too good for men, where are for women? |
    And press review form button with value 'SEND'
    Then appears product page with attached review to it
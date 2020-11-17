Feature: test nr. 6, go to the page and try checking pincode for product

  @PincodeCheck
    @Issue("FAF-234")
  Scenario: go through service to any product page and make check of pincode for this product
    Given open web-shop any product page
    When input pincode for product
    And click on 'CHECK' button
    Then appears page with pincode check status
$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/resources/Features/AddingReview.feature");
formatter.feature({
  "name": "test nr. 5, go to the product page and try adding review",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "go through service to product page and try to add a review to it",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@AddingReview"
    }
  ]
});
formatter.step({
  "name": "open web-shop product page with review section",
  "keyword": "Given "
});
formatter.match({
  "location": "AddingReviewFeatureStepsDef.openWebShopProductPageWithReviewSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \u0027review\u0027 field",
  "keyword": "When "
});
formatter.match({
  "location": "AddingReviewFeatureStepsDef.userClicksOnReviewField()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user inputs name, email and message to review form:",
  "rows": [
    {
      "cells": [
        "username",
        "email",
        "message"
      ]
    },
    {
      "cells": [
        "filpatterson",
        "filpatterson10@gmail.com",
        "all clothes are too good for men, where are for women?"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "AddingReviewFeatureStepsDef.userInputsNameEmailAndMessageToReviewForm(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "press review form button with value \u0027SEND\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "AddingReviewFeatureStepsDef.pressButtonWithValueSEND()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appears product page with attached review to it",
  "keyword": "Then "
});
formatter.match({
  "location": "AddingReviewFeatureStepsDef.appearsPageWithSuccessfulReviewDelivery()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c0\u003e but was:\u003c1\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat org.junit.Assert.assertEquals(Assert.java:631)\r\n\tat com.filpatterson.step.AddingReviewFeatureStepsDef.appearsPageWithSuccessfulReviewDelivery(AddingReviewFeatureStepsDef.java:129)\r\n\tat ✽.appears product page with attached review to it(file:src/resources/Features/AddingReview.feature:11)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/resources/Features/BasicSearch.feature");
formatter.feature({
  "name": "test nr. 7, go to the Google Search page and try searching",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "go to the Google Search page and try searching data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@BasicSearch"
    }
  ]
});
formatter.step({
  "name": "open Google search page",
  "keyword": "Given "
});
formatter.match({
  "location": "BasicSearchFeatureStepsDef.openGoogleMainSeachPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \u0027Search in Google\u0027 button",
  "keyword": "When "
});
formatter.match({
  "location": "BasicSearchFeatureStepsDef.userClicksOnSearchWithoutInput()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "nothing happens and user is still on the same page",
  "keyword": "Then "
});
formatter.match({
  "location": "BasicSearchFeatureStepsDef.nothingHappensOnPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user inputs search request into search box:",
  "rows": [
    {
      "cells": [
        "relevantSearchRequest",
        "irrelevantSearchRequest",
        "notExistingRequest"
      ]
    },
    {
      "cells": [
        "controller",
        "controllr",
        "++++++"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "BasicSearchFeatureStepsDef.userInputsSearchRequestIntoSearchBox(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \u0027Search in Google\u0027 button with inserted search request",
  "keyword": "And "
});
formatter.match({
  "location": "BasicSearchFeatureStepsDef.userClicksOnSearchInGoogleButtonWithInsertedSearchRequest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appears page with results of searching request",
  "keyword": "Then "
});
formatter.match({
  "location": "BasicSearchFeatureStepsDef.appearsPageWithResultsOfSearchingRequest()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/resources/Features/Contacting.feature");
formatter.feature({
  "name": "test nr. 4, go to the page and try to contacting",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "go through service to contact section and try to send message",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Contacting"
    }
  ]
});
formatter.step({
  "name": "open web-shop page contact part and navigate to contact form",
  "keyword": "Given "
});
formatter.match({
  "location": "ContactingFeatureStepsDef.openWebShopPageForContacting()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user inputs name, email, subject and message:",
  "rows": [
    {
      "cells": [
        "username",
        "email",
        "subject",
        "message"
      ]
    },
    {
      "cells": [
        "filpatterson",
        "filpatterson10@gmail.com",
        "clothes for men",
        "all clothes are too good for men, where are for women?"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "ContactingFeatureStepsDef.userInputsNameEmailSubjectAndMessage(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "press button with value \u0027SEND\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "ContactingFeatureStepsDef.pressButtonWithValueSEND()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appears page with notification about successful delivery",
  "keyword": "Then "
});
formatter.match({
  "location": "ContactingFeatureStepsDef.appearsPageWithSuccessfulContactingDelivery()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c0\u003e but was:\u003c1\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat org.junit.Assert.assertEquals(Assert.java:631)\r\n\tat com.filpatterson.step.ContactingFeatureStepsDef.appearsPageWithSuccessfulContactingDelivery(ContactingFeatureStepsDef.java:98)\r\n\tat ✽.appears page with notification about successful delivery(file:src/resources/Features/Contacting.feature:10)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/resources/Features/Login.feature");
formatter.feature({
  "name": "test nr. 1, go to the page and try to authenticate",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "go through service to \"Sign in\" section and perform standard authentication",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.step({
  "name": "open web-shop page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginFeatureStepsDef.openWebShopPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "press button with text \u0027Sign in\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "LoginFeatureStepsDef.pressButtonWithText()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appears authentication form",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginFeatureStepsDef.appearsAuthenticationForm()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user logs in with name and email:",
  "rows": [
    {
      "cells": [
        "username",
        "email"
      ]
    },
    {
      "cells": [
        "filpatterson",
        "filpatterson10@gmail.com"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "LoginFeatureStepsDef.userLogsInWithNameAndEmail(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "press button with value \u0027SIGN IN\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "LoginFeatureStepsDef.pressButtonWithValue()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appears page with successful authentication",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginFeatureStepsDef.appearsPageWithSuccessfulAuthentication()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c0\u003e but was:\u003c1\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat org.junit.Assert.assertEquals(Assert.java:631)\r\n\tat com.filpatterson.step.LoginFeatureStepsDef.appearsPageWithSuccessfulAuthentication(LoginFeatureStepsDef.java:113)\r\n\tat ✽.appears page with successful authentication(file:src/resources/Features/Login.feature:12)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/resources/Features/PincodeCheck.feature");
formatter.feature({
  "name": "test nr. 6, go to the page and try checking pincode for product",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "go through service to any product page and make check of pincode for this product",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@PincodeCheck"
    },
    {
      "name": "@Issue(\"FAF-234\")"
    }
  ]
});
formatter.step({
  "name": "open web-shop any product page",
  "keyword": "Given "
});
formatter.match({
  "location": "PincodeCheckFeatureStepsDef.openWebShopAnyProductPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "input pincode for product",
  "keyword": "When "
});
formatter.match({
  "location": "PincodeCheckFeatureStepsDef.inputPincodeForProduct()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on \u0027CHECK\u0027 button",
  "keyword": "And "
});
formatter.match({
  "location": "PincodeCheckFeatureStepsDef.pressOnCheckButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appears page with pincode check status",
  "keyword": "Then "
});
formatter.match({
  "location": "PincodeCheckFeatureStepsDef.appearsPageWithPincodeCheckStatus()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c0\u003e but was:\u003c1\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat org.junit.Assert.assertEquals(Assert.java:631)\r\n\tat com.filpatterson.step.PincodeCheckFeatureStepsDef.appearsPageWithPincodeCheckStatus(PincodeCheckFeatureStepsDef.java:73)\r\n\tat ✽.appears page with pincode check status(file:src/resources/Features/PincodeCheck.feature:9)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/resources/Features/ProblematicSearch.feature");
formatter.feature({
  "name": "test nr. 8, go to the Google Search page and try problematic searching",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "go to the Google Search page and try searching problematic data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ProblematicSearch"
    }
  ]
});
formatter.step({
  "name": "open Google main search page",
  "keyword": "Given "
});
formatter.match({
  "location": "ProblematicSearchFeatureStepsDef.openGoogleMainSearchPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user inputs not existing search request into search box:",
  "rows": [
    {
      "cells": [
        "notExistingRequest"
      ]
    },
    {
      "cells": [
        "++++++"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "ProblematicSearchFeatureStepsDef.userInputsNotExistingSearchRequestIntoSearchBox(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \u0027Search in Google\u0027 button with inserted not existing search request",
  "keyword": "And "
});
formatter.match({
  "location": "ProblematicSearchFeatureStepsDef.userClicksOnSearchInGoogleButtonWithInsertedNotExistingSearchRequest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appears page that nothing is found",
  "keyword": "Then "
});
formatter.match({
  "location": "ProblematicSearchFeatureStepsDef.appearsPageThatNothingIsFound()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user inputs irrelevantSearchRequest into search field:",
  "rows": [
    {
      "cells": [
        "irrelevantSearchRequest"
      ]
    },
    {
      "cells": [
        "controllr"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "ProblematicSearchFeatureStepsDef.userInputsIrrelevantSearchRequestIntoSearchField(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \u0027Search in Google\u0027 button with inserted irrelevant search request",
  "keyword": "And "
});
formatter.match({
  "location": "ProblematicSearchFeatureStepsDef.userClicksOnSearchInGoogleButtonWithInsertedIrrelevantSearchRequest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appears page with \u0027did you mean\u0027 notification",
  "keyword": "Then "
});
formatter.match({
  "location": "ProblematicSearchFeatureStepsDef.appearsPageWithDidYouMeanNotification()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/resources/Features/Registration.feature");
formatter.feature({
  "name": "test nr. 2, go to the page and try registration",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "go through service to \"Sign up\" section and perform standard registration",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Registration"
    }
  ]
});
formatter.step({
  "name": "open web-shop page for registration",
  "keyword": "Given "
});
formatter.match({
  "location": "RegistrationFeatureStepsDef.openWebShopPageForRegistration()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "press button with text \u0027Sign up\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrationFeatureStepsDef.pressButtonWithTextSignUp()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appears registration form",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationFeatureStepsDef.appearsAuthenticationForm()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user inputs name, email, password and confirms password:",
  "rows": [
    {
      "cells": [
        "username",
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "filpatterson",
        "filpatterson10@gmail.com",
        "12345678"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "RegistrationFeatureStepsDef.userInputsNameEmailPasswordAndConfirmsPassword(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "press button with value \u0027SIGN UP\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "RegistrationFeatureStepsDef.pressButtonWithValueSIGNUP()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appears page with successful registration",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationFeatureStepsDef.appearsPageWithSuccessfulRegistration()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c0\u003e but was:\u003c1\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat org.junit.Assert.assertEquals(Assert.java:631)\r\n\tat com.filpatterson.step.RegistrationFeatureStepsDef.appearsPageWithSuccessfulRegistration(RegistrationFeatureStepsDef.java:117)\r\n\tat ✽.appears page with successful registration(file:src/resources/Features/Registration.feature:12)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/resources/Features/Search.feature");
formatter.feature({
  "name": "test nr. 3, go to the page and try search",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "go through service to search section and perform standard searching request",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Search"
    }
  ]
});
formatter.step({
  "name": "open web-shop page with search field",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchFeatureStepsDef.openWebShopPageWithSearchField()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user inputs info to search",
  "keyword": "When "
});
formatter.match({
  "location": "SearchFeatureStepsDef.userInputsInfoToSearch()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "press search button",
  "keyword": "And "
});
formatter.match({
  "location": "SearchFeatureStepsDef.pressSearchButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appears page with results of search",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchFeatureStepsDef.appearsPageWithResultsOfSearch()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c0\u003e but was:\u003c1\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat org.junit.Assert.assertEquals(Assert.java:631)\r\n\tat com.filpatterson.step.SearchFeatureStepsDef.appearsPageWithResultsOfSearch(SearchFeatureStepsDef.java:74)\r\n\tat ✽.appears page with results of search(file:src/resources/Features/Search.feature:8)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});
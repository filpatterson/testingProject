package com.filpatterson.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/resources/Features/AddingReview.feature"},
        glue = {"com.filpatterson.step.AddingReviewFeatureStepsDef"},
        plugin = { "pretty", "html:target/cucumber-reports"  },
        monochrome = true
)
public class AddingReviewFeatureRunner {
}

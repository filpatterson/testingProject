package com.filpatterson.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/resources/Features/Search.feature"},
        glue = {"com.filpatterson.step.SearchFeatureStepsDef"}
)
public class SearchFeatureRunner {
}

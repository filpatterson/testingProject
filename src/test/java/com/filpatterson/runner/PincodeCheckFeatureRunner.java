package com.filpatterson.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/resources/Features/PincodeCheck.feature"},
        glue = {"com.filpatterson.step.PincodeCheckFeatureStepsDef"}
)
public class PincodeCheckFeatureRunner {
}

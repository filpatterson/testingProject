package com.filpatterson.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/resources/Features/Contacting.feature"},
        glue = {"com.filpatterson.step.ContactingFeatureStepsDef"}
)
public class ContactingFeatureRunner {
}

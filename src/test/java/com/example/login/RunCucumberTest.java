package com.example.login;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.login",
        tags = "@mytag", // Specify the tag to run
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RunCucumberTest {
}

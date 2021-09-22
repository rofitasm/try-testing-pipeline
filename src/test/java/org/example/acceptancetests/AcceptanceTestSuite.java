package org.example.acceptancetests;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/", plugin = {"json:target/destination/cucumber.json"} ,glue="org.example", tags = "@Pokemon", stepNotifications = true)
public class AcceptanceTestSuite {}

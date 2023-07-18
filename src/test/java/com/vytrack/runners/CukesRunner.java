package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"html:target/cucumber-reports.html",
                    "rerun:target/rerun.txt",
                    "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                    "json:target/cucumber.json"
            },
            features = "src/test/resources/features",
            glue = "com/vytrack/step_definitions",
            dryRun = false,// [true] it checks if all snippets are implemented.
            tags = "", // @admin or @student or @regression
            publish = true
    )
    public class CukesRunner {

}

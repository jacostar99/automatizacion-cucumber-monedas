package com.usbcali.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		snippets = CucumberOptions.SnippetType.CAMELCASE,
		features = "src/test/resources",
		glue = {"com.usbcali.monedas.views"},
		plugin = {"pretty" , "html:reporte/cucumber-report.html"},
		tags = "@compararMonedas"
		)
public class RunnerMonedaTest {

}

package com.test;
//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  - commit token for git

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "Features",
		glue= {"stepDef"}
		)

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("Success!!");
	}

}

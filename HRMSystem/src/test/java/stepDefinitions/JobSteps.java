package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JobSteps extends BaseClass {

	@When("^Click on Job Titles Link$")
	public void click_on_Job_Titles_Link() throws Throwable {

		System.out.println("Modification is done in progress 1");
	}

	@Then("^Find Job Title as \"([^\"]*)\" in the table and Click$")
	public void find_Job_Title_as_in_the_table_and_Click(String arg1) throws Throwable {
		
		System.out.println("Modification is done in progress 2");
	}

	@Then("^Click on Job Edit Button$")
	public void click_on_Job_Edit_Button() throws Throwable {
		
		System.out.println("Modification is done in progress 3");
	}

	@Then("^Check on Job Description$")
	public void check_on_Job_Description() throws Throwable {
		
		System.out.println("Modification is done in progress 4");
	}

	@Then("^Job Save Button$")
	public void job_Save_Button() throws Throwable {
		
		System.out.println("Modification is done in progress 5");
	}

}

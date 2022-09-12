package steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import javamethod.RegisterMethods;

public class DatatableSteps {
	private WebDriver driver;

	public DatatableSteps() {
		driver = Hooks.driver;
	}

	@Given("User is on {string} page")
	public void user_is_on_hrm_login_page(String str1) {
		RegisterMethods.getTitle(driver, str1);
	}

	@And("Upload the user image")
	public void Upload_the_user_image() {
		RegisterMethods.imageUpload(driver);
	}

	@And("Select the Hobbies as {string}")
	public void Select_the_Hobbies_as(String str1) {
		RegisterMethods.clickCircket(driver, str1);
	}

	@When("User enters invalid credentials and Login will be unsuccessful with custom error messages")
	public void user_enters_invalid_credentials_and_login_will_be_unsuccessful_with_custom_error_messages(
			io.cucumber.datatable.DataTable dataTable) {
//		List<List<String>> 	data =dataTable.asLists();
//		System.out.println("First name is: "+data.get(0).get(0));

		List<Map<String, String>> maps = dataTable.asMaps();

		System.out.println("UserName 1st value is : " + maps.get(0).get("Username"));
		System.out.println("UserName is 2nd value is : " + maps.get(1).get("Username"));

		System.out.println("Password 1st value is : " + maps.get(0).get("Password"));
		System.out.println("Password is 2nd value is : " + maps.get(1).get("Password"));

	}

	@When("User enters firstname {string}, lastname {string}, email {string}, password {string} and confirm password {string}")
	public void user_enter_the_first_name(String fname, String lname, String email, String password, String cpassword) {
		RegisterMethods.enterFirstName(driver, fname);
		RegisterMethods.enterLastName(driver, lname);
		RegisterMethods.enterEmail(driver, email);
		RegisterMethods.enterPassword(driver, password);
		RegisterMethods.enterCpassword(driver, cpassword);
	}
}

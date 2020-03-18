package CucumberWebTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();

    @Given("I am on homepage")
    public void i_am_on_homepage() {
    }

    @When("I click on register button")
    public void i_click_on_register_button() {
        homePage.clickOnRegisterButton();
    }

    @When("I enter all mandatory registration details")
    public void i_enter_all_mandatory_registration_details() {
        registrationPage.userEntrsRegistrationDetails();
    }

    @Then("I should able to register successfully and see the registration success message")
    public void i_should_able_to_register_successfully() {
        registrationResultPage.verifyUserSeeRegistrationSuccessMessage();
    }

}

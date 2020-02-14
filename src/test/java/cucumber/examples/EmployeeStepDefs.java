/* 
User: Urmi
Date: 2/14/2020 
Time: 12:09 PM
*/

package cucumber.examples;

import com.example.first.spring.FirstSpring.controller.EmployeeController;
import com.example.first.spring.FirstSpring.domain.Employee;
import com.example.first.spring.FirstSpring.service.EmployeeService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeStepDefs {

    private EmployeeService employeeService = mock(EmployeeService.class);

    private EmployeeController employeeController = new EmployeeController(employeeService);

    Employee expected, created;

    MockMvc mockMvc;

    @Given("^I have a saved employee$")
    public void iHaveASavedEmployee(){
        when(employeeService.findById(1L)).thenReturn(Employee.builder().firstName("Rini").lastName("Banerjee").build());
        expected = employeeService.findById(1L);

    }

    @When("^I call get endpoint$")
    public void iCallGetEndpoint(){
        created = employeeController.getById(1L);
    }

    @Then("^I get back employee details$")
    public void iGetBackEmployeeDetails() {
        assertNotNull(created);
        assertEquals(expected, created);
    }
}

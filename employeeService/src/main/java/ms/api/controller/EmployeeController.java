package ms.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import ms.api.entity.Employee;
import ms.api.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;
	
	
	
	@GetMapping("/")
    public String home(@AuthenticationPrincipal OAuth2User principal) {
        return "Welcome, " + principal.getAttribute("login");
    }

	@GetMapping("/Employees")
	public List<Employee> getAllEmployee() {
		List<Employee>empList=employeeService.getAllEmployee();
		
		return empList ;
		
	}
	
	@DeleteMapping("/Employees/delete/{eid}")
	public String deleteEmployeeById(@PathVariable int eid) {
		try {
			
			employeeService.deleteById(eid);
			
		return "Employee "+eid+ "removed successfully";
		}catch (Exception e) {
			return e.getStackTrace().toString();
		}	
	}
	
    @PostMapping("/Employees/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
    
    @PostMapping("/Employees/update")
    public String updateEmployee(@RequestBody Employee employee) throws Exception {
    	employeeService.updateEmployee(employee);
    	
		return "Employee Updated Successfully	";
    	
    }

}

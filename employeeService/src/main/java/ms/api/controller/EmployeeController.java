package ms.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ms.api.entity.Employee;
import ms.api.service.EmployeeService;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;

	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		List<Employee>empList=employeeService.getAllEmployee();
		
		return empList ;
		
	}
	
	@DeleteMapping("/delete/{eid}")
	public String deleteEmployeeById(@PathVariable int eid) {
		try {
			
			employeeService.deleteById(eid);
			
		return "Employee "+eid+ "removed successfully";
		}catch (Exception e) {
			return e.getStackTrace().toString();
		}	
	}
	
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
    
    @PostMapping("/update")
    public String updateEmployee(@RequestBody Employee employee) throws Exception {
    	employeeService.updateEmployee(employee);
    	
		return "Employee Updated Successfully	";
    	
    }

}

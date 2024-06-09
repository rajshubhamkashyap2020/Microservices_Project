package ms.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ms.api.entity.Employee;
import ms.api.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional(rollbackOn = Exception.class)
	public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	@Transactional
	public void deleteById(int eid) throws Exception {
		
		Optional<Employee>optional= employeeRepository.findById(eid);
		Employee employee= optional.get();
		employeeRepository.delete(employee);			
	}

	@Transactional(rollbackOn = Exception.class)
	public void updateEmployee(Employee employee) throws Exception {

		Optional<Employee>optional= employeeRepository.findById(employee.getEid());
		try {
			Employee employee2=(Employee) optional.get();
			employee2.setContact(employee.getContact());
			employee2.setEmail(employee.getEmail());
			employee2.setExpsalary(employee.getExpsalary());
			employee2.setLocation(employee.getLocation());
			employee2.setName(employee.getName());
			
			createEmployee(employee2);
			
		} catch (Exception e) {
			throw new Exception("Unable to find customer with id : "+employee.getEid(),e);
		}
	}
	
	

}

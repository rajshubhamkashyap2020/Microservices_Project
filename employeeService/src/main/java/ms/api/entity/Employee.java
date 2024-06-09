package ms.api.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private int eid;
	private String name;
    private String location;
    private int contact;
    private String email;
    private int expsalary;
    
    
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getExpsalary() {
		return expsalary;
	}
	public void setExpsalary(int expsalary) {
		this.expsalary = expsalary;
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(contact, eid, email, expsalary, location, name);
//	}
	@Override
	public int hashCode() {
		return Objects.hash(contact, eid, email, expsalary, location, name);
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return contact == other.contact && eid == other.eid && Objects.equals(email, other.email)
				&& expsalary == other.expsalary && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name);
	}
    
    

}

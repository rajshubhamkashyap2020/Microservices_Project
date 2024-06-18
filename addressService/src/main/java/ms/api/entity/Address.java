package ms.api.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue
	@Column(name="address_id")
	private int addressId;
	@Column(name="address_line")
	private String addressLine;
	@Column(name="landmark")
	private String landmark;
	@Column(name="pin")
	private int pin;
	
	
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getLandmark() {
		return landmark;
	}
	
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public void setLandmark(String landMark) {
		this.landmark = landMark;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public int hashCode() {
		return Objects.hash(addressLine, landmark, pin);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(addressLine, other.addressLine) && Objects.equals(landmark, other.landmark)
				&& pin == other.pin;
	}
	@Override
	public String toString() {
		return "Address [addressLine=" + addressLine + ", landmark=" + landmark + ", pin=" + pin + "]";
	}
	
	
	
	
	
}

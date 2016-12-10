package niit.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component

public class Shipping {
	@Id @GeneratedValue
	private int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String Firstname;
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddressline1() {
		return Addressline1;
	}
	public void setAddressline1(String addressline1) {
		Addressline1 = addressline1;
	}
	public String getAddressline2() {
		return Addressline2;
	}
	public void setAddressline2(String addressline2) {
		Addressline2 = addressline2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	private String Lastname;
	private String Email;
	private String Phone;
	private String Addressline1;
	private String Addressline2;
	private String city;
	private String zipcode;
	
}


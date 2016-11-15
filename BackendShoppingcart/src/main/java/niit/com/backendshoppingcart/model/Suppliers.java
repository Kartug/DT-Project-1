package niit.com.backendshoppingcart.model;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@javax.persistence.Entity
@Repository("Suppliers")
@Component
public class Suppliers {
	@Id
	private int suppliers_id;
	private String suppliers_name;
	private String suppliers_address;
	public int getSuppliers_id() {
		return suppliers_id;
	}
	public void setSuppliers_id(int suppliers_id) {
		this.suppliers_id = suppliers_id;
	}
	public String getSuppliers_name() {
		return suppliers_name;
	}
	public void setSuppliers_name(String suppliers_name) {
		this.suppliers_name = suppliers_name;
	}
	public String getSuppliers_address() {
		return suppliers_address;
	}
	public void setSuppliers_address(String suppliers_address) {
		this.suppliers_address = suppliers_address;
	}
	

}

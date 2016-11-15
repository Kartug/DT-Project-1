package niit.com.backendshoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Entity 
@Component
@Repository("Catagory")
public class Catagory {
	@Id
	private int catagory_id;
	private String catagory_description;
	private String catagory_name;
	public int getCatagory_id() {
		return catagory_id;
	}
	public void setCatagory_id(int catagory_id) {
		this.catagory_id = catagory_id;
	}
	public String getCatagory_description() {
		return catagory_description;
	}
	public void setCatagory_description(String catagory_description) {
		this.catagory_description = catagory_description;
	}
	public String getCatagory_name() {
		return catagory_name;
	}
	public void setCatagory_name(String catagory_name) {
		this.catagory_name = catagory_name;
	}
	public static void setID(String string) {
		// TODO Auto-generated method stub
		
	}

	

}

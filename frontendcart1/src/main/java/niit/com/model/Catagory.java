package niit.com.model;

import java.util.Set;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Entity 
@Component
@Repository("catagory")
public class Catagory implements Serializable{
	
	
	private static final long serialVersionUID = 3L;

	@Id
	private String catagory_id;
	
	@Column(unique = true, nullable=false)
	private String catagory_name;
	private String catagory_description;

	@OneToMany(mappedBy="catagory",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Products> products;
	
	
	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}

	public String getCatagory_id() {
		return catagory_id;
	}

	public void setCatagory_id(String catagory_id) {
		this.catagory_id = catagory_id;
	}

	public String getCatagory_name() {
		return catagory_name;
	}

	public void setCatagory_name(String catagory_name) {
		this.catagory_name = catagory_name;
	}

	public String getCatagory_description() {
		return catagory_description;
	}

	public void setCatagory_description(String catagory_description) {
		this.catagory_description = catagory_description;
	}

	@Override
	public String toString() {
		return "Catagory [catagory_id=" + catagory_id + ", catagory_name=" + catagory_name + ", catagory_description="
				+ catagory_description + ", products=" + products + "]";
	}

	



	}


	
	 


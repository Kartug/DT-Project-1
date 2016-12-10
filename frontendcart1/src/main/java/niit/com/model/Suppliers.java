package niit.com.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Entity
@Table
@Component
@Repository("Suppliers")
public class Suppliers implements Serializable{
	
	
	private static final long serialVersionUID = 5L;

	@Id
	private String id;
	@Column(unique = true, nullable=false)
	private String name;
	private String address;
	
	/*@OneToMany(mappedBy="suppliers", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Products> products;
	
	
	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}*/
	
	
	@Column(name = "ID")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Suppliers [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	
}

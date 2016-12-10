package niit.com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Component
public class Products implements Serializable{
	
	
	private static final long serialVersionUID = 4L;

	@Id
	private String id;
	@NotEmpty(message = "Product name can not be empty.")
	@Column(unique = true, nullable=false)
	private String name;
	private String description;
//	@NotEmpty(message = "Product price can not be empty.")
	private int price;
	
	private String catagory_id;
	private String supplier_id;
	
	//@OneToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	   // @JsonIgnore
	   /* private List<CartItem> cartItemList;
	
	
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}*/
	@Transient
    private MultipartFile itemImage;
	
	
	public MultipartFile getItemImage() {
		return itemImage;
	}

	public void setItemImage(MultipartFile itemImage) {
		this.itemImage = itemImage;
	}
	@ManyToOne
    @JoinColumn(name="catagory_id", nullable = false, updatable = false, insertable = false)
   	private Catagory catagory;
	
	@ManyToOne
    @JoinColumn(name="supplier_id",nullable = false, updatable = false, insertable = false)
	private Suppliers suppliers;
	
	
	public Catagory getCatagory() {
		return catagory;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

	public Suppliers getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}

	


	public String getcatagory_id() {
		return catagory_id;
	}

	public void setcatagory_id(String catagory_id) {
		this.catagory_id = catagory_id;
	}

	public String getsupplier_id() {
		return supplier_id;
	}

	public void setsupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	/*@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", catagory_id=" + catagory_id + ", supplier_id=" + supplier_id + ", itemImage=" + itemImage
				+ ", catagory=" + catagory + ", suppliers=" + suppliers + "]";
	}*/
	
	
}
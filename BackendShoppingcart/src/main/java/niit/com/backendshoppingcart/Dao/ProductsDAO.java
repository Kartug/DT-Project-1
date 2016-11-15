package niit.com.backendshoppingcart.Dao;

import java.util.List;

import niit.com.backendshoppingcart.model.Products;

public interface ProductsDAO {
	public boolean save(Products products);
	public boolean update(Products products);
	public boolean delete(Products products);
	public boolean get(String id);
	
	public List<Products> list();

}

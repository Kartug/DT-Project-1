package niit.com.Dao;

import java.util.List;

import niit.com.model.Products;


public interface ProductsDAO {

	public boolean save(Products products);

	public boolean update(Products products);

	public boolean saveOrUpdate(Products products);

	public boolean delete(String id);

	public Products get(String id);
	
	public Products getByName(String name);

	public List<Products> list();

}
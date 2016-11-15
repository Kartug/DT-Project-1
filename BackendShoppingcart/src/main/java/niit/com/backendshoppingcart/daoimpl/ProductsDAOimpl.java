package niit.com.backendshoppingcart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import niit.com.backendshoppingcart.Dao.ProductsDAO;
import niit.com.backendshoppingcart.model.Products;

public class ProductsDAOimpl implements ProductsDAO {
	@Autowired
	 private SessionFactory sessionFactory;
	
	public ProductsDAOimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean save(Products products) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Products products) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Products products) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean get(String id) {
		// TODO Auto-generated method stub
		return false;
	}
   @Transactional
	public List<Products> list() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

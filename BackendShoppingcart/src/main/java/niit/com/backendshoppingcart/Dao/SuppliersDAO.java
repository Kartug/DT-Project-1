package niit.com.backendshoppingcart.Dao;

import java.util.List;

import niit.com.backendshoppingcart.model.Suppliers;


public interface SuppliersDAO{
	Suppliers get(int id);
	List<Suppliers> list();
	Boolean save(Suppliers suppliers);
	Boolean update(Suppliers suppliers);
	Boolean delete(Suppliers suppliers);
		
	}


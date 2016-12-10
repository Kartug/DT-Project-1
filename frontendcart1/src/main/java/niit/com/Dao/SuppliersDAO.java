package niit.com.Dao;

import java.util.List;


import niit.com.model.Suppliers;


public interface SuppliersDAO{
	public boolean save(Suppliers suppliers);

	public boolean update(Suppliers suppliers);

	public boolean saveOrUpdate(Suppliers suppliers);

	public boolean delete(String id);

	public Suppliers get(String id);

	public Suppliers getByName(String name);

	public List<Suppliers> list();

}

		


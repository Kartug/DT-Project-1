package niit.com.Dao;

import java.util.List;

import niit.com.model.Catagory;




public interface CatagoryDAO  {

	public Catagory get(String id);

	public Catagory getByName(String name);

	public boolean saveOrUpdate(Catagory catagory);

	public boolean delete(String id);

	public List<Catagory> list();

}

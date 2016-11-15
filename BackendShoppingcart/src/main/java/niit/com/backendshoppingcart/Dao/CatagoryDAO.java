package niit.com.backendshoppingcart.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import niit.com.backendshoppingcart.model.Catagory;
@Repository
public interface CatagoryDAO  {
	public boolean save(Catagory catagory);
	public boolean update(Catagory catagory);
	public boolean delete(Catagory catagory);
	public Catagory get(int id);
	
	public List<Catagory> list();

}

package niit.com.backendshoppingcart.Dao;

import java.util.List;

import niit.com.backendshoppingcart.model.User;

public interface UserDAO {

	public boolean save(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public boolean get(String id);
	
	public List<User> list();

}
	

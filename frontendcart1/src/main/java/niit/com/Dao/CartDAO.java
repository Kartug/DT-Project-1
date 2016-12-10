package niit.com.Dao;

import java.io.IOException;

import niit.com.model.Cart;



public interface CartDAO {
	 Cart getCartById (int cartId);
	    
	   Cart validate(int cartId) throws IOException;  
	    
	    public void update(Cart cart);

}

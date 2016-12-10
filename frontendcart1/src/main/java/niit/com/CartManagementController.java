package niit.com;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import niit.com.Dao.CartDAO;
import niit.com.Dao.CartItemDAO;
import niit.com.Dao.ProductsDAO;
import niit.com.Dao.UsersDetailDao;
import niit.com.model.Cart;
import niit.com.model.CartItem;
import niit.com.model.Products;
import niit.com.model.UsersDetail;


@Controller
@RequestMapping("/usercart/cart")
public class CartManagementController {

	@Autowired
	private CartDAO cartDao;

	@Autowired
	private CartItemDAO cartItemDao;

	@Autowired
	private UsersDetailDao usersDetailDao;

	@Autowired
	private ProductsDAO productsDAO;

	
	 @RequestMapping(value="/refreshCart/{cartId}") 
	 String getCartById(@PathVariable(value = "cartId") int cartId) {
		 	return "redirect:/user/cart/" + cartId;
	 }
	 

	// addItem method is used to add a item in user cart.

	@RequestMapping(value = "/addItem/{id}", method = RequestMethod.GET)
	public String addItem(@PathVariable(value = "id") String id, Model model) {

		User activeUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		UsersDetail usersDetail = usersDetailDao.getUserByUsername(activeUser.getUsername());
		Cart cart = usersDetail.getCart();

		Products products = productsDAO.get(id);
		List<CartItem> cartItems = cart.getCartItems();
		
		double grandTotal=0.0;
		for (int i = 0; i < cartItems.size(); i++) {
		
			if (products.getId() == cartItems.get(i).getProducts().getId()) {
				CartItem cartItem = cartItems.get(i);
				
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(products.getPrice() * cartItem.getQuantity());
				cartItemDao.addCartItem(cartItem);	
				
				for (int j = 0; j < cartItems.size(); j++) {
					grandTotal = grandTotal + cartItem.getTotalPrice();
				}
				cart.setGrandTotal(grandTotal);
				
				try {
					cartDao.validate(cart.getCartId());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				model.addAttribute("cartId", cart.getCartId());
				model.addAttribute("successMsg", products.getName() + " added to cart");
				model.addAttribute("cartList", cartItemDao.getAllCartItems(cart.getCartId()));
				return "cart";
			}
		}

		CartItem cartItem = new CartItem();
		cartItem.setProducts(products);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(products.getPrice() * cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemDao.addCartItem(cartItem);
		
		
		for (int j = 0; j < cartItems.size(); j++) {
			grandTotal = grandTotal + cartItem.getTotalPrice();
		}
		cart.setGrandTotal(grandTotal);
		cartDao.update(cart);
			
		model.addAttribute("successMsg", products.getName() + " product added to cart");
		model.addAttribute("cartId", cart.getCartId());
		model.addAttribute("cartList", cartItemDao.getAllCartItems(cart.getCartId()));
		return "cart";
	}

	/* removeItem method is used to remove a item from user cart. */

	@RequestMapping(value = "/removeItem/{id}/{cartId}", method = RequestMethod.GET)
	public String removeItem(@PathVariable(value = "id") String id, @PathVariable(value = "cartId") int cartId,
			Model model) {
		CartItem cartItem = cartItemDao.getCartItemByProductId(id, cartId);
		if (cartItem != null) {
			cartItemDao.removeCartItem(cartItem);
		} else {
			System.out.println("object is null");
		}
		return "redirect:/user/cart/" + cartId;
	}
	
	@RequestMapping(value = "/addQty/{id}/{cartId}", method = RequestMethod.GET)
	public String addQuantity(@PathVariable(value = "id") String id, @PathVariable(value = "cartId") int cartId,
			Model model) {
		CartItem cartItem = cartItemDao.getCartItemByProductId(id, cartId);

		Products products=productsDAO.get(id);
		cartItem.setQuantity(cartItem.getQuantity() + 1);
		cartItem.setTotalPrice(cartItem.getQuantity()*products.getPrice());
		cartItemDao.addCartItem(cartItem);	
		return "redirect:/user/cart/" + cartId;
	}

	@RequestMapping(value = "/reduceQty/{id}/{cartId}", method = RequestMethod.GET)
	public String reduceQuantity(@PathVariable(value = "id") String id, @PathVariable(value = "cartId") int cartId,
			Model model) {
		CartItem cartItem = cartItemDao.getCartItemByProductId(id, cartId);

		Products products=productsDAO.get(id);
		if(cartItem.getQuantity()>0){
		cartItem.setQuantity(cartItem.getQuantity() - 1);
		cartItem.setTotalPrice(cartItem.getQuantity()*products.getPrice());
		cartItemDao.addCartItem(cartItem);
		}
		return "redirect:/user/cart/" + cartId;
	}
	
	@RequestMapping(value = "/update/{cartId}", method = RequestMethod.GET)
	public String updateCart(@PathVariable(value = "id") String id, @PathVariable(value = "cartId") int cartId,
			Model model) {

		CartItem cartItem = null;
		
		double grandTotal = 0.0;
		List<CartItem> cartItems=cartItemDao.getAllCartItems(cartId);
		for (int j = 0; j < cartItems.size(); j++) {
			grandTotal += cartItem.getTotalPrice();
		}
		Cart cart=cartDao.getCartById(cartId);
		cart.setGrandTotal(grandTotal);
		cartDao.update(cart);
		return "redirect:/user/cart/" + cartId;
	}
	

	/* clearCartItems method is used to remove all items from user cart. */

	@RequestMapping(value = "/clearCartItems/{cartId}", method = RequestMethod.GET)
	public String clearCartItems(@PathVariable(value = "cartId") int cartId, Model model) {
		Cart cart = cartDao.getCartById(cartId);
		cartItemDao.removeAllCartItems(cart);
		return "redirect:/user/cart/" + cartId;
	}

}
package niit.com;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import niit.com.Dao.CatagoryDAO;
import niit.com.Dao.ProductsDAO;
import niit.com.Dao.SuppliersDAO;
import niit.com.model.Catagory;
import niit.com.model.Products;
import niit.com.model.Suppliers;
import niit.com.util.Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ProductsController {

	@Autowired(required = true)
	private ProductsDAO productsDAO;

	@Autowired(required = true)
	private CatagoryDAO catagoryDAO;

	@Autowired(required = true)
	private SuppliersDAO suppliersDAO;

	private Path path;

	
	 /* @Autowired(required=true)
	  
	  @Qualifier(value="productsDAO") public void setProductsDAO(ProductsDAO ps){
	  this.productsDAO = ps; }*/
	 

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		System.out.println("Hello.. I'm inside /products list");
		model.addAttribute("isAdminClickedProducts", "true");
	
		model.addAttribute("products", new Products());
		System.out.println("aftwr true");
		model.addAttribute("productList", this.productsDAO.list());

		model.addAttribute("Catagory", new Catagory());
		model.addAttribute("Suppliers", new Suppliers());

		model.addAttribute("supplierList", this.suppliersDAO.list());
		model.addAttribute("catagoryList", this.catagoryDAO.list());

		return "admin";
	}


	// For add and update product both
	
	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("products") Products products, Model model) {
		
		System.out.println(products.getName() +products.getcatagory_id()+products.getsupplier_id());
		Catagory catagory = catagoryDAO.getByName(products.getCatagory().getCatagory_name());
		System.out.println("catagory=" + catagory);
		System.out.println(catagory.getCatagory_id() + ":" + catagory.getCatagory_name() + ":" + catagory.getCatagory_description());

		Suppliers suppliers = suppliersDAO.getByName(products.getSuppliers().getName());
		System.out.println(suppliers.getId() + ":" + suppliers.getName() + ":" + suppliers.getAddress());
        
		model.addAttribute("Suppliers", suppliers);
		model.addAttribute("Catagory", catagory);
		model.addAttribute("supplierList", this.suppliersDAO.list());
		model.addAttribute("categoryList", this.catagoryDAO.list());

		String newID = Util.removeComma(products.getId());
		products.setId(newID);

		products.setcatagory_id(catagory.getCatagory_id());
		products.setsupplier_id(suppliers.getId());

		products.setCatagory(catagory);
		products.setSuppliers(suppliers);

		productsDAO.saveOrUpdate(products);

		/*
		 * path="D:\\product\\image"; FileUtil.upload(path, itemImage,
		 * product.getId()+".png");
		 */
	
		MultipartFile itemImage = products.getItemImage();
		path = Paths
				.get("C:\\Users\\Karthik Gururaj.KarthikGururaj\\workspace1\\frontendcart1\\src\\main\\webapp\\WEB-INF\\resources\\images\\product images\\"
						+ products.getId() + ".jpg");

		if (itemImage != null && !itemImage.isEmpty()) {
			try {
				System.out.println("inside try");
				itemImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product image saving failed.", e);
			}
		}

		return "redirect:/products";

	}

	@RequestMapping("/product/remove/{id}")
	public String removeProduct(@PathVariable("id") String id, ModelMap model) throws Exception {
		System.out.println("Hello.. I'm inside /products remove");
		try {
			productsDAO.delete(id);
			model.addAttribute("message", "Successfully deleted");

			path = Paths
					.get("C:\\Users\\Karthik Gururaj.KarthikGururaj\\workspace1\\frontendcart1\\src\\main\\webapp\\WEB-INF\\resources\\images\\product images\\"
							+ id +".jpg");

			if (Files.exists(path)) {
				try {
					Files.delete(path);
					System.out.println("Image successfully deleted");
				} catch (IOException e) {
					System.out.println("Error in Image deletion");
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}

		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/products";
	}

	@RequestMapping("/product/edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		model.addAttribute("isAdminClickedEditProducts", "true");
		System.out.println("Hello.. I'm inside /products edit");
		model.addAttribute("Catagory", new Catagory());
		model.addAttribute("Suppliers", new Suppliers());
		model.addAttribute("supplierList", this.suppliersDAO.list());
		model.addAttribute("catagoryList", this.catagoryDAO.list());
		model.addAttribute("products", this.productsDAO.get(id));
		// model.addAttribute("productList", this.productDAO.list());
		return "admin";
	}

	/*
	 * @RequestMapping("/product/get/{id}") public String
	 * getProduct(@PathVariable("id") String id, Model model) {
	 * System.out.println("get Product"); model.addAttribute("Supplier",
	 * supplier); model.addAttribute("Category", category);
	 * model.addAttribute("supplierList", this.supplierDAO.list());
	 * model.addAttribute("categoryList", this.categoryDAO.list());
	 * product=productDAO.get(id); model.addAttribute("product",product);
	 * model.addAttribute("selectedProduct",
	 * this.productDAO.getByName(product.getName()));
	 * model.addAttribute("productList", this.productDAO.list()); //return
	 * "/iindex"; return "redirect:/"; }
	 */

	@RequestMapping("product/get/{id}")
	public String getSelectedProduct(@PathVariable("id") String id, Model model,
			RedirectAttributes redirectAttributes) {
		System.out.println("getSelectedProduct");

		model.addAttribute("productList", this.productsDAO.list());

		redirectAttributes.addFlashAttribute("selectedProduct",
		this.productsDAO.get(id));
		model.addAttribute("selectedProduct", this.productsDAO.get(id));
		 /*model.addAttribute("catagoryList", this.catagoryDAO.list());*/
		return "productInfo";
	}

}

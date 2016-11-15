package niit.com.backendshoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import junit.framework.Assert;
import niit.com.backendshoppingcart.Dao.SuppliersDAO;
import niit.com.backendshoppingcart.model.Suppliers;

public class SupplierstestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext Context;
	
	@Autowired
	static Suppliers suppliers;
	
	@Autowired
	static
	SuppliersDAO suppliersDAO;
	@BeforeClass
	public static void init(){
		
		Context = new AnnotationConfigApplicationContext();
		Context.scan("niit.com.backendshoppingcart");
	    Context.refresh();
	    
	    suppliersDAO = (SuppliersDAO) Context.getBean("SuppliersDAO");
	    		suppliers =(Suppliers) Context.getBean("Suppliers");
	}
	@Test
	public void CreateSuppliersTestCase(){
		suppliers.setSuppliers_id(07);
		suppliers.setSuppliers_address("115abchdjfkss ");
		suppliers.setSuppliers_name("zcsc");
		
		boolean status = suppliersDAO.save(suppliers);
		Assert.assertEquals("Create a Supplierstestcase",true,status);
		
		
	}
	@Test
	public void deleteSuppliersTestCase(){
		suppliers.setSuppliers_id(01);
		suppliers.setSuppliers_address("canon AV ");
		suppliers.setSuppliers_name("lens");
		
		boolean status = suppliersDAO.delete(suppliers);
		Assert.assertEquals("Delete a Supplierstestcase",true,status);
		
		
	}
	@Test
	public void updateSuppliersTestCase(){
		suppliers.setSuppliers_id(06);
		suppliers.setSuppliers_address("james ");
		suppliers.setSuppliers_name("dog");
		
		boolean status = suppliersDAO.update(suppliers);
		Assert.assertEquals("Update a Supplierstestcase",true,status);
		
		
	}
	@Test
	public void getSuppliersTestCase()
	{
		Assert.assertEquals("Get suppliersTestCase",null, suppliersDAO.get(1));
		
		}
	@Test
	public void getAllSuppliersTestCase()
	{
		Assert.assertEquals("getAllCatagoryTestCase",5, suppliersDAO.list().size());
	}

	}


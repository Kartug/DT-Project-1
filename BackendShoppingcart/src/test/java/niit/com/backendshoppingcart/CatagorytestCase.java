package niit.com.backendshoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import junit.framework.Assert;
import niit.com.backendshoppingcart.Dao.CatagoryDAO;
import niit.com.backendshoppingcart.model.Catagory;

public class CatagorytestCase {

	@Autowired
	static AnnotationConfigApplicationContext Context;
	
	@Autowired
	static Catagory catagory;
	
	@Autowired
	static
	CatagoryDAO catagoryDAO;
	
	@BeforeClass
	public static void init(){
		
		Context = new AnnotationConfigApplicationContext();
		Context.scan("niit.com.backendshoppingcart");
	    Context.refresh();
		
	 catagoryDAO =(CatagoryDAO) Context.getBean("CatagoryDAO");
	 catagory=(Catagory)Context.getBean("Catagory");
	}
	 
	

@Test
public void CreateCatagoryTestCase(){
	catagory.setCatagory_id(01);
	catagory.setCatagory_description("canon AV ");
	catagory.setCatagory_name("lens");
	
	boolean status = catagoryDAO.save(catagory);
	Assert.assertEquals("Create a Catagorytestcase",true,status);
	
	
}


@Test
public void updateCatagoryTestCase(){
	catagory.setCatagory_id(01);
	catagory.setCatagory_description("canon VR2 AFcgacsghfcasd le");
	catagory.setCatagory_name("lens");
	
	boolean status = catagoryDAO.update(catagory);
	Assert.assertEquals("update a Catagorytestcase",true,status);
}

@Test
public void deleteCatagoryTestCase(){
	catagory.setCatagory_id(02);
	catagory.setCatagory_description("nikon lens");
	catagory.setCatagory_name("lens");
	
	boolean status = catagoryDAO.delete(catagory);
	Assert.assertEquals("delate a Catagorytestcase",true,status);
}
@Test
public void getCatagoryTestCase()
{
	Assert.assertEquals("Get CatagoryTestCase",null, catagoryDAO.get(02));
	
	}
@Test
public void getAllCatagoryTestCase()
{
	Assert.assertEquals("getAllCatagoryTestCase",2, catagoryDAO.list().size());
}

}

package niit.com.backendshoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.com.backendshoppingcart.model.Catagory;
public class CatagoryTest {
     public static void main(String[] args)  {
	AnnotationConfigApplicationContext annotationApplication = new AnnotationConfigApplicationContext();
	System.out.println("AppcOntext");
	
	annotationApplication.scan("niit.com.backendshoppingcart");
	annotationApplication.refresh();
	System.out.println("refresh");
	
	Catagory catagory =  (Catagory) annotationApplication.getBean("catagory");
	System.out.println(""+catagory);
	System.out.println("catagory");

     }
}
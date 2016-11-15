package niit.com.backendshoppingcart;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.com.backendshoppingcart.model.Products;
public class ProductsTest { 
     public static void main(String[] args)  {
	AnnotationConfigApplicationContext annotationApplication = new AnnotationConfigApplicationContext();
	System.out.println("AppcOntext");
	
	annotationApplication.scan("niit.com.backendshoppingcart");
	annotationApplication.refresh();
	System.out.println("refresh");
	
	Products products =  (Products) annotationApplication.getBean("products");
	System.out.println(""+products);
	System.out.println("products");

     }
}



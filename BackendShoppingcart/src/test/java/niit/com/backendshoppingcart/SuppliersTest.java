package niit.com.backendshoppingcart;


	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

	import niit.com.backendshoppingcart.model.Suppliers;
	public class SuppliersTest {
	     public static void main(String[] args)  {
		AnnotationConfigApplicationContext annotationApplication = new AnnotationConfigApplicationContext();
		System.out.println("AppcOntext");
		
		annotationApplication.scan("niit.com.backendshoppingcart");
		annotationApplication.refresh();
		System.out.println("refresh");
		
		Suppliers suppliers =  (Suppliers) annotationApplication.getBean("suppliers");
		System.out.println(""+suppliers);
		System.out.println("suppliers");

	     }
	}



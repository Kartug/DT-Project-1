package niit.com.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.com.Dao.ProductsDAO;
import niit.com.model.Products;


@Repository("productsDAO")
@Transactional
public class ProductsDAOimpl implements ProductsDAO {

	//SAVE AND UPDATE METHODS NOT NEEDED...... REMOVE IT
	
	
	@Autowired
	private SessionFactory sessionFactory;

	/*public ProductsDAOimpl( ) {
			
	}
	
	 ProductsDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;		
	}*/

	@Transactional
	public boolean save(Products products) {
		// TODO Auto-generated method stub

		try {
			
			Session session = sessionFactory.openSession();
			
			session.save(products);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean saveOrUpdate(Products products) {
		try {

			Session session = sessionFactory.openSession();
			session.saveOrUpdate(products); 
			session.flush();
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Products products) {
		try {
			
			
			
			sessionFactory.openSession().update(products);
			sessionFactory.openSession().flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(String id) {
		try {
			Products productToDelete = new Products();
			productToDelete.setId(id);
			Session session = sessionFactory.openSession();
			session.delete(productToDelete);
			session.flush();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Products get(String id) {


		String hql = "from Products where id='" + id + "'";

		Query query = sessionFactory.openSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Products> listProduct = (List<Products>) query.list();

		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		return null;
	}

	@Transactional
	public Products getByName(String name) {
		
		String hql = "from Products where name='" + name + "'";	
		Query query = sessionFactory.openSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Products> listProduct = (List<Products>) query.list();

		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Products> list() {

		String hql = "from Products ORDER BY ID ASC ";
		Query query = sessionFactory.openSession().createQuery(hql);
		List<Products> list = query.list();
		if (list == null || list.isEmpty()) {
			System.out.println("No products available");
		}
		return list;
	}
}

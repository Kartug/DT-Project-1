package niit.com.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.com.Dao.SuppliersDAO;
import niit.com.model.Suppliers;


@Repository("SuppliersDAO")
@Transactional
public class SuppliersDAOimpl implements SuppliersDAO {

	//SAVE AND UPDATE METHODS NOT NEEDED...... REMOVE IT
	
	
	@Autowired
	private SessionFactory sessionFactory;

	public  SuppliersDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;		
	}
	
	public SuppliersDAOimpl( ) {
	
	}
	
	
	@Transactional
	public Suppliers getByName(String name) {


		String hql = "from Suppliers where name='" + name + "'";

		Query query = sessionFactory.openSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Suppliers> listSuppliers = (List<Suppliers>) query.list();

		if (listSuppliers != null && !listSuppliers.isEmpty()) {
			return listSuppliers.get(0);
		}

		return null;
	}
	@Transactional
	public boolean save(Suppliers suppliers) {
		// TODO Auto-generated method stub

		try {
			sessionFactory.openSession().save(suppliers);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean saveOrUpdate(Suppliers suppliers) {
		try {
			Session session = sessionFactory.openSession();
			session.saveOrUpdate(suppliers); 
			session.flush();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Suppliers suppliers) {
		try {
			sessionFactory.openSession().update(suppliers);
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
			Suppliers supplierToDelete = new Suppliers();
			supplierToDelete.setId(id);
			Session session = sessionFactory.openSession();
			session.delete(supplierToDelete);
			session.flush();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Suppliers get(String id) {


		String hql = "from Suppliers where id='" + id + "'";

		Query query = sessionFactory.openSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Suppliers> listSupplier = (List<Suppliers>) query.list();

		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}

		return null;
	}

	@Transactional
	public List<Suppliers> list() {

		String hql = "from Suppliers ORDER BY ID ASC";
		Query query = sessionFactory.openSession().createQuery(hql);
		List<Suppliers> list = query.list();
		if (list == null || list.isEmpty()) {
			System.out.println("No products available");
		}
		return list;
	}
}

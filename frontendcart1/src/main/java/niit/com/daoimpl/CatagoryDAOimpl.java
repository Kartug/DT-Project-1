package niit.com.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import niit.com.Dao.CatagoryDAO;
import niit.com.model.Catagory;
@Repository("CatagoryDAO")
@Transactional
public class CatagoryDAOimpl implements CatagoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CatagoryDAOimpl (SessionFactory sessionFactory) //constructor
{
	this.sessionFactory=sessionFactory;
}
	
	/*@Transactional
	public Catagory get(String id) {

	
		String hql = "from Catagory where catagory_id='" + catagory_id + "'";
		Session session = sessionFactory.openSession();		
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Catagory> listCatagory = (List<Catagory>) query.list();
		if (listCatagory != null && !listCatagory.isEmpty()) {			
			return listCatagory.get(0);
		}
		return null;
	}*/
	@Transactional
	public Catagory get(String id) {
		return (Catagory)sessionFactory.openSession().get(Catagory.class,id);
		
	}


	@Transactional
	public Catagory getByName(String catagory_name) {

		String hql = "from Catagory where catagory_name='" + catagory_name + "'";
		
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Catagory> listCatagory = (List<Catagory>) query.list();

		if (listCatagory != null && !listCatagory.isEmpty()) {
		
			return listCatagory.get(0);
		}

		return null;
	}
	
	@Transactional
	public boolean saveOrUpdate(Catagory catagory) {
		
		try {
			System.out.println("inside save or update");
			Session session = sessionFactory.openSession();
			session.saveOrUpdate(catagory); 
			session.flush();
					
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			return false;
		}
	}


	@Transactional
	public boolean delete(String id) {
		try {
			Catagory categoryToDelete = new Catagory();
			categoryToDelete.setCatagory_id(id);
			Session session = sessionFactory.openSession();
			session.delete(categoryToDelete);
			session.flush();
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public List<Catagory> list() {

		
		String hql = "from Catagory ORDER BY id ASC ";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		List<Catagory> list = query.list();
		if (list == null || list.isEmpty()) {
		System.out.println("list is empty");
		}
		
		return list;
	}
}

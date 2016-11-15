package niit.com.backendshoppingcart.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.com.backendshoppingcart.Dao.CatagoryDAO;
import niit.com.backendshoppingcart.model.Catagory;
@Repository("CatagoryDAO")
public class CatagoryDAOimpl implements CatagoryDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public CatagoryDAOimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean save(Catagory catagory) {
		try{
			
			sessionFactory.getCurrentSession().save(catagory);
		return true;
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;
	}
		

}	
	@Transactional
	public boolean update(Catagory catagory) {
		try {
			sessionFactory.getCurrentSession().update(catagory);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
     @Transactional
	public boolean delete(Catagory catagory) {
		
		try {
			sessionFactory.getCurrentSession().delete(catagory);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
    	 
     }
     @Transactional
 	public Catagory get(int id) {
 		 return (Catagory) sessionFactory.getCurrentSession().get(Catagory.class,id);
     }
@Transactional
	public List<Catagory> list() {
		String hql = "from Catagory";
		org.hibernate.Query query= sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
	
	}

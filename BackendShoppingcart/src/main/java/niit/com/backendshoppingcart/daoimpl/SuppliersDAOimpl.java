package niit.com.backendshoppingcart.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.com.backendshoppingcart.Dao.SuppliersDAO;
import niit.com.backendshoppingcart.model.Suppliers;
@Repository("SuppliersDAO")
public class SuppliersDAOimpl implements SuppliersDAO {
	@Autowired
	 private SessionFactory sessionFactory;
	
	public SuppliersDAOimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional

	public List<Suppliers> list() {
		String hql = "from Suppliers";
		org.hibernate.Query query= sessionFactory.getCurrentSession().createQuery(hql);
		return  query.list();
	}
  @Transactional
	public Boolean save(Suppliers suppliers) {
			try{
				
				sessionFactory.getCurrentSession().save(suppliers);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
  @Transactional
	public Boolean update(Suppliers suppliers) {
		
			try {
				sessionFactory.getCurrentSession().update(suppliers);
				return true;
			} catch (HibernateException e){ 
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
	
  @Transactional
	public Boolean delete(Suppliers suppliers) {
		 
			
				
				try {
					sessionFactory.getCurrentSession().delete(suppliers);
					return true;
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
		    	 
	}
  @Transactional

public Suppliers get(int id) {
	 return (Suppliers) sessionFactory.getCurrentSession().get(Suppliers.class,id);
	
}

}

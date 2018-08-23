/**
 * 
 */
package com.fa.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.fa.dao.AbstractDao;
import com.fa.dao.UserDao;
import com.fa.model.AppUsers;

/**
 * @author Administrator
 *
 */
@Repository
public class UserDaoImpl extends AbstractDao<Integer,AppUsers> implements UserDao {

	@Override
	public AppUsers findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public AppUsers findBySSO(String sso) {
		try{
			AppUsers user = (AppUsers) getEntityManager()
                    .createQuery("SELECT u FROM AppUsers u WHERE u.ssoId:ssoId")
                    .setParameter("ssoId", sso)
                    .getSingleResult();
             
            return user; 
        }catch(NoResultException ex){
            return null;
        }
	}

	@Override
	public void save(AppUsers user) {
		persist(user);
	}

	@Override
	public void deleteBySSO(String sso) {
		AppUsers user = (AppUsers) getEntityManager()
                .createQuery("SELECT u FROM AppUsers u WHERE u.ssoId:ssoId")
                .setParameter("ssoId", sso)
                .getSingleResult();
        delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AppUsers> findAllUsers() {
		List<AppUsers> users = getEntityManager()
                .createQuery("SELECT u FROM AppUsers u ORDER BY u.firstName ASC")
                .getResultList();
        return users;
	}

}

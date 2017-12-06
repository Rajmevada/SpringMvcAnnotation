package com.rajmevada.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rajmevada.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public User findBySSO(String sso) {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssoId", sso));

		return (User) criteria.uniqueResult();
	}

}

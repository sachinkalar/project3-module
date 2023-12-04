package com.rays.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDTO;
import com.rays.util.HibDataSource;

public class UserModelHibImp implements UserModelInt {

	public long add(UserDTO dto) throws Exception {

		Session session = HibDataSource.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			System.out.println("trac");
			session.save(dto);
			System.out.println("trac1");
			dto.getId();
			System.out.println("trac3");
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			// throw new ApplicationException("Exception in User Add " + e.getMessage());
		} finally {
			session.close();
		}
		return dto.getId();

	}

	public UserDTO authenticate(String login, String password) {

		UserDTO dto = null;
		Session session = HibDataSource.getSession();

		Query q = session.createQuery("from UserDTO where LoginId=? and  Password=?");
		q.setString(0, login);
		q.setString(1, password);

		List list = q.list();
		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
			return dto;
		}
		return null;

	}

	public List list(int pageNo, int pageSize) throws Exception {

		List list = null;
		Session session = null;

		Criteria criteria = session.createCriteria(UserDTO.class);

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);

		}
		session.close();
		list = criteria.list();

		return list;

	}

	public List search(UserDTO dto, int pageNo, int pageSize) throws Exception {

		Session session = null;
		ArrayList<UserDTO> list = null;

		session = HibDataSource.getSession();

		Criteria criteria = session.createCriteria(UserDTO.class);

		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.ilike("FirstName", dto.getFirstName() + "%"));
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}

		list = (ArrayList<UserDTO>) criteria.list();

		session.close();

		return list;

	}

	public void delete(UserDTO dto) throws Exception {

		Session session = null;

		session = HibDataSource.getSession();

		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			session.delete(dto);

			dto.getId();

			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			// TODO: handle exception
		} finally {
			session.close();
		}

	}

	public UserDTO findByPk(int pk) throws Exception {

		Session session = null;
		UserDTO dto = null;

		try {
			session = HibDataSource.getSession();

			dto = (UserDTO) session.get(UserDTO.class, pk);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}

		return dto;

	}

	
}

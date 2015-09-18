package com.hand.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hand.dao.SpecialDiscountDao;
import com.hand.model.Om_normal_discount;
import com.hand.model.Om_special_discount;
@Repository("specialDiscountDao")
public class SpecialDiscountDaoImpl implements SpecialDiscountDao{
	@Autowired()
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private Session session;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Om_special_discount om_special_discount) {
		session = sessionFactory.getCurrentSession();
		session.save(om_special_discount);
		System.out.println("插入一个用户");
		
	}

	public Om_special_discount find(int discount_id) {
		session = sessionFactory.getCurrentSession();
		Om_special_discount om_specail_discount = null;
		om_specail_discount = (Om_special_discount)session.get(Om_special_discount.class, discount_id);
		return om_specail_discount;
	}

	public void update(int discount_id, String discount_name, String cust_code, int amount, int applied_amount,
			int balance, String activity) {
		session = sessionFactory.getCurrentSession();
		Om_special_discount om_special_discount = (Om_special_discount)session.get(Om_special_discount.class,discount_id);
		om_special_discount.setDiscount_name(discount_name);
		om_special_discount.setAmount(amount);
		om_special_discount.setApplied_amount(applied_amount);
		om_special_discount.setBalance(balance);
		om_special_discount.setCust_code(cust_code);
		om_special_discount.setActivity(activity);
		session.update(om_special_discount);
		System.out.println("更新了一条记录");
		// TODO Auto-generated method stub
		
	}

	public List<Om_special_discount> select() {
		session = sessionFactory.getCurrentSession();
		List<Om_special_discount> om_specail_discount = null;
		om_specail_discount = session.createQuery("From Om_special_discount").list();
		return om_specail_discount;
	}

}

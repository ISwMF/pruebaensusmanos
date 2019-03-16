package com.helloworld.apispring.model.dao;

import com.helloworld.apispring.model.entity.Ciudadano;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CiudadanoRepositorio {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Integer crearCiudadano(Ciudadano ciudadano) {
        getSessionFactory().getCurrentSession().save(ciudadano);
        return ciudadano.getId();
    }

    public List<Ciudadano> getAllCitizen() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Ciudadano.class);
        return criteria.list();
    }

    public Ciudadano getCitizenByID(int id) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Ciudadano.class);
        criteria.add(Restrictions.eq("id", id));
        return (Ciudadano) criteria.uniqueResult();
    }

    public List<Ciudadano> getAllCitizenOrderedByPoints() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Ciudadano.class);
        criteria.addOrder(Order.desc("puntos"));
        return criteria.list();
    }

}

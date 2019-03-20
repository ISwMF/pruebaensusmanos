package com.helloworld.apispring.model.dao;

import com.helloworld.apispring.model.entity.Reporte;
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
public class ReporteRepositorio {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public long crearReporte(Reporte reporte) {
        getSessionFactory().getCurrentSession().save(reporte);
        return reporte.getReporteId();
    }

    public List<Reporte> getAllReportsByCitizen(int id) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Reporte.class);
        criteria.createAlias("ciudadano", "c");
        criteria.add(Restrictions.eq("c.id", id));
        return criteria.list();
    }
}

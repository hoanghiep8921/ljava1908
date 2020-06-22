package com.example.backendkyc.service;

import com.example.backendkyc.model.RequestService;
import com.example.backendkyc.model.User;
import com.example.backendkyc.utils.Comparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RequestServiceImpl {
    private static final Logger LOGGER = LogManager.getLogger(RoleService.class);
    @Autowired
    EntityManagerFactory entityManagerFactory;
    @Autowired
    EntityManager em;

    public List<RequestService> searchRequest(Date fromDate, Date toDate, String clientId, String requestId, Pageable pageable){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<RequestService> cq = cb.createQuery(RequestService.class);

        Root<RequestService> requestServiceRoot = cq.from(RequestService.class);
        List<Predicate> predicates = new ArrayList<>();

        if (!Comparator.isEqualNull(fromDate)) {
            predicates.add(cb.greaterThanOrEqualTo(requestServiceRoot.get("time"), fromDate));
        }
        if (!Comparator.isEqualNull(toDate)) {
            predicates.add(cb.lessThanOrEqualTo(requestServiceRoot.get("time"), toDate));
        }
        if (!Comparator.isEqualNullOrEmpty(clientId)) {
            predicates.add(cb.like(requestServiceRoot.get("clientId"), "%" + clientId + "%"));
        }
        if (!Comparator.isEqualNullOrEmpty(requestId)) {
            predicates.add(cb.like(requestServiceRoot.get("requestId"), "%" + requestId + "%"));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        cq.orderBy(cb.desc(requestServiceRoot.get("time")));
        List<RequestService> lstRequest = null;
        if(!Comparator.isEqualNull(pageable)){
            lstRequest = em.createQuery(cq)
                    .setFirstResult((int)pageable.getOffset())
                    .setMaxResults(pageable.getPageSize())
                    .getResultList();
        }else{
            lstRequest = em.createQuery(cq).getResultList();
        }
        return lstRequest;
    }
    public long countSearchRequest(Date fromDate, Date toDate,String clientId,String requestId){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);

        Root<RequestService> requestServiceRoot = cq.from(RequestService.class);
        cq.select(cb.count(requestServiceRoot));
        List<Predicate> predicates = new ArrayList<>();

        if (!Comparator.isEqualNull(fromDate)) {
            predicates.add(cb.greaterThanOrEqualTo(requestServiceRoot.get("time"), fromDate));
        }
        if (!Comparator.isEqualNull(toDate)) {
            predicates.add(cb.lessThanOrEqualTo(requestServiceRoot.get("time"), toDate));
        }
        if (!Comparator.isEqualNullOrEmpty(clientId)) {
            predicates.add(cb.like(requestServiceRoot.get("clientId"), "%" + clientId + "%"));
        }
        if (!Comparator.isEqualNullOrEmpty(requestId)) {
            predicates.add(cb.like(requestServiceRoot.get("requestId"), "%" + requestId + "%"));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        Long count = em.createQuery(cq).getSingleResult();
        return count;
    }
}

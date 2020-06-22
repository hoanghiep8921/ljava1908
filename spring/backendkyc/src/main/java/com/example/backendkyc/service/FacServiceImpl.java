package com.example.backendkyc.service;

import com.example.backendkyc.model.FACService;
import com.example.backendkyc.model.RequestService;
import com.example.backendkyc.utils.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FacServiceImpl {

    @Autowired
    EntityManager entityManager;

    public List<FACService> searchFaceRequest(Date fromDate, Date toDate, String clientId, String requestId, Pageable pageable){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FACService> cq = cb.createQuery(FACService.class);

        Root<FACService> facServiceRoot = cq.from(FACService.class);
        Join<FACService, RequestService> request = facServiceRoot.join("request",JoinType.INNER);
        List<Predicate> predicates = new ArrayList<>();

        if (!Comparator.isEqualNull(fromDate)) {
            predicates.add(cb.greaterThanOrEqualTo(request.get("time"), fromDate));
        }
        if (!Comparator.isEqualNull(toDate)) {
            predicates.add(cb.lessThanOrEqualTo(request.get("time"), toDate));
        }
        if (!Comparator.isEqualNullOrEmpty(clientId)) {
            predicates.add(cb.like(request.get("clientId"), "%" + clientId + "%"));
        }
        if (!Comparator.isEqualNullOrEmpty(requestId)) {
            predicates.add(cb.like(request.get("requestId"), "%" + requestId + "%"));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        cq.orderBy(cb.desc(request.get("time")));
        List<FACService> lstRequest = null;
        if(!Comparator.isEqualNull(pageable)){
            lstRequest = entityManager.createQuery(cq)
                    .setFirstResult((int)pageable.getOffset())
                    .setMaxResults(pageable.getPageSize())
                    .getResultList();
        }else{
            lstRequest = entityManager.createQuery(cq).getResultList();
        }
        return lstRequest;
    }

    public long countSearchRequest(Date fromDate, Date toDate,String clientId,String requestId){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);

        Root<FACService> facServiceRoot = cq.from(FACService.class);
        Join<FACService, RequestService> request = facServiceRoot.join("request",JoinType.INNER);
        cq.select(cb.count(facServiceRoot));
        List<Predicate> predicates = new ArrayList<>();

        if (!Comparator.isEqualNull(fromDate)) {
            predicates.add(cb.greaterThanOrEqualTo(request.get("time"), fromDate));
        }
        if (!Comparator.isEqualNull(toDate)) {
            predicates.add(cb.lessThanOrEqualTo(request.get("time"), toDate));
        }
        if (!Comparator.isEqualNullOrEmpty(clientId)) {
            predicates.add(cb.like(request.get("clientId"), "%" + clientId + "%"));
        }
        if (!Comparator.isEqualNullOrEmpty(requestId)) {
            predicates.add(cb.like(request.get("requestId"), "%" + requestId + "%"));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        Long count = entityManager.createQuery(cq).getSingleResult();
        return count;
    }
}

package com.example.backendkyc.service;

import com.example.backendkyc.model.User;
import com.example.backendkyc.reposiroty.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@Service
public class UserService {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager em;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public List<User> searchListAll(User appUser) {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUserByUserName(String userName) {
        User user = null;
        Optional<User> optUser = userRepository.findByUserName(userName);
        if(optUser.isPresent()){
            user = optUser.get();
        }
        return user;
    }

    public List<User> findUser(User user, String fromDate, String toDate) throws Exception {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);

        Root<User> users = cq.from(User.class);
        List<Predicate> predicates = new ArrayList<>();

        if (user.getUserName() != null && !user.getUserName().isEmpty()) {
            predicates.add(cb.like(users.get("username"), "%" + user.getUserName() + "%"));
        }
        if (user.getEmail() != null && !user.getEmail().isEmpty()) {
            predicates.add(cb.like(users.get("email"), "%" + user.getEmail() + "%"));
        }
        if (user.getFullName() != null && !user.getFullName().isEmpty()) {
            predicates.add(cb.like(users.get("fullName"), "%" + user.getFullName() + "%"));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }
//
}

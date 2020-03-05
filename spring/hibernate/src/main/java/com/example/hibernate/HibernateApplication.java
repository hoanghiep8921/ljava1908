package com.example.hibernate;

import com.example.hibernate.dao.UserDao;
import com.example.hibernate.model.User;
import com.example.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@SpringBootApplication
public class HibernateApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @Autowired
    EntityManagerFactory emf;
    @Override
    public void run(String...args) throws Exception {
//        User u = new User();
//        u.setCountry("HN");
//        u.setName("Hiep");
//        userService.createUser(u);
//        User u1 = userDao.getUserById(1L);
//        System.out.println(u1.getName());
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Object[]> results = em.createQuery("SELECT p.country, p.name FROM User p ")
                .getResultList();

        for (Object[] result : results) {
            System.out.println((result[0] + " " + result[1]));
        }

        em.getTransaction().commit();
        em.close();
    }


}

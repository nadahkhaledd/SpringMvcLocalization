package com.vodafone.repository;

import com.vodafone.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImplementation implements UserRepository{


    private final SessionFactory factory;

    @Autowired
    public UserRepositoryImplementation(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void saveUser(User user) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        }
    }

    @Override
    public List<User> getAll(){
        List<User> users;

        try (Session session = factory.openSession()) {
            users = session.createQuery("from User", User.class)
                    .list();
        }

        return users;
    }




}

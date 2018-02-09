package repositories;


import entity.User;
import helper.EntityHelper;

import javax.persistence.EntityManager;

public class UserRepository {

    //EntityManager entityManager = EntityHelper.getEntityManager();

    public static void save(User user) {
        EntityManager entityManager = EntityHelper.getEntityManager();

        entityManager.persist(user);

    }




    public static User findByEmail(String email) {
        EntityManager entityManager = EntityHelper.getEntityManager();
        return entityManager.find(User.class, email);

    }




}

package helper;


import play.db.jpa.JPA;

import javax.persistence.EntityManager;

public class EntityHelper {

    public static EntityManager getEntityManager() {
        return JPA.em();
    }
}

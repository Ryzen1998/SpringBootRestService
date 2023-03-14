package com.blueLine.java.webServices.blueline.spingService.common.user.repository.userExtRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

@Repository
@Transactional(readOnly = false)
public class UserExtRepositoryImpl implements UserExtRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void newUserAddedJob(Long id,String addedBy) {
        addedBy = addedBy==null?"SYSTEM":addedBy;
        try{
            entityManager.
                    createNativeQuery("insert into user_extended (user_id, created_by, created_date, last_login_date) values (?1,?2,?3,?4);").
                    setParameter(1,id).setParameter(2,addedBy).setParameter(3,new Date()).setParameter(4,new Date()).
                    executeUpdate();
        }catch(Exception ex){
          System.out.println(ex.getMessage());
        }
    }
}

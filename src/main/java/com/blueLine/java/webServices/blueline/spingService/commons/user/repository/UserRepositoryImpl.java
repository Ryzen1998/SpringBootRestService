package com.blueLine.java.webServices.blueline.spingService.commons.user.repository;

import com.blueLine.java.webServices.blueline.spingService.commons.user.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional()
public class UserRepositoryImpl implements UserRepositoryCustom
{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> resultList = new ArrayList<>();
        try {
            resultList = entityManager.createNativeQuery("select * from user_data",User.class).getResultList();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultList;
    }
}

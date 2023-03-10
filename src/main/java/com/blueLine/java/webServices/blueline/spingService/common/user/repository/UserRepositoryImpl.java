package com.blueLine.java.webServices.blueline.spingService.common.user.repository;

import com.blueLine.java.webServices.blueline.spingService.common.user.dto.SignupDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.enums.FilterUserBy;
import com.blueLine.java.webServices.blueline.spingService.common.user.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = false)
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

    @Override
    public void addNewUser(SignupDto data) {

        try {
                     entityManager.createNativeQuery("insert into user_data ( email, is_active, name, password, " +
                    "phone_number, role, user_name)\n" +
                    "values (?1,?2,?3,?4,?5,?6,?7)").setParameter(1,data.getEmail())
                    .setParameter(2,false).setParameter(3,data.getName())
                    .setParameter(4,data.getPassword()).setParameter(5,data.getPhoneNumber())
                    .setParameter(6,1).setParameter(7,data.getUserName()).executeUpdate();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public User findUserBy(FilterUserBy filter, String searchParameter) {
        User result;
        try {
            result =(User)entityManager.createNativeQuery(String.format(
                    "select * from user_data where upper(%s)=?1",filter.toString())
                            ,User.class)
                    .setParameter(1,searchParameter.toUpperCase()).
                             getSingleResult();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
        return result;
    }

    @Override
    public User getUserById(Long id) {
        User result;
        try{
            result =(User)entityManager.createNativeQuery("select * from user_data where id=?1",User.class).
                     setParameter(1,id).
                     getSingleResult();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
        return result;
    }

    @Override
    public User updateUser(User user) {
        User result;
        try {
                   entityManager.createNativeQuery("update user_data set email=?1, name=?2, phone_number=?3 where id=?4",User.class).
                    setParameter(1,user.getEmail()).
                    setParameter(2,user.getName()).
                    setParameter(3,user.getPhoneNumber()).
                    setParameter(4,user.getId()).executeUpdate();

                    result = getUserById(user.getId());

        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
        return result;
    }
}

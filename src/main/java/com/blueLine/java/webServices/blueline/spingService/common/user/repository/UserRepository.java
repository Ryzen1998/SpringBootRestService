package com.blueLine.java.webServices.blueline.spingService.common.user.repository;

import com.blueLine.java.webServices.blueline.spingService.common.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>,UserRepositoryCustom {

}

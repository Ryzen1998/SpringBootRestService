package com.blueLine.java.webServices.blueline.spingService.common.user.repository.userExtRepo;

import com.blueLine.java.webServices.blueline.spingService.common.user.model.UserExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExtRepository extends JpaRepository<UserExt,Long>, UserExtRepositoryCustom {

}

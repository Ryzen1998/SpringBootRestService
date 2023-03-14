package com.blueLine.java.webServices.blueline.spingService.common.security.blueLineAuthenticationContext;

import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.common.user.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public class blueLineAuthContext {
    public static class AuthContext{
        private static String email;
        private static Collection<? extends GrantedAuthority> role;
        public static boolean userRoleIs(Role role){
            if(role!=null) {
                return role.toString().equals(getRole());
            }
            return false;
        }
        public static boolean userEmailIs(String email){
            if(email!=null){
                return email.equals(AuthContext.email);
            }
            return false;
        }
        public static String getEmail() {
            return email;
        }
        public static void setEmail(String email) {
            AuthContext.email = email;
        }
        private static String getRole() {
            return role.toArray()[0].toString();
        }
        public static void setRole(Collection<? extends GrantedAuthority> role) {
            AuthContext.role = role;
        }
    }
}

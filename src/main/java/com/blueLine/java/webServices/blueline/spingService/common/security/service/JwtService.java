package com.blueLine.java.webServices.blueline.spingService.common.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private static final String secreteKey="79244226452948404D635166546A576E5A7234743777217A25432A462D4A614E645267556B58703273357638782F413F4428472B4B6250655368566D59713374";

    public String generateToken( Map<String,Object> extraClaims, UserDetails userDetails){
       return Jwts.builder().setClaims(extraClaims).
               setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).
               setExpiration(new Date(System.currentTimeMillis()+1000*60*24)).signWith(getSigningKey(), SignatureAlgorithm.HS512).
               compact();
    };
    public boolean isTokenValid(String jwtToken,UserDetails userDetails){
        final String email = extractUserName(jwtToken);
        return (email.equals(userDetails.getUsername())) && !isTokenExpired(jwtToken);
    };

    private boolean isTokenExpired(String jwtToken) {
        return extractExpiration(jwtToken).before(new Date());
    };
    private Date extractExpiration(String jwtToken) {
        return extractClaim(jwtToken,Claims::getExpiration);
    };
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    };

    public String extractUserName(String jwtToken) {
        return extractClaim(jwtToken,Claims::getSubject);
    };

    public <T> T extractClaim(String jwtToken, Function<Claims,T>claimsResolver){
       final Claims claims = extractClaims(jwtToken);
       return claimsResolver.apply(claims);
    };

    private Claims extractClaims(String jwtToken){
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(jwtToken).getBody();
    };

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secreteKey);
        return Keys.hmacShaKeyFor(keyBytes);
    };
}

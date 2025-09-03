package br.com.gestao_vendas_b2b.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private final String jwtSecret = "4261656C64756E67";

    // Gera a chave secreta para assinar o JWT
    private Key getSigningKey(){ // ajuda a assinar a key com um algoritmo criptografado
        byte[] keyBytes = Decoders.BASE64.decode(this.jwtSecret); // decodificamos a jwtKey em bites
        return Keys.hmacShaKeyFor(keyBytes); // gerando uma chave secreta criptografada com algoritmo HMAC
    }

    public String generateJwtToken(Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        long jwtExpirationMs = 86400000; // 24 horas
        return Jwts.builder()
                .subject((userPrincipal.getUsername()))
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(getSigningKey())
                .compact();
    }

}

package com.springboot.richttms.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class jwtUtil {



    /* token秘钥*/
    public static final String SECRET = "JKKLJOoasdlfj";

    /** token 过期时间: 1天 */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 1;
    public static String createToken(String name,String password){
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();

        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        // build token
        // param backups {iss:Service, aud:APP}
        String token = JWT.create().withHeader(map) // header
                .withClaim("iss", "Service") // payload
                .withClaim("aud", "APP")
                .withClaim("email", name)
                .withClaim("password",password)
                .withIssuedAt(iatDate) // sign time
                .withExpiresAt(expiresDate) // expire time
                .sign(Algorithm.HMAC256(SECRET)); // signature
        return token;
    }


    /**
     * 解密token
     * @param token
     * @return
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            // e.printStackTrace();
            // token 校验失败, 抛出Token验证非法异常
        }
        return jwt.getClaims();
    }


    public static Map<String,String> getAppUID(String token) {
        Map<String, Claim> claims = verifyToken(token);

        Claim name_claim = claims.get("email");
        Claim password_claim = claims.get("password");

        if (null == name_claim || StringUtils.isEmpty(name_claim)) {
            // token 校验失败, 抛出Token验证非法异常
        }
        String name= name_claim.asString();
        String password=password_claim.asString();
        Map<String,String> map=new HashMap();
        map.put(name,password);
        return map;
    }
}

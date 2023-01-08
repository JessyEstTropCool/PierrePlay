package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.MyUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class GameControllerIntagrationTest
{
    @Test
    public void whenRequestGetGames_ThenForbiddenWithNoToken()
    {
        RestAssured.with().when().request("GET", "/games").then().statusCode(403);
    }

    @Test
    public void whenRequestGetGames_ThenForbiddenWithFakeToken()
    {
        RestAssured.with().when().auth().oauth2("thereisnotoken").request("GET", "/games").then().statusCode(403);
    }

    @Test
    public void whenRequestGetGames_ThenOK()
    {
        RestAssured.with().when().auth().oauth2(getToken()).request("GET", "/games").then().statusCode(200);
    }

    private String getToken()
    {
        return Jwts.builder()
                .setSubject("user")
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
                .signWith(SignatureAlgorithm.HS512,"PierreIsTheBestSecretKeyToGenJWTsPierreIsTheBestSecretKeyToGenJWTs".getBytes())
                .compact();
    }
}
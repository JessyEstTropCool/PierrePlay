package be.helb.PierrePlay.controllers;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class GameControllerIntagrationTest
{
    @Test
    public void whenRequestGet_ThenOK()
    {
        RestAssured.with().when().request("GET", "/games").then().statusCode(200);
    }
}
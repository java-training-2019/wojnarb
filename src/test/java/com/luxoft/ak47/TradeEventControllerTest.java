package com.luxoft.ak47;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TradeEventControllerTest {

    @Test
    void tradeEvent() {
        RestAssured
                .given()
                .when().get("/tradeEvent/OBS_1234")
                .then().statusCode(200); //czy strona istnieje

    }

    @Test
    void checkLenght() {  //czy wieksza od 3
        String  currency = RestAssured
                .given()
                .when().get("/tradeEvent/OBS_1234")
                .then().log().body().extract().xmlPath().getString("tradeEvent.tradeCurr");  // pobieramy wartlosc z XMLa  - .log().body() dodane tylko jako logowanie
        if(!currency.matches("(A-Z){3}")){    // regex sprawdzajacy wielkosc liter i czy ma 3 znaki
            Assertions.fail("zla waluta!  :"  + currency);   //wyswietlanie bladu
        }

    }
    @Test
    void checkLenght2() {  //czy wieksza od 3 inna metoda - org.assertj.core.api.Assertions.assertThat
        String  currency1 = RestAssured
                .given()
                .when().get("/tradeEvent/OBS_1234")
                .then().log().body().extract().xmlPath().getString("tradeEvent.tradeCurr");  // pobieramy wartlosc z XMLa  - .log().body() dodane tylko jako logowanie
        assertThat(currency1).as("Currency > 3")
                .isUpperCase()
                .hasSize(3);
    }

}
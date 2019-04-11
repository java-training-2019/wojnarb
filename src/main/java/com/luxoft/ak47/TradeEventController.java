package com.luxoft.ak47;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;
import java.beans.XMLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class TradeEventController {
    @RequestMapping(value = "/tradeEvent/{id}", produces = MediaType.TEXT_XML_VALUE)
    String tradeEvent(@PathVariable String id) {
        String xmlReturned;
        String locationTag;  //testujemy czy location w url zaczyna sie od obs. Jak nie to ma sie nie wyswietlac xpath
        if (id.startsWith("obs_")) {   //trade Id
            String tradeLocation1 = "<tradeLocation>";
            String tradeLocation2 = "</tradeLocation>";
            locationTag = tradeLocation1 + "HKG" + tradeLocation2;
        }
        else {
            locationTag = "";
        }

        // losowanie currency przez list
        List<String> currList = Arrays.asList("USD", "PLN", "EUR","ASDF");
        Random randomCurr = new Random();
        // wyswietlanie XMLa
        String curr = currList.get(randomCurr.nextInt(currList.size()));
        xmlReturned=
                "<tradeEvent>" +
                        "<id>" + id + "</id>" +
                        "<version>0</version>" +
                        "<tradeCurr>" + curr + "</tradeCurr>" +
                        locationTag +
                        "</tradeEvent>";
        return(xmlReturned);
    }
}
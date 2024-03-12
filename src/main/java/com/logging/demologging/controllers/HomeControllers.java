package com.logging.demologging.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeControllers{

    // Inietta i valori delle variabili d'ambiente personalizzate
    @Value("${myapp.custom.variable1}")
    private int variable1;

    @Value("${myapp.custom.variable2}")
    private int variable2;

    // Mapping per la root, restituisce un messaggio di benvenuto
    @GetMapping("/")
    public String welcome() {

        // Logga il messaggio di benvenuto
        System.out.println("Welcome - Benvenuto");
        return "Welcome-Benvenuto";
    }

    // Mapping per "/exp" calcola ed esegue l'esponente dei due valori
    @GetMapping("/exp")
    public double calculateExponent() {

        // Logga l'inizio del calcolo
        System.out.println("Start");

        // Calcola l'esponente delle varibiali indicate in properties
        double result = Math.pow(variable1, variable2);

        // Logga la fine del calcolo
        System.out.println("Finish");
        return result;
    }

    // Mapping per "/get-errors", lancia un'eccezione personalizzata
    @GetMapping("/getErrors")
    public void throwCustomError() throws Exception {

        // Lancia un'eccezione personalizzata per simulare un errore
        throw new Exception("Errore");
    }
}
package com.isi.maven.services.service.imp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandeImplTest {

    private final CommandeImpl commandeImpl = new CommandeImpl(); // Instance de la classe à tester

    @Test
    void getCommande_ShouldReturnExpectedMessage() {
        String result = commandeImpl.getCommande();
        assertEquals("Commande de vehicules ", result);
    }

    @Test
    void somme_ShouldReturnCorrectSum() {
        int result = commandeImpl.somme(3, 7);
        assertEquals(10, result);
    }

    @Test
    void somme_WithNegativeNumbers_ShouldReturnCorrectSum() {
        int result = commandeImpl.somme(-2, -5);
        assertEquals(-7, result);
    }
}

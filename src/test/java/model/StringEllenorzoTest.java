package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringEllenorzoTest {

    private StringEllenorzo strell;

    @BeforeEach
    void setUp() {strell = new StringEllenorzo();
    }

    @AfterEach
    void tearDown() {strell = null;
    }

    @Test
    void stringEllenorzese() {
    }

    @Test
    void aBeirtKarakterekSzamaNulla() {
        assertFalse(strell.aBeirtKarakterekSzamaNulla(" "));
    }

    @Test
    void aBeirtKarakterekSzamaMaxTizennyolcLehet() {
    }

    @Test
    void aBeirtSzovegSzokoztTartalmaz() {
    }

    @Test
    void nemMegengedettKaraktertTartalmaz() {
    }

    @Test
    void azEgyHosszusaguHelyrajziSzamCsakNemNullaSzamLehet() {
    }

    @Test
    void nemKezdodhetKetNullaval() {
    }

    @Test
    void ketPerjelNemLehetEgymasMellett() {
    }

    @Test
    void maxHaromPerjelLehetBenne() {
    }

    @Test
    void betuEsSzamjegyNemLehetEgymasMellett() {
    }

    @Test
    void karakterTipusaPerjel() {
    }

    @Test
    void karakterTipusaSzamjegy() {
    }

    @Test
    void karakterTipusaMegengedettBetu() {
    }
}
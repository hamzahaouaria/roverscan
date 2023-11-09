package com.hhaouari.roverscan.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PlateauTest {

    @Test
    void testEquals() {
        Plateau plateau1 = new Plateau(5, 5);
        Plateau plateau2 = new Plateau(5, 5);
        assertEquals(plateau1, plateau2);
      }

    @Test
    void testHashCode() {
        Plateau plateau1 = new Plateau(5, 5);
        Plateau plateau2 = new Plateau(5, 5);
        assertEquals(plateau1.hashCode(), plateau2.hashCode());
      }

    @Test
    void testToString() {
        Plateau plateau = new Plateau(5, 5);
        String expectedOutput = "5 5";
        assertEquals(expectedOutput, plateau.toString());
      }
}
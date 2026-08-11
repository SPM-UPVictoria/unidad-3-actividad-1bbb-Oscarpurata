package com.astrea.core;

import com.astrea.core.base.*;
import com.astrea.core.naves.*;
import com.astrea.core.exceptions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class NaveEspacialTest {

    // Usaremos NaveCarga para probar los métodos comunes heredados de NaveEspacial
    @Test
    public void testCreacionValida() throws AstreaException {
        NaveEspacial nave = new NaveCarga("NX-01", "Carguero Ligero", 100.0, 500.0, 1000.0);
        assertEquals("NX-01", nave.getMatricula());
        assertEquals("Carguero Ligero", nave.getModelo());
        assertEquals(100.0, nave.getCombustible(), 0.001);
        assertEquals(500.0, nave.getCapacidadCombustible(), 0.001);
    }

    @Test(expected = AstreaException.class)
    public void testCreacionInvalidaCombustibleExcedeCapacidad() throws AstreaException {
        new NaveCarga("NX-02", "Carguero", 600.0, 500.0, 1000.0);
    }

    @Test(expected = AstreaException.class)
    public void testCreacionInvalidaCapacidadNegativa() throws AstreaException {
        new NaveCarga("NX-03", "Carguero", 100.0, -500.0, 1000.0);
    }

    @Test
    public void testRepostarExitoso() throws AstreaException {
        NaveEspacial nave = new NaveCarga("NX-04", "Carguero", 100.0, 500.0, 1000.0);
        nave.repostarCombustible(50.0);
        assertEquals(150.0, nave.getCombustible(), 0.001);
    }

    @Test(expected = AstreaException.class)
    public void testRepostarInvalidoExcedeCapacidad() throws AstreaException {
        NaveEspacial nave = new NaveCarga("NX-05", "Carguero", 100.0, 500.0, 1000.0);
        nave.repostarCombustible(450.0); // 100 + 450 = 550 > 500
    }

    @Test(expected = AstreaException.class)
    public void testRepostarInvalidoCantidadNegativa() throws AstreaException {
        NaveEspacial nave = new NaveCarga("NX-06", "Carguero", 100.0, 500.0, 1000.0);
        nave.repostarCombustible(-20.0);
    }
}

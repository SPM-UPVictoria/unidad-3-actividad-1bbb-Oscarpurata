package com.astrea.core;

import com.astrea.core.base.*;
import com.astrea.core.naves.*;
import com.astrea.core.exceptions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class NaveCargaTest {

    @Test
    public void testViajeLigero() throws AstreaException {
        NaveCarga nave = new NaveCarga("C-100", "Mula", 100.0, 500.0, 1000.0);
        nave.cargar(400.0); // <= 50% de 1000 (500)
        
        nave.viajar(10.0); // Consumo: 1.5 * 10 = 15.0
        
        assertEquals(85.0, nave.getCombustible(), 0.001);
    }

    @Test
    public void testViajePesado() throws AstreaException {
        NaveCarga nave = new NaveCarga("C-101", "Mula Pesada", 100.0, 500.0, 1000.0);
        nave.cargar(600.0); // > 50% de 1000 (500)
        
        nave.viajar(10.0); // Consumo: 3.0 * 10 = 30.0
        
        assertEquals(70.0, nave.getCombustible(), 0.001);
    }

    @Test
    public void testViajeSinCombustible() throws AstreaException {
        NaveCarga nave = new NaveCarga("C-102", "Mula", 10.0, 500.0, 1000.0);
        
        try {
            nave.viajar(10.0); // Requiere 15.0
            fail("Debió lanzar CombustibleInsuficienteException");
        } catch (CombustibleInsuficienteException e) {
            // El combustible no se descuenta
            assertEquals(10.0, nave.getCombustible(), 0.001);
        }
    }
}

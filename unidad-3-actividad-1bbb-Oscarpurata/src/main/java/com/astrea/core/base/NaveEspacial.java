package com.astrea.core.base;

import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;

public abstract class NaveEspacial {
    protected String matricula;
    protected String modelo;
    protected double combustible;
    protected double capacidadCombustible;

    public NaveEspacial(String matricula, String modelo, double combustibleInicial, double capacidadCombustible) throws AstreaException {
        // TODO: Implementar validaciones y asignación
    }

    public void repostarCombustible(double cantidad) throws AstreaException {
        // TODO: Implementar lógica
    }

    public String getMatricula() {
        return null; // TODO: Implementar
    }

    public String getModelo() {
        return null; // TODO: Implementar
    }

    public double getCombustible() {
        return 0.0; // TODO: Implementar
    }

    public double getCapacidadCombustible() {
        return 0.0; // TODO: Implementar
    }

    public abstract void viajar(double distanciaAniosLuz) throws CombustibleInsuficienteException, AstreaException;
}

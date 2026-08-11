package com.astrea.core.naves;

import com.astrea.core.base.NaveEspacial;
import com.astrea.core.interfaces.Propulsable;
import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;
import com.astrea.core.exceptions.FallaSistemasException;

public class NaveExploracion extends NaveEspacial implements Propulsable {
    private double integridadEscudo;
    private boolean hiperviajeListo;

    public NaveExploracion(String matricula, String modelo, double combustibleInicial, double capacidadCombustible) throws AstreaException {
        super(matricula, modelo, combustibleInicial, capacidadCombustible);
        this.integridadEscudo = 100.0;
        this.hiperviajeListo = false;
    }

    public double getIntegridadEscudo() {
        return this.integridadEscudo;
    }

    public boolean isHiperviajeListo() {
        return this.hiperviajeListo;
    }

    @Override
    public void viajar(double distanciaAniosLuz) throws CombustibleInsuficienteException {
        double consumoTotal = 0.8 * distanciaAniosLuz;

        if (getCombustible() < consumoTotal) {
            throw new CombustibleInsuficienteException("Combustible insuficiente para el viaje.");
        }

        this.combustible -= consumoTotal;
    }

    @Override
    public void activarHiperviaje(double factorWarp) throws FallaSistemasException, CombustibleInsuficienteException {
        if (getCombustible() < 50.0) {
            throw new CombustibleInsuficienteException("Combustible insuficiente para activar el hiperviaje.");
        }

        this.combustible -= 50.0;

        if (factorWarp > 9.0 && Math.random() < 0.3) {
            this.hiperviajeListo = false;
            throw new FallaSistemasException("Falla en los sistemas al activar el hiperviaje.");
        }

        this.hiperviajeListo = true;
    }
}
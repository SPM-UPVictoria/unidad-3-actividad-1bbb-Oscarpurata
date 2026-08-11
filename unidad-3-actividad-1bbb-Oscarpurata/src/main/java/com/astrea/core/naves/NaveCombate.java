package com.astrea.core.naves;

import com.astrea.core.base.NaveEspacial;
import com.astrea.core.interfaces.Defendible;
import com.astrea.core.interfaces.Atacable;
import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;
import com.astrea.core.exceptions.EscudoCriticoException;

public class NaveCombate extends NaveEspacial implements Defendible, Atacable {
    private double integridadEscudo;
    private double potenciaArma;

    public NaveCombate(String matricula, String modelo, double combustibleInicial, double capacidadCombustible, double potenciaArma) throws AstreaException {
        super(matricula, modelo, combustibleInicial, capacidadCombustible);
        this.potenciaArma = potenciaArma;
        this.integridadEscudo = 200.0;
    }

    public double getIntegridadEscudo() {
        return this.integridadEscudo;
    }

    public double getPotenciaArma() {
        return this.potenciaArma;
    }

    @Override
    public void viajar(double distanciaAniosLuz) throws CombustibleInsuficienteException {
        double consumoTotal = 2.0 * distanciaAniosLuz;

        if (getCombustible() < consumoTotal) {
            throw new CombustibleInsuficienteException("Combustible insuficiente.");
        }

        this.combustible -= consumoTotal;
    }

    @Override
    public void recibirImpacto(double potenciaDano) throws EscudoCriticoException {
        if (this.integridadEscudo - potenciaDano <= 0) {
            this.integridadEscudo = 0.0;
            throw new EscudoCriticoException("El escudo ha colapsado.");
        }
        this.integridadEscudo -= potenciaDano;
    }

    @Override
    public void atacar(Defendible objetivo) throws AstreaException {
        if (getCombustible() < 15.0) {
            throw new CombustibleInsuficienteException("Combustible insuficiente para atacar.");
        }

        this.combustible -= 15.0;
        objetivo.recibirImpacto(this.potenciaArma);
    }
}
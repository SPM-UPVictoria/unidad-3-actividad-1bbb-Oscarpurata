package com.astrea.core.naves;

import com.astrea.core.base.NaveEspacial;
import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;

public class NaveCarga extends NaveEspacial {
    private double cargaActual;
    private double cargaMaxima;

    public NaveCarga(String matricula, String modelo, double combustibleInicial, double capacidadCombustible, double cargaMaxima) throws AstreaException {
        super(matricula, modelo, combustibleInicial, capacidadCombustible);
        this.cargaMaxima = cargaMaxima;
        this.cargaActual = 0.0;
    }

    public void cargar(double cantidad) throws AstreaException {
        if (this.cargaActual + cantidad > this.cargaMaxima) {
            throw new AstreaException("Carga excede la capacidad máxima.");
        }
        this.cargaActual += cantidad;
    }

    public double getCargaActual() {
        return this.cargaActual;
    }s

    public double getCargaMaxima() {
        return this.cargaMaxima;
    }

    @Override
    public void viajar(double distanciaAniosLuz) throws CombustibleInsuficienteException {
        double factorConsumo = (this.cargaActual <= this.cargaMaxima * 0.5) ? 1.5 : 3.0;
        double consumoTotal = factorConsumo * distanciaAniosLuz;

        if (getCombustible() < consumoTotal) {
            throw new CombustibleInsuficienteException("Combustible insuficiente.");
        }

        // Acceso directo al atributo herencia de NaveEspacial
        this.combustible -= consumoTotal;
    }
}
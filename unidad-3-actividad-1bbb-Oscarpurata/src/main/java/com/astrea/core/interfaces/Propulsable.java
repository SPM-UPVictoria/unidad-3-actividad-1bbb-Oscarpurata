package com.astrea.core.interfaces;

import com.astrea.core.exceptions.FallaSistemasException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;
public interface Propulsable {
    void activarHiperviaje(double factorWarp) throws FallaSistemasException, CombustibleInsuficienteException;
}

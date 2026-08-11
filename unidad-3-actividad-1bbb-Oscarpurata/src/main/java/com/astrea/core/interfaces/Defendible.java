package com.astrea.core.interfaces;

import com.astrea.core.exceptions.EscudoCriticoException;
public interface Defendible {
    void recibirImpacto(double potenciaDano) throws EscudoCriticoException;
}

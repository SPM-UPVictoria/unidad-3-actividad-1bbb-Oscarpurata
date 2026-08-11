package com.astrea.core.interfaces;

import com.astrea.core.exceptions.AstreaException;
public interface Atacable {
    void atacar(Defendible objetivo) throws AstreaException;
}

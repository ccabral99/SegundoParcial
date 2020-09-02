//
// Created by Camila Cabral on 20/07/2020.
//

#ifndef FINALPROG3_NODOARBOL_H
#define FINALPROG3_NODOARBOL_H

template<class T>
class NodoArbol {
private:
    T dato;
    NodoArbol *izq, *der;
public:
    NodoArbol(T d) {
        dato = d;
        izq = nullptr;
        der = nullptr;
    }
    NodoArbol() {
        izq = nullptr;
        der = nullptr;
    }

    T getDato() const {
        return dato;
    }

    void setDato(T dato) {
        this->dato = dato;
    }

    NodoArbol *getIzq() const {
        return izq;
    }

    void setIzq(NodoArbol *izq) {
        NodoArbol::izq = izq;
    }

    NodoArbol *getDer() const {
        return der;
    }

    void setDer(NodoArbol *der) {
        NodoArbol::der = der;
    }
};

#endif //FINALPROG3_NODOARBOL_H

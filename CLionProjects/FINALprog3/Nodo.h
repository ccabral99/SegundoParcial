//
// Created by Camila Cabral on 18/07/2020.
//

#ifndef FINALPROG3_NODO_H
#define FINALPROG3_NODO_H
template<class T>
class Nodo {
private:
    T dato;
    Nodo<T> *siguiente;
public:
    T getDato()  {
        return dato;
    }

    void setDato(T d) {
        dato = d;
    }

    Nodo<T> *getSiguiente()  {
        return siguiente;
    }

    void setSiguiente(Nodo<T> *siguiente) {
        this->siguiente = siguiente;
    }

};


#endif //FINALPROG3_NODO_H

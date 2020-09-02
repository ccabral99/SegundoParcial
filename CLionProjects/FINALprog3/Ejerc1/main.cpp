#include "../Pila.h"
#include <iostream>
//EJERCICIO: Programa que remueve la primera ocurrencia de un entero específico en una pila de enteros.
using namespace std;

void remover(Pila<int> &, int );

int main()
{
    Pila<int> p;
    p.push(3);
    p.push(2);
    p.push(5);
    p.push(3);
    p.push(9);

    remover(p, 5);

    while (!p.esVacia())
    {
        cout<<p.pop()<<"\t";
    }

}

/**
 * Funcion que remueve un entero específico de un arreglo de enteros
 * @param p pila de enteros pasada por referencia
 * @param numero entero a remover
 */

void remover(Pila<int> &p, int numero)
{
    Pila<int> aux;
    while (!p.esVacia() && p.peek() != numero)
    {
        aux.push(p.pop());                      //coloco elementos en pila auxilar hasta que mi tope sea el valor deseado
    }
    if (p.esVacia())
        throw 202;                              //el numero no se encuentra en la pila

    p.pop();                                    //elimino el elemento

    while(!aux.esVacia())
    {
        p.push(aux.pop());                      //vuelvo a p los elementos que estaban por encima del numero a remover
    }
}
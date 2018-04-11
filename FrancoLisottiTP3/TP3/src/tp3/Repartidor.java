/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.util.Stack;

/**
 *
 * @author usuario
 */
public class Repartidor{
    private int id;
    private String nombre;
    private final Stack<Carta> cartas;
    private boolean tieneCartas; 
    
    public Repartidor(int id,String nombre, Stack<Carta> cartas)
    {
        this.id=id;
        this.cartas=cartas;
        this.nombre=nombre;
        this.tieneCartas=true;
    }
    
    public int obtenerId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public synchronized boolean tieneCartas()
    {
        return this.tieneCartas;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public synchronized Carta repartir()
    {
        if (!cartas.isEmpty())
        {
            Carta car = (Carta) this.cartas.pop();
            notify();
            return car;
        }
        else
        {
            tieneCartas=false;
            notify();
            return null;
        }

    }
}

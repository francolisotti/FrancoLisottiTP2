/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;


import java.util.Observable;
import java.util.Stack;
import tp3.Carta;

/**
 *
 * @author usuario
 */
public class Jugador extends Observable implements Runnable {
    private int id;
    private String nombre;
    private Stack<Carta> cartas ;
    private Repartidor rep;
    private int puntaje;
    private boolean finished = false;
    
    public Jugador (int id, String nombre, Repartidor rep)
    {
        this.id=id;
        this.nombre=nombre;
        this.rep=rep;
        this.cartas = new Stack<Carta>();
        this.puntaje = 0;
    }
    
    public Jugador (int id, String nombre)
    {
    	this.cartas = new Stack<Carta>();
    	this.id=id;
        this.nombre=nombre;
        this.puntaje = 0;
    }
    
    public boolean isFinished() {
        return this.finished;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void addCarta(Carta nueva) {
        cartas.add(nueva);      
    }
    
    public Carta getUltima()
    {
    	return cartas.peek();
    }
    
    public int getPuntaje()
    {
    	return puntaje;
    }
    
    public Stack<Carta> getCartas()
    {
    	return cartas;
    }

    @Override
    public void run() {
        while(rep.tieneCartas())
        {
            Carta c = rep.repartir();
            if (c != null){
                this.cartas.push(c);
                setChanged();
                notifyObservers(this);                
            }
            else{
            	
            	Thread.currentThread().interrupt();
                break;             
            }   
        }        
        this.finalizar();       
        
        
        
    }

	public synchronized void  finalizar() {
		for(Carta obj : cartas)
		{
			this.puntaje=this.puntaje + obj.getValor();
		}
        this.finished=true;	
		setChanged();
        notifyObservers(this);

	}
    
    
}

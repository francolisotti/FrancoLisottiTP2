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
public class TP3 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        Stack pila = new Stack();
        Carta c = new Carta(1,"Oro");
        pila.push(c);
        c = new Carta(2,"Oro");
        pila.push(c);
        c = new Carta(3,"Oro");
        pila.push(c);
        c = new Carta(4,"Oro");
        pila.push(c);
        c = new Carta(5,"Oro");
        pila.push(c);
        c = new Carta(6,"Oro");
        pila.push(c);
        c = new Carta(7,"Oro");
        pila.push(c);
        c = new Carta(8,"Oro");
        pila.push(c);
        c = new Carta(9,"Oro");
        pila.push(c);
        c = new Carta(10,"Oro");
        pila.push(c);
        c = new Carta(11,"Oro");
        pila.push(c);
        c = new Carta(12,"Oro");
        pila.push(c);
        
        c = new Carta(1,"Espada");
        pila.push(c);
        c = new Carta(2,"Espada");
        pila.push(c);
        c = new Carta(3,"Espada");
        pila.push(c);
        c = new Carta(4,"Espada");
        pila.push(c);
        c = new Carta(5,"Espada");
        pila.push(c);
        c = new Carta(6,"Espada");
        pila.push(c);
        c = new Carta(7,"Espada");
        pila.push(c);
        c = new Carta(8,"Espada");
        pila.push(c);
        c = new Carta(9,"Espada");
        pila.push(c);
        c = new Carta(10,"Espada");
        pila.push(c);
        c = new Carta(11,"Espada");
        pila.push(c);
        c = new Carta(12,"Espada");
        pila.push(c);
        
        c = new Carta(1,"Basto");
        pila.push(c);
        c = new Carta(2,"Basto");
        pila.push(c);
        c = new Carta(3,"Basto");
        pila.push(c);
        c = new Carta(4,"Basto");
        pila.push(c);
        c = new Carta(5,"Basto");
        pila.push(c);
        c = new Carta(6,"Basto");
        pila.push(c);
        c = new Carta(7,"Basto");
        pila.push(c);
        c = new Carta(8,"Basto");
        pila.push(c);
        c = new Carta(9,"Basto");
        pila.push(c);
        c = new Carta(10,"Basto");
        pila.push(c);
        c = new Carta(11,"Basto");
        pila.push(c);
        c = new Carta(12,"Basto");
        pila.push(c);
        
        c = new Carta(1,"Copa");
        pila.push(c);
        c = new Carta(2,"Copa");
        pila.push(c);
        c = new Carta(3,"Copa");
        pila.push(c);
        c = new Carta(4,"Copa");
        pila.push(c);
        c = new Carta(5,"Copa");
        pila.push(c);
        c = new Carta(6,"Copa");
        pila.push(c);
        c = new Carta(7,"Copa");
        pila.push(c);
        c = new Carta(8,"Copa");
        pila.push(c);
        c = new Carta(9,"Copa");
        pila.push(c);
        c = new Carta(10,"Copa");
        pila.push(c);
        c = new Carta(11,"Copa");
        pila.push(c);
        c = new Carta(12,"Copa");
        pila.push(c);
     
        Repartidor rep = new Repartidor(1,"Jack",pila);
        
        
        Jugador j1 = new Jugador (1,"Juan",rep);
        Jugador j2 = new Jugador (2,"Jorge",rep);
        Jugador j3 = new Jugador (3,"Jaime",rep);
        Jugador j4 = new Jugador (4,"Julio",rep);
        
        Mesa mesa1 = new Mesa (1,rep);
        j1.addObserver(mesa1);
        j2.addObserver(mesa1);
        j3.addObserver(mesa1);
        j4.addObserver(mesa1);
        mesa1.addJugador(j1);
        mesa1.addJugador(j2);
        mesa1.addJugador(j3);
        mesa1.addJugador(j4);
        
        
        
        Thread [] jugadores = new Thread [4];
        jugadores[0] = new Thread (j1);
        jugadores[1] = new Thread (j2);
        jugadores[2] = new Thread (j3);
        jugadores[3] = new Thread (j4);
        
        
        jugadores[0].start();
        jugadores[1].start();
        jugadores[2].start();
        jugadores[3].start();
        
        
        
        

        
       
    }
    
}

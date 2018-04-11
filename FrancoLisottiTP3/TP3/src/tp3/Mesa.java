/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author usuario
 */
public class Mesa implements Observer{
    private int nro;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private Repartidor rep;
    private boolean partidaGuardada=false;
    
    
    public Mesa (int nro, Repartidor rep)
    {
        this.nro = nro;
        this.rep= rep;
    }

    @Override
    public synchronized void update(Observable o, Object arg) {
        if (o instanceof Jugador) {
        	 Jugador j = (Jugador) o;
        	 Carta c = (Carta) j.getUltima();
             System.out.println("El jugador " + j.getId() + " levanto un " + c.getValor() + " de " +c.getPalo());
             
             
            // if (!rep.tieneCartas() && !partidaGuardada)
             if (this.jugadores.get(0).isFinished() && this.jugadores.get(1).isFinished() && this.jugadores.get(2).isFinished() && this.jugadores.get(3).isFinished() && !partidaGuardada)
             {
            		 Jugador ganador = this.calcularGanador();
                     System.out.println("El jugador ganador es "+ ganador.getNombre() + " (Nro " + ganador.getId() +") "+ "con un puntaje de "+ ganador.getPuntaje());
                     PartidaMySqlPersistence pmsqlp= PartidaMySqlPersistence.getInstance();
                     pmsqlp.agregarPartida(ganador);
                     System.out.println("Informacion guardada en la base de datos");
                     this.partidaGuardada=true;
             }
      }
    }

	private Jugador calcularGanador() {
		Jugador ganador=this.jugadores.get(0);
		for (int i=1; i<this.jugadores.size(); i++)
		{
			if (ganador.getPuntaje()<jugadores.get(i).getPuntaje())
			{
				ganador=jugadores.get(i);							
			}
		}
		return ganador;	
	}
	
	public void addJugador(Jugador j)
	{
		jugadores.add(j);
	}
    
}

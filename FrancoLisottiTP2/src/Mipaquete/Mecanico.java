/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mipaquete;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author usuario
 */
public class Mecanico implements Observer{
    String nombre;
    String apellido;
    int edad;

    public Mecanico (String nombre, String apellido, int edad)
    {
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public void update(Observable o, Object arg) {
    	 if (o instanceof Auto) {
    	        Auto auto = (Auto) o;
    	        Auto viejo = (Auto) arg;
    	        System.out.println("Los valores del auto "+ viejo.getPatente()+ " viejos / nuevos: ");
    	        System.out.println("Nivel de agua: "+ viejo.getNivelAgua()+" / "+auto.getNivelAgua());
    	        System.out.println("Nivel de aceite: "+ viejo.getNivelAceite()+" / "+auto.getNivelAceite());
    	        System.out.println("Presion de neumaticos:  "+ viejo.getPresionNeumaticos()+" / "+auto.getPresionNeumaticos());
    	        
    	        /*System.out.println("\nLos valores del auto "+ auto.getPatente()+ " han cambiado a: ");
    	        System.out.println("Nivel de agua: "+ auto.getNivelAgua());
    	        System.out.println("Nivel de aceite: "+ auto.getNivelAceite());
    	        System.out.println("Presion de neumaticos:  "+ auto.getPresionNeumaticos());*/
    	    }
    }
    
}

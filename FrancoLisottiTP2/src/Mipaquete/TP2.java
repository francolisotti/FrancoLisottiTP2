/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mipaquete;

/**
 *
 * @author usuario
 */
public class TP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Auto auto = new Auto("ARZ123",1996,"Oreon","Ford",15.2,2.2,35.3);
        Mecanico mecanico= new Mecanico("Juan","Perez",35);
        auto.addObserver(mecanico);
        auto.setNivelAceite(45.3);        
    }
    
}

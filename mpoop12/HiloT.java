/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpoop12;

/**
 *
 * @author drago
 */
public class HiloT extends Thread{
    public HiloT(String name){
        super(name);
    }
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Interación "+i+" de "+super.getName());
        }
        System.out.println("Termina"+getName());  
    }
    
}

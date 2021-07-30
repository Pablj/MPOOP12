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
public class MPOOP12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HiloT hilo1=new HiloT("Primer hilo");
        hilo1.start();
        new HiloT("Segundo hilo").start();
        System.out.println("Termina hilo principal");
        
        System.out.println("########## Compitiendo###########");
        new Thread(new HiloR (),"Primer hilo").start();
        new Thread(new HiloR(),"Segundo hilo").start();
        System.out.println("Hilo principal");
//        
        
        System.out.println("##########ThreadGroup###########");
        ThreadGroup grupoHilos=new ThreadGroup("grupo de Hilos");
        Thread hilo11=new HiloAgrupado(grupoHilos, "Hilo 1");
        Thread hilo2=new HiloAgrupado(grupoHilos, "Hilo 2");
        Thread hilo3=new HiloAgrupado(grupoHilos, "Hilo 3");
        Thread hilo4=new HiloAgrupado(grupoHilos, "Hilo 4");
        Thread hilo5=new HiloAgrupado(grupoHilos, "Hilo 5");
       
        System.out.println("Prioridad del gurpo:"+grupoHilos.getMaxPriority());
        hilo3.setPriority(Thread.MAX_PRIORITY);
        grupoHilos.setMaxPriority(Thread.NORM_PRIORITY);
        
        System.out.println("Prioridad del gurpo:"+grupoHilos.getMaxPriority());
       
        
        System.out.println("Prioridad del Thead 1="+hilo11.getPriority());
        System.out.println("Prioridad del Thead 2="+hilo2.getPriority());
        System.out.println("Prioridad del Thead 3="+hilo3.getPriority());
        System.out.println("Prioridad del Thead 4="+hilo4.getPriority());
        hilo11.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        listadeHilos(grupoHilos);
        
    
    }

    private static void listadeHilos(ThreadGroup grupoHilos) {
        System.out.println("Entrando a listadeHilos");
        int numHilos;
        Thread[] listadeHilos;
        numHilos=grupoHilos.activeCount();
        listadeHilos=new Thread[numHilos];
        grupoHilos.enumerate(listadeHilos);
        System.out.println("Hilos activos:"+numHilos);
        for (int i = 0; i < numHilos; i++) {
            System.out.println("Hilos activos en pos:"+i+" "+listadeHilos[i].getName());
        }
        //1h 24mins
    }
    
    
}

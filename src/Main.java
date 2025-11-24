import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Array de los pasajeros del barco.
        ArrayList pasajeros = new ArrayList();

        //Se crean las balsas
        Balsa Acasta = new Balsa("Acasta",1,0.5);
        Balsa Banff	 = new Balsa("Banff",2,1);
        Balsa Cadiz	 = new Balsa("Cadiz",3,2);
        Balsa Deimos	 = new Balsa("Deimos",4,4);
        Balsa Expedicion	 = new Balsa("Expedicion",5,8);

        //Bucle For para crear los pasajeros de forma aleatoria
        for (int i = 0; i < 352; i++) {
            pasajeros.add(new Pasajero(i, (int) (Math.random()*4)+1));
        }

        //Construimos barco con el array pasajeros
        Barco barco = new Barco(pasajeros);

        //Creamos los rescates que se van a realizar con sus respectivas balsas
        Rescate rescate1= new Rescate(Acasta,barco);
        Rescate rescate2= new Rescate(Banff,barco);
        Rescate rescate3= new Rescate(Cadiz,barco);
        Rescate rescate4= new Rescate(Deimos,barco);
        Rescate rescate5= new Rescate(Expedicion,barco);


        //Creamos los hilos de rescates
        Thread hiloAcasta = new Thread(rescate1);
        Thread hiloBanff = new Thread(rescate2);
        Thread hiloCadiz = new Thread(rescate3);
        Thread hiloDeimos = new Thread(rescate4);
        Thread hiloExpedicion = new Thread(rescate5);

        //Los empezamos
        hiloAcasta.start();
        hiloBanff.start();
        hiloCadiz.start();
        hiloDeimos.start();
        hiloExpedicion.start();



    }
}
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Rescate implements Runnable{
    private Balsa balsa;
    private Barco barco;
    private Semaphore semaphore;

    public Rescate(){

    }

    public Rescate(Balsa balsa, Barco barco, Semaphore semaphore) {
        this.balsa = balsa;
        this.barco = barco;
        this.semaphore = semaphore;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    @Override
    public void run() {
        while (barco.hayPasajeros()) {
            try {
                System.out.println(balsa.getNombre()+" está esperando su turno..");
                this.getSemaphore().acquire();
                System.out.println(balsa.getNombre()+ " ha conseguido su turno");

                ArrayList<Pasajero> rescatadosEnViaje = new ArrayList<>();
                int capacidadActual = 0;


                for (int i = 1; i <= 4; i++) {
                    for (int j = 0; j < barco.getPasajeros().size(); j++) {
                        Pasajero p = barco.getPasajeros().get(j);
                        if (capacidadActual < balsa.getCapacidad() && p.getPrioridad() == i) {
                            rescatadosEnViaje.add(p);

                            capacidadActual++;

                            barco.getPasajeros().remove(p);
                        }
                    }
                }

                if (!rescatadosEnViaje.isEmpty()) {
                    System.out.print("Balsa " + balsa.getNombre() + ", rescató: \n");
                    for (Pasajero p : rescatadosEnViaje) {
                        System.out.print("ID:" + p.getId() + "(P" + p.getPrioridad() + ") \n");

                    }
                    System.out.println("");

                }

                System.out.println(balsa.getNombre()+ " libera el turno");
                this.getSemaphore().release();

                Thread.sleep((long) (balsa.getTiempo() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

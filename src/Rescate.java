import java.util.ArrayList;

public class Rescate implements Runnable{
    private Balsa balsa;
    private Barco barco;

    public Rescate(){

    }

    public Rescate(Balsa balsa, Barco barco) {
        this.balsa = balsa;
        this.barco = barco;
    }

    @Override
    public void run() {
        while (barco.hayPasajeros()) {
            try {
                Thread.sleep((long) (balsa.getTiempo() * 1000));

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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Balsa {

    private int capacidad;
    private int tiempo;
    private String nombre;

    public Balsa(int capacidad, String nombre, int tiempo) {
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public Balsa(int capacidad, int tiempo) {
        this.capacidad = capacidad;
        this.tiempo = tiempo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

}

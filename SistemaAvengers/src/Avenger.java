public class Avenger {
    private int id;
    private String nombre;
    private Mision mision;
    private Pago pago;

    //constructor
    public Avenger(int id, String nombre, Mision mision, Pago pago) {
        this.id = id;
        this.nombre = nombre;
        this.mision = mision;
        this.pago = pago;
    }

    //getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Mision getMision() {
        return mision;
    }

    public Pago getPago() {
        return pago;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMision(Mision mision) {
        this.mision = mision;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}

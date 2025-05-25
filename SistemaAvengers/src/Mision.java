import javax.swing.*;

public class Mision {
    private String nombreMision;
    private String descripcion;
    private int nivelPeligrosidad;

    //metodo para asignar mision
    public Mision asignarMision(JTextField nombreMision, JTextField descripcion, JComboBox nivelPeligrosidad){
        Mision nuevaMision = new Mision();
        nuevaMision.nombreMision = nombreMision.getText();
        nuevaMision.descripcion = descripcion.getText();
        nuevaMision.nivelPeligrosidad = nivelPeligrosidad.getSelectedIndex() + 1;
        return nuevaMision;
    }

    //getters
    public String getNombreMision(){
        return nombreMision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNivelPeligrosidad() {
        return nivelPeligrosidad;
    }
}

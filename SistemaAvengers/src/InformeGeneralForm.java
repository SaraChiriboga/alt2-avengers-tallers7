import javax.swing.*;

public class InformeGeneralForm {
    private JPanel pDeployment;
    JPanel pInforme;
    private JLabel nombre;
    private JLabel id;
    private JLabel mision;
    private JLabel desc;
    private JLabel peligro;
    private JLabel mensual;
    private JTextArea informeIngresos;

    //setters
    public void setNombre(String text) {
        nombre.setText(text);
    }

    public void setId(int text) {
        id.setText(String.valueOf(text));
    }

    public void setMision(String text) {
        mision.setText(text);
    }

    public void setDesc(String text) {
        desc.setText(text);
    }

    public void setMensual(double text) {
        mensual.setText(String.valueOf(text));
    }

    public void setPeligro(int text) {
        peligro.setText(String.valueOf(text));
    }

    public void setInformeIngresos(String text) {
        informeIngresos.setText(text);
    }


}



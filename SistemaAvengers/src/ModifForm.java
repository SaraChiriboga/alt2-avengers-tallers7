import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifForm {
    JPanel pModif;
    private JButton guardarButton;
    private JTextField nombre;
    private JTextField mision;
    private JTextField descripcion;
    private JComboBox peligro;
    private JTextField mensual;
    private JLabel idAvenger;

    private SistemaAvengers sistema; //para acceder a los metodos de gestion
    private MainPage main; //para acceder al refresh de datos

    public ModifForm(SistemaAvengers sistema) {
        this.sistema = sistema;
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistema.modificarAvenger(Integer.parseInt(idAvenger.getText()), nombre, mision, descripcion, peligro, mensual);
            }
        });
    }

    //getters y setters
    public JTextField getNombre() {
        return nombre;
    }

    public void setNombre(String text) {
        nombre.setText(text);
    }

    public void setMision(String text) {
        mision.setText(text);
    }

    public void setDescripcion(String text) {
        descripcion.setText(text);
    }

    public void setPeligro(int peligrosidad) {
        peligro.setSelectedIndex(peligrosidad - 1);
    }

    public void setMensual(String text) {
        mensual.setText(text);
    }

    public void setId(String txt){
        idAvenger.setText(txt);
    }

    public JTextField getMision() {
        return mision;
    }

    public JTextField getDescripcion() {
        return descripcion;
    }

    public JComboBox getPeligro() {
        return peligro;
    }

    public JTextField getMensual() {
        return mensual;
    }
}

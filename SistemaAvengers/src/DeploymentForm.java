import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeploymentForm {
    JPanel pDeployment;
    private JTextField nombre;
    private JTextField id;
    private JTextField mision;
    private JTextField des;
    private JTextField mensual;
    private JComboBox peligro;
    private JButton desplegarButton;

    private MainPage main; //inyeccion de dependencia entre clases (dependencia circular de clases)
    SistemaAvengers sistema = new SistemaAvengers(main); //instacia para acceso a metodos de gestion

    public DeploymentForm(MainPage main, SistemaAvengers sistema) {
        this.main = main;
        this.sistema = sistema;
        desplegarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //comprobacion de id unica, positiva y mensual positivo
                try {
                    if (sistema.getAvengers().isEmpty() && Integer.parseInt(id.getText()) > 0 && Double.parseDouble(mensual.getText()) >= 0) {
                        sistema.registrarAvenger(nombre, id, mision, des, peligro, mensual);
                        clear();
                        main.refresh(main.avengersEnMision);
                    }else if (Integer.parseInt(id.getText()) < 1 || Double.parseDouble(mensual.getText()) < 0){
                        JOptionPane.showMessageDialog(null, "Debe ser un numero positivo");
                    }else {
                        for (Avenger i : sistema.getAvengers()){
                            if (i.getId() == Integer.parseInt(id.getText())) {
                                JOptionPane.showMessageDialog(null, "El ID del Avenger debe ser unico!");
                                break;
                            }else {
                                sistema.registrarAvenger(nombre, id, mision, des, peligro, mensual);
                                clear();
                                main.refresh(main.avengersEnMision);
                                break;
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La ID es de valor numerico!");
                }
            }
        });
    }

    //metodo para limpiar campos de texto despues de ingresar un avenger
    public void clear(){
        nombre.setText("");
        id.setText("");
        mision.setText("");
        des.setText("");
        mensual.setText("");
        peligro.setSelectedIndex(-1);
    }

    //getters
    public JTextField getNombre() {
        return nombre;
    }

    public JTextField getId() {
        return id;
    }

    public JTextField getMision() {
        return mision;
    }

    public JTextField getDes() {
        return des;
    }

    public JTextField getMensual() {
        return mensual;
    }

    public JComboBox getPeligro() {
        return peligro;
    }
}

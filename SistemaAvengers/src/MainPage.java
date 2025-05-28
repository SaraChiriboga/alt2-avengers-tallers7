import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage {
    private JPanel pGeneral;
    private JButton desplegarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    JTextArea avengersEnMision;
    private JButton informeButton;
    JTable table;
    private JButton buscarButton;

    SistemaAvengers sistema = new SistemaAvengers(this);
    DeploymentForm despliege = new DeploymentForm(this, sistema); //GUI de registro y compartiendo instancia de avenger para conservar datos
    ModifForm modi = new ModifForm(sistema);

    public MainPage() {
        desplegarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registro = new JFrame("Desplegar Avenger");
                registro.setContentPane(despliege.pDeployment);
                registro.pack();
                registro.setVisible(true); //mostrar el form de registro
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingresa la identificacion del Avenger:"); //ingreso de id del avenger a eliminar
                try {
                    sistema.eliminarAvenger(Integer.parseInt(input));
                    refresh(avengersEnMision);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La ID es de valor numerico!");
                }
            }
        });
        informeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingresa la identificacion del Avenger:");
                try {
                    sistema.emitirInforme(Integer.parseInt(input));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico donde corresponda!");
                }
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingresa la identificacion del Avenger:");
                try {
                    Avenger avengerModificado = new Avenger(0, null, null, null);
                    sistema.modificarAvenger(Integer.parseInt(input));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La ID es de valor numerico!");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Avengers Manager");
        frame.setContentPane(new MainPage().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //refrescar la lista de avengers
    public void refresh(JTextArea cont){
        sistema.listarAvenger(table);
    }
}

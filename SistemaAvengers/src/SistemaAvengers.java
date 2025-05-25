import javax.swing.*;
import java.util.LinkedList;

public class SistemaAvengers {
    private LinkedList<Avenger> avengers = new LinkedList<>();

    private MainPage main;

    public SistemaAvengers(MainPage main) {
        this.main = main;
    }

    //getter
    public LinkedList<Avenger> getAvengers() {
        return avengers;
    }

    //metodo para registrar un avenger
    public void registrarAvenger(JTextField nombre, JTextField id, JTextField mision, JTextField descripcion, JComboBox peligrosidad, JTextField pago){
        Mision m = new Mision();
        m = m.asignarMision(mision, descripcion, peligrosidad);
        Pago pMensual = new Pago(0, null, null, null); //asignacion manual vacia de pago
        pMensual.pagoAvenger(Double.parseDouble(pago.getText())); //calculos con pago mensual

        Avenger nuevoAvenger = new Avenger(Integer.parseInt(id.getText()), nombre.getText(), m, pMensual);
        avengers.add(nuevoAvenger); //avenger registrado

        JOptionPane.showMessageDialog(null, nuevoAvenger.getNombre() + " agregado con exito!"); //aviso de despliegue exitoso
    }

    //metodo para modificar informacion de un avenger (nombre, mision, descripcion, nivel de peligro y mensual)
    ModifForm modificar = new ModifForm(this);
    public Avenger modificarAvenger(int id){
        boolean avengerEncontrado = false;
        Avenger encontrado = new Avenger(0, null, null, null);
        try {
            for (Avenger i : avengers){
                if (i.getId() == id){
                    avengerEncontrado = true;
                    encontrado = i;

                    //el formulario va a estar lleno con los datos actuales, es cuestion de cambiar lo que se requiera
                    modificar.setNombre(encontrado.getNombre());
                    modificar.setMision(encontrado.getMision().getNombreMision());
                    modificar.setDescripcion(encontrado.getMision().getDescripcion());
                    modificar.setPeligro(encontrado.getMision().getNivelPeligrosidad());
                    modificar.setMensual(String.valueOf(encontrado.getPago().getPagoMensual()));
                    modificar.setId(String.valueOf(encontrado.getId()));
                    break;
                }else {avengerEncontrado = false;}
            }

            if (avengerEncontrado){
                JOptionPane.showMessageDialog(null, "Se encuentra modificando a " + encontrado.getNombre() +". Cambie solo lo que necesite!");//aviso
                //mostrar el form de modificacion
                JFrame formModificacion = new JFrame("Modificacion de Avenger");
                formModificacion.setContentPane(modificar.pModif);
                formModificacion.pack();
                formModificacion.setVisible(true);

            }else {JOptionPane.showMessageDialog(null, "No se encontro un Avenger con tal ID!");}
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "¡Debe ser un número!");
        }
        return encontrado;
    }

    //SOBRECARGA DE: metodo para modificar informacion de un avenger (nombre, mision, descripcion, nivel de peligro y mensual)
    public void modificarAvenger(int id, JTextField nombre, JTextField mision, JTextField descripcion, JComboBox peligro, JTextField mensual){
        boolean avengerEncontrado = false;
        for (Avenger i : avengers){
            if (i.getId() == id){
                avengerEncontrado = true;

                i.setNombre(modificar.getNombre().getText()); //nombre
                Mision modMision = new Mision();
                i.setMision(modMision.asignarMision(modificar.getMision(), modificar.getDescripcion(), modificar.getPeligro())); //mision
                Pago modPago = new Pago(0, null, null, null);
                i.setPago(modPago.pagoAvenger(Double.parseDouble(modificar.getMensual().getText()))); //pago
                break;
            }else {avengerEncontrado = false;}
        }

        if (avengerEncontrado){
            JOptionPane.showMessageDialog(null, "Modificacion exitosa!");
            main.refresh(main.avengersEnMision);
        }else {JOptionPane.showMessageDialog(null, "No se encontro un Avenger con tal ID!");}
    }

    //metodo para enlistar en tiempo real los avengers en mision
    public void listarAvenger(JTextArea cont){
        //para tener mayor personalizacion, se agregaran simbolos de acuerdo al avenger ingresado
        for (Avenger i : avengers){
            //SPIDERMAN
            if (i.getNombre().equalsIgnoreCase("Spiderman") || i.getNombre().equalsIgnoreCase("Peter Parker")){
                i.setNombre("Spiderman \uD83D\uDD78\uFE0F");
            }

            //BLACK WIDOW
            if (i.getNombre().equalsIgnoreCase("Black Widow") || i.getNombre().equalsIgnoreCase("Natasha Romanoff")) {
                i.setNombre("Black Widow ⧗");
            }

            // HULK
            if (i.getNombre().equalsIgnoreCase("Hulk") || i.getNombre().equalsIgnoreCase("Bruce Banner")) {
                i.setNombre("Hulk ✇");
            }

            // CAPITÁN AMÉRICA
            if (i.getNombre().equalsIgnoreCase("Captain America") || i.getNombre().equalsIgnoreCase("Steve Rogers")) {
                i.setNombre("Captain America ⍟");
            }

            // SCARLET WITCH
            if (i.getNombre().equalsIgnoreCase("Scarlet Witch") || i.getNombre().equalsIgnoreCase("Wanda Maximoff")) {
                i.setNombre("Scarlet Witch ᗢ");
            }

            // DOCTOR STRANGE
            if (i.getNombre().equalsIgnoreCase("Doctor Strange") || i.getNombre().equalsIgnoreCase("Stephen Strange")) {
                i.setNombre("Doctor Strange ۞");
            }

            // HAWKEYE
            if (i.getNombre().equalsIgnoreCase("Hawkeye") || i.getNombre().equalsIgnoreCase("Clint Barton")) {
                i.setNombre("Hawkeye ➳");
            }

            // THOR
            if (i.getNombre().equalsIgnoreCase("Thor") || i.getNombre().equalsIgnoreCase("Thor Odinson")) {
                i.setNombre("Thor ⚡");
            }

            // IRON MAN
            if (i.getNombre().equalsIgnoreCase("Iron Man") || i.getNombre().equalsIgnoreCase("Tony Stark")) {
                i.setNombre("Iron Man ⎊");;
            }

            cont.setText(cont.getText() + i.getNombre() + " | " + i.getId() + "\n" + i.getMision().getNombreMision() + "\n-------------------------------------------------------------------\n");
        }
    }

    //metodo para eliminar un avenger de la lista de desplegado mediante id
    public void eliminarAvenger(int id){
        boolean listo = false;
        Avenger encontrado = new Avenger(0, null, null, null); //va a contener el elemento ecncontrado
        try {
            for (Avenger elim : avengers){ //recorrer lista
                if (elim.getId() == id){
                    listo = true;
                    encontrado = elim;
                    break;
                }
            }

            if (listo){
                avengers.remove(encontrado); //avenger eliminado
                JOptionPane.showMessageDialog(null,encontrado.getNombre() + " eliminado@!"); //eliminado
            }else {JOptionPane.showMessageDialog(null, "No se encontro un Avenger con tal ID!");}
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "¡Debe ser un número!"); //manejo de excepcion
        }
    }

    //acceso al form de informacion de un avenger
    InformeGeneralForm informe = new InformeGeneralForm();
    public void emitirInforme(int id){
        boolean avenger = false;
        Avenger encontrado = new Avenger(0, null, null, null);
        try {
            for (Avenger emit : avengers){ //encontrar avenger en lista
                if (emit.getId() == id){
                    avenger = true;
                    encontrado = emit;
                    break;
                }else { avenger = false;}
            }

            if (avenger){ //encontrado
                //rellenar informacion de avenger en form
                informe.setNombre(encontrado.getNombre());
                informe.setId(encontrado.getId());
                informe.setMision(encontrado.getMision().getNombreMision());
                informe.setDesc(encontrado.getMision().getDescripcion());
                informe.setPeligro(encontrado.getMision().getNivelPeligrosidad());
                informe.setMensual(encontrado.getPago().getPagoMensual());

                //informe sobre aporte, impuestos, etc
                StringBuilder pagos = new StringBuilder();
                pagos.append("Aporte al fondo de heroes: " + encontrado.getPago().getAporte() + " USD\n").
                        append("Impuesto al gobierno: " + encontrado.getPago().getImpuestos() + " USD\n").
                        append("==================================\n").
                        append(" Pago Neto  a Recibir: " + encontrado.getPago().getNeto() + " USD\n").
                        append("==================================\n");

                informe.setInformeIngresos(pagos.toString());

                //abrir el form de informacion general
                JFrame frame = new JFrame("Informacion general sobre " + encontrado.getNombre());
                frame.setContentPane(informe.pInforme);
                frame.pack();
                frame.setVisible(true);
            }else {JOptionPane.showMessageDialog(null, "No se encontro un Avenger con tal ID!");} //no encontrado
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "¡Debe ser un número!");
        }
    }
}

public class Pago extends Avenger{
    private double pagoMensual;
    private double aporte;
    private double impuestos;
    private double neto;

    public Pago(int id, String nombre, Mision mision, Pago pago) {
        super(id, nombre, mision, pago);
    }

    //metodo con calculos automaticos sobre sueldo
    public Pago pagoAvenger(double pagoMensual){
        setPagoMensual(pagoMensual);
        calculoAporte();
        calculoImpuesto();
        calculoNeto();
        return this;
    }

    //metodo para obtener el valor del aporte al fondo de heroes
    public void calculoAporte(){
        aporte = pagoMensual * 0.08;
    }

    //metodo para obtener el valor de impuestos para el gobierno
    public void calculoImpuesto(){
        double exceso = 0; //diferencia entre mensual y limite
        if (pagoMensual <= 50000){                              //0%
            impuestos = 0;
        }else if (pagoMensual > 50000 && pagoMensual <= 100000){ //10% del exceso a 50,000
            exceso = pagoMensual - 50000;
            impuestos = exceso * 0.1;
        }else if (pagoMensual > 100000 && pagoMensual <= 200000){ //20% del exceso a 100,000
            exceso = pagoMensual - 100000;
            impuestos = exceso * 0.2;
        }else {                                         //30% del exceso a 200,000
            exceso = pagoMensual - 200000;
            impuestos = exceso * 0.3;
        }
    }

    //metodo para calcular el pago neto al avenger
    public void calculoNeto(){
        neto = pagoMensual - aporte - impuestos; //lo restante despues de pagar impuestos y aportar al fondo
    }

    //getters y setters
    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    public double getAporte() {
        return aporte;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public double getNeto() {
        return neto;
    }
}

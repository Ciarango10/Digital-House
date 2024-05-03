package ejemplo;

public class EjecutivoDeCuenta extends EmpleadoBanco{

    @Override
    public void procesarSolicitud(Integer monto) {
        if (monto < 60000) {
            System.out.println("Yo me encargo de gestionarlo. Ejectutivo de cuenta");
        } else if (getSigEmpleadoBanco() != null) {
            getSigEmpleadoBanco().procesarSolicitud(monto);
        }
    }

}

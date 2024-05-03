package ejemplo;

public class Director extends EmpleadoBanco{
    @Override
    public void procesarSolicitud(Integer monto) {
        if (monto > 200000) {
            System.out.println("Yo me encargo de gestionarlo. Director");
        } else if (getSigEmpleadoBanco() != null) {
            getSigEmpleadoBanco().procesarSolicitud(monto);
        }
    }

}

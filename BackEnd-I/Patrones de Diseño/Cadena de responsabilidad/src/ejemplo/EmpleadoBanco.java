package ejemplo;

public abstract class EmpleadoBanco {

    private EmpleadoBanco sigEmpleadoBanco;

    public abstract void procesarSolicitud(Integer monto);

    public EmpleadoBanco getSigEmpleadoBanco() {
        return sigEmpleadoBanco;
    }

    public void setSigEmpleadoBanco(EmpleadoBanco sigEmpleadoBanco) {
        this.sigEmpleadoBanco = sigEmpleadoBanco;
    }

}

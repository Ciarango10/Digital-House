package ejemplo2;

public abstract class EmpleadoGobierno {

    EmpleadoGobierno sigEmpleadoGobierno;

    public abstract void leerDocumento(Documento documento);

    public EmpleadoGobierno getSigEmpleadoGobierno() {
        return sigEmpleadoGobierno;
    }

    public void setSigEmpleadoGobierno(EmpleadoGobierno sigEmpleadoGobierno) {
        this.sigEmpleadoGobierno = sigEmpleadoGobierno;
    }

}

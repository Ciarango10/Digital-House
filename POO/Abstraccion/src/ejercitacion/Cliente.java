package ejercitacion;

public class Cliente {
    private int nroCliente;
    private String apellido;
    private String DNI;
    private String CUIT;
    public Cliente(int nroCliente, String apellido, String DNI, String CUIT) {
        this.nroCliente = nroCliente;
        this.apellido = apellido;
        this.DNI = DNI;
        this.CUIT = CUIT;
    }

    @Override
    public String toString() {
       return nroCliente + ", " + apellido + " DNI: " + DNI;
    }
}

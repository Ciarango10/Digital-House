package ejemplo2;
import org.xml.sax.HandlerBase;
import java.time.LocalDate;

public abstract class Tarjeta {
    private int numeroTarjeta;
    private int codigoSeguridad;
    private LocalDate fechaExpiracion;

    public void procesador(Tarjeta tarjeta, double monto) {
        if(validarFecha() && autorizacion(tarjeta, monto)) {
            System.out.println("Pago exitoso!");
        } else {
            System.out.println("Pago no autorizado!");
        }
    }

    private boolean validarFecha() {
        return fechaExpiracion.isAfter(LocalDate.now());
    }

    protected abstract boolean autorizacion(Tarjeta tarjeta, double monto);

    public Tarjeta(int numeroTarjeta, int codigoSeguridad, LocalDate fechaExpiracion) {
        this.numeroTarjeta = numeroTarjeta;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaExpiracion = fechaExpiracion;
    }

}

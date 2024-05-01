package ejemplo2;

import java.time.LocalDate;

public class Debito extends Tarjeta{
    private double saldoDisponible;

    public Debito(int numeroTarjeta, int codigoSeguridad, LocalDate fechaExpiracion, double saldoDisponible) {
        super(numeroTarjeta, codigoSeguridad, fechaExpiracion);
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    protected boolean autorizacion(Tarjeta tarjeta, double monto) {
        if(saldoDisponible >= monto) {
            saldoDisponible -= monto;
            return true;
        }
        return false;
    }
}

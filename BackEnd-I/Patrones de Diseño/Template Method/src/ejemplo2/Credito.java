package ejemplo2;

import java.time.LocalDate;

public class Credito extends Tarjeta{
    private double limite;
    private double saldoUtilizado;

    public Credito(int numeroTarjeta, int codigoSeguridad, LocalDate fechaExpiracion, double limite, double saldoUtilizado) {
        super(numeroTarjeta, codigoSeguridad, fechaExpiracion);
        this.limite = limite;
        this.saldoUtilizado = saldoUtilizado;
    }

    @Override
    protected boolean autorizacion(Tarjeta tarjeta, double monto) {
        if(limite >= saldoUtilizado+monto) {
            saldoUtilizado += monto;
            return true;
        }
        return false;
    }
}

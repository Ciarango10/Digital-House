package ejemplo2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Tarjeta debito = new Debito(880511920, 241, LocalDate.of(2027, 5, 1), 1000000);
        Tarjeta credito = new Credito(128308905, 908, LocalDate.of(2025, 7, 30), 5000000, 4000000);

        debito.procesador(debito, 800000);
        debito.procesador(debito, 200001);

        credito.procesador(credito, 500000);
        credito.procesador(credito, 500001);

    }
}

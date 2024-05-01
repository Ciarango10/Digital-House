package ejemplotaza;

public class Taza {
    private String tipoLiquido;
    private double porcentaje;

    public Taza(String tipoLiquido, double porcentaje) {
        this.tipoLiquido = tipoLiquido;
        this.porcentaje = porcentaje;
    }

    public String getTipoLiquido() {
        return tipoLiquido;
    }

    public void setTipoLiquido(String tipoLiquido) {
        this.tipoLiquido = tipoLiquido;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}

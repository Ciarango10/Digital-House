package parcial;

public class Main {
    public static void main(String[] args) {
        Consulta consulta = new Consulta("2023/11/13 06:30", "Corazón");
        Consulta consulta2 = new Consulta("2023/10/05 12:45", "Riñones");

        Particular pacienteParticular = new Particular(consulta, "2005/01/31", "Carlos", "Arango", true, 600.00, "1025643641");
        System.out.println(pacienteParticular.necesitaEvaluacionInicial());

        ObraSocial pacienteObraSocial = new ObraSocial(consulta2, "2005/08/24", "Juanes", "Cardenas", false, "Unión", 6);
        System.out.println(pacienteObraSocial.necesitaEvaluacionInicial());

        ObraSocial pacienteObraSocial2 = new ObraSocial(consulta2, "2003/01/14", "Samuel", "Velasquez", true, "NiñosFuturos", 4);
        System.out.println(pacienteObraSocial2.Comparar(pacienteObraSocial));

        System.out.println(pacienteObraSocial2.Comparar(pacienteParticular));
    }
}

public class Dios {
    private static Dios instancia;

    private Dios(){

    }
    /*Esta técnica se llama inicialización tardía hasta que no se invoque al método getInstancia
   no se crea ningún objeto en memoria.*/
    public static Dios getInstancia(){
        if(instancia == null)
            instancia = new Dios();
        return instancia;
    }

    public String pedir(String pedido){
        return "tu pedido fue escuchado: " + pedido;
    }
}

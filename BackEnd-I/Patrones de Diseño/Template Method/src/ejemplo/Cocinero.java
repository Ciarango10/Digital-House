package ejemplo;

public abstract class Cocinero {
    public void hacerPizza() {
        prepararMasa();
        preCocinarMasa();
        prepararIngredientes();
        agregarIngredientes();
        cocinarPizza();
        empaquetarPizza();
    }

    protected abstract void prepararIngredientes();
    protected abstract void agregarIngredientes();

    private void prepararMasa(){
        System.out.println("Preparando masa...");
    }

    private void preCocinarMasa() {
        System.out.println("Pre cocinando masa...");
    }

    private void cocinarPizza() {
        System.out.println("Enviando al horno la pizza");
    }

    private void empaquetarPizza() {
        System.out.println("Empaquetando pizza");
    }
}

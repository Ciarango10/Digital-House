package ejercitacion;
public class Main {
    public static void main(String[] args) {
        Asteroide asteroide1 = new Asteroide(10,20,'S',12);
        asteroide1.irA(12,30,'N');

        Nave nave1 = new Nave(30,40,'E',61.00);
        nave1.irA(25,8,'S');

        System.out.println(nave1.getVida());
        nave1.restarVida(40);
        System.out.println(nave1.getVida());
    }
}

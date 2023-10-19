package ejercitacion;

public class Main {
    public static void main(String[] args) {
        UsuarioJuego usuarioJuego = new UsuarioJuego("Carlos", "ABC123");

        // CONFIRMAMOS QUE LOS GETTERS FUNCIONEN
        System.out.println(usuarioJuego.getNombre());
        System.out.println(usuarioJuego.getClave());
        System.out.println(usuarioJuego.getPuntaje());
        System.out.println(usuarioJuego.getNivel());

        // CONFIRMAMOS QUE LOS SETTERS FUNCIONEN
        usuarioJuego.setNombre("Ivan");
        System.out.println(usuarioJuego.getNombre());

        usuarioJuego.setClave("123ABC");
        System.out.println(usuarioJuego.getClave());

        usuarioJuego.setPuntaje(5.0);
        System.out.println(usuarioJuego.getPuntaje());

        usuarioJuego.setNivel(10);
        System.out.println(usuarioJuego.getNivel());

        // UTILIZAMOS LAS FUNCIONES
        usuarioJuego.aumentarPuntaje();
        System.out.println(usuarioJuego.getPuntaje());

        usuarioJuego.subirNivel();
        System.out.println(usuarioJuego.getNivel());

        usuarioJuego.bonus(7);
        System.out.println(usuarioJuego.getPuntaje());

    }
}

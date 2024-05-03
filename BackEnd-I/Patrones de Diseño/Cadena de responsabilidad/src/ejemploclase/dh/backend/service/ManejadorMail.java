package ejemploclase.dh.backend.service;

import ejemploclase.dh.backend.model.Mail;

public abstract class ManejadorMail {

    private ManejadorMail siguiente;
    public abstract String comprobarMail(Mail mail);

    public ManejadorMail getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ManejadorMail siguiente) {
        this.siguiente = siguiente;
    }

}

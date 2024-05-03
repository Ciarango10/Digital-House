package ejemploclase.dh.backend.service;

import ejemploclase.dh.backend.model.Mail;

public class ManejadorGerencia extends ManejadorMail{

    @Override
    public String comprobarMail(Mail mail) {
        if(mail.getTema().equalsIgnoreCase("gerencia") || mail.getDestino().equalsIgnoreCase("gerencia@colmena.com")) {
            return "El mail sera manejado por el Area Gerencia";
        } else {
            return getSiguiente().comprobarMail(mail);
        }
    }

}

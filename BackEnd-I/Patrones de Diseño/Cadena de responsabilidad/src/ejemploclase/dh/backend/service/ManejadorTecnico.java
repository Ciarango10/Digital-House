package ejemploclase.dh.backend.service;

import ejemploclase.dh.backend.model.Mail;

public class ManejadorTecnico extends ManejadorMail{

    @Override
    public String comprobarMail(Mail mail) {
        if(mail.getTema().equalsIgnoreCase("tecnico") || mail.getDestino().equalsIgnoreCase("tecnico@colmena.com")) {
            return "El mail sera manejado por el Area Tecnica";
        } else {
            return getSiguiente().comprobarMail(mail);
        }
    }

}

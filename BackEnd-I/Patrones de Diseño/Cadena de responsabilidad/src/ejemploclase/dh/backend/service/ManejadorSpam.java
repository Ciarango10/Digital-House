package ejemploclase.dh.backend.service;

import ejemploclase.dh.backend.model.Mail;

public class ManejadorSpam extends ManejadorMail{

    @Override
    public String comprobarMail(Mail mail) {
        return "El mail sera enviado a Spam";
    }

}

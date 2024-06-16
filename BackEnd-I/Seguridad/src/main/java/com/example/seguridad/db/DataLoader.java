package com.example.seguridad.db;

import com.example.seguridad.login.AppUser;
import com.example.seguridad.login.AppUsuarioRoles;
import com.example.seguridad.repository.IUserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;

    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

        userRepository.save(new AppUser("Ines", "inesita", "ines@gmail.com", password, AppUsuarioRoles.ADMIN));
        userRepository.save(new AppUser("Cristina", "cris", "mariacris@gmail.com", password2, AppUsuarioRoles.USER));
    }

}

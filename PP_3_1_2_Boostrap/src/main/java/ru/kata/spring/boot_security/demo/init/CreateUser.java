package ru.kata.spring.boot_security.demo.init;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repo.RoleRepository;
import ru.kata.spring.boot_security.demo.repo.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class CreateUser {
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CreateUser(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void runObjectCreated() {
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        roleRepo.save(adminRole);
        roleRepo.save(userRole);


        userRepo.save(new User("user", "user", passwordEncoder.encode("user"), Set.of(userRole), 20, "User@gmail.com"));
        userRepo.save(new User("admin", "admin", passwordEncoder.encode("admin"), Set.of(adminRole), 30, "Admin@gmail.com"));
    }
}

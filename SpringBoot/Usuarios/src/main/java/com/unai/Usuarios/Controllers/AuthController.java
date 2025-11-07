package com.unai.Usuarios.Controllers;

import com.unai.Usuarios.models.User;
import com.unai.Usuarios.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        // 1️⃣ Hashear la contraseña antes de guardar
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 2️⃣ Asignar rol o roles
        user.setRole("USER");

        // 3️⃣ Guardar en base de datos
        userRepository.save(user);

        return "Usuario registrado con éxito";
    }
}

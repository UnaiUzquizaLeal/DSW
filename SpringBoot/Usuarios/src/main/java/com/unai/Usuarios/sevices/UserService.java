package com.unai.Usuarios.sevices;

import com.unai.Usuarios.models.User;
import com.unai.Usuarios.repositories.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service // 1️⃣ Indica que esta clase es un "servicio" gestionado por Spring (un componente)
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    // 2️⃣ Se inyecta el repositorio que accede a la base de datos
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 3️⃣ Este metodo se ejecuta automáticamente cuando alguien intenta hacer login
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 4️⃣ Busca el usuario en la base de datos
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // 5️⃣ Convierte tu entidad "User" a un objeto que Spring Security entiende: "UserDetails"
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())    // nombre de usuario
                .password(user.getPassword())    // contraseña encriptada
                .roles(user.getRole())           // rol (Spring agrega automáticamente el prefijo ROLE_)
                .disabled(!user.isEnabled())     // si el usuario está inactivo, no podrá loguear
                .build();
    }
}

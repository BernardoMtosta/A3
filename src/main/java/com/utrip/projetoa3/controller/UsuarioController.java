package com.utrip.projetoa3.controller;

import com.utrip.projetoa3.model.Usuario;
import com.utrip.projetoa3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastro")
    public String cadastrar(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Usuário cadastrado com sucesso!";
    }

    @PostMapping("/login")
public String login(@RequestBody Usuario usuario) {
    System.out.println("Recebido nome: " + usuario.getNome());
    System.out.println("Recebido senha: " + usuario.getSenha());

    return usuarioRepository.findByNomeAndSenha(usuario.getNome(), usuario.getSenha())
            .map(u -> "Login bem-sucedido!")
            .orElse("Nome ou senha inválidos!");
    }
}
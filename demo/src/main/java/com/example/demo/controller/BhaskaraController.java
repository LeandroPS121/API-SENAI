package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BhaskaraService;

@RestController
@RequestMapping("/api")
public class BhaskaraController {

    @Autowired
    private BhaskaraService bhaskaraService;

    @PostMapping("/usuarios")
    public ResponseEntity<String> registrarUsuario(@RequestParam String nome, @RequestParam String email,
            @RequestParam String senha) {
        String mensagem = bhaskaraService.registrarUsuario(nome, email, senha);
        if (mensagem.equals("Usuário registrado com sucesso!")) {
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/calcular-bhaskara")
    public ResponseEntity<String> calcularBhaskara(@RequestParam double a, @RequestParam double b,
            @RequestParam double c) {
        String resultado = bhaskaraService.calcularBhaskara(a, b, c);

        if (resultado.contains("Não existem raízes reais")
                || resultado.contains("O coeficiente 'a' não pode ser zero")) {
            return new ResponseEntity<>(resultado, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @GetMapping("/calcular-bhaskara")
    public ResponseEntity<String> obterUltimoCalculo() {
        String resultado = bhaskaraService.obterUltimoCalculo();

        if (resultado == null || resultado.isEmpty()) {
            return new ResponseEntity<>("Nenhum cálculo realizado ainda.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}

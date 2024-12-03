package com.example.demo.controller;

import com.example.demo.service.BhaskaraService;
import com.example.demo.model.Historico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BhaskaraController {

    @Autowired
    private BhaskaraService bhaskaraService;

    // Endpoint para registrar um usuário
    @PostMapping("/usuarios")
    public ResponseEntity<String> registrarUsuario(@RequestParam String nome, @RequestParam String email,
            @RequestParam String senha) {
        String mensagem = bhaskaraService.registrarUsuario(nome, email, senha);
        if (mensagem.equals("Usuário registrado com sucesso!")) {
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED); // 201 Created para sucesso
        } else {
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST); // 400 Bad Request para erro
        }
    }

    // Endpoint para calcular as raízes de Bhaskara
    @PostMapping("/calcular-bhaskara")
    public ResponseEntity<String> calcularBhaskara(@RequestParam double a, @RequestParam double b,
            @RequestParam double c) {
        String resultado = bhaskaraService.calcularBhaskara(a, b, c);

        if (resultado.contains("Não existem raízes reais")
                || resultado.contains("O coeficiente 'a' não pode ser zero")) {
            // Retorna 400 (Bad Request) caso o coeficiente a seja zero ou não exista raiz
            // real
            return new ResponseEntity<>(resultado, HttpStatus.BAD_REQUEST);
        }

        // Retorna 200 OK com o resultado das raízes
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    // Endpoint para obter o histórico de cálculos de um usuário
    @GetMapping("/usuarios/{userId}/historico")
    public ResponseEntity<List<Historico>> obterHistorico(@PathVariable Long userId) {
        List<Historico> historico = bhaskaraService.obterHistorico(userId);

        if (historico.isEmpty()) {
            // Retorna 404 Not Found caso o histórico do usuário não seja encontrado
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Retorna 200 OK com o histórico
        return new ResponseEntity<>(historico, HttpStatus.OK);
    }

    // Endpoint para obter o último cálculo realizado (GET)
    @GetMapping("/calcular-bhaskara")
    public ResponseEntity<String> obterUltimoCalculo() {
        String resultado = bhaskaraService.obterUltimoCalculo();

        if (resultado == null || resultado.isEmpty()) {
            // Se não houver nenhum cálculo realizado, retorna 404 Not Found
            return new ResponseEntity<>("Nenhum cálculo realizado ainda.", HttpStatus.NOT_FOUND);
        }

        // Retorna 200 OK com o resultado do último cálculo
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}

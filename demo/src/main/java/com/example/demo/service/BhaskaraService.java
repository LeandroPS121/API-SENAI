package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.Historico;

@Service
public class BhaskaraService {

    private static final Map<Long, String> usuarios = new HashMap<>();
    private static final List<Historico> historicos = new ArrayList<>();
    private static Long userIdCounter = 1L;

    private static String ultimoCalculo;

    public String registrarUsuario(String nome, String email, String senha) {
        for (String usuario : usuarios.values()) {
            if (usuario.equals(email)) {
                return "Erro: Email já cadastrado!";
            }
        }
        usuarios.put(userIdCounter++, nome);
        return "Usuário registrado com sucesso!";
    }

    public String calcularBhaskara(double a, double b, double c) {
        if (a == 0) {
            return "O coeficiente 'a' não pode ser zero.";
        }

        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            return "Não existem raízes reais.";
        }

        double raiz1 = (-b + Math.sqrt(delta)) / (2 * a);
        double raiz2 = (-b - Math.sqrt(delta)) / (2 * a);

        String raizes = "Raízes: " + raiz1 + " e " + raiz2;

        Historico historico = new Historico(userIdCounter - 1, a, b, c, raizes, LocalDate.now());
        historicos.add(historico);

        ultimoCalculo = raizes;

        return raizes;
    }

    public List<Historico> obterHistorico(Long userId) {
        List<Historico> resultado = new ArrayList<>();
        for (Historico historico : historicos) {
            if (historico.getUserId().equals(userId)) {
                resultado.add(historico);
            }
        }
        return resultado;
    }

    // Método para obter o último cálculo realizado
    public String obterUltimoCalculo() {
        return ultimoCalculo;
    }
}

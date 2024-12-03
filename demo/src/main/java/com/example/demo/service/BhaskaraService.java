package com.example.demo.service;

import com.example.demo.model.Historico;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class BhaskaraService {

    // Simulando banco de dados em memória
    private static final Map<Long, String> usuarios = new HashMap<>();
    private static final List<Historico> historicos = new ArrayList<>();
    private static Long userIdCounter = 1L;

    // Simulando o último cálculo realizado
    private static String ultimoCalculo;

    // Método para criar um novo usuário
    public String registrarUsuario(String nome, String email, String senha) {
        for (String usuario : usuarios.values()) {
            if (usuario.equals(email)) {
                return "Erro: Email já cadastrado!";
            }
        }
        usuarios.put(userIdCounter++, nome); // Armazenando usuário
        return "Usuário registrado com sucesso!";
    }

    // Método para calcular as raízes de Bhaskara
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

        // Formata o resultado das raízes
        String raizes = "Raízes: " + raiz1 + " e " + raiz2;

        // Simula o armazenamento no histórico
        Historico historico = new Historico(userIdCounter - 1, a, b, c, raizes, LocalDate.now());
        historicos.add(historico);

        // Armazena o resultado do cálculo
        ultimoCalculo = raizes;

        return raizes;
    }

    // Método para recuperar o histórico de cálculos de um usuário
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

package br.com.dio.desafio.service;

import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MentoriaService {
    private static final List<Mentoria> mentorias = new ArrayList<>();

    public static List<Mentoria> listarMentorias() {
        return mentorias;
    }

    public static void cadastrarMentoria(String titulo, String descricao, LocalDate data) {
        Mentoria mentoria = new Mentoria(titulo, descricao, data);
        mentorias.add(mentoria);
        System.out.println("Mentoria cadastrada com sucesso!");
    }
}

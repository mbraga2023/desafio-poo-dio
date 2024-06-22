package br.com.dio.desafio.service;

import br.com.dio.desafio.dominio.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoService {
    private static final List<Curso> cursos = new ArrayList<>();

    public static List<Curso> listarCursos() {
        return cursos;
    }

    public static void cadastrarCurso(String titulo, String descricao, int cargaHoraria) {
        Curso curso = new Curso(titulo, descricao, cargaHoraria);
        cursos.add(curso);
        System.out.println("Curso cadastrado com sucesso!");
    }
}

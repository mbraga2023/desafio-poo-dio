package br.com.dio.desafio.service;

import br.com.dio.desafio.dominio.Dev;

import java.util.HashSet;
import java.util.Set;

public class DevService {
    private static final Set<Dev> devs = new HashSet<>();

    public static Set<Dev> listarDevs() {
        return devs;
    }

    public static void cadastrarDev(String nome) {
        Dev dev = new Dev();
        dev.setNome(nome);
        devs.add(dev);
        System.out.println("Desenvolvedor cadastrado com sucesso!");
    }
}

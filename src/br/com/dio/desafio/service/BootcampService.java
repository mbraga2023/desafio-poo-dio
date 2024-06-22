package br.com.dio.desafio.service;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Dev;

import java.util.HashSet;
import java.util.Set;

public class BootcampService {
    private static final Set<Bootcamp> bootcamps = new HashSet<>();

    public static Set<Bootcamp> listarBootcamps() {
        return bootcamps;
    }

    public static void inscreverDevBootcamp(Dev dev, Bootcamp bootcamp) {
        dev.inscreverBootcamp(bootcamp);
        System.out.println("Desenvolvedor inscrito no bootcamp com sucesso!");
    }

    public static void adicionarBootcamp(Bootcamp bootcamp) {
        bootcamps.add(bootcamp);
        System.out.println("Bootcamp adicionado com sucesso!");
    }
}

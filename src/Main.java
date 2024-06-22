import br.com.dio.desafio.dominio.*;
import br.com.dio.desafio.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Dev> devs = new ArrayList<>();
    private static final List<Curso> cursos = new ArrayList<>();
    private static final List<Mentoria> mentorias = new ArrayList<>();

    public static void main(String[] args) {
        registrarDadosIniciais();

        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            switch (opcao) {
                case 1:
                    cadastrarDev();
                    break;
                case 2:
                    cadastrarCurso();
                    break;
                case 3:
                    cadastrarMentoria();
                    break;
                case 4:
                    inscreverDevBootcamp();
                    break;
                case 5:
                    registrarProgressao();
                    break;
                case 6:
                    calcularXPDev();
                    break;
                case 7:
                    mostrarCursos();
                    break;
                case 8:
                    mostrarMentorias();
                    break;
                case 9:
                    mostrarBootcamps();
                    break;
                case 10:
                    mostrarDesenvolvedores();
                    break;
                case 0:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Digite novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Cadastrar novo desenvolvedor");
        System.out.println("2. Cadastrar novo curso");
        System.out.println("3. Cadastrar nova mentoria");
        System.out.println("4. Inscrever desenvolvedor em bootcamp");
        System.out.println("5. Registrar progressão de desenvolvedor");
        System.out.println("6. Calcular XP total de um desenvolvedor");
        System.out.println("7. Mostrar todos os cursos");
        System.out.println("8. Mostrar todas as mentorias");
        System.out.println("9. Mostrar todos os bootcamps");
        System.out.println("10. Mostrar lista de desenvolvedores");
        System.out.println("0. Sair");
    }

    private static void registrarDadosIniciais() {
        // Criar devs fictícios e adicioná-los à lista de devs
        Dev dev1 = new Dev("João");
        Dev dev2 = new Dev("Maria");
        devs.add(dev1);
        devs.add(dev2);

        // Criar cursos fictícios e adicioná-los à lista de cursos
        Curso curso1 = new Curso("Java Fundamentals", "Curso introdutório de Java", 40);
        Curso curso2 = new Curso("POO Fundamentals", "Curso Orientação a Objetos", 60);
        cursos.add(curso1);
        cursos.add(curso2);

        // Criar mentorias fictícias e adicioná-las à lista de mentorias
        Mentoria mentoria1 = new Mentoria("Mentoria de Arquitetura de Software",
                "Mentoria sobre práticas de arquitetura de software",
                LocalDate.now().plusDays(7));
        Mentoria mentoria2 = new Mentoria("Mentoria de Carreira em TI",
                "Mentoria sobre desenvolvimento de carreira em tecnologia",
                LocalDate.now().plusDays(15));
        mentorias.add(mentoria1);
        mentorias.add(mentoria2);

        // Adicionar cursos e mentorias a bootcamps fictícios
        Bootcamp bootcamp1 = new Bootcamp("Bootcamp de Programação", "Bootcamp 1");
        bootcamp1.adicionarConteudo(curso1);
        bootcamp1.adicionarConteudo(mentoria1);

        Bootcamp bootcamp2 = new Bootcamp("Bootcamp de Desenvolvimento Web", "Bootcamp 2");
        bootcamp2.adicionarConteudo(curso2);
        bootcamp2.adicionarConteudo(mentoria2);

        // Adicionar bootcamps à lista de bootcamps gerenciada pelo BootcampService
        BootcampService.adicionarBootcamp(bootcamp1);
        BootcampService.adicionarBootcamp(bootcamp2);
    }




    private static int lerOpcao() {
        System.out.print("\nDigite a opção desejada: ");
        return scanner.nextInt();
    }

    private static void cadastrarDev() {
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Digite o nome do desenvolvedor: ");
        String nome = scanner.nextLine();
        Dev dev = new Dev();
        dev.setNome(nome);
        devs.add(dev);
        System.out.println("Desenvolvedor cadastrado com sucesso!");
    }

    private static void cadastrarCurso() {
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Digite o título do curso: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição do curso: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a carga horária do curso: ");
        int cargaHoraria = scanner.nextInt();
        Curso curso = new Curso(titulo, descricao, cargaHoraria);
        cursos.add(curso);
        System.out.println("Curso cadastrado com sucesso!");
    }

    private static void cadastrarMentoria() {
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Digite o título da mentoria: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição da mentoria: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a data da mentoria (AAAA-MM-DD): ");
        String dataString = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataString);
        Mentoria mentoria = new Mentoria(titulo, descricao, data);
        mentorias.add(mentoria);
        System.out.println("Mentoria cadastrada com sucesso!");
    }

    private static void inscreverDevBootcamp() {
        scanner.nextLine(); // Limpar o buffer do scanner
        Set<Bootcamp> bootcamps = BootcampService.listarBootcamps();

        if (devs.isEmpty()) {
            System.out.println("Não há desenvolvedores cadastrados!");
            return;
        }

        System.out.println("Desenvolvedores disponíveis:");
        int i = 1;
        for (Dev dev : devs) {
            System.out.println(i + ". " + dev.getNome());
            i++;
        }

        System.out.print("Escolha o número do desenvolvedor para inscrever no bootcamp: ");
        int numDev = scanner.nextInt();

        System.out.println("Bootcamps disponíveis:");
        i = 1;
        for (Bootcamp bootcamp : bootcamps) {
            System.out.println(i + ". " + bootcamp.getNome());
            i++;
        }

        System.out.print("Escolha o número do bootcamp para inscrever o desenvolvedor: ");
        int numBootcamp = scanner.nextInt();

        // Inscrever o desenvolvedor no bootcamp selecionado
        Dev dev = devs.get(numDev - 1);
        Bootcamp bootcamp = (Bootcamp) bootcamps.toArray()[numBootcamp - 1];
        BootcampService.inscreverDevBootcamp(dev, bootcamp);
    }

    private static void registrarProgressao() {
        scanner.nextLine(); // Limpar o buffer do scanner

        if (devs.isEmpty()) {
            System.out.println("Não há desenvolvedores cadastrados!");
            return;
        }

        System.out.println("Desenvolvedores disponíveis:");
        int i = 1;
        for (Dev dev : devs) {
            System.out.println(i + ". " + dev.getNome());
            i++;
        }

        System.out.print("Escolha o número do desenvolvedor para registrar a progressão: ");
        int numDev = scanner.nextInt();

        // Registrar progressão para o desenvolvedor selecionado
        Dev dev = devs.get(numDev - 1);
        dev.progredir();
    }

    private static void calcularXPDev() {
        scanner.nextLine(); // Limpar o buffer do scanner
        // Implementar conforme necessidade
    }

    private static void mostrarCursos() {
        System.out.println("\n=== Todos os Cursos ===");
        for (Curso curso : cursos) {
            System.out.println(curso);
        }
    }

    private static void mostrarMentorias() {
        System.out.println("\n=== Todas as Mentorias ===");
        for (Mentoria mentoria : mentorias) {
            System.out.println(mentoria);
        }
    }

    private static void mostrarBootcamps() {
        Set<Bootcamp> bootcamps = BootcampService.listarBootcamps();
        System.out.println("\n=== Todos os Bootcamps ===");
        for (Bootcamp bootcamp : bootcamps) {
            System.out.println(bootcamp);
        }
    }

    private static void mostrarDesenvolvedores() {
        System.out.println("\n=== Lista de Desenvolvedores ===");
        for (Dev dev : devs) {
            System.out.println(dev.toString()); // Calls the overridden toString() method
            System.out.println(); // Optional: for spacing between developers
        }
    }


}


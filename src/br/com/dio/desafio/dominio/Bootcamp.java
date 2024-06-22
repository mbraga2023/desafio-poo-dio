package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void adicionarConteudo(Conteudo conteudo) {
        conteudos.add(conteudo);
    }

    public void removerConteudo(Conteudo conteudo) {
        conteudos.remove(conteudo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bootcamp: ").append(nome)
                .append(" - ").append(descricao)
                .append(", Data Inicial: ").append(dataInicial)
                .append(", Data Final: ").append(dataFinal)
                .append(", Devs Inscritos: ");

        if (!devsInscritos.isEmpty()) {
            // Append names of devsInscritos
            Iterator<Dev> iterator = devsInscritos.iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next().getNome());
                if (iterator.hasNext()) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append("Nenhum Dev inscrito");
        }

        sb.append(", Conteúdos: ");

        if (!conteudos.isEmpty()) {
            Iterator<Conteudo> iterator = conteudos.iterator();
            while (iterator.hasNext()) {
                sb.append("").append(iterator.next().getTitulo());
                if (iterator.hasNext()) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append("Nenhum conteúdo registrado");
        }

        return sb.toString();
    }


}

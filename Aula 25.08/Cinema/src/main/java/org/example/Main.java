package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Cliente {
    private String nome;
    private int idade;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
}


class Filme {
    private String nome;
    private double preco;
    private int idadeMinima;

    public Filme(String nome, double preco, int idadeMinima) {
        this.nome = nome;
        this.preco = preco;
        this.idadeMinima = idadeMinima;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getIdadeMinima() { return idadeMinima; }
}

class Ingresso {
    private Cliente cliente;
    private Filme filme;
    private String assento;

    public Ingresso(Cliente cliente, Filme filme, String assento) {
        this.cliente = cliente;
        this.filme = filme;
        this.assento = assento;
    }

    public Cliente getCliente() { return cliente; }
    public Filme getFilme() { return filme; }
    public String getAssento() { return assento; }

    @Override
    public String toString() {
        return filme.getNome() + " - " + assento + " - " + cliente.getNome();
    }
}

class Cinema {
    private List<Filme> filmesDisponiveis;
    private List<Ingresso> ingressosVendidos;

    public Cinema() {
        this.filmesDisponiveis = new ArrayList<>();
        this.ingressosVendidos = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public Filme buscarFilme(String nome) throws Exception {
        for (Filme f : filmesDisponiveis) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                return f;
            }
        }
        throw new Exception("Filme não encontrado!");
    }

    public void venderIngresso(Cliente cliente, Filme filme, String assento) throws Exception {
        if (cliente.getIdade() < filme.getIdadeMinima()) {
            throw new Exception("O ingresso não pode ser vendido pois sua idade não permite!");
        }

        for (Ingresso i : ingressosVendidos) {
            if (i.getAssento().equalsIgnoreCase(assento)) {
                throw new Exception("O ingresso não pode ser vendido pois seu assento não está mais disponível!");
            }
        }

        Ingresso ingresso = new Ingresso(cliente, filme, assento);
        ingressosVendidos.add(ingresso);
        System.out.println("Ingresso vendido com sucesso! " + ingresso);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cinema cinema = new Cinema();

        cinema.adicionarFilme(new Filme("Homem Aranha", 20.0, 12));
        cinema.adicionarFilme(new Filme("Batman", 22.0, 14));
        cinema.adicionarFilme(new Filme("It - A Coisa", 25.0, 18));
        cinema.adicionarFilme(new Filme("Frozen", 18.0, 0));
        cinema.adicionarFilme(new Filme("Vingadores", 30.0, 12));

        String continuar;
        do {
            try {
                System.out.print("\nQue filme você deseja assistir? ");
                String nomeFilme = sc.nextLine();
                Filme filmeEscolhido = cinema.buscarFilme(nomeFilme);

                System.out.print("Qual assento você deseja? (ex: A1 a F5): ");
                String assento = sc.nextLine();

                System.out.print("Qual o seu nome? ");
                String nomeCliente = sc.nextLine();

                System.out.print("Qual a sua idade? ");
                int idade = Integer.parseInt(sc.nextLine());

                Cliente cliente = new Cliente(nomeCliente, idade);

                cinema.venderIngresso(cliente, filmeEscolhido, assento);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.print("\nDeseja comprar outro ingresso? (s/n): ");
            continuar = sc.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        sc.close();
    }
}

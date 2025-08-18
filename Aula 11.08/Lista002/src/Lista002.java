import java.util.Random;
import java.util.Scanner;

public class Lista002 {

    public static void gerarSenha() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder senha = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        System.out.println("Senha gerada: " + senha);
    }

    public static void gerarJogador() {
        String[] nomes = {"Cássio", "Neymar", "Lionel", "Cristiano", "Thiago", "Gabriel", "Roberto", "André"};
        String[] sobrenomes = {"Ramos", "Silva", "Messi", "Ronaldo", "Alcântara", "Jesus", "Firmino", "Santos"};
        String[] posicoes = {"goleiro", "atacante", "zagueiro", "meio-campista", "lateral"};
        String[] times = {"Corinthians", "Flamengo", "Barcelona", "Real Madrid", "Liverpool", "PSG"};

        Random random = new Random();

        String nome = nomes[random.nextInt(nomes.length)];
        String sobrenome = sobrenomes[random.nextInt(sobrenomes.length)];
        String posicao = posicoes[random.nextInt(posicoes.length)];
        String time = times[random.nextInt(times.length)];
        int idade = 18 + random.nextInt(23);

        System.out.println(nome + " " + sobrenome + " é um futebolista brasileiro de " + idade +
                " anos que atua como " + posicao + ". Atualmente defende o " + time + ".");
    }


    public static void gerarPokemon() {
        String[] nomes = {"Pikachu", "Charmander", "Squirtle", "Bulbasaur", "Eevee", "Snorlax", "Gengar", "Machop"};
        String[] tipos = {"Elétrico", "Fogo", "Água", "Planta", "Normal", "Fantasma", "Lutador", "Venenoso"};

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos Pokémons deseja gerar? ");
        int quantidade = sc.nextInt();

        for (int i = 0; i < quantidade; i++) {
            String nome = nomes[random.nextInt(nomes.length)];
            String tipo = tipos[random.nextInt(tipos.length)];
            int nivel = 1 + random.nextInt(100);

            System.out.println(nome + " é um Pokémon do tipo " + tipo + " de nível " + nivel + ".");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha o exercício:");
        System.out.println("1 - Gerador de Senha");
        System.out.println("2 - Gerador de Jogador");
        System.out.println("3 - Gerador de Pokémon");
        System.out.print("Opção: ");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                gerarSenha();
                break;
            case 2:
                gerarJogador();
                break;
            case 3:
                gerarPokemon();
                break;
            default:
                System.out.println("Opção inválida!");
        }

        sc.close();
    }
}



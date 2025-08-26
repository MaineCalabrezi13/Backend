package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ===== Classe Musica =====
class Musica {
    private String titulo;
    private String artista;

    public Musica(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }

    @Override
    public String toString() {
        return titulo + " - " + artista;
    }
}

// ===== Classe Playlist =====
class Playlist {
    private String nome;
    private List<Musica> musicas;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
        System.out.println("Você adicionou a música " + musica.getTitulo() + " na playlist.");
    }

    public void exibirPlaylist() {
        System.out.println("\nPlaylist: " + nome);
        for (Musica m : musicas) {
            System.out.println("- " + m.getTitulo());
        }
    }
}

// ===== Classe MusicCloud =====
class MusicCloud {
    private List<Musica> musicasDisponiveis;

    public MusicCloud() {
        this.musicasDisponiveis = new ArrayList<>();
        // adiciona algumas músicas na nuvem
        musicasDisponiveis.add(new Musica("Macarena", "Los del Rio"));
        musicasDisponiveis.add(new Musica("Evidências", "Chitãozinho & Xororó"));
        musicasDisponiveis.add(new Musica("Shape of You", "Ed Sheeran"));
        musicasDisponiveis.add(new Musica("Bohemian Rhapsody", "Queen"));
    }

    // procura música pelo título
    public Musica buscarMusica(String titulo) throws Exception {
        for (Musica m : musicasDisponiveis) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                return m;
            }
        }
        throw new Exception("A música " + titulo + " não foi encontrada no sistema.");
    }
}

// ===== Classe Main =====
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // cria nuvem e playlist
        MusicCloud cloud = new MusicCloud();

        System.out.print("Digite o nome da sua playlist: ");
        String nomePlaylist = sc.nextLine();
        Playlist playlist = new Playlist(nomePlaylist);

        String resposta;
        do {
            System.out.print("Digite o nome da música: ");
            String titulo = sc.nextLine();

            try {
                Musica m = cloud.buscarMusica(titulo);
                playlist.adicionarMusica(m);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Deseja adicionar outra música? (s/n): ");
            resposta = sc.nextLine();

        } while (resposta.equalsIgnoreCase("s"));

        // exibe a playlist final
        playlist.exibirPlaylist();
        sc.close();
    }
}

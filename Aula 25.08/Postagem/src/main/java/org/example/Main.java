package org.example;

import java.util.Scanner;

// ===== Enum para tipo de postagem =====
enum TipoPostagem {
    TEXTO, IMAGEM, VIDEO
}

// ===== Classe Postagem =====
class Postagem {
    private String titulo;
    private String descricao;
    private TipoPostagem tipo;

    public Postagem(String titulo, String descricao, TipoPostagem tipo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public TipoPostagem getTipo() { return tipo; }
}

// ===== Interface PlataformaSocial =====
interface PlataformaSocial {
    void compartilharPostagem(Postagem postagem) throws Exception;
    void compartilharImagem(Postagem postagem) throws Exception;
    void compartilharVideo(Postagem postagem) throws Exception;
}

// ===== Classe MyBook =====
class MyBook implements PlataformaSocial {
    @Override
    public void compartilharPostagem(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no MyBook.");
    }

    @Override
    public void compartilharImagem(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no MyBook.");
    }

    @Override
    public void compartilharVideo(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no MyBook.");
    }
}

// ===== Classe Fotogram =====
class Fotogram implements PlataformaSocial {
    @Override
    public void compartilharPostagem(Postagem postagem) throws Exception {
        throw new Exception("O Fotogram não suporta compartilhar postagens de texto.");
    }

    @Override
    public void compartilharImagem(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no Fotogram.");
    }

    @Override
    public void compartilharVideo(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no Fotogram.");
    }
}

// ===== Classe AnyTube =====
class AnyTube implements PlataformaSocial {
    @Override
    public void compartilharPostagem(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no AnyTube.");
    }

    @Override
    public void compartilharImagem(Postagem postagem) throws Exception {
        throw new Exception("O AnyTube não suporta compartilhar imagens.");
    }

    @Override
    public void compartilharVideo(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no AnyTube.");
    }
}

// ===== Main =====
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada do usuário
        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        System.out.print("Tipo (texto, imagem, video): ");
        String tipoStr = sc.nextLine().toUpperCase();

        TipoPostagem tipo;
        try {
            tipo = TipoPostagem.valueOf(tipoStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo inválido! Usando TEXTO como padrão.");
            tipo = TipoPostagem.TEXTO;
        }

        Postagem postagem = new Postagem(titulo, descricao, tipo);

        // Plataformas
        PlataformaSocial myBook = new MyBook();
        PlataformaSocial fotogram = new Fotogram();
        PlataformaSocial anyTube = new AnyTube();

        // Testando conforme instruções
        try {
            myBook.compartilharPostagem(postagem);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro no MyBook: " + e.getMessage());
        }

        try {
            fotogram.compartilharImagem(postagem);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro no Fotogram: " + e.getMessage());
        }

        try {
            anyTube.compartilharVideo(postagem);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro no AnyTube: " + e.getMessage());
        }

        sc.close();
    }
}

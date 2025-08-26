package org.example;

public class Main {
    // ===== Classe Barco =====
    static class Barco {
        private String nome;
        private int tamanho;

        public Barco(String nome, int tamanho) {
            this.nome = nome;
            this.tamanho = tamanho;
        }

        public String getNome() { return nome; }
        public int getTamanho() { return tamanho; }
    }

    // ===== Classe BasePorto =====
    static class BasePorto {
        protected String nome;
        protected Barco[] barcosAtracados;
        protected int qtd;

        public BasePorto(String nome, int capacidade) {
            this.nome = nome;
            this.barcosAtracados = new Barco[capacidade];
            this.qtd = 0;
        }

        public boolean atracarBarco(Barco barco) {
            if (barco == null) return false;
            if (qtd >= barcosAtracados.length) return false;
            barcosAtracados[qtd++] = barco;
            System.out.println(barco.getNome() + " atracado no " + nome);
            return true;
        }

        public boolean desatracarBarco(Barco barco) {
            if (barco == null || qtd == 0) return false;
            for (int i = 0; i < qtd; i++) {
                if (barcosAtracados[i] == barco) {
                    for (int j = i; j < qtd - 1; j++) {
                        barcosAtracados[j] = barcosAtracados[j + 1];
                    }
                    barcosAtracados[--qtd] = null;
                    System.out.println(barco.getNome() + " desatracado do " + nome);
                    return true;
                }
            }
            return false;
        }
    }

    // ===== PortoPequeno =====
    static class PortoPequeno extends BasePorto {
        public PortoPequeno(String nome, int capacidade) {
            super(nome, capacidade);
        }

        @Override
        public boolean atracarBarco(Barco barco) {
            if (barco.getTamanho() <= 10) {
                return super.atracarBarco(barco);
            }
            return false;
        }
    }

    // ===== PortoGrande =====
    static class PortoGrande extends BasePorto {
        public PortoGrande(String nome, int capacidade) {
            super(nome, capacidade);
        }

        @Override
        public boolean atracarBarco(Barco barco) {
            if (barco.getTamanho() >= 10) {
                return super.atracarBarco(barco);
            }
            return false;
        }
    }

    // ===== Método main =====
    public static void main(String[] args) {
        Barco[] barcos = new Barco[] {
                new Barco("Barco 1", 2),
                new Barco("Barco 2", 5),
                new Barco("Barco 3", 7),
                new Barco("Barco 4", 12),
                new Barco("Barco 5", 20)
        };

        PortoPequeno portoPequeno = new PortoPequeno("porto pequeno", 10);
        PortoGrande portoGrande = new PortoGrande("porto grande", 10);

        for (Barco b : barcos) {
            boolean atracado = portoPequeno.atracarBarco(b);
            if (!atracado) {
                portoGrande.atracarBarco(b);
            }
        }
    }
}

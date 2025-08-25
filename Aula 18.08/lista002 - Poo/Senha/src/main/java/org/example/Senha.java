package org.example;
import java.util.Random;

public class Senha {
    private String senha;

    public Senha() {
        this.senha = gerarSenha();
    }

    public String getSenha() {
        return senha;
    }

    private String gerarSenha() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }
}
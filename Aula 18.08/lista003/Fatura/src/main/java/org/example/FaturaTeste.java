package org.example;

public class FaturaTeste {
    public static void main(String[] args) {
        Fatura f1 = new Fatura("001", "Teclado Mecânico", 2, 150.0);
        Fatura f2 = new Fatura("002", "Mouse Gamer", -3, -50.0);

        System.out.println("Fatura 1:");
        System.out.println("Número: " + f1.getNumero());
        System.out.println("Descrição: " + f1.getDescricao());
        System.out.println("Quantidade: " + f1.getQuantidade());
        System.out.println("Preço por Item: " + f1.getPrecoPorItem());
        System.out.println("Total: R$ " + f1.getTotalFatura());

        System.out.println("\nFatura 2:");
        System.out.println("Número: " + f2.getNumero());
        System.out.println("Descrição: " + f2.getDescricao());
        System.out.println("Quantidade: " + f2.getQuantidade());
        System.out.println("Preço por Item: " + f2.getPrecoPorItem());
        System.out.println("Total: R$ " + f2.getTotalFatura());
    }
}
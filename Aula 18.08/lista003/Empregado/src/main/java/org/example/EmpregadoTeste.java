package org.example;

import org.example.Empregado;

public class EmpregadoTeste {
    public static void main(String[] args) {
        Empregado e1 = new Empregado("Ana", "Silva", 3000.0);
        Empregado e2 = new Empregado("Carlos", "Souza", 4500.0);

        System.out.println("Salários Anuais (antes do aumento):");
        System.out.println(e1.getNome() + " " + e1.getSobrenome() + ": R$ " + e1.getSalarioAnual());
        System.out.println(e2.getNome() + " " + e2.getSobrenome() + ": R$ " + e2.getSalarioAnual());

        e1.aplicarAumento(10);
        e2.aplicarAumento(10);

        System.out.println("\nSalários Anuais (após aumento de 10%):");
        System.out.println(e1.getNome() + " " + e1.getSobrenome() + ": R$ " + e1.getSalarioAnual());
        System.out.println(e2.getNome() + " " + e2.getSobrenome() + ": R$ " + e2.getSalarioAnual());
    }
}

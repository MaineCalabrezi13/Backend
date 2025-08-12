package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        if (idade < 12){
            System.out.println("Categorio: Infantil");
        }else if(idade >=12 && idade<=17){
            System.out.println("Categorio: Adolescente");
        }else if(idade>=18){
            System.out.println("Categorio: Adulto");
        }
    }
}
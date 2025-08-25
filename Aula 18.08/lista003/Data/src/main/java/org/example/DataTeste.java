package org.example;

public class DataTeste {
    public static void main(String[] args) {

        Data d1 = new Data(25, 8, 2025);
        Data d2 = new Data(29, 2, 2024);

        Data d3 = new Data(31, 4, 2025);
        Data d4 = new Data(15, 13, 2025);
        Data d5 = new Data(0, 12, 2025);

        System.out.println("\nDatas criadas:");
        d1.displayData();
        d2.displayData();
        d3.displayData();
        d4.displayData();
        d5.displayData();
    }
}

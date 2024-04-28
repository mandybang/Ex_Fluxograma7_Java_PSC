import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matriz = new double[4][4];

        System.out.println("Preencha a matriz 4x4:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Digite o valor para a posição [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextDouble();
            }
        }

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Exibir valores da diagonal principal");
            System.out.println("2. Exibir valores da diagonal secundária");
            System.out.println("3. Exibir matriz transposta");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    double[] diagonalPrincipal = diagonalPrincipal(matriz);
                    System.out.println("\nValores da diagonal principal:");
                    exibirVetor(diagonalPrincipal);
                    break;
                case 2:
                    double[] diagonalSecundaria = diagonalSecundaria(matriz);
                    System.out.println("\nValores da diagonal secundária:");
                    exibirVetor(diagonalSecundaria);
                    break;
                case 3:
                    double[][] transposta = matrizTransposta(matriz);
                    System.out.println("\nMatriz transposta:");
                    exibirMatriz(transposta);
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);
        scanner.close();
    }

    public static double[] diagonalPrincipal(double[][] matriz) {
        double[] diagonal = new double[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            diagonal[i] = matriz[i][i];
        }
        return diagonal;
    }

    public static double[] diagonalSecundaria(double[][] matriz) {
        double[] diagonal = new double[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            diagonal[i] = matriz[i][matriz.length - 1 - i];
        }
        return diagonal;
    }

    public static double[][] matrizTransposta(double[][] matriz) {
        double[][] transposta = new double[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                transposta[j][i] = matriz[i][j];
            }
        }
        return transposta;
    }

    public static void exibirMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void exibirVetor(double[] vetor) {
        for (double valor : vetor) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}

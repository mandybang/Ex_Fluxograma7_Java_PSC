import java.util.Scanner;

public class Matriz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[3][3]; // Declarando uma matriz 3x3

        System.out.println("Digite 9 números inteiros: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        
        System.out.println("Matriz fornecida:");
        exibirMatriz(matriz);
        
        if (verificarMatriz(matriz)) {
            System.out.println("A matriz é um quadrado mágico.");
        } else {
            System.out.println("A matriz não é um quadrado mágico.");
        }
    scanner.close();
    }

    // Método para exibir a matriz
    public static void exibirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para verificar se a matriz é um quadrado mágico
    public static boolean verificarMatriz(int[][] matriz) {
        int n = matriz.length;
        int somaReferencia = somaLinha(matriz, 0); // Soma da primeira linha, que será a referência

        // Verificando as linhas
        for (int i = 1; i < n; i++) {
            if (somaLinha(matriz, i) != somaReferencia) {
                return false;
            }
        }

        // Verificando as colunas
        for (int j = 0; j < n; j++) {
            if (somaColuna(matriz, j) != somaReferencia) {
                return false;
            }
        }

        // Verificando a diagonal principal
        if (somaDiagonalPrincipal(matriz) != somaReferencia) {
            return false;
        }

        // Verificando a diagonal secundária
        if (somaDiagonalSecundaria(matriz) != somaReferencia) {
            return false;
        }

        return true;
    }

    // Método para calcular a soma de uma linha específica
    public static int somaLinha(int[][] matriz, int linha) {
        int soma = 0;
        for (int j = 0; j < matriz[linha].length; j++) {
            soma += matriz[linha][j];
        }
        return soma;
    }

    // Método para calcular a soma de uma coluna específica
    public static int somaColuna(int[][] matriz, int coluna) {
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            soma += matriz[i][coluna];
        }
        return soma;
    }

    // Método para calcular a soma da diagonal principal
    public static int somaDiagonalPrincipal(int[][] matriz) {
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            soma += matriz[i][i];
        }
        return soma;
    }

    // Método para calcular a soma da diagonal secundária
    public static int somaDiagonalSecundaria(int[][] matriz) {
        int soma = 0;
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            soma += matriz[i][n - 1 - i];
        }
        return soma;
    }
}

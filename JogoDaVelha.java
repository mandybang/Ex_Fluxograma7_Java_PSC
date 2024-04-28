import java.util.Scanner;

public class JogoDaVelha {
    private char[][] tabuleiro;
    private char jogadorAtual;

    public JogoDaVelha() {
        tabuleiro = new char[3][3];
        jogadorAtual = 'X'; // Começa com o jogador 'X'
        inicializarTabuleiro();
    }

    // Método para inicializar o tabuleiro com espaços vazios
    private void inicializarTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    // Método para exibir o tabuleiro na tela
    public void exibirTabuleiro() {
        System.out.println("-------------");
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Método para realizar uma jogada
    public boolean fazerJogada(int linha, int coluna) {
        if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3 || tabuleiro[linha][coluna] != ' ') {
            System.out.println("Jogada inválida! Tente novamente.");
            return false;
        }
        tabuleiro[linha][coluna] = jogadorAtual;
        return true;
    }

    // Método para verificar se o jogo acabou
    public boolean jogoAcabou() {
        return verificaVencedor('X') || verificaVencedor('O') || tabuleiroCheio();
    }

    // Método para verificar se há um vencedor
    private boolean verificaVencedor(char jogador) {
        // Verificar linhas e colunas
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
                (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
                return true;
            }
        }
        // Verificar diagonais
        if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
            (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)) {
            return true;
        }
        return false;
    }

    // Método para verificar se o tabuleiro está cheio (empate)
    private boolean tabuleiroCheio() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false; // Ainda há espaço vazio, o jogo não acabou
                }
            }
        }
        return true; // Tabuleiro cheio, empate
    }

    // Método para trocar de jogador
    private void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();

        while (!jogo.jogoAcabou()) {
            // Exibir o tabuleiro e as instruções
            System.out.println("Jogador " + jogo.jogadorAtual + ", é sua vez!");
            jogo.exibirTabuleiro();
            System.out.println("Digite a linha e a coluna (de 0 a 2) separadas por espaço:");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            // Fazer a jogada
            if (jogo.fazerJogada(linha, coluna)) {
                jogo.trocarJogador(); // Trocar de jogador após uma jogada válida
            }
        }

        // Exibir o resultado do jogo
        jogo.exibirTabuleiro();
        if (jogo.verificaVencedor('X')) {
            System.out.println("Jogador X venceu!");
        } else if (jogo.verificaVencedor('O')) {
            System.out.println("Jogador O venceu!");
        } else {
            System.out.println("Empate!");
        }
        scanner.close();
    }
}

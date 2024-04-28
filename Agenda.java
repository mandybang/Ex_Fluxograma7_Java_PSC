/**
 * (Loiane - Adaptado) Faça um programa para armazenar em uma matriz os compromissos de uma agenda pessoal,
 * onde, cada dia do mês deve conter 24 horas, e, para cada uma destas 24 horas podemos associar uma tarefa 
 * específica (compromisso agendado). O programa deve ter um menu onde o usuário indica o dia do mês que deseja 
 * alterar e a hora, entrando em seguida com o compromisso, ou então, o usuário pode também consultar a agenda, 
 * fornecendo o dia e a hora para obter o compromisso armazenado.

 */
import java.util.Scanner;

public class Agenda {
    private String[][] agenda;

    public Agenda() {
        this.agenda = new String[31][24];
    }

    public void adicionarCompromisso(int dia, int hora, String compromisso) {
        if (dia >= 1 && dia <= 31 && hora >= 0 && hora <= 23) {
            agenda[dia - 1][hora] = compromisso;
            System.out.println("Compromisso adicionado com sucesso!");
        } else {
            System.out.println("Dia ou hora inválidos!");
        }
    }

    public String consultarCompromisso(int dia, int hora) {
        if (dia >= 1 && dia <= 31 && hora >= 0 && hora <= 23) {
            return agenda[dia - 1][hora];
        } else {
            return "Dia ou hora inválidos!";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda minhaAgenda = new Agenda();

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar compromisso");
            System.out.println("2. Consultar compromisso");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o dia do mês: ");
                    int dia = scanner.nextInt();
                    System.out.print("Digite a hora (0-23): ");
                    int hora = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Digite o compromisso: ");
                    String compromisso = scanner.nextLine();
                    minhaAgenda.adicionarCompromisso(dia, hora, compromisso);
                    break;
                case 2:
                    System.out.print("Digite o dia do mês: ");
                    dia = scanner.nextInt();
                    System.out.print("Digite a hora (0-23): ");
                    hora = scanner.nextInt();
                    String compromissoConsultado = minhaAgenda.consultarCompromisso(dia, hora);
                    System.out.println("Compromisso: " + compromissoConsultado);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

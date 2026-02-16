package main;

import java.util.Random;
import java.util.Scanner;

public class JoKenPo {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------Pedra-Papel-Tesoura---------");
        System.out.println("Instruções:");
        System.out.println("-Escreva a opção de jogada desejada dentre as três disponíveis(pedra, papel ou tesoura).");
        System.out.println("-O primeiro que ganhar 3 rodadas vence.");
        System.out.println();

        String initial = "";
        while (!initial.equals("iniciar") && !initial.equals("sair")) {
            System.out.println("\"iniciar\" para começar o jogo | \"sair\" para encerrar o programa");
            initial = scanner.nextLine().toLowerCase().trim();
        }


        if (initial.equals("iniciar")) {

            String[] opcoes = {"pedra", "papel", "tesoura"};
            int playerScore = 0;
            int cpuScore = 0;

            while (playerScore < 3 && cpuScore < 3) {

                String playerChoice = "";

                while (!playerChoice.equals("pedra") &&
                        !playerChoice.equals("papel") &&
                        !playerChoice.equals("tesoura")) {
                    System.out.println();
                    System.out.println("pedra, papel ou tesoura?");
                    playerChoice = scanner.nextLine().toLowerCase().trim();
                }

                Random random = new Random();
                int randomNumber = random.nextInt(3);
                var cpuChoice = opcoes[randomNumber];


                System.out.println("Escolha da CPU: " + cpuChoice);

                if (cpuChoice.equals(playerChoice)) {
                    System.out.println("Empate! Nenhum dos dois pontua!");
                    System.out.println("-------------------");
                } else if (
                        (playerChoice.equals("pedra") && cpuChoice.equals("tesoura")) ||
                                (playerChoice.equals("papel") && cpuChoice.equals("pedra")) ||
                                playerChoice.equals("tesoura") && cpuChoice.equals("papel")
                ) {
                    System.out.println("Jogador venceu a rodada!");
                    System.out.println("-------------------");

                    playerScore += 1;
                } else {
                    System.out.println("CPU venceu a rodada!");
                    System.out.println("-------------------");
                    cpuScore += 1;
                }
            }
            if (cpuScore == 3) {
                System.out.println("Vitória da CPU por " + cpuScore + "-" + playerScore);
            } else {
                System.out.println("Vitória do Jogador por " + playerScore + "-" + cpuScore);
            }
        }
    }
}

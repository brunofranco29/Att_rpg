package org.example;

import java.util.Scanner;
import java.util.Random;

import java.util.Scanner;
import java.util.Random;

public class ControleBatalha {

    public void iniciarBatalha(Personagem jogador, Personagem inimigo) {
        Scanner scanner = new Scanner(System.in);
        Random roletaDeAcoes = new Random();

        System.out.println("\n=== BATALHA INICIADA ===");
        System.out.println(jogador.getNome() + " VS " + inimigo.getNome() + "\n");

        int turno = 1;

        while (jogador.isVivo() && inimigo.isVivo()) {
            System.out.println("===============================");
            System.out.println("Turno " + turno);
            System.out.println("Você: " + jogador.getVida() + " HP | Inimigo: " + inimigo.getVida() + " HP");
            System.out.println("===============================");

            System.out.println("\nSua vez de agir! Escolha:");
            System.out.println("1 - Ataque Básico");
            System.out.println("2 - Usar Habilidade Especial");
            System.out.print("Opção: ");

            int escolha = scanner.nextInt();

            if (escolha == 1) {
                jogador.atacar(inimigo);
            } else if (escolha == 2) {
                System.out.println("\n--- Lista de Habilidades ---");
                jogador.mostrarHabilidades();
                System.out.print("Escolha a habilidade (1, 2 ou 3): ");
                int escolhaHab = scanner.nextInt();
                jogador.usarHabilidade(inimigo, escolhaHab);
            } else {
                System.out.println("Você hesitou e perdeu a vez!");
            }

            if (!inimigo.isVivo()) break;

            System.out.println("\n--- Turno do Inimigo ---");
            int acaoInimigo = roletaDeAcoes.nextInt(2) + 1;

            if (acaoInimigo == 1) {
                inimigo.atacar(jogador);
            } else {
                int habInimigo = roletaDeAcoes.nextInt(3) + 1;
                inimigo.usarHabilidade(jogador, habInimigo);
            }

            System.out.println("\nDigite qualquer coisa e pressione ENTER para o próximo turno...");
            scanner.next();

            turno++;
        }

        declararVencedor(jogador, inimigo);
    }

    private void declararVencedor(Personagem p1, Personagem p2) {
        System.out.println("\n=== FIM DE BATALHA ===");
        if (p1.isVivo()) {
            System.out.println("VITÓRIA! O vencedor é: " + p1.getNome() + "!");
        } else {
            System.out.println("DERROTA! O vencedor é: " + p2.getNome() + "!");
        }
    }
}

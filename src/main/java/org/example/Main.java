package org.example;

import java.util.Scanner;
import java.util.Random;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Personagem jogador = null;
        Personagem inimigo = null;

        System.out.println("=== CRIAÇÃO DE PERSONAGEM ===");
        System.out.print("Digite o nome do seu herói: ");
        String nomeJogador = scanner.nextLine();

        System.out.println("\nEscolha a sua classe:");
        System.out.println("1 - Guerreiro (Alta vida, possui Armadura)");
        System.out.println("2 - Mago (Alto dano, usa Mana)");
        System.out.println("3 - Arqueiro (Dano médio, chance de Esquiva)");
        System.out.print("Opção: ");
        int escolhaClasse = scanner.nextInt();

        switch (escolhaClasse) {
            case 1:
                jogador = new Guerreiro(nomeJogador);
                break;
            case 2:
                jogador = new Mago(nomeJogador);
                break;
            case 3:
                jogador = new Arqueiro(nomeJogador);
                break;
            default:
                System.out.println("Opção inválida! Você foi transformado em um Guerreiro por padrão.");
                jogador = new Guerreiro(nomeJogador);
                break;
        }

        System.out.println("\nGerando inimigo...");
        String[] nomesInimigos = {"Orc Selvagem", "Goblin Sorrateiro", "Esqueleto Sombrio"};
        String nomeInimigoAleatorio = nomesInimigos[random.nextInt(nomesInimigos.length)];
        int classeInimigoAleatoria = random.nextInt(3) + 1;

        switch (classeInimigoAleatoria) {
            case 1:
                inimigo = new Guerreiro(nomeInimigoAleatorio);
                break;
            case 2:
                inimigo = new Mago(nomeInimigoAleatorio);
                break;
            case 3:
                inimigo = new Arqueiro(nomeInimigoAleatorio);
                break;
        }

        System.out.println("Um " + inimigo.getNome() + " apareceu no seu caminho!");

        ControleBatalha controle = new ControleBatalha();
        controle.iniciarBatalha(jogador, inimigo);

        scanner.close();
    }
}
package org.example;

import java.util.Random;

import java.util.Random;

import java.util.Random;

public class Arqueiro extends Personagem {
    private int chanceEsquiva;

    public Arqueiro(String nome) {
        super(nome, 80, 12);
        this.chanceEsquiva = 30; // 30% inicial
    }

    @Override
    public void mostrarHabilidades() {
        System.out.println("1 - Flecha Perfurante (Dano alto)");
        System.out.println("2 - Tiro Duplo (Atira duas flechas rápidas)");
        System.out.println("3 - Bomba de Fumaça (Aumenta a chance de esquiva em 15%)");
    }

    @Override
    public void usarHabilidade(Personagem alvo, int escolha) {
        switch (escolha) {
            case 1:
                System.out.println("\n>>> " + this.nome + " atirou uma [Flecha Perfurante]!");
                alvo.receberDano(30, TipoDano.FISICO);
                break;
            case 2:
                System.out.println("\n>>> " + this.nome + " usou [Tiro Duplo]!");
                System.out.println("Primeira flecha:");
                alvo.receberDano(15, TipoDano.FISICO);
                System.out.println("Segunda flecha:");
                alvo.receberDano(15, TipoDano.FISICO);
                break;
            case 3:
                System.out.println("\n>>> " + this.nome + " jogou uma [Bomba de Fumaça] no chão!");
                this.chanceEsquiva += 15;
                System.out.println("* Ficou mais difícil acertar " + this.nome + "! Esquiva atual: " + this.chanceEsquiva + "% *");
                break;
            default:
                System.out.println("A flecha caiu da corda! Perdeu o turno.");
        }
    }

    @Override
    public void receberDano(int dano, TipoDano tipo) {
        Random gerador = new Random();
        if (gerador.nextInt(100) + 1 <= this.chanceEsquiva) {
            System.out.println("* INCRÍVEL! " + this.nome + " esquivou do ataque e não sofreu dano! *");
        } else {
            super.receberDano(dano, tipo);
        }
    }
}

package org.example;

public class Guerreiro extends Personagem {
    private int defesa;

    public Guerreiro(String nome) {
        super(nome, 100, 15);
        this.defesa = 5;
    }

    @Override
    public void mostrarHabilidades() {
        System.out.println("1 - Golpe Demolidor (Dano alto)");
        System.out.println("2 - Ataque Furioso (Dano massivo, mas o Guerreiro perde 10 de HP)");
        System.out.println("3 - Postura Defensiva (Aumenta a defesa permanentemente nesta batalha)");
    }

    @Override
    public void usarHabilidade(Personagem alvo, int escolha) {
        switch (escolha) {
            case 1:
                System.out.println("\n>>> " + this.nome + " usou [Golpe Demolidor]!");
                alvo.receberDano(25, TipoDano.FISICO);
                break;
            case 2:
                System.out.println("\n>>> " + this.nome + " executou um [Ataque Furioso] com toda a força!");
                alvo.receberDano(45, TipoDano.FISICO);
                System.out.println("* O impacto causou recuo! *");
                this.receberDano(10, TipoDano.VERDADEIRO);
                break;
            case 3:
                System.out.println("\n>>> " + this.nome + " assumiu a [Postura Defensiva]!");
                this.defesa += 5;
                System.out.println("* Defesa aumentada! Agora reduz " + this.defesa + " de dano por ataque. *");
                break;
            default:
                System.out.println("Movimento desconhecido! Tropeçou e perdeu o turno.");
        }
    }

    @Override
    public void receberDano(int dano, TipoDano tipo) {
        if (tipo == TipoDano.FISICO) {
            int danoReduzido = dano - this.defesa;
            if (danoReduzido < 0) danoReduzido = 0;
            System.out.println("* A armadura de " + this.nome + " absorveu " + this.defesa + " de dano FÍSICO! *");
            super.receberDano(danoReduzido, tipo);
        } else {
            System.out.println("* A armadura de " + this.nome + " é inútil contra dano " + tipo + "! *");
            super.receberDano(dano, tipo);
        }
    }
}

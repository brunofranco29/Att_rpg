package org.example;

public class Mago extends Personagem {
    private int mana;

    public Mago(String nome) {
        super(nome, 60, 10);
        this.mana = 40;
    }

    @Override
    public void mostrarHabilidades() {
        System.out.println("1 - Bola de Fogo (Dano alto | Custo: 15 Mana)");
        System.out.println("2 - Dreno de Vida (Dano médio, cura o Mago | Custo: 20 Mana)");
        System.out.println("3 - Choque Estático (Dano baixo | Custo: 5 Mana)");
        System.out.println("Mana atual: " + this.mana);
    }

    @Override
    public void usarHabilidade(Personagem alvo, int escolha) {
        switch (escolha) {
            case 1:
                if (mana >= 15) {
                    mana -= 15;
                    System.out.println("\n>>> " + this.nome + " lançou [Bola de Fogo]!");
                    alvo.receberDano(40);
                } else {
                    System.out.println("Sem mana para Bola de Fogo! Perdeu o turno.");
                }
                break;
            case 2:
                if (mana >= 20) {
                    mana -= 20;
                    System.out.println("\n>>> " + this.nome + " usou [Dreno de Vida]!");
                    alvo.receberDano(20);
                    this.curar(15);
                } else {
                    System.out.println("Sem mana para Dreno de Vida! Perdeu o turno.");
                }
                break;
            case 3:
                if (mana >= 5) {
                    mana -= 5;
                    System.out.println("\n>>> " + this.nome + " disparou um [Choque Estático] rápido!");
                    alvo.receberDano(15);
                } else {
                    System.out.println("Sem mana para Choque Estático! Perdeu o turno.");
                }
                break;
            default:
                System.out.println("Habilidade mágica desconhecida! Perdeu o turno.");
        }
    }
}

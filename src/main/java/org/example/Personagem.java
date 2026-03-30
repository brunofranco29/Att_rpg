package org.example;

public abstract class Personagem implements AcaoBatalha {
    protected String nome;
    protected int vida;
    protected int danoBase;

    public Personagem(String nome, int vida, int danoBase) {
        this.nome = nome;
        this.vida = vida;
        this.danoBase = danoBase;
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nome + " recebeu " + dano + " de dano! (HP restante: " + this.vida + ")");
    }

    public void receberDano(int dano, TipoDano tipo) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nome + " recebeu " + dano + " de dano " + tipo + "! (HP restante: " + this.vida + ")");
    }

    public void curar(int valor) {
        this.vida += valor;
        System.out.println(this.nome + " recuperou " + valor + " de HP! (HP atual: " + this.vida + ")");
    }

    public boolean isVivo() {
        return this.vida > 0;
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println("\n>>> " + this.nome + " deu um ataque básico em " + alvo.getNome() + "!");
        alvo.receberDano(this.danoBase, TipoDano.FISICO);
    }

    @Override
    public abstract void usarHabilidade(Personagem alvo, int escolha);

    public String getNome() { return nome; }
    public int getVida() { return vida; }
}


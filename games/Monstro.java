package games;

public class Monstro{
    String nome;
    int vida;
    int ataque;
    int vidaMax;
    String tipoMonstro;
    int expSeDerrotado;
    int moneySeDerrotado;

   public Monstro(String tipo){
        if("dragao".equalsIgnoreCase(tipo)){
            this.nome = "DRAGAO";
            this.tipoMonstro = tipo;
            this.vida = 500;
            this.ataque = 100;
            this.vidaMax = 500;
            this.expSeDerrotado = 100;
            this.moneySeDerrotado = 200;
        }else if("goblin".equalsIgnoreCase(tipo)){
            this.nome = "GOBLIN";
            this.tipoMonstro = tipo;
            this.vida = 200;
            this.ataque = 40;
            this.vidaMax = 200;
            this.expSeDerrotado = 30;
            this.moneySeDerrotado = 50;
        }else if("slime".equalsIgnoreCase(tipo)){
            this.nome = "SLIME";
            this.tipoMonstro = tipo;
            this.vida = 100;
            this.ataque = 15;
            this.vidaMax = 100;
            this.expSeDerrotado = 20;
            this.moneySeDerrotado = 30;
        }
   }

    public String getNome(){return nome;}
    public String getTipoMonstro(){return tipoMonstro;}
    public int getHp(){return vida;}
    public int getHpMax(){return vidaMax;}
    public int getAtk(){return ataque;}
    public int getExpSeDerrotado(){return expSeDerrotado;}
    public int getMoneySeDerrotado(){return moneySeDerrotado;}

    public void exibirDados(){
        System.out.printf("Monstro: %s | Vida: %d/%d | Ataque: %d | Exp se Derrotado: %d | Dinheiro se Derrotado: %d |",nome,vida,vidaMax,ataque,expSeDerrotado,moneySeDerrotado);
    }

    public void receberDano(int qnt){
        vida -= qnt;
        System.out.printf("Monstro %s recebeu %d de dano\n", nome, qnt);
        if(vida < 0){
            vida = 0;
        }
    }

    public void acabouBatalha(){
        vida = vidaMax;
    }
    
}
package games;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogador{
    private String nome;
    private String nomeTipo;
    private char ranking;
    private int hp;
    private int hpMax;
    private int atk;
    private int exp;
    private int expParaUpar;
    private int money;
    private boolean statusDefesa;
    ArrayList<String> inventario = new ArrayList<>();
    private char rankings[] = {'F', 'E', 'D', 'C', 'B', 'A', 'S'};
    String itemEquipado;

    public Jogador(String nome, String tipo){
        if("humano".equalsIgnoreCase(tipo)){
            this.nome = nome;
            this.nomeTipo = tipo;
            this.ranking = 'F';
            this.hp = 100;
            this.hpMax = 100;
            this.atk = 10;
            this.exp = 0;
            this.expParaUpar = 50;
            this.money = 100;
            this.statusDefesa = false;
            this.itemEquipado = null;
        }else if("guerreiro".equalsIgnoreCase(tipo)){
            this.nome = nome;
            this.nomeTipo = tipo;
            this.ranking = 'F';
            this.hp = 120;
            this.hpMax = 120;
            this.atk = 8;
            this.exp = 0;
            this.expParaUpar = 50;
            this.money = 100;
            this.statusDefesa = false;
            this.itemEquipado = null;
        }else if("espadachim".equalsIgnoreCase(tipo)){
            this.nome = nome;
            this.nomeTipo = tipo;
            this.ranking = 'F';
            this.hp = 80;
            this.hpMax = 80;
            this.atk = 25;
            this.exp = 0;
            this.expParaUpar = 50;
            this.money = 100;
            this.statusDefesa = false;
            this.itemEquipado = null;
        }else{
            System.out.println("!!Nome de classe invalido!!");
        }
    }

    public void exibirDados(){
        System.out.printf("=====Jogador=====\nNome: %s\nTipo: %s\nVida: %d/%d\nAtaque: %d\nRank: %c\nExp: %d/%d\nDinheiro: %d\n=================\n", nome, nomeTipo, hp,hpMax, atk, ranking, exp, expParaUpar, money);
    }

    public ArrayList<Integer> inventarioModiicavel(){
        int qntPocaoCura = 0, qntPocaoDano = 0, qntEspadaDeFerro = 0, i = 1, op;
        ArrayList<Integer> opcoes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String opcaoEquipar;

        for(int j = 0; j < inventario.size(); j++){
            if("Pocao de Cura".equalsIgnoreCase(inventario.get(j))){
                qntPocaoCura++;
            }else if("Pocao de Dano".equalsIgnoreCase(inventario.get(j))){
                qntPocaoDano++;
            }else if("Espada de Ferro".equalsIgnoreCase(inventario.get(j))){
                qntEspadaDeFerro++;
            }
        }

        System.out.printf("========Inventario========\n");
        if(inventario.size() == 0){System.out.printf("---------VAZIO---------\n");}
        if(qntPocaoCura > 0){System.out.printf("%d.Pocao de Cura x%d\n", i, qntPocaoCura);opcoes.add(22); i++;}
        if(qntPocaoDano > 0){System.out.printf("%d.Pocao de Dano x%d\n", i, qntPocaoDano);opcoes.add(33);i ++;}
        if(qntEspadaDeFerro > 0){System.out.printf("%d.Espada De Ferro x%d\n", i, qntEspadaDeFerro);opcoes.add(44);i ++;}
        if(itemEquipado == null){System.out.printf("Item equipado: Nenhum\n");}else{System.out.printf("Item equipado: %s\n", itemEquipado);}
        System.out.printf("==========================\n");
        System.out.printf("Deseja equipar alguma coisa(1:sim, 2:nao): ");
        op = sc.nextInt();
        sc.nextLine();
        System.out.printf("==========================\n");

        if(op == 1){
            if(itemEquipado == null){
                System.out.printf("Oque deseja equipar? ");
                opcaoEquipar = sc.nextLine();
                itemEquipado = opcaoEquipar;
                usouItem(44);
                equipouItem(44);
            }else{
                System.out.println("Voce ja tem um item equipado\n");
            }
        }else{System.out.printf("Voltando...\n");}

        return opcoes;
    }

    public ArrayList<Integer> mostrarInventario(){
        int qntPocaoCura = 0, qntPocaoDano = 0, qntEspadaDeFerro = 0, i = 1;
        ArrayList<Integer> opcoes = new ArrayList<>();

        for(int j = 0; j < inventario.size(); j++){
            if("Pocao de Cura".equalsIgnoreCase(inventario.get(j))){
                qntPocaoCura++;
            }else if("Pocao de Dano".equalsIgnoreCase(inventario.get(j))){
                qntPocaoDano++;
            }else if("Espada de Ferro".equalsIgnoreCase(inventario.get(j))){
                qntEspadaDeFerro++;
            }
        }

        System.out.printf("========Inventario========\n");
        if(inventario.size() == 0){System.out.printf("---------VAZIO---------\n");}
        if(qntPocaoCura > 0){System.out.printf("%d.Pocao de Cura x%d\n", i, qntPocaoCura);opcoes.add(22); i++;}
        if(qntPocaoDano > 0){System.out.printf("%d.Pocao de Dano x%d\n", i, qntPocaoDano);opcoes.add(33);}
        System.out.printf("==========================\n");
        return opcoes;
    }

    public void seterAumentarRancking(){
        char rankingPassado = ranking;
        for(int i = 0; i < 7; i++){
            if(ranking == 'S'){
                System.out.printf("\n!!Voce ja esta no ranking maximo!!\n");
                break;
            }
            if(ranking == rankings[i]){
                ranking = rankings[i + 1];
                exp -= expParaUpar;
                expParaUpar *= 1.5;
                hp *= 1.5;
                hpMax *= 1.5;
                atk *= 1.5;
                if(itemEquipado != null){equipouItem(44);}
                System.out.printf("\n!!Voce upou do rank %c para o rank %c, Parabens %s!!\n", rankingPassado, ranking, nome);
                break;
            }
        }
    }

    public int usouItem(int codigo){
    String nomeItem = null;
    if (codigo == 22) nomeItem = "Pocao de Cura";
    else if (codigo == 33) nomeItem = "Pocao de Dano";
    else if (codigo == 44) nomeItem = "Espada de Ferro";
    else return 1;

    if (!inventario.contains(nomeItem)) return 2;

    inventario.remove(nomeItem);
    return 0;
    }

    public void acabaouBatalha(){
        hp = hpMax;
    }

    public void fezCompra(String item, int valor){
        money -= valor;
        inventario.add(item);
        System.out.printf("\n!!Voce comprou %s por %d dinheiros!!\n", item, valor);
    }

    public void perdeuMoney(int valor){
        money -= valor;
        System.out.printf("\nJogador %s perdeu %d Gold\n", nome, valor);
    }

    public void ganhouMoney(int valor){
        money += valor;
        System.out.printf("\nJogador %s ganhou %d Gold\n", nome, valor);
    }

    public void receberDano(int qnt){
        hp -= qnt;
        System.out.printf("\nJogador %s recebeu %d de dano\n", nome, qnt);
        if(hp < 0){
            hp = 0;
        }
    }

    public void receberCura(int qnt){
        hp += qnt;
        int valSla = qnt;
        if(hp > hpMax){
            valSla = (qnt - (hp - hpMax));
            hp = hpMax;
        }

        System.out.printf("\nJogador %s Curou %d de vida\n", nome, valSla);
    }

    public void venceubatalha(){
        exp += expParaUpar/5;
        System.out.printf("Voce Ganhou %d de exp\n", expParaUpar / 5);
        while (exp >= expParaUpar && ranking != 'S') {
                seterAumentarRancking();
        }
    }

    public void ganhouExp(int qnt){
        exp += qnt;
        System.out.printf("Voce Ganhou %d de exp\n", qnt);

        while (exp >= expParaUpar && ranking != 'S') {
                seterAumentarRancking();
        }
    }

    public void equipouItem(int codigo){
        if(codigo == 44){
            atk *= 1.5;
        }
    }

    public void endPVP(){hp = hpMax;}
    public String getNome(){return nome;}
    public String getNomeTipo(){return nomeTipo;}
    public char getRanking(){return ranking;}
    public int getHp(){return hp;}
    public int getHpMax(){return hpMax;}
    public int getAtk(){return atk;}
    public int getExp(){return exp;}
    public int getExpParaUpar(){return expParaUpar;}
    public int getMoney(){return money;}
    public boolean getStatusDefesa(){return statusDefesa;}

    public void setStatusDefesa(int val){
        if(val == 1){
            statusDefesa = true;
        }else if(val == 0){
            statusDefesa = false;
        }else{
            System.out.printf("valor nao correspondente, Joel burro\n");
        }
    }
}
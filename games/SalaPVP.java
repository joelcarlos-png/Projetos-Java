package games;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SalaPVP{
    Random rnd = new Random();
    Game menu = new Game();
    private int qntMaxima = 2;
    Scanner sc = new Scanner(System.in);

    public void batalhaPVP(Jogador jog1, Jogador jog2){
        System.out.printf("Jogador 1: %s | Vida: %d/%d | Ataque: %d|\n", jog1.getNome(), jog1.getHp(), jog1.getHpMax(), jog1.getAtk());
        System.out.printf("Jogador 2: %s | Vida: %d/%d | Ataque: %d|\n\n", jog2.getNome(), jog2.getHp(), jog2.getHpMax(), jog2.getAtk());

        int sorteio = rnd.nextInt(2);
        System.out.printf("Foi sorteado que o Jogador %d vai começar\n", sorteio + 1);

        Jogador atacante = (sorteio == 0) ? jog1 : jog2;
        Jogador defensor = (sorteio == 0) ? jog2 : jog1;

        Jogador vencedor;
        Jogador perdedor;
        boolean sorteioFugitivo = true;
        while (atacante.getHp() > 0 && defensor.getHp() > 0 && sorteioFugitivo != false) {
            System.out.printf("Jogador 1: %s | Vida: %d/%d | Ataque: %d|\n", jog1.getNome(), jog1.getHp(), jog1.getHpMax(), jog1.getAtk());
            System.out.printf("Jogador 2: %s | Vida: %d/%d | Ataque: %d|\n\n", jog2.getNome(), jog2.getHp(), jog2.getHpMax(), jog2.getAtk());
            int sorteadorDefesa = 5;
            boolean valor = true;
            while(valor == true){
                System.out.printf("Vez de %s:\n", atacante.getNome());
                menu.painel(3);
                System.out.printf("Oq quer fazer: ");
                int op = sc.nextInt();
                sc.nextLine();
                switch (op) {
                    case 1:
                        if(defensor.getStatusDefesa() == true){
                            sorteadorDefesa = rnd.nextInt(3);
                        }
                        defensor.setStatusDefesa(0);
                        if (sorteadorDefesa == 0){
                            System.out.printf("!!Jogador %s conseguiu defender!!\n", defensor.getNome());
                        }else{
                            System.out.printf("!!Jogador %s NAO conseguiu defender!!\n", defensor.getNome());
                            defensor.receberDano(atacante.getAtk());
                        }
                        valor = false;
                        break;
                    case 2:
                        atacante.setStatusDefesa(1);
                        System.out.printf("Jogador %s tentou defender\n", atacante.getNome());
                        valor = false;
                        break;
                    case 3:
                        ArrayList<Integer> opcoesInventario = atacante.mostrarInventario();
                        System.out.printf("Qual item vc quer usar(0 para abortar): ");
                        op = sc.nextInt();
                        sc.nextLine();
                        if(op == 0){
                            System.out.printf("Voltando...\n");
                            break;
                        }else if(op < 1 || op > opcoesInventario.size()){
                            System.out.printf("Valor Invalido\n");
                            break;
                        }

                        if(opcoesInventario.get(op - 1) == 22){
                            int controle = atacante.usouItem(22);
                            if(controle == 0){
                                System.out.printf("!!Jogador %s usou pocao de Cura!!\n", atacante.getNome());
                                atacante.receberCura(25);
                                valor = false;
                            }else{
                                System.out.printf("Deu erro ai pai");
                            }
                        }else if(opcoesInventario.get(op - 1) == 33){
                            int controle = atacante.usouItem(33);
                            if(controle == 0){
                                System.out.printf("!!Jogador %s usou pocao de Dano!!\n", atacante.getNome());
                                defensor.receberDano(30);
                                valor = false;
                            }else{
                                System.out.printf("Deu erro ai pai");
                            }
                        }else{
                            System.out.printf("Voce nao usou nada, Joel Burro\n");
                        }
                        break;
                    case 4:
                        System.out.printf("Tem certeza que deseja desistir? (1:Sim, 2:Nao):");
                        op = sc.nextInt();
                        sc.nextLine();
                        if(op == 1){
                            System.out.printf("Jogador %s Perdeu por desistencia, MELHORE CARA\n", atacante.getNome());
                            sorteioFugitivo = false;
                            valor = false;
                            System.out.printf("PARABENS, Jogador %s Venceu, PARABENS\n", defensor.getNome());
                            atacante.receberDano(atacante.getHp());
                        }else{
                            System.out.printf("voltando...\n");
                        }
                        break;
                    default:
                        System.out.printf("!!Digite um numero de 1 a 4!!\n");
                        break;
                }
            }
            Jogador parcial = defensor;
            defensor = atacante;
            atacante = parcial;
        }
        if(jog1.getHp() > 0){
            vencedor = jog1;
            perdedor = jog2;
            vencedor.venceubatalha();
            int saque = perdedor.getMoney() / 3;
            vencedor.ganhouMoney(saque);
            perdedor.perdeuMoney(saque);
        }else if(jog2.getHp() > 0){
            vencedor = jog2;
            perdedor = jog1;
            vencedor.venceubatalha();
            int saque = perdedor.getMoney() / 3;
            vencedor.ganhouMoney(saque);
            perdedor.perdeuMoney(saque);
        }else{
            System.out.printf("!!Emapate!!\n");
        }

        jog1.acabaouBatalha();
        jog2.acabaouBatalha();
    }
}
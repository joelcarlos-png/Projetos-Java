package games;

import java.util.Scanner;

public class Cidade{
    Game menu = new Game();
    public void menuLoja(Jogador jog){
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op != 4) {
            System.out.printf("Dinheiro Atual: %d\n", jog.getMoney());
            menu.painel(4);
            System.out.printf("Digite sua opcao: ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    if(jog.getMoney() < 30){
                        System.out.printf("!!Voce nao tem dinheiro suficiente, Pobre kkkkkkk!!\n");
                        break;
                    }

                    jog.fezCompra("Pocao de Cura", 30);
                    break;
                case 2:
                    if(jog.getMoney() < 50){
                        System.out.printf("!!Voce nao tem dinheiro suficiente, Pobre kkkkkkk!!\n");
                        break;
                    }

                    jog.fezCompra("Pocao de Dano", 50);
                    break;
                case 3:
                    if(jog.getMoney() < 80){
                        System.out.printf("!!Voce nao tem dinheiro suficiente, Pobre kkkkkkk!!\n");
                        break;
                    }

                    jog.fezCompra("Espada de Ferro", 80);
                    break;
                case 4:
                    System.out.printf("Saindo da loja...\n");
                    break;
                default:
                    System.out.printf("!!Digite um numero de 1 a 4!!\n");
                    break;
            }

        }
    }
}
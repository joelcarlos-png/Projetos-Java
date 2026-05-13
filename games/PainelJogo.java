package games;

import java.util.Scanner;

public class PainelJogo{
    Cidade cid = new Cidade();
    Floresta flor = new Floresta();
    Game menu = new Game();
    Scanner sc = new Scanner(System.in);

    public void painelJogador(Jogador jog){
        int op = 1;
        while(op != 5){
            System.out.printf("=-=-=-=-=-=-=-=-=-=%s-=-=-=-=-=-=-=-=\n", jog.getNome());
            menu.painel(5);
            System.out.printf("Digite sua opcao: ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    while(op != 2){
                        menu.painel(7);
                        System.out.printf("Digite sua opcao: ");
                        op = sc.nextInt();
                        sc.nextLine();
                        switch (op) {
                            case 1:
                                cid.menuLoja(jog);
                                break;
                            case 2:
                                System.out.printf("Voltando para o painel...\n");
                                break;
                            default:
                                System.out.printf("Digite 1 ou 2\n");
                                break;
                        }
                    }
                    break;//cidade
                case 2:
                    while (op != 3) {
                        menu.painel(8);
                        System.out.printf("Digite sua opcao: ");
                        op = sc.nextInt();
                        sc.nextLine();
                        switch (op) {
                            case 1:
                                op = 1;
                                while(op == 1){
                                    flor.campoDeTreino(jog);
                                    System.out.printf("Deseja Fazer outro treino? (1: sim, 2: nao): ");
                                    op = sc.nextInt();
                                    sc.nextLine();
                                }
                                break;
                            case 2:
                                op = 1;
                                while(op == 1){
                                    flor.cacarMonstros(jog);
                                    System.out.printf("Deseja caçar outro monstro? (1: sim, 2: nao): ");
                                    op = sc.nextInt();
                                    sc.nextLine();
                                }
                                break;
                            case 3:
                                System.out.printf("Voltando para o painel...\n");
                                break;
                            default:
                                System.out.printf("Digite de 1 a 3\n");
                                break;
                        }
                    }
                    break;//floresta
                case 3:
                    jog.inventarioModiicavel();
                    break;//inventario
                case 4:
                    jog.exibirDados();
                    break;//ver estatistica
                case 5:
                    System.out.printf("Voltando...\n");
                    break;
                default:
                    break;
            }
        }
    }
}
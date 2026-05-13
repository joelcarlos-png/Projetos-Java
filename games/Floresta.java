package games;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Floresta{
    Random rnd = new Random();
    Scanner sc = new Scanner(System.in);

    public void animacaoBoneco(int valor, char letraTargada){

        for (int i = 0; i < 30; i++){System.out.printf("\n");}
        
        if(valor == 1){
            System.out.printf("===============\n");
            System.out.printf(" O    |  | \n");
            System.out.printf("/|\\   |--| \n");
            System.out.printf("/ \\   |  | \n");
        }else if(valor == 2){
            System.out.printf("===============\n");
            System.out.printf(" O    |  | \n");
            System.out.printf("/|\\--* |-| ACERTOU\n");
            System.out.printf("/ \\   |  | \n");
        }else if(valor == 3){
            System.out.printf("===============\n");
            System.out.printf(" O    |  | \n");
            System.out.printf("/|\\--*|--|  ERROU\n");
            System.out.printf("/ \\   |  | \n");
        }else if(valor == 4){
            System.out.printf("\nProxima letra: \n");
            System.out.printf("===============\n");
            System.out.printf(" O    |  | \n");
            System.out.printf("/|\\   |--|       %c\n", letraTargada);
            System.out.printf("/ \\   |  | \n");
        }else if(valor == 5){
            System.out.printf("                              ______________                                \n");
            System.out.printf("                        ,===:'.,            `-._                            \n");
            System.out.printf("                             `:.`---.__         `-._                        \n");
            System.out.printf("                                     `:.     `--.         `.                \n");
            System.out.printf("                                       \\.         `.         `.            \n");
            System.out.printf("                         (,,(,          \\.          `.    ____,-`.,        \n");
            System.out.printf("                      (,'      `/        \\.    ,--.___`.'                  \n");
            System.out.printf("                   ,  ,'  ,--.  `,    \\.;'         `                       \n");
            System.out.printf("                    `{D, {    \\  :    \\;                                  \n");
            System.out.printf("                      V,,'    /  /     //                                   \n");
            System.out.printf("                      j;;    /  ,' ,-//.    ,---.      ,                    \n");
            System.out.printf("       O             \\;'   /  ,' /  _  \\  /  _  \\    ,'/                \n");
            System.out.printf("      /|\\                   \\   `'  / \\  `'  / \\  `.' /                  \n");
            System.out.printf("      / \\                    `.___,'   `.__,'   `.__,'  VZ                  \n");
        }else if(valor == 6){
            System.out.printf("                              ______________                                \n");
            System.out.printf("                        ,===:'.,            `-._                            \n");
            System.out.printf("                             `:.`---.__         `-._                        \n");
            System.out.printf("                                     `:.     `--.         `.                \n");
            System.out.printf("                                       \\.         `.         `.            \n");
            System.out.printf("                         (,,(,          \\.          `.    ____,-`.,        \n");
            System.out.printf("                      (,'      `/        \\.    ,--.___`.'                  \n");
            System.out.printf("                   ,  ,'  ,--.  `,    \\.;'         `                       \n");
            System.out.printf("                    `{D, {    \\  :    \\;             ACERTOU                     \n");
            System.out.printf("                      V,,'    /  /     //                                   \n");
            System.out.printf("                      j;;    /  ,' ,-//.    ,---.      ,                    \n");
            System.out.printf("       O             \\;'   /  ,' /  _  \\  /  _  \\    ,'/                \n");
            System.out.printf("      /|\\-----------POW     \\   `'  / \\  `'  / \\  `.' /                  \n");
            System.out.printf("      / \\                    `.___,'   `.__,'   `.__,'  VZ                  \n");
        }else if(valor == 7){
            System.out.printf("                        /(.-\"\"-.)\\            \n");
            System.out.printf("                     |\\  \\/      \\/  /|        \n");
            System.out.printf("                    | \\ / =.  .= \\ / |         \n");
            System.out.printf("                    \\( \\   o\\/o   / )/         \n");
            System.out.printf("                     \\_, '-/  \\-' ,_/          \n");
            System.out.printf("                        /   \\__/   \\           \n");
            System.out.printf("                       \\ \\__/\\__/ /            \n");
            System.out.printf("      O            ___\\ \\|--|/ /___            \n");
            System.out.printf("     /|\\            /`    \\      /    `\\       \n");
            System.out.printf("     / \\          /       '----'       \\       \n");
        }else if(valor == 8){
            System.out.printf("                        /(.-\"\"-.)\\            \n");
            System.out.printf("                     |\\  \\/      \\/  /|        \n");
            System.out.printf("                    | \\ / =.  .= \\ / |         \n");
            System.out.printf("                    \\( \\   o\\/o   / )/         \n");
            System.out.printf("                     \\_, '-/  \\-' ,_/          \n");
            System.out.printf("                        /   \\__/   \\   ACERTOU        \n");
            System.out.printf("                       \\ \\__/\\__/ /            \n");
            System.out.printf("      O            ___\\ \\|--|/ /___            \n");
            System.out.printf("     /|\\---------POW/`    \\      /    `\\       \n");
            System.out.printf("     / \\          /       '----'       \\       \n");
        }else if(valor == 9){
            System.out.printf("                  _______       \n");
            System.out.printf("                 /       \\      \n");
            System.out.printf("                /  >   <  \\     \n"); 
            System.out.printf("      O        |    ___    |    \n");
            System.out.printf("     /|\\       |   /     \\ |    \n"); 
            System.out.printf("     / \\        \\_________/     \n");
        }else if(valor == 10){
            System.out.printf("                  _______       \n");
            System.out.printf("                 /       \\      \n");
            System.out.printf("                /  >   <  \\   ACERTOU  \n"); 
            System.out.printf("      O        |    ___    |    \n");
            System.out.printf("     /|\\-----* |   /     \\ |    \n"); 
            System.out.printf("     / \\        \\_________/     \n");
        }else{
            System.out.printf("indice nao bate pro painel joel burro\n");
        }
    }

    public void campoDeTreino(Jogador jog){
        int flagVenceuMiniGame = 0;
        char letrasMiniGame[] = {'A','S','D','F'};
        System.out.printf("!!MINIGAME DE TREINO ESTA PARA COMECAR!!\n");
        System.out.print("Começando em: ");
            for(int i = 5; i > 0; i--){
                System.out.printf("%d ", i);
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        System.err.println();
        for(int i = 0; i < 7; i++){
            int valorAleatorio = rnd.nextInt(4);
            animacaoBoneco(4, letrasMiniGame[valorAleatorio]);
            long tempoDuracao = System.currentTimeMillis() + 1000;
            boolean acerto = false;
            boolean erro = true;

            try {
                while (System.in.available() > 0) {System.in.read();}
            } catch (java.io.IOException e) {
                System.out.printf("Erro ao limpar buffer de entrada\n");
                break;
            }

            System.out.printf("!!APERTE AGORA!!: ");
            while (System.currentTimeMillis() < tempoDuracao){
                try {
                    if (System.in.available() > 0) {
                        char c = (char) System.in.read();

                        if(Character.toLowerCase(c) == Character.toLowerCase(letrasMiniGame[valorAleatorio])){
                            acerto = true;
                            erro = false;
                            break;
                        }
                    }
                } catch (java.io.IOException e) {
                    System.out.printf("Erro ao ler entrada\n");
                    erro = true;
                    break;
                }
                try { Thread.sleep(10); } catch (InterruptedException e) {}
            }

            if(acerto == true){
                animacaoBoneco(2, 'a');
                try { Thread.sleep(500); } catch (InterruptedException e) {}
                flagVenceuMiniGame++;
                System.out.printf("\nProxima letra: \n");
            }

            if(erro == true){
                animacaoBoneco(3, 'a');
                try { Thread.sleep(500); } catch (InterruptedException e) {}
                System.out.printf("\nProxima letra: \n");
            }
        }
        if(flagVenceuMiniGame >= 5){
            System.out.printf("VOCE VENCEU\n");
            jog.venceubatalha();
        }else{
            System.out.printf("VOCE PERDEU TENTE NOVAMENTE\n");
        }
    }

    public void cacarMonstros(Jogador jog){
        Game menu = new Game();
        String tipoMonstros[] = {"dragao", "goblin", "slime"};
        int sorteio = rnd.nextInt(3);
        Monstro monst = new Monstro(tipoMonstros[sorteio]);
        int indicesAnimacoes[] = new int[2];
        if(sorteio == 0){
            indicesAnimacoes = new int[]{5, 6};
        }else if(sorteio == 1){
            indicesAnimacoes = new int[]{7, 8};
        }else if(sorteio == 2){
            indicesAnimacoes = new int[]{9, 10};
        }else{
            System.out.printf("indices da animacao nao deu certo, joel burro\n");
        }

        boolean flagFugir = false;
        while(jog.getHp() > 0 && monst.getHp() > 0 && flagFugir == false){
            int finalTurno = sorteio;
            animacaoBoneco(indicesAnimacoes[0], 'a');

            while(finalTurno < 3){
                monst.exibirDados();
                System.out.printf("\nJogador %s | Vida: %d/%d | Ataque: %d |\n", jog.getNome(), jog.getHp(), jog.getHpMax(), jog.getAtk());
                menu.painel(6);
                System.out.printf("Digite sua opcao: ");
                int op = sc.nextInt();
                sc.nextLine();
                switch(op) {
                    case 1:
                        animacaoBoneco(indicesAnimacoes[1], 'a');
                        System.out.println("!!Voce atacou!!\n");
                        monst.receberDano(jog.getAtk());
                        finalTurno++;
                        try { Thread.sleep(500); } catch (InterruptedException e) {}
                        break;
                    case 2:
                        jog.setStatusDefesa(1);
                        System.out.println("!!Voce Defendeu!!\n");
                        finalTurno++;
                        try { Thread.sleep(500); } catch (InterruptedException e) {}
                        break;
                    case 3:
                        ArrayList<Integer> opcoesInventario = jog.mostrarInventario();
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
                            int controle = jog.usouItem(22);
                            if(controle == 0){
                                System.out.printf("!!Jogador %s usou pocao de Cura!!\n", jog.getNome());
                                jog.receberCura(25);
                                finalTurno++;
                            }else{
                                System.out.printf("Deu erro ai pai");
                            }
                        }else if(opcoesInventario.get(op - 1) == 33){
                            int controle = jog.usouItem(33);
                            if(controle == 0){
                                System.out.printf("!!Jogador %s usou pocao de Dano!!\n", jog.getNome());
                                monst.receberDano(30);
                                finalTurno++;
                            }else{
                                System.out.printf("Deu erro ai pai\n");
                            }
                        }else{
                            System.out.printf("Voce nao usou nada, Joel Burro\n");
                        }
                        break;
                    case 4:
                        System.out.printf("Voce tem certeza que quer desistir? (1: sim, 2: nao): ");
                        op = sc.nextInt();
                        sc.nextLine();

                        if(op == 1){
                            finalTurno = 3;
                            flagFugir = true;
                            System.out.printf("Voce fugiu do Monstro %s\n", monst.getNome());
                        }else{
                            System.out.printf("voltando...\n");
                        }
                        break;
                    default:
                        System.out.printf("Digite um numero de 1 a 4\n");
                        break;
                }
            }
            System.out.printf("Vez do monstro %s:\n",monst.getNome());
            int mult = 1;
            if(flagFugir == true){}else{
            if(jog.getStatusDefesa() == true){
                int sorteioStatusDefesa = rnd.nextInt(4);
                if(sorteio == 0){
                    if(sorteioStatusDefesa <= 2){
                        mult = 0;
                        System.out.print("!!Voce consegui defender!!\n");
                    }else{
                        System.out.printf("!!Voce nao conseguiu defender!!\n");
                    }
                }else if(sorteio == 1){
                    if(sorteioStatusDefesa <= 1){
                        mult = 0;
                        System.out.print("!!Voce consegui defender!!\n");
                    }else{
                        System.out.printf("!!Voce nao conseguiu defender!!\n");
                    }
                }else if(sorteio == 2){
                    if(sorteioStatusDefesa == 0){
                        mult = 0;
                        System.out.print("!!Voce consegui defender!!\n");
                    }else{
                        System.out.printf("!!Voce nao conseguiu defender!!\n");
                    }
                }
                jog.setStatusDefesa(0);
            }

            jog.receberDano(monst.getAtk() * mult);
            System.out.print("Proximo turno em: ");
            for(int i = 5; i > 0; i--){
                System.out.printf("%d ", i);
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
            System.err.println();
            }
        }
        int jogVencedor = 0;
        if(monst.getHp() <= 0 && jog.getHp() > 0){
            jogVencedor = 1;
        }else if(monst.getHp() == 0 && jog.getHp() == 0){
            jogVencedor = 2;
        }

        if(jogVencedor == 0){
            System.out.printf("!!O Monstro %s GANHO!!\n", monst.getNome());
        }else if(jogVencedor == 1){
            System.out.printf("!!O Jogador %s GANHO!!\n", jog.getNome());
            jog.ganhouMoney(monst.getMoneySeDerrotado());
            jog.ganhouExp(monst.getExpSeDerrotado());
        }else{
            System.out.printf("!DEU EMPATE!\n", jog.getNome());
        }

        monst.acabouBatalha();
        jog.acabaouBatalha();
    }
}
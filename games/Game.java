package games;

import java.util.ArrayList;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.Scanner;

public class Game {
    int numeroJogadores = 0;
    ArrayList<Jogador> jogadoresTotal = new ArrayList<>();
    Floresta lugar = new Floresta();

    public void painel(int valor){
        if (valor == 1){
            System.out.printf("=-=-=-=-=-=-=-=OpcoesGame-=-=-=-=-=-=-=-\n");
            System.out.printf("1.Criar Novo Jogador                    \n");
            System.out.printf("2.Fazer PVP                             \n");
            System.out.printf("3.Ver Jogadores                         \n");
            System.out.printf("4.Entrar Painel jogador                 \n");
            System.out.printf("5.Sair                                  \n");
            System.out.printf("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        }else if(valor == 2){
            System.out.printf("\n=======Classes=======\n1.humano / Vida: 100/ Ataque: 10\n---------------------\n2.guerreiro / Vida : 120 / Ataque: 8\n---------------------\n3.Espadachim / Vida: 80 / Ataque: 25\n=====================\n");
        }else if(valor == 3){
            System.out.printf("=-=-=-=-=-=-=-=Batalha-=-=-=-=-=-=-=-=-=\n");
            System.out.printf("1.Atacar                                \n");
            System.out.printf("2.Defender (1/3 chance de defender)     \n");
            System.out.printf("3.Usar Item                             \n");
            System.out.printf("4.Fugir                                 \n");
            System.out.printf("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        }else if(valor == 4){
            System.out.printf("=-=-=-=-=-=-=-=Loja-=-=-=-=-=-=-=-=-=-=-\n");
            System.out.printf("1.Pocao de Cura (30G | Cura:25)         \n");
            System.out.printf("2.Pocao de Dano (50G | Dano:30)         \n");
            System.out.printf("3.Espada de Ferro (80G | Dano: + 50%%)   \n");
            System.out.printf("4.Sair da Loja                          \n");
            System.out.printf("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        }else if(valor == 5){
            System.out.printf("1.Cidade                                 \n");
            System.out.printf("2.Floresta                               \n");
            System.out.printf("3.Inventario                             \n");
            System.out.printf("4.Ver Estatistica                        \n");
            System.out.printf("5.Sair do painel do jogador              \n");
            System.out.printf("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        }else if(valor == 6){
            System.out.printf("=-=-=-=-=-=-CaçaAoMonstro-=-=--=-=-=-=-=\n");
            System.out.printf("1.Atacar                                \n");
            System.out.printf("2.Defender                              \n");
            System.out.printf("3.Usar Item                             \n");
            System.out.printf("4.Fugir                                 \n");
            System.out.printf("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        }else if(valor == 7){
            System.out.printf("=-=-=-=-=-=-=-=-=-Cidade-=-=--=-=-=-=-=\n");
            System.out.printf("1.Loja                                  \n");
            System.out.printf("2.Sair da Ciadade                       \n");
            System.out.printf("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        }else if(valor == 8){
            System.out.printf("=-=-=-=-=-=-=-=-Floresta=-=-=--=-=-=-=-=\n");
            System.out.printf("1.Treinar                               \n");
            System.out.printf("2.Caçar Monstro                         \n");
            System.out.printf("3.Sair da Floresta                      \n");
            System.out.printf("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        }else{
            System.out.printf("!!!Painel nao existente, Joel Burro!!!!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game menu = new Game();
        SalaPVP batalha = new SalaPVP();
        PainelJogo paineljogo = new PainelJogo();
        int op = 0;
        while (op != 5) {
            menu.painel(1);
            System.out.printf("Digite sua opcao: ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    menu.painel(2);
                    System.out.printf("Digite um NickName: ");
                    String name = sc.nextLine();
                    System.out.printf("Digite uma Classe: ");
                    String tipo = sc.nextLine();
                    Jogador novo =  new Jogador(name, tipo);
                    menu.jogadoresTotal.add(novo);
                    menu.numeroJogadores++;
                    break;
                case 2:
                    if(menu.jogadoresTotal.size() < 2){
                        System.out.printf("!!Voce precisa ter pelo menos 2 jogadores!!\n");
                        break;
                    }
                    boolean paradaParcial = true;
                    String jogador1indice = "", jogador2indice = "";
                    while(paradaParcial == true){
                        System.out.printf("\n--------Jogadores--------------------------------\n");
                        for(int i = 0; i < menu.jogadoresTotal.size(); i++){
                            System.out.printf("%d. Jogador: %s | Tipo: %s\n",i + 1, menu.jogadoresTotal.get(i).getNome(), menu.jogadoresTotal.get(i).getNomeTipo());
                        }
                        System.out.printf("------------------------------------------------------\nDigite dois jogadores para a batalha: ");
                        jogador1indice = sc.nextLine();
                        jogador2indice = sc.nextLine();
                        if(jogador1indice.equalsIgnoreCase(jogador2indice)){
                            System.out.println("!!Voce nao pode escolher o mesmo jogador!!\n");
                        }else{
                            paradaParcial = false;
                        }
                    }
                    int indicejog1 = -1, indicejog2 = -1;
                    for(int i = 0; i < menu.jogadoresTotal.size(); i++){
                        if(jogador1indice.equalsIgnoreCase(menu.jogadoresTotal.get(i).getNome())){
                            indicejog1 = i;
                            break;
                        }
                    }
                    for(int i = 0; i < menu.jogadoresTotal.size(); i++){
                        if(jogador2indice.equalsIgnoreCase(menu.jogadoresTotal.get(i).getNome())){
                            indicejog2 = i;
                            break;
                        }
                    }

                    if(indicejog1 != -1 && indicejog2 != -1){
                        batalha.batalhaPVP(menu.jogadoresTotal.get(indicejog1), menu.jogadoresTotal.get(indicejog2));
                    }else{
                        System.out.printf("!!Um ou ambos os jogadores nao foram encontrados!!\n");
                    }
                    break;
                case 4:
                {
                    System.out.printf("\n--------Jogadores--------------------------------\n");
                    for(int i = 0; i < menu.jogadoresTotal.size(); i++){
                        System.out.printf("%d. Jogador: %s | Tipo: %s\n",i + 1, menu.jogadoresTotal.get(i).getNome(), menu.jogadoresTotal.get(i).getNomeTipo());
                    }
                    System.out.printf("------------------------------------------------------\n");
                    System.out.printf("Digite o nome do jogador para entrar no painel: ");
                    String sla = sc.nextLine();
                    int controle = 0;
                    for(int i = 0; i < menu.jogadoresTotal.size(); i++){
                        if(sla.equalsIgnoreCase(menu.jogadoresTotal.get(i).getNome())){
                            paineljogo.painelJogador(menu.jogadoresTotal.get(i));
                            controle = 1;
                            break;
                        }
                    }
                    if (controle == 0){
                        System.out.printf("!!Jogador nao encontrado!!\n");
                    }else{
                        break;
                    }
                }
                    break;
                case 3:
                {
                    System.out.printf("\n--------Jogadores--------------------------------\n");
                    for(int i = 0; i < menu.jogadoresTotal.size(); i++){
                        System.out.printf("%d. Jogador: %s | Tipo: %s\n",i + 1, menu.jogadoresTotal.get(i).getNome(), menu.jogadoresTotal.get(i).getNomeTipo());
                    }
                    System.out.printf("------------------------------------------------------\n");
                    System.out.printf("Digite o nome do jogador para ver as estatisticas: ");
                    String sla2 = sc.nextLine();
                    int controle2 = 0;
                    for(int i = 0; i < menu.jogadoresTotal.size(); i++){
                        if(sla2.equalsIgnoreCase(menu.jogadoresTotal.get(i).getNome())){
                            menu.jogadoresTotal.get(i).exibirDados();
                            controle2 = 1;
                            break;
                        }
                    }
                    if (controle2 == 0){
                        System.out.printf("!!Jogador nao encontrado!!\n");
                    }else{
                        break;
                    }
                }
                    break;
                case 5:
                    System.out.printf("Tem certeza que deseja sair: (1: sim, 2:nao)");
                    int opsair = sc.nextInt();
                    if(opsair == 1){
                        break;
                    }else{
                        op = 10;
                        break;
                    }
                default:
                    System.out.printf("!!Digite um opcao de 1 a 4!!\n");
                    break;
            }
        }
        System.err.println("Saindo do sistema\n");
        sc.close();
    }   
}
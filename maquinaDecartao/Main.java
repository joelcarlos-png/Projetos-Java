package maquinaDecartao;

import games.Controle;

import java.util.Scanner;



public class Main {

    public static final String RESET  = "\u001B[0m";

    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE  = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";

    static Banco banco = new Banco();
    static Controle c = new Controle();

    public static void painel(int flag){
        if(flag == 1){
            System.out.printf("=========Opcoes-Banco=========\n");
            System.out.printf("1.Criar Nova Conta            \n");
            System.out.printf("2.Apagar Conta                \n");
            System.out.printf("3.Ver contas                  \n");
            System.out.printf("4.Entar no painel da Conta    \n");
            System.out.printf("5.Sair                        \n");
            System.out.printf("==============================\n");
        }else if(flag == 2){
            System.out.printf("=========Opcoes-Conta=========\n");
            System.out.printf("1.Criar cartao                \n");
            System.out.printf("2.ver cartoes                 \n");
            System.out.printf("3.Entrar no painel do cartao  \n");
            System.out.printf("4.Ver detalhes da conta       \n");
            System.out.printf("5.Ver historico de compra     \n");
            System.out.printf("6.Sair do painel              \n");
            System.out.printf("==============================\n");
        }else if(flag == 3){
            System.out.printf("=========Opcoes-Cartoes=========\n");
            System.out.printf("1.Ver todos os cartoes          \n");
            System.out.printf("2.Ver todos os parcelamentos    \n");
            System.out.printf("3.Excluir cartao                \n");
            System.out.printf("4.Fazer compra                  \n");
            System.out.printf("5.Fazer compra parcelado        \n");
            System.out.printf("================================\n");
        }else{
            System.out.printf("Painel nao encontrado \n");
        }
    }

    public static void entrarPainel(Conta conta){
        int op = 0;
        while(op != 6){
            painel(2);
            op = c.lerInteiro("Digite sua opção: ");
            switch (op){
                case 1:
                    conta.criarNovoCartao(c.lerString("Digite a senha para o cartao: "), conta);
                    break;
                case 2:
                    mostrarCartoes(conta);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.printf("Voltando...\n");
                    break;
                default:
                    System.out.printf("Digite um numero de 1 a 5!!\n");
                    break;
            }
        }
    }

    public static boolean mostrarContas(){
        if(banco.getContas().size() <= 0){
            System.out.printf("Voce ainda nao criou nenhuma conta\n");
            return false;
        }
        System.out.printf("=======================Contas=========================\n");
        for(int i = 0; i < banco.getContas().size(); i++){
            Conta daVez = banco.getContas().get(i);
            System.out.printf("| Conta %d | Titular: %s | Saldo: %.2f | Cartoes: %d |\n",
                    i + 1,
                    daVez.getTitular(),
                    daVez.getSaldo(),
                    daVez.getNumCartoes());
        }
        System.out.printf("======================================================\n");
        return true;
    }

    public static boolean mostrarCartoes(Conta conta){
        if(conta.getCartoes().size() <= 0){
            System.out.printf("Voce ainda nao criou nenhum cartao\n");
            return false;
        }
        System.out.printf("=======================Cartoes=========================\n");
        for(int i = 0; i < conta.getCartoes().size(); i++){
            Cartao daVez = conta.getCartoes().get(i);
            System.out.printf("| Cartao %d | Cor: %s | Codigo: %d |\n",
                    i + 1,
                    daVez.getCor(),
                    daVez.getCodigo());
        }
        System.out.printf("======================================================\n");
        return true;
    }

    public static void main(String[] args){

        int op = 0, ctr;
        String ctrs;
        while(op != 5){
            painel(1);
            op = c.lerInteiro("Digite sua opção: ");
            switch (op) {
                case 1:
                    Conta novo = new Conta(c.lerString("Digite a senha para a conta: "));
                    banco.setNovaConta(novo);
                    break;
                case 2:
                    boolean flaghit = false;
                    while (flaghit == false){
                        if(mostrarContas() == false){
                            break;
                        }
                        ctrs = c.lerString("Digite o nome da conta para deletar: ");
                        for(int i = 0; i < banco.getContas().size() ; i++){
                            Conta daVez = banco.getContas().get(i);
                            if(ctrs.equalsIgnoreCase(daVez.getTitular())){
                                System.out.printf(AMARELO + "Conta com titular %s deletada\n" + RESET, banco.getContas().get(i).getTitular());
                                banco.getContas().remove(i);
                                flaghit = true;
                                break;
                            }
                        }
                        if(flaghit == false){
                            System.out.printf("Conta nao encontrada\n");
                        }
                    }

                    break;
                case 3:
                    mostrarContas();
                    break;
                case 4:
                    boolean flaghit2 = false;
                    while (flaghit2 == false){
                        if(mostrarContas() == false){
                            break;
                        }
                        ctrs = c.lerString("Digite o nome da conta para deletar: ");
                        for(int i = 0; i < banco.getContas().size() ; i++){
                            Conta daVez = banco.getContas().get(i);
                            if(ctrs.equalsIgnoreCase(daVez.getTitular())){

                                flaghit2 = true;
                                break;
                            }
                        }
                        if(flaghit2 == false){
                            System.out.printf("Conta nao encontrada\n");
                        }
                    }
                    break;
                case 5:
                    ctr = c.lerInteiro("Tem certeza? (1:sim | 2:nao):");

                    if(ctr == 1){
                        System.out.printf("Saindo...\n");
                    }else{
                        System.out.printf("Voltando...\n");
                        op = 0;
                    }
                    break;
                default:
                    System.out.printf("!!Digite um numero de 1 a 5!!\n");
                    break;
            }
        }
    }
}

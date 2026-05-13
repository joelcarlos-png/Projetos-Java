package maquinaDecartao;

import games.Controle;

import java.util.Scanner;

public class Main {
    public static void painel(int flag){
        if(flag == 1){
            IO.println("=========Opcoes-Banco=========");
            IO.println("1.Criar Nova Conta            ");
            IO.println("2.Apagar Conta                ");
            IO.println("3.Entar no painel da Conta    ");
            IO.println("4.Sair                        ");
            IO.println("==============================");
        }else if(flag == 2){
            IO.println("=========Opcoes-Conta=========");
            IO.println("1.Cartoes                     ");
            IO.println("2.Ver detalhes da conta       ");
            IO.println("2.Sair do painel              ");
            IO.println("==============================");
        }else if(flag == 3){
            IO.println("=========Opcoes-Cartoes=========");
            IO.println("1.Ver todos os cartoes                       ");
            IO.println("2.Ver todos os parcelamentos         ");
            IO.println("2.Excluir cartao                ");
            IO.println("2.                 ");
            IO.println("==============================");
        }
    }
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Banco banco = new Banco();
        Controle c = new Controle();

        int op = 0, ctr;
        while(op != 4){
            op = sc.nextInt();
            switch (op) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    ctr = c.lerInteiro("Tem certeza? (1:sim | 2:nao):");

                    if(ctr == 1){
                        IO.println("Saindo...");
                    }else{
                        IO.println("Voltando...");
                        op = 0;
                    }
                    break;
                default:
                    IO.println("!!Digite um numero de 1 a 4!!");
                    break;
            }
        }
    }
}

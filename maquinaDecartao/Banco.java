package maquinaDecartao;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    String nome = "Joel's Banc Ltda.";
    private static ArrayList<Conta> contas = new ArrayList<>();
    double saldoVinculado = 0;

    public void setSaldoVinculado(double saldo) {
        saldoVinculado += saldo;
    }

    public double getSaldoVinculado(){return saldoVinculado;}
    public ArrayList<Conta> getContas(){return contas;}

    public void setNovaConta(Conta conta){
        contas.add(conta);
    }

}

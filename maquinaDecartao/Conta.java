package maquinaDecartao;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conta {
    Scanner sc = new Scanner(System.in);
    private double saldo;
    private String titular;
    private long senhaHash;
    private static ArrayList<Cartao> cartoes = new ArrayList<>();
    protected static ArrayList<historicoConta> historico = new ArrayList<>();

    protected void exibirCartoes(){
        for(int i = 0; i < cartoes.size(); i++){
            System.out.printf("|Cartao %d: %s |\n",i + 1 , cartoes.get(i).getCor());
        }
    }

    private void criarNovoCartao(String senha){
        if(cartoes.size() >= 5){
            System.out.printf("!!Voce ja tem 5 cartoes\n!!");
        }else{
            Cartao cart = new Cartao(senha);
            cartoes.add(cart);
        }
    }

    private long algortmoHash(String senha){
        long hash = 98765432100103L;
        for(int i = 0; i < senha.length(); i++){
            char carac = senha.charAt(i);
            hash = hash ^ carac;
            hash *= 16777619;
            hash = (hash << 9) | (hash >>> (64 - 9));
        }

        hash ^= hash >>> 33;
        hash *= 0xff51afd7ed558ccdL;
        hash ^= hash >>> 33;

        return hash;
    }

    private void criadorSenhaHash(String senha){
        long hashCriado = algortmoHash(senha);
        this.senhaHash = hashCriado;
    }

    private boolean verificadorSenha(String senha){
        if(senhaHash == algortmoHash(senha)){
            return true;
        }
        return false;
    }

    protected Conta(String senha){
        System.out.printf("Digite o nome do Titular: ");
        String nomeProposto = sc.nextLine();
        this.titular = nomeProposto;
        this.saldo = 0;
        criadorSenhaHash(senha);
        System.out.printf("!!Conta criada!! = | Titular: %s | Saldo: %d | Cartoes: %d |\n", titular, saldo, cartoes.size());
    }

    public double getSaldo(){
        return saldo;
    }

    public boolean setSaldo(double valor, int operacao){
        if(operacao == 1){
            saldo += valor;
            return true;
        }else if(operacao == 2){
            if(valor >= saldo){
                saldo -= valor;
                return true;
            }else{
                System.out.printf("Voce nao tem saldo suficiente para sacar esse valor!!\n");
                return false;
            }
        }else{
            System.out.printf("Operacao nao correspondente!!\n");
            return false;
        }
    }

    public String getTitular(){
        return titular;
    }
    
}

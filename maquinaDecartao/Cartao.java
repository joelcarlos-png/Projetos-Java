package maquinaDecartao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Cartao {
    Scanner sc = new Scanner(System.in);
    public static String[] cores = {"AZUL","VERMELHO","AMARELO","VERDE","ROSA"};
    private String cor;
    private long codigo;
    private long senhaHash;
    private static ArrayList<Parcelamento> totParcelamentos = new ArrayList<>();

    LocalDateTime horaAgora = LocalDateTime.now();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String dataAgora = horaAgora.format(formatador);
    
    private void criadorDeCodigo(){
        Random rdn = new Random();
        long codigoBase = 0;
        
        for(int i = 0; i < 16; i++){
            long num = rdn.nextInt(10);
            num *= Math.pow(10, i);
            codigoBase += num;
        }
        this.codigo = codigoBase;
    }

    public void fezCompra(double valor, String senha, Conta cont){
        if(verificadorSenha(senha)){
            if(cont.setSaldo(valor, 2)){
                historicoConta historicoCompra = new historicoConta(valor, cor, dataAgora, null);
                cont.historico.add(historicoCompra);
            System.out.printf("!!Compra de %.2f realizada no cartao %s!!\nTitular do cartao: %s | Saldo atual: %.2f |\n", valor, cor, cont.getTitular(), cont.getSaldo());
            }else{}
        }else{
            System.out.printf("Senha incorreta\n");
        }
    }

    public void fezCompraParcelado(Conta cont, double valor, int meses, String senha, String loja, String produto){
        if(verificadorSenha(senha)){
            Parcelamento novoParcelamento = new Parcelamento(valor, meses, loja, produto);
            totParcelamentos.add(novoParcelamento);
            historicoConta historicoCompra = new historicoConta(valor, cor, dataAgora, novoParcelamento);
            cont.historico.add(historicoCompra);
            System.out.printf("Produto %s da loja %s com valor de %.2f parcelado em %d meses | valor da parcela: %.2f\n",novoParcelamento.getProduto(), novoParcelamento.getLoja(), novoParcelamento.getValorTotal(), novoParcelamento.getMeses(), novoParcelamento.getValorParcela());
        }
    }

    protected void mostrarCodigo(){
        System.out.printf("Codigo: ");
        for(int i = 16; i >= 4; i -= 4){
            long valPrint = (codigo % (long)Math.pow(10, i)) / (long)Math.pow(10, i - 4);
            System.out.printf("%04d", valPrint);
            if(i == 4){break;}else{System.out.printf("-");}
        }
    }

    protected void mostrarParcelamentos(){
        if(totParcelamentos.size() <= 0){
            System.out.printf("Voce nao tem parcelamentos ativos\n");
        }else{
            System.out.printf("================Parcelamentos================\n");
            for(int i = 0; i < totParcelamentos.size(); i++){
                System.out.printf("%d.| Produto: %s | Valor da parcela: %.2f | Quantidade de meses: %d |\n",i + 1, totParcelamentos.get(i).getProduto(), totParcelamentos.get(i).getValorParcela(), totParcelamentos.get(i).getMeses());
            }
            System.out.printf("=============================================\n");
            System.out.printf("Deseja ver parcelamento com mais detalhes(-1 para sair ou numero do parcelamento): ");
            int opcaoParcelamento = sc.nextInt();
            sc.nextLine();
            if(opcaoParcelamento != -1){
                totParcelamentos.get(opcaoParcelamento - 1).mostrarDetalhes();    
            }
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

    protected Cartao(String senha){
        criadorSenhaHash(senha);
        criadorDeCodigo();
        System.out.printf("==========Cores==========");
        for(int i = 0; i < cores.length; i ++){
            System.out.printf("%d. %s\n", i + 1, cores[i]);
        }
        System.out.printf("=========================\nDigite a cor para o cartao: ");
        int escolha = sc.nextInt();

        this.cor = cores[escolha -1];

        String arrayAux[] = new String[cores.length - 1];

        int j = 0;
        for(int i = 0; i < cores.length; i++){
            if(i != escolha){
                arrayAux[j] = cores[i];
                j++;
            }
        }
        cores = arrayAux;
    }

    public long getCodigo(){
        return codigo;
    }

    public String getCor(){
        return cor;
    }
}

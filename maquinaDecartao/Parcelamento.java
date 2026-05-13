package maquinaDecartao;

public class Parcelamento {
    private double valorParcela;
    private int meses;
    private double valorTotal;
    private String loja;
    private String produto;

    public Parcelamento(double valorTotal, int meses, String loja, String produto){
        this.valorTotal = valorTotal;
        this.valorParcela = valorTotal / meses;
        this.meses = meses;
        this.loja = loja;
        this.produto = produto;
    }

    public double getValorParcela(){
        return valorParcela;
    }
    public String getProduto(){return  produto;}
    public String getLoja(){return  loja;}
    public int getMeses(){return meses;}
    public double getValorTotal(){return valorTotal;}

    public void mostrarDetalhes(){
        System.out.printf("==========%s==========\n", produto);
        System.out.printf("Nome: %s              \n", produto);
        System.out.printf("Emissor: %s           \n", loja);
        System.out.printf("Valor da parcela: %d  \n", valorParcela);
        System.out.printf("Qnt. de Meses: %d     \n",  meses);
        System.out.printf("Valor total: %d       \n",  valorTotal);
        System.out.printf("======================\n", produto);
    }
}

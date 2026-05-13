package maquinaDecartao;

public class historicoConta {
    double valorDaCompra;
    String corCartaoUsado;
    String horaDaCompra;
    Parcelamento parcelamento;

    public historicoConta(double valor, String cor, String horaDaCompra, Parcelamento parci){
        this.valorDaCompra = valor;
        this.corCartaoUsado = cor;
        this.horaDaCompra = horaDaCompra;
        if(parci != null){this.parcelamento = parci;}
    }
}
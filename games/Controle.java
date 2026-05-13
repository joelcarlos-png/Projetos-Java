package games;

import java.util.Locale;
import java.util.Scanner;

public class Controle {
    private static final Scanner sc = new Scanner(System.in);

    public static final String RESET  = "\u001B[0m";

    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE  = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";

    public static int lerInteiro(String pergunta){
        System.out.printf("%s", pergunta);
        while (!sc.hasNextInt()){
            sc.nextLine();
            System.out.printf(VERMELHO + "ERRO: " + RESET + AMARELO + "!!DIGITE APENAS DADOS TIPO INTEIRO(INT)!!\n" + RESET);
            System.out.printf("%s", pergunta);
        }
        int x = sc.nextInt();
        sc.nextLine();
        return x;
    }

    public static char lerChar(String pergunta) {
        while (true) {
            System.out.print(pergunta);
            String entrada = sc.nextLine().trim();

            if (entrada.length() == 1) {
                return entrada.charAt(0);
            }

            System.out.println(AMARELO + "ERRO: " + RESET + VERMELHO
                    + "!!DIGITE APENAS DADOS TIPO CARACTERE(CHAR) DE APENAS UM DIGITO!!" + RESET);
        }
    }

    public static String lerString(String pergunta) {
        while (true) {
            System.out.print(pergunta);
            String entrada = sc.nextLine().trim();

            if (!entrada.isEmpty()) {
                return entrada;
            }

            System.out.println(AMARELO + "ERRO: " + RESET + VERMELHO
                    + "!!DIGITE APENAS DADOS TIPO STRING!!" + RESET);
        }
    }

    public static float lerFloat(String pergunta){
        sc.useLocale(Locale.US);
        System.out.printf("%s", pergunta);
        while (!sc.hasNextFloat()){
            sc.nextLine();
            System.out.printf(AMARELO + "ERRO: " + RESET + VERMELHO + "!!DIGITE APENAS DADOS TIPO DECIMAL(FLOAT)!!\n" + RESET);
            System.out.printf("%s", pergunta);
        }
        float x = sc.nextFloat();
        sc.nextLine();
        return x;
    }

    public static double lerDouble(String pergunta){
        sc.useLocale(Locale.US);
        System.out.printf("%s", pergunta);
        while (!sc.hasNextDouble()){
            sc.nextLine();
            System.out.printf(AMARELO + "ERRO: " + RESET + VERMELHO + "!!DIGITE APENAS DADOS TIPO DOUBLE!!\n" + RESET);
            System.out.printf("%s", pergunta);
        }
        double x = sc.nextDouble();
        sc.nextLine();
        return x;
    }

    public static void main(String[] args) {
        int inteiro = lerInteiro("Digite um Numero(int): ");
        char caractere = lerChar("Digite um caractere(char): ");
        String sla = lerString("Digite uma string: ");
        float flutuante = lerFloat("Digite um numero float: ");
        double flutuante2 = lerDouble("Digite um numero double: ");

        System.out.printf(Locale.US, "%d\n%c\n%s\n%.2f\n%.2f", inteiro, caractere, sla, flutuante, flutuante2);
    }
}

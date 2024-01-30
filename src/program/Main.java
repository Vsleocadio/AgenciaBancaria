package program;

import entities.Pessoa;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static ArrayList<Conta> contasBancarias;
     static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        menu();
    }

    public static void menu(){
        System.out.println("----------BEM VINDO AO LEO BANK--------");
        System.out.println("----------SELECIONE UMA OPERAÇÃO--------");
        System.out.println(" | Opção 1 -  Criar conta |");
        System.out.println(" | Opção 2 -  Depositar   |");
        System.out.println(" | Opção 3 -  Sacar       |");
        System.out.println(" | Opção 4 -  Transferir  |");
        System.out.println(" | Opção 5 -  Listar      |");
        System.out.println(" | Opção 6 -  Sair        |");

        int opcao = sc.nextInt();

        switch(opcao){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Obrigado por usar nossa agência!");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                menu();
        }
    }
    public static void criarConta(){
        System.out.println("------- CADASTRO DE CONTA ------");
        System.out.println("Informe seu nome completo: ");
        String nome = sc.nextLine();
        System.out.println("Informe seu CPF: ");
        String cpf = sc.nextLine();
        System.out.println("Informe seu email: ");
        String email = sc.nextLine();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);
        contasBancarias.add(conta);
        System.out.println(nome+ " Sua conta foi criada com sucesso!");
        menu();
    }

    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta c: contasBancarias){
                if(c.getNumeroConta() == numeroConta){
                    conta = c;
                }
            }
        }return conta;
    }

    public static void depositar(){
        System.out.println("Número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Valor a depositar: ");
            Double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("R$" +valorDeposito + " depositado com sucesso!");
        }else {
            System.out.println("Conta não encontrada!");
        }
        menu();

    }

    public static void sacar(){
        System.out.println("Número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null){
            System.out.println("Valor a sacar: ");
            Double valorSaque = sc.nextDouble();
            conta.sacar(valorSaque);
            System.out.println("R$ "+valorSaque+ " sacado com sucesso!");
        }else{
            System.out.println("Conta não encontrada");
        }
        menu();
    }
    public static void transferir(){
        System.out.println("Número da conta do remetente: ");
        int numeroContaRemetente = sc.nextInt();

        Conta contaRemente = encontrarConta(numeroContaRemetente);

        if(contaRemente != null) {
            System.out.println("Número da conta destinatário: ");
            int numeroContaDestinatario = sc.nextInt();

            Conta contaDestinario = encontrarConta(numeroContaDestinatario);
            if(contaDestinario != null){
                System.out.println("Valor a transferir para "+ contaDestinario.getPessoa().getNome() + ":" );
                Double valor = sc.nextDouble();
                contaRemente.transferir(contaDestinario, valor);

            }


        }menu();
    }

    public static void listar(){
        if(contasBancarias.size() > 0 ){
            for(Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        }else{
            System.out.println("Não existe nenhuma conta criada!");

        }
        menu();
    }
}
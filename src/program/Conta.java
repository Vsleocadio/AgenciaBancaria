package program;

import entities.Pessoa;
import utilities.Utils;

public class Conta {

    private static int contadorDeContas = 1;
    private int numeroConta;
    private entities.Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas +=1;
    }

    public static int getContadorDeContas() {
        return contadorDeContas;
    }

    public static void setContadorDeContas(int contadorDeContas) {
        Conta.contadorDeContas = contadorDeContas;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString(){
        return "\nNúmero da conta: " + this.getNumeroConta()+
                "\nNome: " + this.pessoa.getNome()+
                "\nCPF: " + this.pessoa.getCpf()+
                "\nE-mail: " + this.pessoa.getEmail()+
                "\nSaldo: " + Utils.doubleToString(this.getSaldo());
    }

    public void depositar(Double valor){
        if(valor >0) {
            this.setSaldo(getSaldo() + valor);
        }else{
            System.out.println(" R$ "+valor+ " Não foi possivel depositar esse valor!");
        }

    }

    public void sacar(Double valor){
        if(valor >0 && this.getSaldo() >= valor){
            this.setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$ "+ valor + "realizado com sucesso!");
            System.out.println("Seu saldo atual da conta é: " + " R$ " +this.getSaldo());

        }else {
            System.out.println(" R$ "+valor+ " Não foi possivel sacar esse valor!");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valor){
        if(valor >0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("R$ "+ valor+ " transferido com sucesso!");
        }else{
            System.out.println("Não foi possivel realizar a transferência! ");
        }
    }
}

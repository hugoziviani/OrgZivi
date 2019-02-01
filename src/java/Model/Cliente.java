/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hz
 */
public class Cliente {
    private String nome;
    private int idade;
    private String endereco;
    int n_conta;

    public Cliente(String nome, int idade, String endereco, int n_conta){
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.n_conta = n_conta;
    }
    public Cliente() {
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getN_conta() {
        return n_conta;
    }
    public void setN_conta(int n_conta) {
        this.n_conta = n_conta;
    }
    
    
    public void printCliente(){    
        System.out.printf("%s %d %s %d \n",this.getNome(), this.getIdade(), this.getEndereco(), this.getN_conta());
    }
    
    
    
    
}

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
public class Transacao {
    private String idTransacao;
    private int id_conta;
    private float valor;

    public Transacao() {
        this.idTransacao = "";
        this.id_conta = 0;
        this.valor = 0.0f;
    }
    public Transacao(String idTransacao, int id_conta, float valor) {
        this.idTransacao = idTransacao;
        this.id_conta = id_conta;
        this.valor = valor;
    }
    
    public String getIdTransacao() {
        return idTransacao;
    }
    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }
    public int getId_conta() {
        return id_conta;
    }
    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public void printTransacao(){
        System.out.printf("%s %s %d %s %f \n", "Data/Hora/Origem "+this.getIdTransacao()," Conta: ", this.getId_conta()," Valor:", this.getValor());
    }
    
}

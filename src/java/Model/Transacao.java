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
    private int id_conta;
    private String data_hora;
    private float valor;

    public Transacao() {
        this.id_conta = 0;
        this.data_hora = "";
        this.valor = 0.0f;
    }
    public Transacao(int id_conta, String data_hora, float valor) {
        this.id_conta = id_conta;
        this.data_hora = data_hora;
        this.valor = valor;
    }
    public int getId_conta() {
        return id_conta;
    }
    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }
    public String getData_hora() {
        return data_hora;
    }
    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public void printTransacao(){
        System.out.printf("%s %s %d %s %f", "Data: "+this.getData_hora()," Origem:", this.getId_conta()," Valor:", this.getValor());
    }
    
    
}

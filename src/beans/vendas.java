/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.util.Date;


/**
 *
 * @author julia
 */
public class vendas {
 private int id;
    private Date data;
    private String nomeCliente;
    private String nomeProduto;
    private String nomeServico;
    private String funcionario;
    private double valor;
    private String hora;

    public vendas(int id, Date data, String nomeCliente, String nomeProduto, String nomeServico, String funcionario, double valor, String hora) {
        this.id = id;
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        this.nomeServico = nomeServico;
        this.funcionario = funcionario;
        this.valor = valor;
        this.hora = hora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    

    public vendas() {
    }
    

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }
     
}

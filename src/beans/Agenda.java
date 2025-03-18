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
public class Agenda {
    private int id;
    private Date data;
    private String nomeCliente;
    private String hora;
    private String nomeServico;
    private String funcionario;
    private double valor;

    public Agenda() {
    }

    public Agenda(int id, Date data, String nomeCliente, String hora, String nomeServico, String funcionario, double valor) {
        this.id = id;
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.hora = hora;
        this.nomeServico = nomeServico;
        this.funcionario = funcionario;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
     
}

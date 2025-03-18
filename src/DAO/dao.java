/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import beans.Agenda;
import conexao.coon;
import beans.Clientes;
import beans.funcionarios;
import beans.vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
 

/**
 *
 * @author julia
 */
public class dao {

    private coon conexao;
    private Connection conn;

    public dao() {
        this.conexao = new coon();
        this.conn = this.conexao.getConexao();
    }

    public void inserirC(Clientes cliente) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO clientes( nome, telefone, cpf, email, endereco, aniversario, alergia) VALUES "
                + "( ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, sdf.format(cliente.getAniversario()));
            stmt.setString(7, cliente.getAlergia());
            stmt.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Cliente: " + e.getMessage());
        }
    }

    public void inserirA(Agenda agenda) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    if (agenda.getData() == null) {
        JOptionPane.showMessageDialog(null, "Erro: a data está nula!");
        return;
    }

    String sql = "INSERT INTO agenda(dat, nomeCliente, hora, nomeFuncionario, nomeServico, valor) VALUES (?, ?, ?, ?, ?, ?)";
    
    try {
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, sdf.format(agenda.getData()));   
        stmt.setString(2, agenda.getNomeCliente());
        stmt.setString(3, agenda.getHora());  
        stmt.setString(4, agenda.getFuncionario());
        stmt.setString(5, agenda.getNomeServico());
        stmt.setDouble(6, agenda.getValor());
        stmt.execute();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao inserir Agenda: " + e.getMessage());
    }
}

    public void inserirV(vendas venda) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
        String sql = "INSERT INTO vendas(dat, nomeCliente, nomeFuncionario, nomeProduto, nomeServico, valor, hora) VALUES "
                + "( ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, sdf.format(venda.getData()));
            stmt.setString(2, venda.getNomeCliente());
            stmt.setString(3, venda.getFuncionario());
            stmt.setString(4, venda.getNomeProduto());
            stmt.setString(5, venda.getNomeServico());
            stmt.setDouble(6, venda.getValor());
            stmt.setString(7, venda.getHora());
            stmt.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Venda: " + e.getMessage());
        }
    }

    public Clientes getClienteNome(String nome) {
        String sql = "SELECT * FROM clientes WHERE nome LIKE ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Clientes cliente = new Clientes();
            rs.next();

            cliente.setId(rs.getInt("id"));
            cliente.setNome(nome);
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEmail(rs.getString("email"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setAniversario(rs.getDate("aniversario"));
            cliente.setAlergia(rs.getString("alergia"));
            return cliente;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro: " + e.getMessage());
            return null;
        }
    }

    public List<vendas> getVendas(String nome) {
        String sql = "SELECT * FROM vendas WHERE nomeCliente LIKE ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            List<vendas> listaVendas = new ArrayList<>();

            while (rs.next()) {
                vendas venda = new vendas();
                venda.setId(rs.getInt("id"));
                venda.setData(rs.getDate("dat"));
                venda.setNomeCliente(rs.getString("nomeCliente"));
                venda.setNomeProduto(rs.getString("nomeProduto"));
                venda.setNomeServico(rs.getString("nomeServico"));
                venda.setFuncionario(rs.getString("nomeFuncionario"));
                venda.setValor(rs.getDouble("valor"));
                venda.setHora(rs.getString("hora"));
                listaVendas.add(venda);

            }

            return listaVendas;
        } catch (Exception e) {
            return null;
        }

    }

    public List<Agenda> getAgenda() {
        String sql = "SELECT * FROM agenda";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Agenda> listaAgenda = new ArrayList<>();

            while (rs.next()) {
                Agenda agenda = new Agenda();
                agenda.setId(rs.getInt("id"));
                agenda.setData(rs.getDate("dat"));
                agenda.setNomeCliente(rs.getString("nomeCliente"));
                agenda.setNomeServico(rs.getString("nomeServico"));
                agenda.setFuncionario(rs.getString("nomeFuncionario"));
                agenda.setValor(rs.getDouble("valor"));
                agenda.setHora(rs.getString("hora"));
                listaAgenda.add(agenda);

            }

            return listaAgenda;
        } catch (Exception e) {
            return null;
        }

    }
    public List<funcionarios> getFuncionarios() {
        String sql = "SELECT * FROM funcionarios";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<funcionarios> listaF = new ArrayList<>();

            while (rs.next()) {
                funcionarios f = new funcionarios();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                listaF.add(f);

            }

            return listaF;
        } catch (Exception e) {
            return null;
        }

    }
    public boolean clienteExiste(String nomeCliente) {
        String sql = "SELECT 1 FROM clientes WHERE nome = ? LIMIT 1";

        try ( PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, nomeCliente);
            try ( ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            return false;
        }

    }

    public boolean funcionarioExiste(String nomeFuncionario) {
        String sql = "SELECT 1 FROM funcionarios WHERE nome = ? LIMIT 1";

        try ( PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, nomeFuncionario);
            try ( ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            return false;
        }

    }

    public double servicoExiste(String nomeServico) {
        String sql = "SELECT valor FROM servicos WHERE nome = ? LIMIT 1";

        try ( PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, nomeServico);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("valor"); 
                }
            }
        } catch (Exception e) {
           return -1.0;  
        }

        return -1.0;  
    }

    public double produtoExiste(String nomeProduto) {
        String sql = "SELECT valor FROM produtos WHERE nome = ? LIMIT 1";

        try ( PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, nomeProduto);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("valor");  
                }
            }
        } catch (Exception e) {
            return -1.0;
        }

        return -1.0;
    }

}

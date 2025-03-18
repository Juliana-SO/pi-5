/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author julia
 */
public class coon {
      public Connection getConexao() {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/salao",  
                    "root",  
                    "@Juli4321" 
            );
            return conn;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar: " + e.getMessage());
            return null;
        }

    }
}

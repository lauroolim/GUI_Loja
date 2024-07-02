/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import View.TelaCadastro;
import View.TelaLogin;
import View.TelaMenu;
import View.TelaProdutos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author lauro
 */
public class ClienteDAO {
    public void CadastrarCliente(String cpf, String nome, String telefone, String email, String senha) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "INSERT INTO cliente (cpf, nome, telefone, email, senha) VALUES ('"+cpf+"','"+nome+"','"+telefone+"','"+email+"','"+senha+"')";
        System.out.println(sql);
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        conexao.close();
    }
    
    public void login(String email, String senha) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT email, senha FROM cliente WHERE email = '"+email+"' AND senha = '"+senha+"'";
        System.out.println(sql);
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();      
        
        if(rs.next()){
            System.out.println("Possui");
            TelaProdutos produtos = new TelaProdutos(); 
            produtos.setVisible(true);            
            
        } else {            
            System.out.println("Nao Possui");
            JOptionPane.showMessageDialog(null, "Credenciais invalidas");
        }
        conexao.close();
    }
    
    public void compraProduto(String email) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT email, senha FROM cliente WHERE email = '"+email+"'";
        System.out.println(sql);
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        if(rs.next()){
            System.out.println("Possui");
            TelaProdutos produtos = new TelaProdutos(); 
            produtos.setVisible(true);            
            JOptionPane.showMessageDialog(null, "Pedido feito com sucesso");

        } else {            
            System.out.println("Nao Possui");
            JOptionPane.showMessageDialog(null, "Faça o cadastro para completar a compra");
            TelaCadastro cadastro = new TelaCadastro();
            cadastro.setVisible(true);
        }
        conexao.close();
    }
}

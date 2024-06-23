/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import View.TelaCadastro;
import View.TelaLogin;
import model.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import model.ClienteDAO;
/**
 *
 * @author lauro
 */
public class ClienteController {
    public void CadastroCliente(TelaCadastro view) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        ClienteDAO cadastro = new ClienteDAO();
        cadastro.CadastrarCliente(view.getTxtCpf().getText(), view.getTxtNome().getText(), view.getTxtTelefone().getText(), view.getTxtEmail().getText(), view.getTxtSenha().getText());
    }
    
    public void LoginUsuario (TelaLogin view) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        ClienteDAO login = new ClienteDAO();
        login.login(view.getTxtEmailLogin().getText(), view.getTxtSenhaLogin().getText());
    }
}
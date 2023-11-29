/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padaria.DAO;

import com.mycompany.padaria.models.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionariosDAO {

    private static String url = "jdbc:mysql://localhost:3306/padaria";
    //LOGIN BD AMORIM ABAIXO, NÃO APAGAR, 
    //CASO FOR EFETIAR TESTE APENAS COMENTAR AS DUAS LINHAS DE CODIGO E COLOCAR O LGIN DO SEU BD!!!!
    private static String login = "eaamorim_";
    private static String senha = "@Eaamorim5454";
    
    //LOGIN BD MICAEL ABAIXO, NÃO APAGAR!!!!
    //CASO FOR EFETIAR TESTE APENAS COMENTAR AS DUAS LINHAS DE CODIGO E COLOCAR O LGIN DO SEU BD!!!!
    //private static String login = "root";
    //private static String senha = "senha";

    public static boolean salvarFuncionarios(Funcionario funcionario) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);

            comandoSQL = conexao.prepareStatement("INSERT INTO Funcionarios (nomeFuncionario, cpfFuncionario) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            comandoSQL.setString(1, funcionario.getNomeFuncionario());
            comandoSQL.setString(2, funcionario.getCPF());

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                
                retorno = true;
                
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            ex.printStackTrace();
            retorno = false;
            
        } finally {
            
            try {
                
                if (comandoSQL != null) {
                    
                    comandoSQL.close();
                    
                }
                
                if (conexao != null) {
                    
                    conexao.close();
                    
                }
                
            } catch (SQLException ex) {
                
                ex.printStackTrace();
                
            }
            
        }

        return retorno;
        
    }

}

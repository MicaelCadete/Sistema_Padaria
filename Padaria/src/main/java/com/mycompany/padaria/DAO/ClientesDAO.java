/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padaria.DAO;

import com.mycompany.padaria.models.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Classe para a validação do banco de dados do formulário
 *
 * @author enzo.aamorim
 * @since 2023-11-06
 * @version 1.0
 *
 */
public class ClientesDAO {

    private static String url = "jdbc:mysql://localhost:3306/padaria";
    //LOGIN BD AMORIM ABAIXO, NÃO APAGAR, 
    //CASO FOR EFETIAR TESTE APENAS COMENTAR AS DUAS LINHAS DE CODIGO E COLOCAR O LGIN DO SEU BD!!!!
    private static String login = "eaamorim_";
    private static String senha = "@Eaamorim5454";
    
    //LOGIN BD MICAEL ABAIXO, NÃO APAGAR!!!!
    //CASO FOR EFETIAR TESTE APENAS COMENTAR AS DUAS LINHAS DE CODIGO E COLOCAR O LGIN DO SEU BD!!!!
    //private static String login = "root";
    //private static String senha = "senha";

    public static boolean confirmarClientes(Cliente obj) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;

        try {

            //Acessando o banco de dados
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2  - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preprarar o comando SQL
            comandoSQL = conexao.prepareStatement("INSERT INTO Clientes (nomeCliente, cpfCliente, telefoneCliente, emailCliente, sexoCliente, estadoCivilCliente, dataNascimentoCliente, cepCliente, bairroCliente, logradouroCliente, numeroCliente, complementoCliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ", PreparedStatement.RETURN_GENERATED_KEYS);
            comandoSQL.setString(1, obj.getNomeCliente());
            comandoSQL.setString(2, obj.getCpfCliente());
            comandoSQL.setString(3, obj.getTelefoneCliente());
            comandoSQL.setString(4, obj.getEmailCliente());
            comandoSQL.setString(5, obj.getSexoCliente());
            comandoSQL.setString(6, obj.getEcCliente());
            comandoSQL.setString(7, obj.getDnCliente());
            comandoSQL.setString(8, obj.getCepCliente());
            comandoSQL.setString(9, obj.getBairroCliente());
            comandoSQL.setString(10, obj.getLogradouroCliente());
            comandoSQL.setString(11, obj.getNumeroCliente());
            comandoSQL.setString(12, obj.getComplementoCliente());

            //Passo 4 - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                retorno = true;

            }

        } catch (ClassNotFoundException ex) {

            retorno = false;

        } catch (SQLException ex) {

            retorno = false;

        } finally {

            if (conexao != null) {

                try {

                    conexao.close();

                } catch (SQLException ex) {

                    Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);

                }

            }
        }

        return retorno;

    }

    public static ArrayList<Cliente> listarClientes() {

        ArrayList<Cliente> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2  - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preprarar o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT * FROM Clientes");

            //Passo 4 - Executar a consulta
            rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    
                    String nome = rs.getString("nomeCliente");
                    String cpf = rs.getString("cpfCliente");
                    String telefone = rs.getString("telefoneCliente");

                    Cliente item = new Cliente(nome, cpf, telefone);

                    lista.add(item);

                }
            }

        } catch (Exception e) {
            
            lista = null;
            
        } finally {
            
            if (conexao != null) {
                
                try {
                    
                    conexao.close();
                    
                } catch (SQLException ex) {
                    
                    Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
                
                }
            }
        }

        return lista;
    }

    public static boolean alterarClientes(Cliente obj) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;

        try {
            
            //Acessando o banco de dados
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2  - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preprarar o comando SQL
            comandoSQL = conexao.prepareStatement("UPDATE Clientes SET nomeCliente = ?, cpfCliente = ?, telefoneCliente = ?, emailCliente = ?, sexoCliente = ?, estadoCivilCliente = ?, dataNascimentoCliente = ?, cepCliente = ?, bairroCliente = ?, logradouroCliente = ?, numeroCliente = ?, complementoCliente = ?  WHERE nomeCliente = ? ");
            comandoSQL.setString(1, obj.getNomeCliente());
            comandoSQL.setString(2, obj.getCpfCliente());
            comandoSQL.setString(3, obj.getTelefoneCliente());
            comandoSQL.setString(4, obj.getEmailCliente());
            comandoSQL.setString(5, obj.getSexoCliente());
            comandoSQL.setString(6, obj.getEcCliente());
            comandoSQL.setString(7, obj.getDnCliente());
            comandoSQL.setString(8, obj.getCepCliente());
            comandoSQL.setString(9, obj.getBairroCliente());
            comandoSQL.setString(10, obj.getLogradouroCliente());
            comandoSQL.setString(11, obj.getNumeroCliente());
            comandoSQL.setString(12, obj.getComplementoCliente());

            //Passo 4 - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                
                retorno = true;
                
            }
            
        } catch (ClassNotFoundException ex) {
            
            retorno = false;
            
        } catch (SQLException ex) {
            
            retorno = false;
            
        }
        
        return retorno;
        
    }
    
    public static boolean excluir(String nomeExcluir){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        
        try {
            //Receita de bolo para acessar o banco de dados
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            comandoSQL = 
            conexao.prepareStatement("DELETE FROM Clientes WHERE nomeCliente = ?");
            
            comandoSQL.setString(1, nomeExcluir);
            
            //Passo 4 - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas > 0){
                
                retorno = true;
                
            }
            
            
        } catch (ClassNotFoundException ex) {
            
            retorno = false;
            
        } catch (SQLException ex) {
            
            retorno = false;
            
        }

        return retorno;
        
    }

    public static ArrayList<Cliente> buscarPorNome(String nomeCliente) {

        ArrayList<Cliente> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2  - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preprarar o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT * FROM Clientes WHERE nomeCliente = ?");
            comandoSQL.setString(1, nomeCliente);

            //Passo 4 - Executar a consulta
            rs = comandoSQL.executeQuery();

            if (rs != null) {
                
                while (rs.next()) {
                    
                    String nome = rs.getString("nomeCliente");
                    String cpf = rs.getString("cpfCliente");
                    String telefone = rs.getString("telefoneCliente");

                    Cliente item = new Cliente(nome, cpf, telefone);

                    lista.add(item);

                }
            }

        } catch (Exception e) {
            
            lista = null;
            
        } finally {
            
            if (conexao != null) {
                
                try {
                    
                    conexao.close();
                    
                } catch (SQLException ex) {
                    
                    Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
                
                }
            }
        }

        return lista;
        
    }

}

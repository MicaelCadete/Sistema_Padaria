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
 * @author enzo.aamorim
 * @since 2023-11-06
 * @version 1.0
 * 
 */

public class ClienteDAO {

    private static String url = "jdbc:mysql://localhost:3306/padaria";
    private static String login = "eaamorim_";
    private static String senha = "@Eaamorim5454";
    
    public static boolean salvar(Cliente obj) {
        
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
            comandoSQL = conexao.prepareStatement("INSERT INTO Clientes (nomeCliente, cpfCliente, telefoneCliente, emailCliente, sexoCliente, ecCliente, dnCliente, cepCliente, bairroCliente, logradouroCliente, numeroCliente, complementoCliente) VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);
            comandoSQL.setInt(1, Integer.parseInt(obj.getNomeCliente()));
            comandoSQL.setString(2, obj.getCpfCliente());
            comandoSQL.setString(3, obj.getTelefoneCliente());
            comandoSQL.setInt(4, Integer.parseInt(obj.getEmailCliente()));
            comandoSQL.setInt(5, Integer.parseInt(obj.getSexoCliente()));
            comandoSQL.setInt(6, Integer.parseInt(obj.getEcCliente()));
            comandoSQL.setInt(7, Integer.parseInt(obj.getDnCliente()));
            comandoSQL.setInt(8, obj.getCepCliente());
            comandoSQL.setInt(9, Integer.parseInt(obj.getBairroCliente()));
            comandoSQL.setInt(10, Integer.parseInt(obj.getLogradouroCliente()));
            comandoSQL.setInt(11, obj.getNumeroCliente());
            comandoSQL.setInt(12, Integer.parseInt(obj.getComplementoCliente()));

            //Passo 4 - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet rs = comandoSQL.getGeneratedKeys();
                if (rs != null) {
                    while (rs.next()) {
                        int idGerado = rs.getInt(1);
                        obj.setIdCliente(idGerado);
                    }
                }

            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        }
        return retorno;
    }

    public static ArrayList<Cliente> listar() {

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
                    int id = rs.getInt("IdCliente");
                    String nome = rs.getString("nomeCliente");
                    String cpf = rs.getString("cpfCliente");
                    String telefone = rs.getString("telefoneCliente");
                    String email = rs.getString("emailCliente");
                    String sexo = rs.getString("sexoCliente");
                    String ec = rs.getString("ecCliente");
                    String dn = rs.getString("dnCliente");
                    int cep = rs.getInt("cepCliente");
                    String bairro = rs.getString("bairroCliente");
                    String logradouro = rs.getString("logradouroCliente");
                    int numero = rs.getInt("numeroCliente");
                    String complemento = rs.getString("complementoCliente");

                    Cliente item = new Cliente(id, nome, cpf, telefone, email, sexo, ec, dn, cep, bairro, logradouro, numero, complemento);

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
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return lista;
    }

    public static boolean alterar(Cliente obj) {
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
            comandoSQL = conexao.prepareStatement("UPDATE NotaFiscal SET nomeCliente = ?, cpfCliente = ?, telefoneCliente = ?, emailCliente = ?, sexoCliente = ?, bairroCliente = ?, logradouroCliente = ?, numeroCliente = ?, complementoCliente = ?  WHERE idCliente = ? ");
            comandoSQL.setString(1, obj.getNomeCliente());
            comandoSQL.setString(2, obj.getCpfCliente());
            comandoSQL.setString(3, obj.getTelefoneCliente());
            comandoSQL.setString(4, obj.getEmailCliente());
            comandoSQL.setString(5, obj.getSexoCliente());
            comandoSQL.setString(6, obj.getEcCliente());
            comandoSQL.setString(7, obj.getDnCliente());
            comandoSQL.setInt(8, obj.getCepCliente());
            comandoSQL.setString(9, obj.getBairroCliente());
            comandoSQL.setString(10, obj.getLogradouroCliente());
            comandoSQL.setInt(11, obj.getNumeroCliente());
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
    
    public static ArrayList<Cliente> buscarPorNumero(int numeroNota) {

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
            comandoSQL = conexao.prepareStatement("SELECT * FROM Clientes WHERE numeroNota = ?");
            comandoSQL.setInt(1, numeroNota);

            //Passo 4 - Executar a consulta
            rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("IdCliente");
                    String nome = rs.getString("nomeCliente");
                    String cpf = rs.getString("cpfCliente");
                    String telefone = rs.getString("telefoneCliente");
                    String email = rs.getString("emailCliente");
                    String sexo = rs.getString("sexoCliente");
                    String ec = rs.getString("ecCliente");
                    String dn = rs.getString("dnCliente");
                    int cep = rs.getInt("cepCliente");
                    String bairro = rs.getString("bairroCliente");
                    String logradouro = rs.getString("logradouroCliente");
                    int numero = rs.getInt("numeroCliente");
                    String complemento = rs.getString("complementoCliente");

                    Cliente item = new Cliente(id, nome, cpf, telefone, email, sexo, ec, dn, cep, bairro, logradouro, numero, complemento);

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
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return lista;
    }

}

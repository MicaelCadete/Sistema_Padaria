/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padaria.DAO;

import com.mycompany.padaria.models.Padaria;
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
 * @author ftfer
 */
public class PadariaDAO {

    private static String url = "jdbc:mysql://localhost:3306/padaria";
    private static String login = "eaamorim_";
    private static String senha = "@Eaamorim5454";

    public static boolean salvar(Padaria obj) {
        
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
            comandoSQL.setInt(2, obj.getCpfCliente());
            comandoSQL.setInt(3, obj.getTelefoneCliente());
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

    public static ArrayList<Padaria> listar() {

        ArrayList<Padaria> lista = new ArrayList<>();
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
                    int nome = Integer.parseInt(rs.getString("nomeCliente"));
                    int cpf = rs.getInt("cpfCliente");
                    int telefone = rs.getInt("telefoneCliente");
                    int email = Integer.parseInt(rs.getString("emailCliente"));
                    int sexo = Integer.parseInt(rs.getString("sexoCliente"));
                    int ec = Integer.parseInt(rs.getString("ecCliente"));
                    int dn = Integer.parseInt(rs.getString("dnCliente"));
                    int cep = rs.getInt("cepCliente");
                    int bairro = Integer.parseInt(rs.getString("bairroCliente"));
                    int logradouro = Integer.parseInt(rs.getString("logradouroCliente"));
                    int numero = rs.getInt("numeroCliente");
                    int complemento = Integer.parseInt(rs.getString("complementoCliente"));

                    Padaria item = new Padaria(id, nome, cpf, telefone, email, sexo, ec, dn, cep, bairro, logradouro, numero, complemento);

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
                    Logger.getLogger(PadariaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return lista;
    }

    public static boolean alterar(Padaria obj) {
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
            comandoSQL = conexao.prepareStatement("UPDATE NotaFiscal SET numeroNota = ?, valorNota = ?  WHERE idNota = ? ");
            comandoSQL.setInt(1, obj.getNumeroNota());
            comandoSQL.setDouble(2, obj.getValorNota());
            comandoSQL.setInt(3, obj.getIdNota());

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
    
    public static ArrayList<Padaria> buscarPorNumero(int numeroNota) {

        ArrayList<Padaria> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2  - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preprarar o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT * FROM NotaFiscal WHERE numeroNota = ?");
            comandoSQL.setInt(1, numeroNota);

            //Passo 4 - Executar a consulta
            rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("IdNota");
                    int numero = rs.getInt("numeroNota");
                    double valor = rs.getDouble("valorNota");

                    Padaria item = new Padaria(id, numero, valor);

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
                    Logger.getLogger(PadariaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return lista;
    }

}

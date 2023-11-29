/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padaria.DAO;

import com.mycompany.padaria.models.Cliente;
import com.mycompany.padaria.models.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    private static String url = "jdbc:mysql://localhost:3306/padaria";
    //LOGIN BD AMORIM ABAIXO, NÃO APAGAR, 
    //CASO FOR EFETIAR TESTE APENAS COMENTAR AS DUAS LINHAS DE CODIGO E COLOCAR O LGIN DO SEU BD!!!!
    private static String login = "eaamorim_";
    private static String senha = "@Eaamorim5454";
    
    //LOGIN BD MICAEL ABAIXO, NÃO APAGAR!!!!
    //CASO FOR EFETIAR TESTE APENAS COMENTAR AS DUAS LINHAS DE CODIGO E COLOCAR O LGIN DO SEU BD!!!!
    //private static String login = "root";
    //private static String senha = "senha";
    
    public static boolean CadastrarProduto(Produto obj) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);

            comandoSQL = conexao.prepareStatement("INSERT INTO produtos (nomeProduto, quantidadeProduto, valorProduto) VALUES (?,?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);
            comandoSQL.setString(1, obj.getNomeProduto());
            comandoSQL.setInt(2, obj.getQuantidadeProduto());
            comandoSQL.setDouble(3, obj.getValorProduto());

            int linhasAlteradas = comandoSQL.executeUpdate();
            if (linhasAlteradas > 0) {
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
                    Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retorno;
    }

    public static ArrayList<Produto> listarProdutos() {
        ArrayList<Produto> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);
            comandoSQL = conexao.prepareStatement("SELECT * FROM produtos");
            rs = comandoSQL.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String nomeProduto = rs.getString("nomeProduto");
                    int quantidadeProduto = rs.getInt("quantidadeProduto");
                    double valorProduto = rs.getDouble("valorProduto");
                    int idProduto = rs.getInt("idProduto");

                    Produto item = new Produto(idProduto, nomeProduto, quantidadeProduto, valorProduto);
                    lista.add(item);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            lista = null;
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    public static boolean alterarProdutos(Produto obj) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, senha);
            
            comandoSQL = conexao.prepareStatement("update Produtos set nomeProduto = ?, quantidadeProduto = ?, valorProduto = ? where idProduto = ?");
            
            comandoSQL.setString(1, obj.getNomeProduto());
            
            String nn = obj.getNomeProduto();
            
            comandoSQL.setInt(2, obj.getQuantidadeProduto());
            
            int qtd = obj.getQuantidadeProduto();
            
            comandoSQL.setDouble(3, obj.getValorProduto());
            
            double v = obj.getValorProduto();
            
            int teste = obj.getIdProduto();
            
            comandoSQL.setInt(4, obj.getIdProduto());

            int linhas = comandoSQL.executeUpdate();
            if (linhas > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            retorno = false;
        }
         return retorno;
    }

    public static boolean excluir(String nomeExcluir){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);
            comandoSQL = conexao.prepareStatement("DELETE FROM produtos WHERE nomeProduto = ?");
            comandoSQL.setString(1, nomeExcluir);
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {

            retorno = false;

        } catch (Exception e) {
            retorno = false;
        }
        return retorno;
    }

    public static ArrayList<Produto> buscarPorNome(String nomeProduto) {

        ArrayList<Produto> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);
            comandoSQL = conexao.prepareStatement("SELECT * FROM produtos WHERE nomeProduto = ?");
            comandoSQL.setString(1, nomeProduto);
            rs = comandoSQL.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String nome = rs.getString("nomeProduto");
                    int quantidadeProduto = rs.getInt("quantidadeProduto");
                    double valorProduto = rs.getDouble("valorProduto");

                    Produto item = new Produto(nome, quantidadeProduto, valorProduto);

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

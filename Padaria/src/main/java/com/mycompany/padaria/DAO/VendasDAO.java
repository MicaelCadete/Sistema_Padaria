/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padaria.DAO;

import com.mycompany.padaria.models.Vendas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author アモリム
 */
public class VendasDAO {

    private static String url = "jdbc:mysql://localhost:3306/padaria";
    //LOGIN BD AMORIM ABAIXO, NÃO APAGAR, 
    //CASO FOR EFETIAR TESTE APENAS COMENTAR AS DUAS LINHAS DE CODIGO E COLOCAR O LGIN DO SEU BD!!!!
    private static String login = "eaamorim_";
    private static String senha = "@Eaamorim5454";

    //LOGIN BD MICAEL ABAIXO, NÃO APAGAR!!!!
    //CASO FOR EFETIAR TESTE APENAS COMENTAR AS DUAS LINHAS DE CODIGO E COLOCAR O LGIN DO SEU BD!!!!
    //private static String login = "root";
    //private static String senha = "P@$$w0rd";

    public static boolean NovaVenda(Vendas obj) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);

            //comandoSQL = conexao.prepareStatement("UPDATE Vendas6 set idProduto = ?, nomeProduto = ?, valorProduto = ?, quantidadeProduto = ?, precoTotalVendas = ?,  cpfFuncionario = ?, cpfCliente = ? where idVenda = ?", PreparedStatement.RETURN_GENERATED_KEYS);
            comandoSQL = conexao.prepareStatement("INSERT INTO Vendas7 (idProduto, nomeProduto, valorProduto, quantidadeProduto, precoTotalVendas,  cpfFuncionario, cpfCliente) VALUES (?,?,?,?,?,?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);
            comandoSQL.setInt(1, obj.getIdProduto());
            comandoSQL.setString(2, obj.getNomeProduto());
            comandoSQL.setDouble(3, obj.getValorProduto());
            comandoSQL.setInt(4, obj.getQuantidadeProduto());
            comandoSQL.setDouble(5, obj.getPrecoTotalVendas());
            comandoSQL.setString(6, obj.getCPFFuncionario());
            comandoSQL.setString(7, obj.getCPFCliente());
            //comandoSQL.setInt(8, obj.getIdVenda());

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

    public static boolean alterarProdutos(Vendas obj) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);

            comandoSQL = conexao.prepareStatement("update Vendas7 set nomeProduto = ?, quantidadeProduto = ?, valorProduto = ?, precoTotalVendas = ?,  cpfFuncionario = ?, cpfCliente = ? where idVenda = ?");
            comandoSQL.setString(1, obj.getNomeProduto());
            comandoSQL.setInt(2, obj.getQuantidadeProduto());
            comandoSQL.setDouble(3, obj.getValorProduto());
            comandoSQL.setDouble(4, obj.getPrecoTotalVendas());
            comandoSQL.setString(5, obj.getCPFFuncionario());
            comandoSQL.setString(6, obj.getCPFCliente());
            comandoSQL.setInt(7, obj.getIdVenda());

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

    public static boolean excluir(int id) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);
            comandoSQL = conexao.prepareStatement("DELETE FROM Vendas7 WHERE idVenda = ?");
            comandoSQL.setInt(1, id);
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

    public static ArrayList<Vendas> listar() {
        ArrayList<Vendas> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);
            comandoSQL = conexao.prepareStatement("SELECT * FROM vendas7");
            rs = comandoSQL.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    // id cpfc data valor
                    String CPFC = rs.getString("CPFCliente");
                    Date data = rs.getDate("dataVenda");
                    double valor = rs.getDouble("precoTotalVendas");
                    int idVenda = rs.getInt("idVenda");

                    Vendas item = new Vendas(idVenda, valor, data, CPFC);
                    lista.add(item);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            lista = null;
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    public static ArrayList<Vendas> BuscaData(String inicio, String fim) {
        ArrayList<Vendas> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);

            String sqlQuery = "SELECT * FROM vendas7 WHERE dataVenda >= ? AND dataVenda <= ?";
            comandoSQL = conexao.prepareStatement(sqlQuery);

            java.util.Date inicioFormatado = new SimpleDateFormat("dd/MM/yyyy").parse(inicio);
            java.util.Date fimFormatado = new SimpleDateFormat("dd/MM/yyyy").parse(fim);

            java.sql.Date sqlDateInicio = new java.sql.Date(inicioFormatado.getTime());
            java.sql.Date sqlDateFim = new java.sql.Date(fimFormatado.getTime());

            comandoSQL.setDate(1, sqlDateInicio);
            comandoSQL.setDate(2, sqlDateFim);

            rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    String CPFC = rs.getString("CPFCliente");
                    //Date data = rs.getDate("dataVenda");

                    java.util.Date dataFormatada = rs.getDate("dataVenda");
                    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                    String dataVendaStr = formatador.format(dataFormatada);

                    double valor = rs.getDouble("precoTotalVendas");

                    Vendas item = new Vendas(valor, dataVendaStr, CPFC);
                    lista.add(item);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException e) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    public static ArrayList<Vendas> listarProdutosVenda() {
        ArrayList<Vendas> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);
            comandoSQL = conexao.prepareStatement("SELECT nomeProduto, quantidadeProduto,valorProduto FROM Vendas7");
            rs = comandoSQL.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String nomeProduto = rs.getString("nomeProduto");
                    int quantidadeProduto = rs.getInt("quantidadeProduto");
                    double valorProduto = rs.getDouble("valorProduto");

                    Vendas item = new Vendas(nomeProduto, quantidadeProduto, valorProduto);
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

}

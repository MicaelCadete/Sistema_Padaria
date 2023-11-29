/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padaria.models;

import java.sql.Date;

/**
 *
 * @author enzo.aamorim
 */
public class Vendas {

    private int idVenda;
    private int idProduto;
    private String nomeProduto;
    private double valorProduto;
    private int quantidadeProduto;
    private double precoTotalVendas;
    private String dataVenda;
    private Date data;
    private Date inicio;
    private Date fim;
    private String CPFFuncionario;
    private String CPFCliente;
    private String dInicio;
    private String dFim;

    public Vendas(int idProduto1, String nomeProduto1, double valorUnitario, int quantidadeProduto1, double valorTotal, String CPFF, String CPFC) {
    }

    public Vendas(String nomeProduto, int quantidadeProduto, double valorProduto) {
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorProduto = valorProduto;
    }

    public Vendas(double precoTotalVendas, Date data, String CPFCliente) {
        this.precoTotalVendas = precoTotalVendas;
        this.data = data;
        this.CPFCliente = CPFCliente;
    }

    public Vendas(int idVenda, int idProduto, String nomeProduto, double valorProduto, int quantidadeProduto, double precoTotalVendas, String dataVenda) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.precoTotalVendas = precoTotalVendas;
        this.dataVenda = dataVenda;
    }

    public Vendas(double precoTotalVendas, String dataVenda, String CPFCliente) {
        this.precoTotalVendas = precoTotalVendas;
        this.dataVenda = dataVenda;
        this.CPFCliente = CPFCliente;
    }
    
    
    
    public Vendas(Date inicio, Date fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public Vendas(int idProduto, String nomeProduto, double valorProduto, int quantidadeProduto, double precoTotalVendas) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.precoTotalVendas = precoTotalVendas;
    }

    public Vendas(int idProduto, String nomeProduto, double valorProduto, int quantidadeProduto, double precoTotalVendas, String dataVenda, String CPFFuncionario, String CPFCliente) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.precoTotalVendas = precoTotalVendas;
        this.dataVenda = dataVenda;
        this.CPFFuncionario = CPFFuncionario;
        this.CPFCliente = CPFCliente;
    }

    public Vendas(int idVenda, double precoTotalVendas, Date data, String CPFCliente) {
        this.idVenda = idVenda;
        this.precoTotalVendas = precoTotalVendas;
        this.data = data;
        this.CPFCliente = CPFCliente;
    }

    public Vendas() {
    }
    
    

    public Vendas(String dInicio, String dFim) {
        this.dInicio = dInicio;
        this.dFim = dFim;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public String getdInicio() {
        return dInicio;
    }

    public void setdInicio(String dInicio) {
        this.dInicio = dInicio;
    }

    public String getdFim() {
        return dFim;
    }

    public void setdFim(String dFim) {
        this.dFim = dFim;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getPrecoTotalVendas() {
        return precoTotalVendas;
    }

    public void setPrecoTotalVendas(double precoTotalVendas) {
        this.precoTotalVendas = precoTotalVendas;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getCPFFuncionario() {
        return CPFFuncionario;
    }

    public void setCPFFuncionario(String CPFFuncionario) {
        this.CPFFuncionario = CPFFuncionario;
    }

    public String getCPFCliente() {
        return CPFCliente;
    }

    public void setCPFCliente(String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }

}

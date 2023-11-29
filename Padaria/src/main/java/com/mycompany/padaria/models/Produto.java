/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padaria.models;

/**
 *
 * @author enzo.aamorim
 */
public class Produto {
    private int idProduto;
    private String nomeProduto;
    private int quantidadeProduto;
    private double valorProduto;

    public Produto() {
    }

    public Produto(int idProduto, String nomeProduto, int quantidadeProduto, double valorProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorProduto = valorProduto;
    }

    public Produto(String nomeProduto, int quantidadeProduto, double valorProduto) {
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorProduto = valorProduto;
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

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
    
    
    
}

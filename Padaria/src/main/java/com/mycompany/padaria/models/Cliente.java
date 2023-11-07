/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padaria.models;

/**
 *
 * @author ftfer
 */
public class Cliente {
    
    private int idCliente;
    private String nomeCliente;
    private String cpfCliente;
    private String telefoneCliente;
    private String emailCliente;
    private String sexoCliente;
    private String ecCliente;
    private String dnCliente;
    private int cepCliente;
    private String bairroCliente;
    private String logradouroCliente;
    private int numeroCliente;
    private String complementoCliente;

    public Cliente() {
    }

    public Cliente(int idCliente, String nomeCliente, String cpfCliente, String telefoneCliente, String emailCliente, String sexoCliente, String ecCliente, String dnCliente, int cepCliente, String bairroCliente, String logradouroCliente, int numeroCliente, String complementoCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
        this.sexoCliente = sexoCliente;
        this.ecCliente = ecCliente;
        this.dnCliente = dnCliente;
        this.cepCliente = cepCliente;
        this.bairroCliente = bairroCliente;
        this.logradouroCliente = logradouroCliente;
        this.numeroCliente = numeroCliente;
        this.complementoCliente = complementoCliente;
    }

    public Cliente(int idCliente, String nomeCliente, String cpfCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
    }

    public Cliente(String nomeCliente, String cpfCliente, String telefoneCliente, String emailCliente, String sexoCliente, String ecCliente, String dnCliente, int cepCliente, String bairroCliente, String logradouroCliente, int numeroCliente, String complementoCliente) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
        this.sexoCliente = sexoCliente;
        this.ecCliente = ecCliente;
        this.dnCliente = dnCliente;
        this.cepCliente = cepCliente;
        this.bairroCliente = bairroCliente;
        this.logradouroCliente = logradouroCliente;
        this.numeroCliente = numeroCliente;
        this.complementoCliente = complementoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSexoCliente() {
        return sexoCliente;
    }

    public void setSexoCliente(String sexoCliente) {
        this.sexoCliente = sexoCliente;
    }

    public String getEcCliente() {
        return ecCliente;
    }

    public void setEcCliente(String ecCliente) {
        this.ecCliente = ecCliente;
    }

    public String getDnCliente() {
        return dnCliente;
    }

    public void setDnCliente(String dnCliente) {
        this.dnCliente = dnCliente;
    }

    public int getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(int cepCliente) {
        this.cepCliente = cepCliente;
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        this.bairroCliente = bairroCliente;
    }

    public String getLogradouroCliente() {
        return logradouroCliente;
    }

    public void setLogradouroCliente(String logradouroCliente) {
        this.logradouroCliente = logradouroCliente;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getComplementoCliente() {
        return complementoCliente;
    }

    public void setComplementoCliente(String complementoCliente) {
        this.complementoCliente = complementoCliente;
    }
    
    

}

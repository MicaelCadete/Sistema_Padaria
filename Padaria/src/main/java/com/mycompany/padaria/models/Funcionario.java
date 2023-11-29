/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padaria.models;

/**
 *
 * @author wwwfi
 */
public class Funcionario {

    private String CPF;
    private String nomeFuncionario;

    
    public Funcionario(){
        
    }
    
    
    public Funcionario(String nomeFuncionario, String CPF) {
        this.CPF = CPF;
        this.nomeFuncionario = nomeFuncionario;

    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
}

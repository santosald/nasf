/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geral;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class Medico implements Serializable {
    String nome;
    int senha;
    List<Prontuario> prontuarios = new ArrayList<Prontuario>();
    List<Paciente> pacientes = new ArrayList<Paciente>();
    List<Eventos> eventos = new ArrayList<Eventos>();
    
    public Medico(String nome, int senha){
        this.nome = nome;
        this.senha = senha;
    }

    public List<Eventos> getEventos() {
        return eventos;
    }

    public void setEventos(List<Eventos> eventos) {
        this.eventos = eventos;
    }
    
    public void adicionarPaciente(Paciente paciente){
        this.pacientes.add(paciente);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public List<Prontuario> getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(List<Prontuario> prontuarios) {
        this.prontuarios = prontuarios;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    
}

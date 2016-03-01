package com.medicfast.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer     id;
    
    @Column
    private String    nome;
    
    @Column
    private String usuario;
    
    @Column
    private String   senha;

    
    //Get Set Id
    public void setId(Integer id) { this.id = id; }
    public Integer getId() { return id; }
    
    //Get Set Nome
    public String getNome() { return nome; }
    public void setNome(String nome) {this.nome = nome;}
    
    //Get Set Usuario
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getUsuario() { return usuario; }
    
    //Get Set Senha
    public void setSenha(String senha) { this.senha = senha; }
    public String getSenha() { return senha; }
    
}

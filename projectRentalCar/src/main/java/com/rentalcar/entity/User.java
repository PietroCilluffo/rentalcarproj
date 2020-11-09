package com.rentalcar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")


public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 private int id;
 
 @Column(name = "nome")
 private String nome;
 
 @Column(name = "cognome")
 private String cognome;
 
 @Column(name = "email")
 private String email;
 
 //buona pratica scrivere un costruttore vuoto
 public User() {
	 
 }
 
 public User(String nome, String cognome, String email) {
	 this.nome = nome;
	 this.cognome = cognome;
	 this.email = email;
	 
 }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCognome() {
	return cognome;
}

public void setCognome(String cognome) {
	this.cognome = cognome;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
 
}
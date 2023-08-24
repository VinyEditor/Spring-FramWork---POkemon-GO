package com.seunome.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    // Outros atributos e relacionamentos
    
    // Getters e setters
}

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipo;
    // Outros atributos e relacionamentos
    
    // Getters e setters
}

@Entity
public class CompanheiroPokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Pokemon pokemon;
    private int nivelCombate;
    // Outros atributos e relacionamentos
    
    // Getters e setters
}

@Entity
public class EventoCalendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Date data;
    // Outros atributos
    
    // Getters e setters
}


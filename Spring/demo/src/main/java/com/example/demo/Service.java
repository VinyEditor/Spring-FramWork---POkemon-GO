package com.seunome.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seunome.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    // Implemente métodos de lógica de negócios e interação com o repositório
}

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;
    
    // Implemente métodos de lógica de negócios e interação com o repositório
}

@Service
public class CompanheiroPokemonService {
    @Autowired
    private CompanheiroPokemonRepository companheiroPokemonRepository;
    
    // Implemente métodos de lógica de negócios e interação com o repositório
}

@Service
public class EventoCalendarioService {
    @Autowired
    private EventoCalendarioRepository eventoCalendarioRepository;
    
    // Implemente métodos de lógica de negócios e interação com o repositório
}

package com.seunome.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.seunome.projeto.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    // Implemente endpoints para manipular usuários
}

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;
    
    // Implemente endpoints para manipular Pokémons
}

@RestController
@RequestMapping("/companheiros")
public class CompanheiroPokemonController {
    @Autowired
    private CompanheiroPokemonService companheiroPokemonService;
    
    // Implemente endpoints para manipular companheiros Pokémon
}

@RestController
@RequestMapping("/eventos")
public class EventoCalendarioController {
    @Autowired
    private EventoCalendarioService eventoCalendarioService;
    
    // Implemente endpoints para manipular eventos do calendário
}

package com.seunome.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seunome.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
   public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setUsername(usuario.getUsername());
            usuarioExistente.setPassword(usuario.getPassword());
            usuarioExistente.setEmail(usuario.getEmail());
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }

    public boolean excluirUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

     public Pokemon atualizarPokemon(Long id, Pokemon pokemon) {
        Pokemon pokemonExistente = pokemonRepository.findById(id).orElse(null);
        if (pokemonExistente != null) {
            pokemonExistente.setNome(pokemon.getNome());
            pokemonExistente.setTipo(pokemon.getTipo());
            pokemonExistente.setNivel(pokemon.getNivel());
            return pokemonRepository.save(pokemonExistente);
        }
        return null;
    }

    public boolean excluirPokemon(Long id) {
        if (pokemonRepository.existsById(id)) {
            pokemonRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

@Service
public class CompanheiroPokemonService {
    @Autowired
    private CompanheiroPokemonRepository companheiroPokemonRepository;

    public CompanheiroPokemon atualizarCompanheiroPokemon(Long id, CompanheiroPokemon companheiroPokemon) {
        CompanheiroPokemon companheiroExistente = companheiroPokemonRepository.findById(id).orElse(null);
        if (companheiroExistente != null) {
            companheiroExistente.setPokemon(companheiroPokemon.getPokemon());
            companheiroExistente.setNivelCombate(companheiroPokemon.getNivelCombate());
            companheiroExistente.setDataCaptura(companheiroPokemon.getDataCaptura());
            return companheiroPokemonRepository.save(companheiroExistente);
        }
        return null;
    }

    public boolean excluirCompanheiroPokemon(Long id) {
        if (companheiroPokemonRepository.existsById(id)) {
            companheiroPokemonRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

@Service
public class EventoCalendarioService {
    @Autowired
    private EventoCalendarioRepository eventoCalendarioRepository;

     public EventoCalendario atualizarEventoCalendario(Long id, EventoCalendario eventoCalendario) {
        EventoCalendario eventoExistente = eventoCalendarioRepository.findById(id).orElse(null);
        if (eventoExistente != null) {
            eventoExistente.setTitulo(eventoCalendario.getTitulo());
            eventoExistente.setData(eventoCalendario.getData());
            eventoExistente.setLocal(eventoCalendario.getLocal());
            return eventoCalendarioRepository.save(eventoExistente);
        }
        return null;
    }

    public boolean excluirEventoCalendario(Long id) {
        if (eventoCalendarioRepository.existsById(id)) {
            eventoCalendarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

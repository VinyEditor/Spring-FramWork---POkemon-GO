package com.seunome.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seunome.projeto.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos de consulta personalizados (se necessário)
}

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    // Métodos de consulta personalizados (se necessário)
}

@Repository
public interface CompanheiroPokemonRepository extends JpaRepository<CompanheiroPokemon, Long> {
    // Métodos de consulta personalizados (se necessário)
}

@Repository
public interface EventoCalendarioRepository extends JpaRepository<EventoCalendario, Long> {
    // Métodos de consulta personalizados (se necessário)
}

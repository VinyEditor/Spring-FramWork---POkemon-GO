package com.seunome.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seunome.projeto.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}

@Repository
public interface CompanheiroPokemonRepository extends JpaRepository<CompanheiroPokemon, Long> {
}

@Repository
public interface EventoCalendarioRepository extends JpaRepository<EventoCalendario, Long> {
}

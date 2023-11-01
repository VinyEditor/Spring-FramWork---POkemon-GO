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

    @PostMapping("/usuarios")
public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
    // Se a validação passar, o objeto "usuario" será válido
    // Faça o processamento necessário e retorne a resposta apropriada
}
    
@GetMapping
    public ResponseEntity<Page<Usuario>> listarUsuarios(@RequestParam(defaultValue = "0") int pagina,
                                                       @RequestParam(defaultValue = "10") int tamanhoPagina) {
        Page<Usuario> usuarios = usuarioService.listarUsuarios(pagina, tamanhoPagina);
        return ResponseEntity.ok(usuarios);
    }
}

   @Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
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

    @RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
        if (usuarioAtualizado != null) {
            return ResponseEntity.ok(usuarioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        if (usuarioService.excluirUsuario(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

}

}

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;
    
   @Service
public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> listarPokemons() {
        return pokemonRepository.findAll();
    }

    public Pokemon buscarPokemonPorId(Long id) {
        return pokemonRepository.findById(id).orElse(null);
    }

    public Pokemon criarPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon atualizarPokemon(Long id, Pokemon pokemon) {
        Pokemon pokemonExistente = pokemonRepository.findById(id).orElse(null);
        if (pokemonExistente != null) {
            pokemon.setId(id);
            return pokemonRepository.save(pokemon);
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

    @RestController
@RequestMapping("/pokemons")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> listarPokemons() {
        return pokemonService.listarPokemons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> buscarPokemonPorId(@PathVariable Long id) {
        Pokemon pokemon = pokemonService.buscarPokemonPorId(id);
        if (pokemon != null) {
            return ResponseEntity.ok(pokemon);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Pokemon> criarPokemon(@RequestBody Pokemon pokemon) {
        Pokemon novoPokemon = pokemonService.criarPokemon(pokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPokemon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> atualizarPokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        Pokemon pokemonAtualizado = pokemonService.atualizarPokemon(id, pokemon);
        if (pokemonAtualizado != null) {
            return ResponseEntity.ok(pokemonAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPokemon(@PathVariable Long id) {
        if (pokemonService.excluirPokemon(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<Page<Pokemon>> listarPokemons(@RequestParam(defaultValue = "0") int pagina,
                                                        @RequestParam(defaultValue = "10") int tamanhoPagina) {
        Page<Pokemon> pokemons = pokemonService.listarPokemons(pagina, tamanhoPagina);
        return ResponseEntity.ok(pokemons);
    }
}

@RestController
@RequestMapping("/companheiros")
public class CompanheiroPokemonController {
    @Autowired
    private CompanheiroPokemonService companheiroPokemonService;
    
   @Service
public class CompanheiroPokemonService {
    @Autowired
    private CompanheiroPokemonRepository companheiroPokemonRepository;

    public List<CompanheiroPokemon> listarCompanheirosPokemon() {
        return companheiroPokemonRepository.findAll();
    }

    public CompanheiroPokemon buscarCompanheiroPokemonPorId(Long id) {
        return companheiroPokemonRepository.findById(id).orElse(null);
    }

    public CompanheiroPokemon criarCompanheiroPokemon(CompanheiroPokemon companheiroPokemon) {
        return companheiroPokemonRepository.save(companheiroPokemon);
    }

    public CompanheiroPokemon atualizarCompanheiroPokemon(Long id, CompanheiroPokemon companheiroPokemon) {
        CompanheiroPokemon companheiroExistente = companheiroPokemonRepository.findById(id).orElse(null);
        if (companheiroExistente != null) {
            companheiroPokemon.setId(id);
            return companheiroPokemonRepository.save(companheiroPokemon);
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

    @RestController
@RequestMapping("/companheiros")
public class CompanheiroPokemonController {
    @Autowired
    private CompanheiroPokemonService companheiroPokemonService;

    @GetMapping
    public List<CompanheiroPokemon> listarCompanheirosPokemon() {
        return companheiroPokemonService.listarCompanheirosPokemon();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanheiroPokemon> buscarCompanheiroPokemonPorId(@PathVariable Long id) {
        CompanheiroPokemon companheiro = companheiroPokemonService.buscarCompanheiroPokemonPorId(id);
        if (companheiro != null) {
            return ResponseEntity.ok(companheiro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CompanheiroPokemon> criarCompanheiroPokemon(@RequestBody CompanheiroPokemon companheiroPokemon) {
        CompanheiroPokemon novoCompanheiro = companheiroPokemonService.criarCompanheiroPokemon(companheiroPokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCompanheiro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanheiroPokemon> atualizarCompanheiroPokemon(@PathVariable Long id, @RequestBody CompanheiroPokemon companheiroPokemon) {
        CompanheiroPokemon companheiroAtualizado = companheiroPokemonService.atualizarCompanheiroPokemon(id, companheiroPokemon);
        if (companheiroAtualizado != null) {
            return ResponseEntity.ok(companheiroAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCompanheiroPokemon(@PathVariable Long id) {
        if (companheiroPokemonService.excluirCompanheiroPokemon(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @GetMapping
    public ResponseEntity<Page<CompanheiroPokemon>> listarCompanheirosPokemon(@RequestParam(defaultValue = "0") int pagina,
                                                                              @RequestParam(defaultValue = "10") int tamanhoPagina) {
        Page<CompanheiroPokemon> companheiros = companheiroPokemonService.listarCompanheirosPokemon(pagina, tamanhoPagina);
        return ResponseEntity.ok(companheiros);
    }
}

@RestController
@RequestMapping("/eventos")
public class EventoCalendarioController {
    @Autowired
    private EventoCalendarioService eventoCalendarioService;
    
    @RestController
@RequestMapping("/eventos")
public class EventoCalendarioController {
    @Autowired
    private EventoCalendarioService eventoCalendarioService;

    @GetMapping
    public List<EventoCalendario> listarEventosCalendario() {
        return eventoCalendarioService.listarEventosCalendario();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoCalendario> buscarEventoCalendarioPorId(@PathVariable Long id) {
        EventoCalendario evento = eventoCalendarioService.buscarEventoCalendarioPorId(id);
        if (evento != null) {
            return ResponseEntity.ok(evento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EventoCalendario> criarEventoCalendario(@RequestBody EventoCalendario eventoCalendario) {
        EventoCalendario novoEvento = eventoCalendarioService.criarEventoCalendario(eventoCalendario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoCalendario> atualizarEventoCalendario(@PathVariable Long id, @RequestBody EventoCalendario eventoCalendario) {
        EventoCalendario eventoAtualizado = eventoCalendarioService.atualizarEventoCalendario(id, eventoCalendario);
        if (eventoAtualizado != null) {
            return ResponseEntity.ok(eventoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEventoCalendario(@PathVariable Long id) {
        if (eventoCalendarioService.excluirEventoCalendario(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RestController
@RequestMapping("/eventos")
public class EventoCalendarioController {
    @Autowired
    private EventoCalendarioService eventoCalendarioService;

    @GetMapping
    public List<EventoCalendario> listarEventosCalendario() {
        return eventoCalendarioService.listarEventosCalendario();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoCalendario> buscarEventoCalendarioPorId(@PathVariable Long id) {
        EventoCalendario evento = eventoCalendarioService.buscarEventoCalendarioPorId(id);
        if (evento != null) {
            return ResponseEntity.ok(evento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EventoCalendario> criarEventoCalendario(@RequestBody EventoCalendario eventoCalendario) {
        EventoCalendario novoEvento = eventoCalendarioService.criarEventoCalendario(eventoCalendario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoCalendario> atualizarEventoCalendario(@PathVariable Long id, @RequestBody EventoCalendario eventoCalendario) {
        EventoCalendario eventoAtualizado = eventoCalendarioService.atualizarEventoCalendario(id, eventoCalendario);
        if (eventoAtualizado != null) {
            return ResponseEntity.ok(eventoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEventoCalendario(@PathVariable Long id) {
        if (eventoCalendarioService.excluirEventoCalendario(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @GetMapping
    public ResponseEntity<Page<EventoCalendario>> listarEventosCalendario(@RequestParam(defaultValue = "0") int pagina,
                                                                          @RequestParam(defaultValue = "10") int tamanhoPagina) {
        Page<EventoCalendario> eventos = eventoCalendarioService.listarEventosCalendario(pagina, tamanhoPagina);
        return ResponseEntity.ok(eventos);
    }
}

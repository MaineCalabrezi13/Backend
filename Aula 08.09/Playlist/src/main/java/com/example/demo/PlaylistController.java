package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private Map<Integer, Playlist> playlists = new HashMap<>();
    private int proximoIdPlaylist = 1;

    @PostMapping
    public Map<String, Integer> criarPlaylist(@RequestBody Playlist playlist) {
        int id = proximoIdPlaylist++;
        playlist.setId(id);
        playlists.put(id, playlist);
        return Map.of("id", id);
    }

    @PostMapping("/{id}/musicas")
    public ResponseEntity<String> adicionarMusica(@PathVariable int id, @RequestBody Musica musica) {
        Playlist playlist = playlists.get(id);
        if (playlist == null) {
            return ResponseEntity.notFound().build();
        }
        playlist.adicionarMusica(musica);
        return ResponseEntity.ok("Música adicionada à playlist " + playlist.getNome());
    }

    @GetMapping
    public Collection<Playlist> listarPlaylists() {
        return playlists.values();
    }

    @GetMapping("/{id}/musicas")
    public ResponseEntity<List<Musica>> listarMusicas(@PathVariable int id) {
        Playlist playlist = playlists.get(id);
        if (playlist == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(playlist.getMusicas());
    }
}

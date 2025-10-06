package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BibliotecaService {

    private List<Livro> livrosDisponiveis = new ArrayList<>();
    private Map<UUID, Emprestimo> emprestimosAtivos = new HashMap<>();

    public BibliotecaService() {
        livrosDisponiveis.add(new Livro("1984", "George Orwell"));
        livrosDisponiveis.add(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien"));
        livrosDisponiveis.add(new Livro("Dom Quixote", "Miguel de Cervantes"));
        livrosDisponiveis.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry"));
    }

    public List<Livro> getLivrosDisponiveis() {
        return livrosDisponiveis;
    }

    public Collection<Emprestimo> getEmprestimos() {
        return emprestimosAtivos.values();
    }

    public Optional<Emprestimo> criarEmprestimo(UUID livroId, String usuarioId) {
        Optional<Livro> livroOpt = livrosDisponiveis.stream()
                .filter(l -> l.getId().equals(livroId))
                .findFirst();

        if (livroOpt.isEmpty()) {
            return Optional.empty(); // Livro não está disponível
        }

        Livro livro = livroOpt.get();
        livrosDisponiveis.remove(livro);

        Emprestimo emprestimo = new Emprestimo(livroId, usuarioId);
        emprestimosAtivos.put(emprestimo.getEmprestimoId(), emprestimo);

        return Optional.of(emprestimo);
    }

    public boolean devolverLivro(UUID emprestimoId) {
        Emprestimo emprestimo = emprestimosAtivos.remove(emprestimoId);
        if (emprestimo == null) return false;

        Livro livro = new Livro("Título Desconhecido", "Autor Desconhecido");

        livro = livrosDisponiveis.stream()
                .filter(l -> l.getId().equals(emprestimo.getLivroId()))
                .findFirst()
                .orElse(new Livro("Livro Devolvido", "Autor"));

        livrosDisponiveis.add(livro);
        return true;
    }
}

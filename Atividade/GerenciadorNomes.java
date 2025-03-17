// Caio Caramés Lanzelotti da Silva - 10308718
// Vitor Costa Lemos - 10438932

import java.util.List;

public interface GerenciadorNomes {

    int MAX_CARACTERES_NOMES = 20;

    List<String> obterNomes();

    void adicionarNome(String nome);
}

// Caio Caramés Lanzelotti da Silva - 10308718
// Vitor Costa Lemos - 10438932

public class Main {
    public static void main(String[] args) {
        GerenciadorNomes gerenciador = new GerenciadorNomesBD(); 
        Ihm ihm = new Ihm(gerenciador);
        ihm.dialogar(); 
    }
}

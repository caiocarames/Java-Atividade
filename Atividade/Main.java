public class Main {
    public static void main(String[] args) {
        GerenciadorNomes gerenciador = new GerenciadorNomesBD(); 
        Ihm ihm = new Ihm(gerenciador);
        ihm.dialogar(); 
    }
}

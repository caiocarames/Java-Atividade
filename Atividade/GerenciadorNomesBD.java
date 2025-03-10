import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesBD implements GerenciadorNomes {
    private static final String URL = "jdbc:postgresql://db.pxuzgxpcmtpcfescntjd.supabase.co:5432/postgres";
    private static final String USER = "postgres"; 
    private static final String PASSWORD = "atividade12345"; 

    
    private static final String CREATE_TABLE_SQL = 
        "CREATE TABLE IF NOT EXISTS gerenciadornomesbd (" +
        "id SERIAL PRIMARY KEY, " +
        "nome VARCHAR(30) NOT NULL)"; 

    private static final String INSERT_NOME_SQL = 
        "INSERT INTO gerenciadornomesbd (nome) VALUES (?)";

    private static final String SELECT_NOMES_SQL = 
        "SELECT nome FROM gerenciadornomesbd";

    public GerenciadorNomesBD() {
        criarTabela();
    }

    private void criarTabela() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.execute(CREATE_TABLE_SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> obterNomes() {
        List<String> nomes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_NOMES_SQL)) {

            while (rs.next()) {
                nomes.add(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(INSERT_NOME_SQL)) {

            pstmt.setString(1, nome);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

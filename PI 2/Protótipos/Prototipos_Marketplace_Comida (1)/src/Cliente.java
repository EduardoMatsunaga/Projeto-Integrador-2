import java.sql.*;
public class Cliente {
    String cpf;
    String nome; 
    String telefone; 
    String email; 
    String senha; 
    String cep; 
    String logradouro; 
    int numero;
    String complemento; 
    
    void Cliente(){
        this.cpf = "";
        this.nome = "";
        this.telefone = "";
        this.email = "";
        this.senha = "";
        this.cep = "";
        this.logradouro = "";
        this.numero = 0;
        this.complemento = "";
    }
    
        public void insertCliente(Cliente c)
            throws ClassNotFoundException, SQLException {

        GenericDao gDao = new GenericDao();
        Connection conn = gDao.getConnection();

        String sql = "INSERT INTO cliente "
                   + "(cpf, nome, email, telefone, logradouro, numeroEnd, complemento) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, c.cpf);
        ps.setString(2, c.nome);
        ps.setString(3, c.email);
        ps.setString(4, c.telefone);
        ps.setString(5, c.logradouro);
        ps.setInt(6, c.numero);

        if (c.complemento == null || c.complemento.trim().isEmpty()) {
            ps.setNull(7, java.sql.Types.VARCHAR);
        } else {
            ps.setString(7, c.complemento);
        }

        ps.executeUpdate();

        ps.close();
        conn.close();
    }
}

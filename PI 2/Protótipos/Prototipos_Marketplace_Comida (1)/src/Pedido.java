import java.sql.*;

public class Pedido {
    int item;
    double valor;
    int qtd;
    
    void Pedido(){
        this.item = 0;
        this.valor = 0.0;
        this.qtd = 0;
    }
    
    public int AchaProduto(String desc) throws ClassNotFoundException, SQLException{
        GenericDao gDao = new GenericDao();
        Connection conn = gDao.getConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT p.id FROM produto p WHERE p.nome = '"+desc+"'");
        int ret = rs.getInt("id");
        conn.close();
        return ret;
    }
    
    public void insertPedido(Pedido p) throws ClassNotFoundException, SQLException {
        GenericDao gDao = new GenericDao();
        Connection conn = gDao.getConnection();
        String sql = "INSERT INTO pedido VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, Integer.toString(p.item));
        ps.setInt(2, p.qtd);
        ps.setDouble(3, p.valor);
        ps.execute();
        ps.close();
        conn.close();
    }
}



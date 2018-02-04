import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados {
			
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/desafio_back";
		String usuario = "root";
		String senha = "";	
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}
	public void mostrarMedia() {
		try {
			String query = "SELECT AVG(vl_total) as media FROM `tb_customer_account` WHERE vl_total > 560 AND id_customer BETWEEN 15 AND 27";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
				System.out.println("Média:" + this.resultset.getString("media")); 
			}
		} catch (Exception e) {
			System.out.println ("Erro: " + e.getMessage());
		}
	}
	public void inserirContato(String cpf_cnpj, String nm_customer, String is_active, String vl_total) {
		try {
			String query = "INSERT INTO tb_customer_account (cpf_cnpj, nm_customer, is_active, vl_total) VALUES ('" + cpf_cnpj + "','" + nm_customer + "','" + is_active  + "','" + vl_total + "');'";
			this.statement.executeUpdate(query);			
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void desconectar() {
		try {
			this.connection.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}	

	public void listaClientesMedia() {
		try {
			String query = "SELECT * FROM `tb_customer_account` WHERE vl_total > 560 AND id_customer BETWEEN 15 AND 27 ORDER BY vl_total DESC";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
				System.out.println("Id:" + this.resultset.getString("id_customer") + "- CPF/CNPJ: " + this.resultset.getString("cpf_cnpj") 
				+ "- Nome: " + this.resultset.getString("nm_customer") + "-Status: " + this.resultset.getString("is_active") 
				+ "-Saldo: " + this.resultset.getString("vl_total"));
			}
		} catch (Exception e) {
			System.out.println ("Erro: " + e.getMessage());
		}
	}
	


	
}

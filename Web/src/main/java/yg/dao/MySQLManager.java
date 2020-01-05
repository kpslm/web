package yg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLManager {
	private static MySQLManager instance;

	static synchronized MySQLManager getInstance() {

		if (instance == null) {
			instance = new MySQLManager();
		}
		return instance;
	}

	private Connection connection = null;
	public Connection getConnection() {
		return connection;
	}
	 private String url = "jdbc:mysql://localhost:3306/ygmag?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private String utilisateur = "root";
	private String motDePasse = "";

	private MySQLManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}

	}
}

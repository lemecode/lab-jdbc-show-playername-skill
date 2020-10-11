package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	public static Connection getConnection() {

		Properties prop = loadPropertiesFile();

		final String driver = prop.getProperty("driver");
		final String url = prop.getProperty("url");
		final String user = prop.getProperty("username");
		final String pass = prop.getProperty("password");

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;

	}

	public static Properties loadPropertiesFile() {

		Properties prop = new Properties();

		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}

}

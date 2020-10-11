package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO {

	public Skill getSkillBylD(Long id) throws SQLException {
		Skill s = null;

		String sql = "Select * from skill";

		Statement st = ConnectionManager.getConnection().createStatement();

		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				if (id.equals(rs.getLong(1))) {
					long id1 = rs.getLong(1);
					String name = rs.getString(2);

					s = new Skill(id1, name);

				}

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return s;

	}

}

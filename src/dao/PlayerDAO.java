package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Skill;
import utility.ConnectionManager;

public class PlayerDAO {

	public List<Player> getAllPlayer() throws SQLException {

		ArrayList<Player> list = new ArrayList<Player>();

		String sql = "Select * from player join skill on player.skill_id = skill.id";

		Statement st = ConnectionManager.getConnection().createStatement();

		ResultSet rs = st.executeQuery(sql);

		// System.out.println("Records Exist " + rs.next());

		while (rs.next()) {

			// System.out.println("raching 3");
			long id = rs.getLong(1);
			String name = rs.getString(2);
			String country = rs.getString(3);
			long skillId = rs.getLong(4);
			String skillName = rs.getString(7);

			Skill s = new Skill(skillId, skillName);
			Player p = new Player(id, name, country, s);

			list.add(p);

		}

		return list;

	}

}

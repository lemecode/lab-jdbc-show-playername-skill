package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.PlayerDAO;
import dao.SkillDAO;
import model.Player;
import model.Skill;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SkillDAO skilldao = new SkillDAO();
		PlayerDAO playerdao = new PlayerDAO();
		int c;

		do {
			System.out.println("1. Get Skill By ID ");
			System.out.println("2. Get Player Details");
			System.out.println("3. Exit");
			System.out.println("Enter choice");

			int ch = Integer.parseInt(br.readLine());
			c = ch;
			switch (ch) {
			case 1:
				System.out.println("Enter the Skill ID");
				long id = Long.parseLong(br.readLine());

				Skill s = skilldao.getSkillBylD(id);
				System.out.println("Skill Name:" + s.getSkillName());
				break;

			case 2:
				ArrayList<Player> p = (ArrayList<Player>) playerdao.getAllPlayer();

				System.out.println("ID \t Player Name \t Country \t Skill Name");
				System.out.println();
				for (Player pla : p) {
					System.out.println(pla.getPlayerld() + "\t" + pla.getName() + "\t" + pla.getCountry() + "\t"
							+ pla.getSkill().getSkillName());
					System.out.println();
				}
				break;

			default:
				break;
			}

		} while (c != 3);
	}
}

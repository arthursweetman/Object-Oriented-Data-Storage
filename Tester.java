import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Tester{

	public static Scanner in = new Scanner(System.in);
	public static Scanner fin = null;
	public static Scanner fin1 = null;
	public static Scanner fin2 = null;
	public static HashMap<Integer, User> users = new HashMap<Integer, User>();
	public static HashMap<Integer, Team> teams = new HashMap<Integer, Team>();

	public static void main(final String[] args) throws Exception {


		//=============================================== Import Teams and Users

		fin = new Scanner(new File("team_users.txt"));
		fin1 = new Scanner(new File("teams.txt"));
		fin2 = new Scanner(new File("users.txt"));

		fin2.nextLine();
		while(fin2.hasNextLine()) {
			User u = new User(fin2);
			users.put(u.getUserId(), u);
		}

		fin1.nextLine();
		while(fin1.hasNextLine()) {
			Team t = new Team(fin1);
			teams.put(t.getTeamId(), t);
		}

		fin.nextLine();
		while(fin.hasNextLine()) {
			TeamUser tu = new TeamUser(fin);

			int userID = tu.getUserId();
			int teamID = tu.getTeamId();

			teams.get(teamID).users.add(users.get(userID));
			users.get(userID).teams.add(teams.get(teamID));
		}

		//======================================================= Menu
		
		menu: {
			while(true) {
				switch(getMenuChoice()) {
				case "1": lookUpUsersByTeamId();		break; 
				case "2": lookUpTeamsByUserId();		break;
				case "3": listTeamsWithNoUsers();		break;
				case "4": listUsersThatAreNotOnTeam();	break;
				case "5": 								break menu;
				}
			}
		}
		System.out.println("Good bye...");
	}

	//============================================================ Other Methods
	
	private static void listUsersThatAreNotOnTeam() {
		for(User u : users.values()) {
			if(u.teams.size() == 0)
				System.out.println(u.toString());
		}
	}

	private static void listTeamsWithNoUsers() {
		for(Team t : teams.values()) {
			if(t.users.size() == 0)
				System.out.println(t.toString());
		}
	}

	private static void lookUpTeamsByUserId() {
		System.out.println("Please enter UserID ");
		int userID = Integer.parseInt(in.nextLine());
		if (userID < 1 || userID > 1000) {
			System.out.println("Invalid userID");
			return;
		}
		User u = users.get(userID);
		if(u.teams.isEmpty()) {
			System.out.println("User is not on any teams");
			return;
		}
		for(Team t : u.teams)
			System.out.println(t.toString());
	}

	private static void lookUpUsersByTeamId() {
		System.out.println("Please enter TeamID ");
		int teamID = Integer.parseInt(in.nextLine());
		if (teamID < 1 || teamID > 100) {
			System.out.println("Invalid teamID");
			return;
		}
		Team t = teams.get(teamID);
		for(User u : t.users)
			System.out.println(u.toString());
	}

	private static String getMenuChoice() {
		while(true) {
			System.out.println("=========================================");
			System.out.println("1.	Look up users on a team by teamId");
			System.out.println("2.	Look up team a user is on by userId");
			System.out.println("3.	List teams with no users");
			System.out.println("4.	List users that are not on a team");
			System.out.println("5.	Exit");
			System.out.print(">> ");
			String ret = in.nextLine();
			if(ret.charAt(0) >= '1' && ret.charAt(0) <= '5') 
				return ret.substring(0,1);
			else
				System.out.println("\n============== Input Error ==============");
		}
	}

}


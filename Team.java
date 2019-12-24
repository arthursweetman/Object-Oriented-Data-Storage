import java.util.ArrayList;
import java.util.Scanner;

public class Team {

	//=========================================================== Properties
	private int teamId;
	private String universityTeamName;
	private int ownerUserId;
	private boolean isActive;
	public ArrayList<User> users = new ArrayList<User>();

	//=========================================================== Constructors
	public Team (int teamId, String universityTeamName, int ownerUserId, boolean isActive) {
		setTeamId(teamId);
		setUniversityTeamName(universityTeamName);
		setOwnerUserId(ownerUserId);
		setIsActive(isActive);
	}

	public Team (Scanner fin) throws Exception {
		String[] parts = fin.nextLine().split("\t");
		setTeamId(Integer.parseInt(parts[0]));
		setUniversityTeamName(parts[1]);
		setOwnerUserId(Integer.parseInt(parts[2]));
		setIsActive(Boolean.parseBoolean(parts[3]));
	}

	//=========================================================== Methods
	public boolean equals (Object obj) {
		if(!(obj instanceof Team)) return false;
		Team t = (Team) obj;
		return getEqualsString().equals(t.getEqualsString());
	}

	private String getEqualsString() {
		return teamId + "-" + universityTeamName + "-" + ownerUserId + "-" + isActive;
	}

	public String toString() {
		return "teamId: " + teamId + ", universityTeamName: " + universityTeamName + ", ownerUserId: " + ownerUserId + ", isActive: " + isActive;
	}

	//=========================================================== Getters/Setters
	public int getTeamId() {
		return this.teamId;
	}

	public String getUniversityTeamName() {
		return this.universityTeamName;
	}

	public int getOwnerUserId() {
		return this.ownerUserId;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public void setUniversityTeamName(String universityTeamName) {
		this.universityTeamName = universityTeamName;
	}

	public void setOwnerUserId(int ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}

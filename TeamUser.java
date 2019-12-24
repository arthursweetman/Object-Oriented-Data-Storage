import java.util.Scanner;

public class TeamUser {

	//=========================================================== Properties
	private int teamId;
	private int userId;
	private boolean isAssistantCoach;
	private boolean hasBeenHonored;

	//=========================================================== Constructors
	public TeamUser (int teamId, int userId, boolean isAssistantCoach, boolean hasBeenHonored) {
		setTeamId(teamId);
		setUserId(userId);
		setIsAssistantCoach(isAssistantCoach);
		setHasBeenHonored(hasBeenHonored);
	}

	public TeamUser (Scanner fin) throws Exception {
		String[] parts = fin.nextLine().split("\t");
		setTeamId(Integer.parseInt(parts[0]));
		setUserId(Integer.parseInt(parts[1]));
		setIsAssistantCoach(Boolean.parseBoolean(parts[2]));
		setHasBeenHonored(Boolean.parseBoolean(parts[3]));
	}

	//=========================================================== Methods
	public boolean equals (Object obj) {
		if(!(obj instanceof TeamUser)) return false;
		TeamUser t = (TeamUser) obj;
		return getEqualsString().equals(t.getEqualsString());
	}

	private String getEqualsString() {
		return teamId + "-" + userId + "-" + isAssistantCoach + "-" + hasBeenHonored;
	}

	public String toString() {
		return "teamId: " + teamId + ", userId: " + userId + ", isAssistantCoach: " + isAssistantCoach + ", hasBeenHonored: " + hasBeenHonored;
	}

	//=========================================================== Getters/Setters
	public int getTeamId() {
		return this.teamId;
	}

	public int getUserId() {
		return this.userId;
	}

	public boolean getIsAssistantCoach() {
		return this.isAssistantCoach;
	}

	public boolean getHasBeenHonored() {
		return this.hasBeenHonored;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setIsAssistantCoach(boolean isAssistantCoach) {
		this.isAssistantCoach = isAssistantCoach;
	}

	public void setHasBeenHonored(boolean hasBeenHonored) {
		this.hasBeenHonored = hasBeenHonored;
	}

}

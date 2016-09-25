
public class Piloto {
	private String number, driver, team, laps, time;
	private int pts;

	public Piloto(String number, String driver, String team, String laps, String time, int pts) {
		super();
		this.number = number;
		this.driver = driver;
		this.team = team;
		this.laps = laps;
		this.time = time;
		this.pts = pts;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getLaps() {
		return laps;
	}

	public void setLaps(String laps) {
		this.laps = laps;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPts() {
		return pts;
	}

	public void setPts(int pts) {
		this.pts = pts;
	}

}

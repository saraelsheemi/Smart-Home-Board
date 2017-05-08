package src;

public class Intrepreter {
	private TV tv;

	public Intrepreter(TV tv) {
		// TODO Auto-generated constructor stub
		this.tv = tv;
	}

	public String intrepret(String statement) {
		switch (statement) {
		case "turn on":
			tv.setStatus(true);
			return "device turned on successfully";
		case "turn off":
			tv.setStatus(false);
			return "device turned off successfully";
		case "getStatus":
			return String.valueOf(tv.isStatus());
		default:
			return "unknown command";
		}
	}
}

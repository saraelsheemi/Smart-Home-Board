package src;

public class Interpreter {
	
	private LightBulb lightBulb;

	public Interpreter( LightBulb lightBulb) {
		this.lightBulb = lightBulb;
	}
	
	public String interpret(String statement) {
		switch (statement) {
		case "turn on":
			lightBulb.setStatus(true);
			return "Device turned on successfully";
		case "turn off":
			lightBulb.setStatus(false);
			return "Device turned off successfully";
		case "getStatus":
				if(lightBulb.isStatus()){
					return "On";
				}else{
					return "Off";
				}
		default:
			return "Unknown command";
		}
	}

}

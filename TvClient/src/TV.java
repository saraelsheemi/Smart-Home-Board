/**
 * 
 */

/**
 * @author joe
 *
 */
public class TV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		Registeration r = new Registeration();
		try{
		r.register();
		}catch(Exception e){
			e.getMessage();
		}
		System.out.println("end of a tv program");
	}

}

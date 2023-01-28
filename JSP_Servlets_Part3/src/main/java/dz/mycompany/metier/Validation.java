package dz.mycompany.metier;
import java.util.ArrayList;

public class Validation {
	
	ArrayList<User> users;
	
	public Validation() {
		users = new ArrayList<User>();
		
		User user = new User("Amir", "34");
		users.add(user);
		
		user = new User("Chouaib", "19");
		users.add(user);
		
		user = new User("Outhman", "03");
		users.add(user);
		
		user = new User("Yahia", "34");
		users.add(user);
		
		user = new User("Mohammed", "19");
		users.add(user);
	}
	
	
	public int valider(String username, String password) {
		int result = 0;		
		
		for(User user: users) {
			if(user.getUsername().equals(username) && !user.getPassword().equals(password)) {
				result = 1;
				
			}else {
				if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
					result = 2;
				}
			}	
		}
		
		
		return result;
	}

}

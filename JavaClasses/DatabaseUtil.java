import java.util.Set;
import java.util.TreeSet;

public class DatabaseUtil {

	private Set<User> collects = new TreeSet<User>();
	
	
	
	
	//This function attempts to add a user to the
	//database, a boolean describing the result of the operation
	//is returned.
	public boolean createNewUser(User usr) {
		boolean rtrn =false;
		
		
		
		
		//If the password is the empty string or null, do not
		//allow this user to be created, same for the username.
		if(usr.isPassword("") == false &&  usr.isPassword(null) == false
				&& usr.getUserName().equals("") == false && usr.getUserName().equals(null) == false) {
			
			//If the user isn't already in the database,
			//do not allow the user to be created.
			if(collects.contains(usr) == false) {
				collects.add(usr);
				rtrn = true;
			}
			
			
		}
		
		
		return rtrn;
	}
	
	
	//This function checks if the passed UserName 
	//is taken and returns the result of the check.
	public boolean isTaken(String usr) {
		
		boolean rtrn = true;
		
		if(usr != "" && usr != null) {
			User usrr = new User();
			usrr.SetUsername(usr);
			usrr.SetPassword(":");
			
			
			
			
			rtrn = this.collects.contains(usrr);
		}
		
		
		return rtrn;
	}
	
	
	//This function Removes the passed
	//user from the database.
	public void removeUser(User usr) {
		if(collects.contains(usr)){
			collects.remove(usr);
		}
	}
	
	
	
	
	
	//This function changes the username of the
	//passed user, given that the user's
	//password which was passed is correct.
	public boolean changeUserName(User usr, String pass, String newUserName) {
		boolean rtrn = false;
		
		if(this.collects.contains(usr) && usr.isPassword(pass)){
			//Remove this user from the database.
			this.collects.remove(usr);
			
			usr.SetUsername(newUserName);
			//add it back to the database.
			this.collects.add(usr);
			
			rtrn = true;
			
		}
			
		return rtrn;
		
	}
	
	//This function removes the passed user from the database,
	//If the passed password is correct.
	public boolean deleteUser(User usr,String pass) {
		
		boolean rtrn = false;

		if(this.collects.contains(usr) && usr.isPassword(pass)){
			//Remove this user from the database.
			this.collects.remove(usr);
			rtrn = true;
			
		}
			
		return rtrn;
	}
	
	/*
	
	//This function is for recovering a user account
	//in the even that the user forgot their password.
	public boolean forgotPassword(String username) {
		
	}
	
	
	//This function is for returning the username
	//of a particular user, if the user forgot
	//the username.
	public boolean forgotUserName() {
		
	}
	
	
	
	
	*/
	
	
	//This function attempts to
	//change the password to the passed string, and returns the
	//status of the operation.
	public boolean changePassword(User usr, String pass, String newPass) {
		boolean rtrn = false;

		if(this.collects.contains(usr) && usr.isPassword(pass)){
			//Remove this user from the database.
			this.collects.remove(usr);
			
			usr.SetPassword(newPass);
			
			//add it back to the database.
			this.collects.add(usr);
			
			rtrn = true;
			
		}
			
		return rtrn;
	}
		
		
		
}

import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class User implements Comparable<User> {
	
	
	private String username;
	private String password;
	private Vector<WatchList> lists;
	
	

	//This function sets the username.
	public void SetUsername(String usr) {
		this.username = usr;
	}
	
	//This function sets the password.
	public void SetPassword(String pass) {
		this.password = pass;
	}
	
	
	//This function adds a new watchlist
	//to list.
	public void createNewWatchList(String name) {
		
	}
	
	
	//This function duplicates a watchlist
	//to the list.
	public void duplicateWatchList(WatchList lst) {
		
	}
	
	
	//This function removes a watchlist.
	public void deleteWatchList(WatchList lst) {
		
	}
	
	
	
	
	
	
	



	//This function returns a negative value if o is less than this,
	//zero if this is equal to o, and positive if this is greater than o.
	@Override
	public int compareTo(User o) {
		String thisU, oU;
		int rtrn = 0;
		thisU = this.username.toLowerCase();
		oU = o.username.toLowerCase();
		
		//If user names are the same, then the users are equal.
		//No two users can have the same username, but two
		//users can share the same password.
		if(thisU == oU) {
			rtrn = 0;
		}
		else {
			//Otherwise if the usernames are different then check
			//the passwords to make sure they don't match.
			rtrn = this.password.compareTo(o.password);
		}
		
		return rtrn;
	}
	
}

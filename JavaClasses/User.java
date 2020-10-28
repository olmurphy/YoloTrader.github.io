
import java.util.Vector;

public class User implements Comparable<User> {
	
	
	private String username;
	private String password;
	private Vector<WatchList> lists;
	
	//This function is the constructor.
	User(){
		lists = new Vector<WatchList>();
	}
	
	

	//This function sets the username.
	public void SetUsername(String usr) {
		this.username = usr;
	}
	
	//This function sets the password.
	public void SetPassword(String pss) {
		
		this.password = pss;
		
	}
	
	
	//This function returns the username.
	public String getUserName() {
		return this.username;
	}
	
	//This function checks if the passed string
	//matches the password.
	public boolean isPassword(String pss) {
		boolean rtrn = false;
		
		if(pss != null ) {
			rtrn = this.password.equals(pss);
		}
		
		return rtrn;
	}
	
	//This function adds a new watchlist
	//to list.
	public void createNewWatchList(String name) {
		WatchList lstt = new WatchList(name);
		
		this.lists.add(lstt);
	}
	
	//This function adds a new watchlist
	//to list.
	public void createNewWatchList(WatchList lst) {
		this.lists.add(lst);
	}
	
	
	//This function duplicates a watchlist
	//to the list.
	public void duplicateWatchList(WatchList lst) {
		this.createNewWatchList(lst);
	}
	
	
	//This function removes a watchlist from the list.
	public void deleteWatchList(WatchList lst) {
		if(this.lists.contains(lst)) {
			lists.remove(lst);
		}
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
			rtrn = thisU.compareTo(oU);
		}
		
		return rtrn;
	}
	
}

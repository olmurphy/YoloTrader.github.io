import java.util.Set;

public class WatchList {
	private Set<Stock> list;
	private String name;
	
	//This function is the constructor for the watchlist object.
	WatchList(String nm){
		this.name = "New List";
		if(nm != null || nm != "" ) {
			this.name = nm;
		}
	}
	
	//This function adds a new stock to the list,
	//if it isn't already in the list.
	public void add(Stock st) {
		list.add(st);
	}
	
	//Returns boolean value that answers whether or not
	//the stock is on the watchlist.
	public boolean onList(Stock st) {
		return list.contains(st);
	}
	
	
	//This function removes the passed stock from the watchlist,
	//If it is on the list.
	public void remove(Stock st) {
		if(list.contains(st) == true) {
			list.remove(st);
		}
	}
	
	
}

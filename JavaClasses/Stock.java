
//This class is representative of a stock.
public class Stock implements Comparable<Stock>{

	
	private String ticker;
	private String name;
	
	
	
	
	//This function returns the ticker symbol.
	public String getTicker() {
		return this.ticker;
	}
	
	//This function returns the name of the company or equity.
	public String getName() {
		return  this.name;
	}
	
	//This function is for setting the ticker symbol.
	public void setTicker(String tc) {
		this.ticker = tc;
	}
	
	//This function is for setting the name of the company or equity.
	public void setName(String nm) {
		this.name = nm;
	}

	//this function returns a negative value if o is less than this,
	//zero if this is equal to o, and positive if this is greater than o.
	@Override
	public int compareTo(Stock o) {
		//Compare by ticker, before comparing by name.
		int rtrn = this.ticker.compareTo(o.ticker);
		
		if(rtrn == 0) {
			rtrn = this.name.compareTo(o.name);
		}
		
		
		return rtrn;
	}
	
	
	
	
}

package edu.baylor.ecs.csi3471.API;

import edu.baylor.ecs.csi3471.dao.GenericDAO;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.presentation.UI.stockPage.GraphPanel;
import yahoofinance.Stock;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


/**
 * The StockUtil class is responsible for managing watch lists, and 
 * looking up & analyzing stocks.
 * <p>
 * YoloTrader utilizes the YahooFinanceAPI & FinancialModelingPrepAPI(NASDAQ) to
 * provide its services.
 * 
 * @author      Prince Kalu
 */
public class StockUtil {

	/**
     * enum that has the exchanges listed
     *
     * allows to add onto the query search to indicate the exchange used in the api
     */
    enum Exchange {
        NASDAQ,
        NYSE;
        
        
        /**
         * this a method for an instance of the enum that is called to increment the
         * value of enum to the next & length of # of enums.
         *
         * Usage: used inside of for-loop when querying API
         */
        private static final Exchange[] values = values();
        public Exchange next() {
            return values[(this.ordinal()+1) % values.length];
        }
    }

    //private GenericDAO<StockWatchList> WatchLists;
    public static Exchange exchange;
    
    
    private final static String SEARCH_URL ="https://financialmodelingprep.com/api/v3/search?query=";
    private final static String EXCHANGE_URL = "&limit=10&exchange=";
    
    private static String SEARCH_API_URL = "&apikey=4819ef0b5de9d90ed219e89c51f35d34";
    
    private final static String SEARCH_API_URL_1 = "&apikey=4819ef0b5de9d90ed219e89c51f35d34";
    private final static String SEARCH_API_URL_2 = "&apikey=9f2e6a54a66d7c7961207ce53c05e063";
    
    private final static String GRAPH_URL = "https://financialmodelingprep.com/api/v3/historical-chart/30min/";
    private static String GRAPH_API_URL = "?apikey=4819ef0b5de9d90ed219e89c51f35d34";
    
    private final static String GRAPH_API_URL_1 = "?apikey=4819ef0b5de9d90ed219e89c51f35d34";
    private final static String GRAPH_API_URL_2 = "?apikey=9f2e6a54a66d7c7961207ce53c05e063";
    
    
    
    
    /**
     * The extractData function is a helper function for the getGraphData function.
     * <p>
     * @param line	${@link String}
     * <p>
     * @return	{@link String} 
     */
    private static String extractData(String line) {
    	String separate = ":";
        String start = "\"";
        int begin;
    	int end;
    	
    	begin = line.indexOf(separate);
        begin= line.indexOf(start,begin);
        begin++;
        end = line.indexOf(start, begin);
        String data = line.substring(begin, end);
        
        return data;
    }
    
    
    /**
     * The extractPrice function is a helper function for the getGraphData function.
     * <p>
     * @param line	${@link String}
     * <p>
     * @return	{@link Double} 
     */
    private static Double extractPrice(String line) {
    	String separate = ":";
        String start = " ";
        String stop = ",";
        int begin;
    	int end;
    	
  
        begin= line.lastIndexOf(start);
        begin++;
        end =  line.indexOf(stop, begin);
        String data = line.substring(begin, end);
        

        
        
        
        return Double.parseDouble(data);
    }
    
    
    
    /**
     * The getPosition function is a helper function for the getGraphData function.
     * <p>
     * @param time	${@link String}
     * <p>
     * @return	{@link Integer} 
     */
    private static int getPosition(String time) {
    	int rtrn = -1;
    	if(time.contains("09:30:00")) {
    		rtrn = 0;
    	}
    	else if(time.contains("10:00:00")) {
    		rtrn = 1;
    	}
    	else if(time.contains("10:30:00")) {
    		rtrn = 2;
    	}
    	else if(time.contains("11:00:00")){
    		rtrn = 3;
    		
    	}
    	else if(time.contains("11:30:00")){
    		rtrn = 4;
    		
    	}
    	else if(time.contains("12:00:00")){
    		rtrn = 5;
    	}
    	else if(time.contains("12:30:00")){
    		rtrn = 6;
    		
    	}
    	else if(time.contains("13:00:00")){
    		rtrn = 7;
    		
    	}
    	else if(time.contains("13:30:00")){
    		rtrn = 8;
    		
    	}
    	else if(time.contains("14:00:00")){
    		rtrn = 9;
    		
    	}
    	else if(time.contains("14:30:00")){
    		rtrn = 10;
    		
    	}
    	else if(time.contains("15:00:00")){
    		rtrn = 11;
    	}
    	else if(time.contains("15:30:00")){
    		rtrn = 12;
    		
    	}
    	else if(time.contains("16:00:00")){
    		rtrn = 13;
    		
    	}
    	
    	
    	return rtrn;
    }
    
    
    /*FIXME: TEST IF IT CAN HANDLE DRAWING DURING THE MARKET DAY!*/
    
    /**
     * The getGraph function returns a GraphPanel object
     * which is the visual representation of equity's price
     * movements for the day.
     * <p>
     * @param equity	${@link yahoofinance.Stock}
     * <p>
     * @return	{@link GraphPanel} 
     */
    public static GraphPanel getGraph(yahoofinance.Stock equity ) {
    	//create graph.
    	Vector<Double> values = getGraphData(equity);
    
    	
    	//Can Only show prices for times that have already happened.
    	for(int x = values.size()-1; x > -1; x--) {
    		if(values.elementAt(x) == -1.0) {
    			
    			values.remove(x);
    			
    			if(x == 1) {
    				values.add(values.elementAt(0));
    			}
    				
    		}
    	}
    	
    	
    	GraphPanel graph = new GraphPanel(values, equity.getName());
    	
    	//Check if the graph should be painted red or green.
    	Double first;
    	Double last;
    	
    	
    	
    	//get open price for the day, and the most recent closing price.
    	first = values.firstElement();
    	last = values.firstElement();
    	for(int x = 1; x < values.size(); x++) {
    		if(values.elementAt(x) != -1.0) {
    			last = values.elementAt(x);
    		}
    	}
    	
    	graph.setLineColor(Color.GREEN);
    	
    	if(last < first) {
    		graph.setLineColor(Color.RED);
    	}
    	
    	return graph;
    	
    }
    
    
    
    /**
     * The getGraphData function returns a list of equity's prices for the day.
     * <p>
     * @param equity	${@link yahoofinance.Stock}
     * <p>
     * @return	{@link Vector<Double>} 
     */
    public static Vector<Double> getGraphData(yahoofinance.Stock equity){
    	
    	String query = GRAPH_URL + equity.getSymbol() + GRAPH_API_URL;
    	Vector<Double> data = new Vector<Double>();
    	String close = "close";
    	Double cls;
    	String date = "date";
    	String todaY = "";
    	String time = "";
    	String price;
    	int begin;
    	int end;
    	String separate = ":";
        String start = "\"";
        String space = " ";
        boolean today = false;
        
        //Set all  14 values in vector to -1;
        for(int x = 0; x < 14; x++) {
        	data.add(-1.0);
        }
    	
    	
    	try {
    	
	    	URL url = new URL(query);
	    	
	    
	    	//read and modify the data to double
	    	try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
	    		
	    	
	    		  	
	    	    for (String line; (line = reader.readLine()) != null;) {
	    	    	
	    	    	/*INTERPRETATION : 	- Only get the last 8 entries!!
	    	    	 * 					- Only read entries from the current day.
	    	    	 *						-only read the closing tags of these entries.
	    	    	*/
	    	    	
	    	    	
	    	    	//If API limit has been reached
	    	    	if(line.contains("Error")) {
	    	    		//Switch API Keys :).
	    	    		
	    	    	
	    	    		//If P's API key is being used.
	    	    		if(GRAPH_API_URL == GRAPH_API_URL_1) {
	    	    			//Check if O's API key is still good.
	    	    			query = GRAPH_URL + equity.getSymbol() + GRAPH_API_URL_2;
	    	    			URL url2 = new URL(query);
	    	    			BufferedReader check = new BufferedReader(new InputStreamReader(url2.openStream(), "UTF-8" ));
	    	    			
	    	    			line = check.readLine();
	    	    			
	    	    			//If O's API key is still good.
	    	    			if(line.contains("ERROR") == false) {
	    	    				//Change to O's API key.
	    	    				GRAPH_API_URL = GRAPH_API_URL_2;
	    	    				
	    	    				//Call function again
	    	    				data = getGraphData(equity);
	    	    			}
	    	    			
	    	    			//Otherwise.
	    	    			else {
	    	    				System.out.println("BOTH API KEYS MAXED OUT. TRY AGAIN TOMMO.");
	    	    				
	    	    			}
	    	    			
	    	    		}
	    	    		
	    	    		//Otherwise O's API key is being used.
	    	    		else {
	    	    			
	    	    			//Check if P's API key is still good.
	    	    			query = GRAPH_URL + equity.getSymbol() + GRAPH_API_URL_1;
	    	    			URL url2 = new URL(query);
	    	    			BufferedReader check = new BufferedReader(new InputStreamReader(url2.openStream(), "UTF-8" ));
	    	    			
	    	    			line = check.readLine();
	    	    			
	    	    			//If P's API key is still good.
	    	    			if(line.contains("ERROR") == false) {
	    	    				//Change to P's API key.
	    	    				GRAPH_API_URL = GRAPH_API_URL_1;
	    	    				
	    	    				//Call function again
	    	    				data = getGraphData(equity);
	    	    			}
	    	    			
	    	    			//Otherwise.
	    	    			else {
	    	    				System.out.println("BOTH API KEYS MAXED OUT. TRY AGAIN TOMMO.");
	    	    				
	    	    			}
	    	    			
	    	    		}
	    	    		
	    	    	}//End of if API limit has been reached.
	    	    	
	    	    	
	    	    	//Otherwise API limit has not yet been reached.
	    	    	else {
	                    //Check the date.
		    	    	if(line.contains(date)) {
	                    	
	                    
	                        //If today's date has not been determined.
	                    	if(today == false) {
		                        
	                    		//Get the date and time.
		                        todaY = extractData(line);
		                        
		                        //Get the time
		                        begin = todaY.indexOf(space);
		                        begin++;
		                        time = todaY.substring(begin);
		                        
		                        //Only pay attention to the desired times.
		                        if(getPosition(time) != -1) {
		                       
			                        //Get the date
			                        begin = 0;
			                        end = todaY.indexOf(space, begin);
			                        todaY = todaY.substring(begin, end);
			                        
			                       
			                        
			                        
			                        //At this point todaY is now the string format of today.
			                        today = true;
			                        
			                        //This also means that this entry is the most recent entry.
			                        while(line.contains(close) == false) {
			                        	
			                        	line = reader.readLine();
			                        	
			                        }
			                        
			                        //Now at close tag, get closing price.
			                   
			                        cls= extractPrice(line);
			                       
			                        
			                        int pos = getPosition(time);
			                        
			                        //Save the data
			                        data.set(pos,cls);
			                        today = true;
			                        
		                        
		                        }
		                        
		                        
	                    	}
	                    	
	                    	//Otherwise, the date has been determined, implying that this entry is not the 
	                    	//most recent entry.
	                    	else {
	                    	
	                    	
		                    	//If this entry is from today.
		                    	if(line.contains(todaY)) {
		                    		
		                    		//Get the time of the entry
		                    		time = extractData(line);
			                        begin = line.indexOf(space);
			                        begin++;
			                        time = line.substring(begin);
			                        
			                        
			                        //if this is a desired time.
			                        if(getPosition(time) != -1) {
			                        	
			                        	 	//Extract the closing price
			                        		while(line.contains(close) == false) {
			                        			
					                        	line = reader.readLine();
					                        }
					                        
					                     	//Now at close tag, get closing price.
			                        		
					                        cls= extractPrice(line);
					                        
					                        int pos = getPosition(time);
					                        
					                        //Save the data
					                        data.set(pos, cls);
					                        today = true;
			                        	
			                        }
		                    		
		                    	}
		                    	
	                    	}
                    	
                        
		    	    	}//End of check date.
	    	    	}//End of API limit not reached.
	    	    
	    	  }//End of for loop.
	    	}
	    	
    	}
    	catch(UnsupportedEncodingException u) {
           YoloTrader.logger.warning("An Unsupported encoding exception was caught..Printing stack trace...\n");
           YoloTrader.logger.warning(u.toString());
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
        	YoloTrader.logger.warning("A Malformed(BAD) URL exception was caught..Printing stack trace...\n");
        	YoloTrader.logger.warning(e.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
        	YoloTrader.logger.warning("An Input/Output exception was caught..Printing stack trace...\n");
            YoloTrader.logger.warning(e.toString());
        }
    	
    	
    
    	
	    
	    //return data
    	return data;
    	
    }
    

    /**
     * The pullUp function returns a ${@link Map} of name keys to ticker values. The name
     * keys are corresponding matches to the query String.
     * <p>
     * @param query		the name/ticker to look for.
     * <p>
     * @return	returns a list, in the form of a map, of all plausible matches.
     */
    public static Map<String, String> pullUp(String query) {

        Map<String, String> results = new HashMap<String, String>();
        String sanitizedQuery = "";

        //Shed query of any illegal characters.
        for(int x = 0; x < query.length(); x++) {

            if( (query.charAt(x) > 64 &&  query.charAt(x) < 91)  ||
                    (query.charAt(x) > 96 &&  query.charAt(x) < 123))  {
                sanitizedQuery += query.charAt(x);
            }
        }

        Stock stock = null;

        String guess;
        String symbol = "symbol";
        String separate = ":";
        String start = "\"";
        String tick = "";
        String name = "";

        int begin, end;

        try {
            for(int x = 0; x < 2; x++) {

                //Access FinancialModelingPrepAPI.
                String search1 = SEARCH_URL + sanitizedQuery + EXCHANGE_URL;

                if(x == 0) {
                    search1 += Exchange.NASDAQ;
                }

                else {
                    search1 += Exchange.NYSE;
                }

                String search =  search1 + SEARCH_API_URL;


                URL url = new URL(search);

                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                for (String line; (line = reader.readLine()) != null ;) {
                	
                	//If the current API key is maxed out.
                	if(line.contains("ERROR")) {
                		
                		//Switch API Keys :).
	    	    		
    	    	    	
	    	    		//If P's API key is being used.
	    	    		if(SEARCH_API_URL == SEARCH_API_URL_1) {
	    	    			
	    	    			//Check if O's API key is still good.
	    	    			search = search1 + SEARCH_API_URL_2;
	    	    			URL url2 = new URL(search);
	    	    			BufferedReader check = new BufferedReader(new InputStreamReader(url2.openStream(), "UTF-8" ));
	    	    			
	    	    			line = check.readLine();
	    	    			
	    	    			//If O's API key is still good.
	    	    			if(line.contains("ERROR") == false) {
	    	    				//Change to O's API key.
	    	    				SEARCH_API_URL = SEARCH_API_URL_2;
	    	    				
	    	    				//Call function again
	    	    				results = pullUp(query);
	    	    			}
	    	    			
	    	    			//Otherwise.
	    	    			else {
	    	    				System.out.println("BOTH API KEYS MAXED OUT. TRY AGAIN TOMMO.");
	    	    				
	    	    			}
	    	    			
	    	    		}
	    	    		
	    	    		//Otherwise O's API key is being used.
	    	    		else {
	    	    			
	    	    			//Check if P's API key is still good.
	    	    			search = search1 + SEARCH_API_URL_1;
	    	    			URL url2 = new URL(search);
	    	    			BufferedReader check = new BufferedReader(new InputStreamReader(url2.openStream(), "UTF-8" ));
	    	    			
	    	    			line = check.readLine();
	    	    			
	    	    			//If P's API key is still good.
	    	    			if(line.contains("ERROR") == false) {
	    	    				//Change to P's API key.
	    	    				SEARCH_API_URL = SEARCH_API_URL_1;
	    	    				
	    	    				//Call function again
	    	    				results = pullUp(query);
	    	    			}
	    	    			
	    	    			//Otherwise.
	    	    			else {
	    	    				System.out.println("BOTH API KEYS MAXED OUT. TRY AGAIN TOMMO.");
	    	    				
	    	    			}
	    	    			
	    	    		}
	    	    		
                		
                	}
                	
                	//Otherwise.
                	else {
                		
                		
                		 //Only be concerned with the symbol and name line.
                        if(line.contains(symbol)) {

                            //Get ticker.
                            begin = line.indexOf(separate);
                            begin= line.indexOf(start,begin);
                            begin++;
                            end = line.indexOf(start, begin);
                            tick = line.substring(begin, end);

                            //Get name
                            line = reader.readLine();
                            begin = line.indexOf(separate);
                            begin= line.indexOf(start,begin);
                            begin++;
                            end = line.indexOf(start, begin);
                            name= line.substring(begin, end);

                            //Make mapping.
                            results.put(name, tick);
                        }
                		
                	}

                   
                }//End of reading JSON.
            }
        }
        catch(UnsupportedEncodingException u) {
            YoloTrader.logger.warning("An Unsupported encoding exception was caught..Printing stack trace...\n");
            YoloTrader.logger.warning(u.toString());
         } catch (MalformedURLException e) {
             // TODO Auto-generated catch block
         	YoloTrader.logger.warning("A Malformed(BAD) URL exception was caught..Printing stack trace...\n");
         	YoloTrader.logger.warning(e.toString());
         } catch (IOException e) {
             // TODO Auto-generated catch block
         	YoloTrader.logger.warning("An Input/Output exception was caught..Printing stack trace...\n");
             YoloTrader.logger.warning(e.toString());
         }

        return results;
    }

}

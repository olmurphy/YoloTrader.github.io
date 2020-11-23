package edu.baylor.ecs.csi3471.API;

<<<<<<< HEAD
import edu.baylor.ecs.csi3471.dao.GenericDAO;
=======
import edu.baylor.ecs.csi3471.dao.StockWatchListDAO;
import edu.baylor.ecs.csi3471.main.YoloTrader;
>>>>>>> 9df659717b9e8744fdcff686467c1d80fe5e8d8b
import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.model.StockWatchList;

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

    //Two different exchanges
    //to search from.
    enum Exchange {
        NASDAQ,
        NYSE
    }

    GenericDAO<StockWatchList> WatchLists;

    private final static String SEARCH_URL ="https://financialmodelingprep.com/api/v3/search?query=";
    private final static  String EXCHANGE_URL = "&limit=10&exchange=";
    private final static String SEARCH_API_URL = "&apikey=4819ef0b5de9d90ed219e89c51f35d34";
    
    private final static String GRAPH_URL = "https://financialmodelingprep.com/api/v3/historical-chart/1hour/";
    private final static String GRAPH_API_URL = "?apikey=4819ef0b5de9d90ed219e89c51f35d34";
    
    
    

    
    /**
     * The getGraphData function returns a list of equity's prices for the day.
     * <p>
     * @param equity	${@link yahoofinance.Stock}
     * <p>
     * @return	{@link Vector<Double>} 
     */
    public Vector<Double> getGraphData(yahoofinance.Stock equity){
    	
    	String query = GRAPH_URL + equity.getSymbol() + GRAPH_API_URL;
    	Vector<Double> data = new Vector<Double>();
    	String close = "close";
    	String price;
    	int begin;
    	int end;
    	String separate = ":";
        String start = "\"";
    	
    	
    	try {
    	
	    	URL url = new URL(query);
	    	
	    
	    	//read and modify the data to double
	    	try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
	    	    for (String line; (line = reader.readLine()) != null;) {
	    	    	

                    //Only be concerned with the closing price.
                    if(line.contains(close)) {
                    	

                        //Get closing price.
                        begin = line.indexOf(separate);
                        begin= line.indexOf(start,begin);
                        begin++;
                        end = line.indexOf(start, begin);
                        price = line.substring(begin, end);
                        
                       

                        //Modify and save data.
                        data.add(Double.parseDouble(price));
                        
                    }
	    	    
	    	  }
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
                String search = SEARCH_URL + sanitizedQuery + EXCHANGE_URL;

                if(x == 0) {
                    search += Exchange.NASDAQ;
                }

                else {
                    search += Exchange.NYSE;
                }

                search += SEARCH_API_URL;


                URL url = new URL(search);

                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                for (String line; (line = reader.readLine()) != null ;) {


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

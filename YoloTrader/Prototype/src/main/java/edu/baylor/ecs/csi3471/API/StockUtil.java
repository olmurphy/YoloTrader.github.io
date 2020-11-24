package edu.baylor.ecs.csi3471.API;

import edu.baylor.ecs.csi3471.dao.GenericDAO;
import edu.baylor.ecs.csi3471.main.YoloTrader;
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
 * @author  Prince Kalu
 */
public class StockUtil {

    /**
     * enum that has the exchanges listed
     *
     * allows to add onto the query search to indicate the exchange used in the api
     */
    enum Exchange {
        NASDAQ, // located in NYC
        NYSE, // New York Stock Exchange
        AMEX, // American Stock Exchange in NYC
        NSE, // National Stock Exchange of India Limited, located in Mumbai, Maharashtra
        LSE, // london stock exchange, located in London, UK
        BSE; // Bombay Stock Exchange Ltd., (Indian) located at Dalal Street, Mumbai

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

    GenericDAO<StockWatchList> WatchLists;
    public static Exchange exchange;

    private final static String SEARCH_URL ="https://financialmodelingprep.com/api/v3/search?query=";
    private final static  String EXCHANGE_URL = "&limit=15&exchange=";
    private final static String SEARCH_API_URL_1 = "&apikey=4819ef0b5de9d90ed219e89c51f35d34";
    private final static String SEARCH_API_URL_2 = "&apikey=9f2e6a54a66d7c7961207ce53c05e063";
    
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
        	YoloTrader.logger.warning("A Malformed(BAD) URL exception was caught..Printing stack trace...\n");
        	YoloTrader.logger.warning(e.toString());
        } catch (IOException e) {
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

        // shed query of any illegal characters.
        for(int x = 0; x < query.length(); x++) {

            if( (query.charAt(x) > 64 &&  query.charAt(x) < 91)  ||
                    (query.charAt(x) > 96 &&  query.charAt(x) < 123))  {
                sanitizedQuery += query.charAt(x);
            }
        }

        String symbol = "symbol";
        String separate = ":";
        String start = "\"";
        String tick = "";
        String name = "";

        int begin, end;

        try {

            // get the end of the enum list
            exchange = Exchange.values()[Exchange.values().length - 1];

            for(int x = 0; x < Exchange.values().length; x++) {
                exchange = exchange.next();  // iterates to first, second, ...

                // Access FinancialModelingPrepAPI.
                String search = SEARCH_URL + sanitizedQuery + EXCHANGE_URL;

                search += exchange;

                search += SEARCH_API_URL_1;

                /*
                 * Documentation for error
                 *
                 * This is the error below after too many API queries, so we know when processing for Errors, if they appear
                 * {"Error Message" : "Limit Reach . Please upgrade your plan or visit our documentation for more details at https://financialmodelingprep.com/developer/docs/pricing "}
                 */

                URL url = new URL(search);

                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                for (String line; (line = reader.readLine()) != null ;) {

                    // only be concerned with the symbol and name line.
                    if(line.contains(symbol)) {

                        // get ticker.
                        begin = line.indexOf(separate);
                        begin= line.indexOf(start,begin);
                        begin++;
                        end = line.indexOf(start, begin);
                        tick = line.substring(begin, end);

                        // get name
                        line = reader.readLine();
                        begin = line.indexOf(separate);
                        begin= line.indexOf(start,begin);
                        begin++;
                        end = line.indexOf(start, begin);
                        name= line.substring(begin, end);

                        // make mapping.
                        results.put(name, tick);
                    }
                }
            }
        }

        catch(UnsupportedEncodingException u) {
            YoloTrader.logger.warning("An Unsupported encoding exception was caught..Printing stack trace...\n");
            YoloTrader.logger.warning(u.toString());
         } catch (MalformedURLException e) {
         	YoloTrader.logger.warning("A Malformed(BAD) URL exception was caught..Printing stack trace...\n");
         	YoloTrader.logger.warning(e.toString());
         } catch (IOException e) {
         	YoloTrader.logger.warning("An Input/Output exception was caught..Printing stack trace...\n");
         	YoloTrader.logger.warning(e.toString());
         }

        return results;
    }
}

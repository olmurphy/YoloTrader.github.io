package edu.baylor.ecs.csi3471.API;

import edu.baylor.ecs.csi3471.dao.GenericDAO;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.presentation.UI.stockPage.FlowPanel;
import edu.baylor.ecs.csi3471.presentation.UI.stockPage.GraphPanel;
import edu.baylor.ecs.csi3471.presentation.UI.stockPage.NewsPanel;
import yahoofinance.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import static java.util.Map.entry;


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
    
    
    
    private static String NEWS_URL = "https://financialmodelingprep.com/api/v3/stock_news?tickers=";
    private static String GENERAL_NEWS_URL = "https://financialmodelingprep.com/api/v3/stock_news?limit=50";
	
	private static String NEWS_API = "&limit=50&apikey=4819ef0b5de9d90ed219e89c51f35d34";
	private static String GENERAL_NEWS_API = "&apikey=4819ef0b5de9d90ed219e89c51f35d34";
	
	
	private final static String NEWS_API_1 = "&limit=50&apikey=4819ef0b5de9d90ed219e89c51f35d34";
	private final static String NEWS_API_2 = "&limit=50&apikey=9f2e6a54a66d7c7961207ce53c05e063";
	
	private final static String GENERAL_NEWS_API_1 = "&apikey=4819ef0b5de9d90ed219e89c51f35d34";
	private final static String GENERAL_NEWS_API_2 = "&apikey=9f2e6a54a66d7c7961207ce53c05e063";
	
	private final static String P_KEY = "4819ef0b5de9d90ed219e89c51f35d34";
	private final static String O_KEY = "9f2e6a54a66d7c7961207ce53c05e063";
	
	private final static String MOVERS_URL = "https://financialmodelingprep.com/api/v3/gainers?apikey=";
	private static String MOVERS_API =  P_KEY;
	
	private final static String LOSERS_URL = "https://financialmodelingprep.com/api/v3/losers?apikey=";
	private static String LOSERS_API =  P_KEY;

    
	
	
    
    
    /**
     * The extractData function is a helper function for parsing data from the 
     * API.
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
     * The getWorkingKey function returns a working API key. 
     * <p>
     * @param Key	The key that is currently being used.
     * <p>
     * @return${@link String} a working API key, or null(if none are working)
     */
    private static String getWorkingKey(String Key) {
    	String rtrn = null;
    	
    	try {
    		//If P's API key is being used.
    		if(Key.contains(P_KEY)) {
    			//Check if O's API key is still good.
    			String pull = GENERAL_NEWS_URL +  GENERAL_NEWS_API_2;
    			URL url2 = new URL(pull);
    			BufferedReader check = new BufferedReader(new InputStreamReader(url2.openStream(), "UTF-8" ));
    			
    			String line = check.readLine();
    			
    			//If O's API key is still good.
    			if(line.contains("ERROR") == false) {
    				//Change to O's API key.
    				rtrn = Key.replace(P_KEY, O_KEY);
    				
    			}
    			
    			check.close();
    		}
    		
    		//Otherwise O's API key is being used.
    		else {
    			
    			//Check if P's API key is still good.
    			String pull = GENERAL_NEWS_URL  + GENERAL_NEWS_API_1;
    			URL url2 = new URL(pull);
    			BufferedReader check = new BufferedReader(new InputStreamReader(url2.openStream(), "UTF-8" ));
    			
    			String line = check.readLine();
    			
    			//If P's API key is still good.
    			if(line.contains("ERROR") == false) {
    				//Change to P's API key.
    				rtrn = Key.replace(O_KEY, P_KEY);
    				
    			}
    			
    			check.close();
    			
    		}
    		
    		
    	
		}catch(UnsupportedEncodingException u) {
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
		
		return rtrn;
    	
		
    }
    
    
    /**
     * The getTopWinners function returns a FlowPanel containing
     * the day's worst performing stocks.
     * <p>
     * @return {@link FlowPanel}
     */
    public static FlowPanel getTopLosers() {
    	FlowPanel feed = new FlowPanel();
		//First get movers info.
		Vector<String> tickers = new Vector<String>();
		Vector<String> percentage = new Vector<String>();
	
		
		int pos = 0;
		
		String pull = LOSERS_URL  + LOSERS_API;
		String tick = "ticker";
		String percent = "changesPercentage";
		String candidate = " ";
		
		
		try {
			URL url = new URL(pull);
	
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
				
			    for (String line; (line = reader.readLine()) != null;) {
			    	
			    	
			    	//If API limit reached.
			    	if(line.contains("Error")) {
			    		
			    		String plausibleKey = getWorkingKey(LOSERS_API);
			    		
			    		//If there is a working key.
			    		if(plausibleKey != null) {
			    			LOSERS_API = plausibleKey;
			    			
			    			//call func again
			    			feed = getTopLosers();
			    		}
			    		
			    		//Otherwise.
			    		else {
			    			YoloTrader.logger.warning("API LIMIT REACHED. 24 HOUR COOLDOWN NEEDED.");
			    		}
			    		
			    
			    	}
			    	
			    	//Otherwise, API limit hasn't been reached.
			    	else {
			    		
			    		
			    		//If image data.
			    		if(line.contains(tick)) {
			    			//consider as candidate.
			    			candidate = extractData(line);
			    			
			    		}
			    		
			    		//else if title data.
			    		else if(line.contains(percent)) {
			    			//must ensure the stock is still up for the day.
			    			String movement = extractData(line);
			    			
			    			//Sanitize.
			    			movement = movement.replace("(", " ");
			    			movement = movement.replace(")", " ");
			    			
			    			//add to percent vector and ticker vector.
			    			if(candidate != " " && movement.contains("-")) {
				    			tickers.add(candidate);
				    			percentage.add(movement);
			    			}
			    			
			    		}
			    		
			    		
			    		
			    	}
			  }//End of for loop.
			  reader.close();
			    
			    
			}//out of inner try block.
			
			
			//At this point the vectors have the required data to construct the TopMovers feed.
			for(int x = 0; x < tickers.size(); x++) {
				JPanel slot = new JPanel();
				slot.setBackground(Color.BLACK);
				slot.setPreferredSize(new Dimension(100,100));
				slot.setLayout(new BoxLayout(slot, BoxLayout.PAGE_AXIS));
				JLabel title = new JLabel();
				title.setBorder(new EmptyBorder(5,0,5,0));
				title.setText(tickers.elementAt(x));
				title.setForeground(Color.RED.darker().darker());
				title.setFont(new Font("Futura", Font.PLAIN, 22));
				JLabel move = new JLabel();
				move.setFont(new Font("Futura", Font.PLAIN, 14));
				move.setText(percentage.elementAt(x));
				move.setVerticalAlignment(JLabel.BOTTOM);
				move.setForeground(Color.RED.brighter().brighter().brighter());
				
				slot.add(title);
				
				slot.add(move);
				feed.addToScroll(slot);
			}
			
			
		}//End of outer try block.
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
		
		
				
		
		return feed;
    	
    }
    
    
    /**
     * The getTopWinners function returns a FlowPanel containing
     * the day's best performing stocks.
     * <p>
     * @return {@link FlowPanel}
     */
    public static FlowPanel getTopWinners() {
    	FlowPanel feed = new FlowPanel();
		//First get movers info.
		Vector<String> tickers = new Vector<String>();
		Vector<String> percentage = new Vector<String>();
	
		
		int pos = 0;
		
		String pull = MOVERS_URL  + MOVERS_API;
		String tick = "ticker";
		String percent = "changesPercentage";
		String candidate = " ";
		
		
		try {
			URL url = new URL(pull);
	
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
				
			    for (String line; (line = reader.readLine()) != null;) {
			    	
			    	
			    	//If API limit reached.
			    	if(line.contains("Error")) {
			    		String plausibleKey = getWorkingKey(MOVERS_API);
			    		
			    		//If there is a working key.
			    		if(plausibleKey != null) {
			    			MOVERS_API = plausibleKey;
			    			
			    			//call func again
			    			feed = getTopWinners();
			    		}
			    		
			    		//Otherwise.
			    		else {
			    			YoloTrader.logger.warning("API LIMIT REACHED. 24 HOUR COOLDOWN NEEDED.");
			    		}
			    		
			    
			    	}
			    	
			    	//Otherwise, API limit hasn't been reached.
			    	else {
			    		
			    		
			    		
			    		//If image data.
			    		if(line.contains(tick)) {
			    			//consider as candidate.
			    			candidate = extractData(line);
			    			
			    		}
			    		
			    		//else if title data.
			    		else if(line.contains(percent)) {
			    			//must ensure the stock is still up for the day.
			    			String movement = extractData(line);
			    			
			    			//Sanitize.
			    			movement = movement.replace("(", " ");
			    			movement = movement.replace(")", " ");
			    			
			    			//add to percent vector and ticker vector.
			    			if(candidate != " " && movement.contains("+")) {
				    			tickers.add(candidate);
				    			percentage.add(movement);
			    			}
			    			
			    		}
			    		
			    		
			    		
			    	}
			  }//End of for loop.
			  reader.close();
			    
			    
			}//out of inner try block.
			
			
			//At this point the vectors have the required data to construct the TopMovers feed.
			for(int x = 0; x < tickers.size(); x++) {
				JPanel slot = new JPanel();
				slot.setBackground(Color.BLACK);
				slot.setPreferredSize(new Dimension(100,100));
				slot.setLayout(new BoxLayout(slot, BoxLayout.PAGE_AXIS));
				JLabel title = new JLabel();
				title.setBorder(new EmptyBorder(5,0,5,0));
				title.setText(tickers.elementAt(x));
				title.setForeground(Color.GREEN.darker().darker());
				title.setFont(new Font("Futura", Font.PLAIN, 22));
				JLabel move = new JLabel();
				move.setFont(new Font("Futura", Font.PLAIN, 14));
				move.setText(percentage.elementAt(x));
				move.setVerticalAlignment(JLabel.BOTTOM);
			
				move.setForeground(Color.GREEN);
				
				slot.add(title);
				
				slot.add(move);
				feed.addToScroll(slot);
			}
			
			
		}//End of outer try block.
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
		
		
				
		
		return feed;
    	
    }
    
    
    
    /**
     * The getGeneralNews function returns a NewsPanel containing general news.
     * <p>
     */
	public static NewsPanel getGeneralNews() {
		NewsPanel feed = null;
		//First get news info.
		Vector<String> imageURLS = new Vector<String>();
		Vector<String> titles = new Vector<String>();
		Vector<String> links = new Vector<String>();
		
		int pos = 0;
		
		String pull = GENERAL_NEWS_URL  + GENERAL_NEWS_API;
		String img = "image";
		String title = "title";
		String link = "url";
		
		try {
			URL url = new URL(pull);
	
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
				
			    for (String line; (line = reader.readLine()) != null;) {
			    	
			    	
			    	//If API limit reached.
			    	if(line.contains("Error")) {
			    		String plausibleKey = getWorkingKey(GENERAL_NEWS_API);
			    		
			    		//If there is a working key.
			    		if(plausibleKey != null) {
			    			GENERAL_NEWS_API = plausibleKey;
			    			
			    			//call func again
			    			feed = getGeneralNews();
			    		}
			    		
			    		//Otherwise.
			    		else {
			    			YoloTrader.logger.warning("API LIMIT REACHED. 24 HOUR COOLDOWN NEEDED.");
			    		}
			    		
			    
			    	}
			    	
			    	//Otherwise, API limit hasn't been reached.
			    	else {
			    		
			    		
			    		
			    		//If image data.
			    		if(line.contains(img)) {
			    			//add to image vector
			    			imageURLS.add(extractData(line));
			    			
			    		}
			    		
			    		//else if title data.
			    		else if(line.contains(title)) {
			    			//add to data vector
			    			titles.add(extractData(line));
			    			
			    		}
			    		
			    		//else if article link data.
			    		else if(line.contains(link)) {
			    			links.add(extractData(line));
			    			
			    		}
			    		
			    		
			    	}
			  }//End of for loop.
			  reader.close();
			    
			    
			}//out of inner try block.
			
			
			//At this point the vectors have the required data to construct the NewsPane.
			feed = constructNewsPanel(imageURLS, titles, links);
			
			
		}//End of outer try block.
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
		
		
				
		
		return feed;
	}
    
    
    
    
    
    /**
     * The constructNewsPanel function is a helper function for
     * the getNewsPanel function.
     * <p>
     * @param images	${@link Vector} 
     * @param titles	${@link Vector} 
     * @param links		${@link Vector} 
     */
    private static NewsPanel constructNewsPanel( Vector<String> images,  Vector<String> titles,  Vector<String> links) {
    
    	NewsPanel feed = new NewsPanel();
    	
    	
    	//Make a map of titles to links.
    	Map<String, String> hyperLink = new HashMap<String,String>();
    	for(int x = 0; x < titles.size(); x++) {
    		hyperLink.put(titles.elementAt(x), links.elementAt(x));
    	}
    	
    	try {
    		final int run = images.size();
	    	for(int x = 0; x < run; x++) {
	    		JPanel article = new JPanel();
	    		
	    		//Prepare the title
	    		JLabel title = new JLabel(titles.firstElement());
	    		title.setForeground(Color.WHITE);
	    	
	    		title.setFont(new Font("Futura", Font.PLAIN, 16));
	    		
	    		title.addMouseListener(new MouseAdapter() {
	    			
	    		   @Override
	    		   public void mouseClicked(MouseEvent e) {
	    		    	
	    		    	try {
	    		    		
	    		    		
	    		    		URL link = new URL(hyperLink.get(title.getText()));
	    		    		
	    		    		
	    		    		
							Desktop.getDesktop().browse(link.toURI());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	    		    }
	    		 
	    		    @Override
	    		    public void mouseEntered(MouseEvent e) {
	    		        // the mouse has entered the label, the title should change to blue.
	    		    	
	    		    	
	    		    	title.setForeground(Color.BLUE);
	    		    	title.validate();
	    		    	

	    		    }
	    		 
	    		    @Override
	    		    public void mouseExited(MouseEvent e) {
	    		        // the mouse has exited the label, title should turn back to black.
	    		    	
	    		    	title.setForeground(Color.WHITE);
	    		    	title.validate();
	    		    }
	    		});
	    		
	    		
	    		//Prepare the image icon.
	    		URL url = new URL(images.firstElement());
	            BufferedImage image = ImageIO.read(url);
	            
	    		ImageIcon picture = new ImageIcon(image);
	    	
	    		JLabel pic = new JLabel(picture);
	    		
	    		
	    		//Add to panel.
	    		//article.setSize(100, 100);
	    		JPanel slot = new JPanel();
	    		//slot.setLayout();
	    		slot.setBackground(Color.BLACK);
	    		slot.add(pic, BorderLayout.LINE_START);
	    		//slot.add(title, BorderLayout.CENTER);
	    		
	    		//article.setBackground(Color.BLACK);
	    		
	    		//Add to NewsPanel.
	    		feed.addToScroll(slot);
	    		
	    		if(titles.size() > 0) {
		    		titles.remove(0);
		    		images.remove(0);
		    		links.remove(0);
	    		}
	    		
	    		
	    		
	    		
	    		
	    		
	    	}//End of for loop.
    	}catch(UnsupportedEncodingException u) {
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
    	
    	
    	
    	
    	
    	
		
    	
    	return feed;
    }
    
    
    
    /**
     * The getNewsPanel function returns the NewsPanel for equity.
     * <p>
     * @param equity	${@link yahoofinance.Stock} 
     */
	public static NewsPanel getNewsPanel(yahoofinance.Stock equity) {
		NewsPanel feed = null;
		//First get news info.
		Vector<String> imageURLS = new Vector<String>();
		Vector<String> titles = new Vector<String>();
		Vector<String> links = new Vector<String>();
		
		int pos = 0;
		
		String pull = NEWS_URL + equity.getSymbol() + NEWS_API;
		String img = "image";
		String title = "title";
		String link = "url";
		
		try {
			URL url = new URL(pull);
	
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
				
			    for (String line; (line = reader.readLine()) != null;) {
			    	
			    	
			    	//If API limit reached.
			    	if(line.contains("Error")) {
			    		
			    		String plausibleKey = getWorkingKey(NEWS_API);
			    		
			    		//If there is a working key.
			    		if(plausibleKey != null) {
			    			NEWS_API = plausibleKey;
			    			
			    			//call func again
			    			feed = getNewsPanel(equity);
			    		}
			    		
			    		//Otherwise.
			    		else {
			    			YoloTrader.logger.warning("API LIMIT REACHED. 24 HOUR COOLDOWN NEEDED.");
			    		}
			    		
			    		
			    	}
	    	    	
			    	
			    	//Otherwise, API limit hasn't been reached.
			    	else {
			    		
			    		//If image data.
			    		if(line.contains(img)) {
			    			//add to image vector
			    			imageURLS.add(extractData(line));
			    			
			    		}
			    		
			    		//else if title data.
			    		else if(line.contains(title)) {
			    			//add to data vector
			    			titles.add(extractData(line));
			    			
			    		}
			    		
			    		//else if article link data.
			    		else if(line.contains(link)) {
			    			links.add(extractData(line));
			    			
			    		}
			    		
			    		
			    	}
			  }//End of for loop.
			  reader.close();
			    
			    
			}//out of inner try block.
			
			
			//At this point the vectors have the required data to construct the NewsPane.
			feed = constructNewsPanel(imageURLS, titles, links);
			
			
		}//End of outer try block.
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
		
		//Want a scrollViewPane that has multiple panels, each panel
		//contains a image, and title(that is a hyperlink to the news article).
		
				
		
		return feed;
	}
    
    
    /**
     * The extractPrice function is used to parse price data from the API.
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
    	
    		

		Map<String,Integer> map = Map.ofEntries(
				entry("09:30:00", 0), entry("10:00:00", 1), entry("10:30:00",2 ),
				entry("11:00:00",3 ), entry("11:30:00",4 ), entry("12:00:00",5 ),
				entry("12:30:00",6 ), entry("13:00:00",7 ), entry("13:30:00",8 ),
				entry("14:00:00",9 ), entry("14:30:00",10 ), entry("15:00:00",11 ),
				entry("15:30:00",12 ), entry("16:00:00",13 ));

		return map.getOrDefault(time, -1);
    	
    	
    
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
	    	    		String plausibleKey = getWorkingKey(GRAPH_API_URL);
			    		
			    		//If there is a working key.
			    		if(plausibleKey != null) {
			    			GRAPH_API_URL = plausibleKey;
			    			
			    			//call func again
			    			data = getGraphData(equity);
			    		}
			    		
			    		//Otherwise.
			    		else {
			    			YoloTrader.logger.warning("API LIMIT REACHED. 24 HOUR COOLDOWN NEEDED.");
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
	    	    reader.close();
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

        yahoofinance.Stock stock = null;

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
                	if(line.contains("Error")) {
                		String plausibleKey = getWorkingKey(SEARCH_API_URL);
			    		
			    		//If there is a working key.
			    		if(plausibleKey != null) {
			    			SEARCH_API_URL = plausibleKey;
			    			
			    			//call func again
			    			results = pullUp(query);
			    		}
			    		
			    		//Otherwise.
			    		else {
			    			YoloTrader.logger.warning("API LIMIT REACHED. 24 HOUR COOLDOWN NEEDED.");
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
                reader.close();
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

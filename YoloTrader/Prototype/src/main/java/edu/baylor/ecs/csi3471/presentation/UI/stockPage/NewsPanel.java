package edu.baylor.ecs.csi3471.presentation.UI.stockPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import edu.baylor.ecs.csi3471.main.YoloTrader;
import yahoofinance.Stock;


/**
 * The NewsPanel class is responsible for displaying
 * related stock news for the day.
 * <p>
 * @author      Prince Kalu
 */
public class NewsPanel {
	
	private JScrollPane newsFeed;
	private JPanel view;
	
	
	
	
	
	/**
     * Constructor.
     */
	public NewsPanel(){
		view = new JPanel();
		view.setLayout(new BoxLayout(view, BoxLayout.PAGE_AXIS));
		newsFeed = new JScrollPane(view);
		newsFeed.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		newsFeed.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		
		
	}
	
	
	/**
     * The getNewsScrollPane function returns a JPanel containing the news feed.
     * <p>
     * @return ${@link JScrollPane}
     */
	public JScrollPane getNewsScrollPane() {
		return newsFeed;
	}
	
	
	/**
     * The getJPanel function returns a JPanel containing newsFeed.
     * <p>
     * @return ${@link JPanel}
     */
	public JPanel getJPanel() {
		JPanel window = new JPanel();
		window.add(newsFeed);
		return window;
	}
	
	
	
	/**
     * The addToScroll function adds x to the scrollView.
     * <p>
     * @param x ${@link Component}
     */
	public void addToScroll(Component x) {
		view.add(x); 
		
	}
	
}

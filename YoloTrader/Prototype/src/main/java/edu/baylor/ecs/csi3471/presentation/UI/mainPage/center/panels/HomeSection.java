package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

import edu.baylor.ecs.csi3471.API.StockUtil;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.presentation.UI.stockPage.GraphPanel;

public class HomeSection {

    public static JPanel homeMainPanel;

    public static JScrollPane getHomeMainPanel() {
    	
    	JScrollPane feed = new JScrollPane(homeMainPanel);

		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.WHITE));
		UIManager.put("ScrollBar.track", new ColorUIResource(Color.BLACK));
		UIManager.put("ScrollBar.width", 5);
		
		feed.getVerticalScrollBar().setUI(new BasicScrollBarUI() );
		feed.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
		feed.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		feed.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 

        return feed;
    }

    public static void setHomeMainPanel() {
    	YoloTrader.logger.info("Preparing HomePanel..");
    	
        HomeSection.homeMainPanel = new JPanel();
        homeMainPanel.setLayout(new BoxLayout(homeMainPanel, BoxLayout.Y_AXIS));
        //homeMainPanel.setPreferredSize(new Dimension(1000, 3000));
        HomeSection.homeMainPanel.setBackground(Color.BLACK);

        //Set up the top winners
        HomeSection.homeMainPanel.setBackground(Color.BLACK);
        JLabel todaysWins = new JLabel();
        todaysWins.setForeground(Color.WHITE);
        todaysWins.setText("[ Today's Best Performing Stocks ]");
        todaysWins.setFont(new Font("Futura", Font.PLAIN, 22));
        todaysWins.setBorder(new EmptyBorder(40, 0, 5, 0));
        
        JScrollPane winners = StockUtil.getTopWinners().getFeed();

        JPanel green = new JPanel();
        green.setLayout(new BoxLayout(green, BoxLayout.Y_AXIS));
        green.setBackground(Color.BLACK);
        green.setBorder(new EmptyBorder(5,50,50,50));
       
        JPanel temp1 = new JPanel();
        temp1.setLayout(new FlowLayout(FlowLayout.LEFT));
        temp1.setPreferredSize(new Dimension(900,120));
        temp1.add(todaysWins);
        temp1.setBackground(Color.BLACK);
        
        green.add(temp1);
        green.add(winners);

        //Set up the top losers
        JLabel todaysloss = new JLabel();
        todaysloss.setForeground(Color.WHITE);
        todaysloss.setText("[ Today's Worst Performing Stocks ]");
        todaysloss.setFont(new Font("Futura", Font.PLAIN, 22));
        todaysloss.setBorder(new EmptyBorder(40, 0, 20, 0));
        JScrollPane losers = StockUtil.getTopLosers().getFeed();
        
        JPanel temp = new JPanel();
        temp.setLayout(new FlowLayout(FlowLayout.RIGHT));
        temp.setPreferredSize(new Dimension(900,120));
        temp.add(todaysloss);
        temp.setBackground(Color.BLACK);
        
        
        JPanel red = new JPanel();
        red.setLayout(new BoxLayout(red, BoxLayout.Y_AXIS));
        red.setBackground(Color.BLACK);
        red.setBorder(new EmptyBorder(0,50,50,50));
        
        red.add(temp);
        red.add(losers);

        //Set up the newsFeed.
		JScrollPane news = StockUtil.getGeneralNews().getNewsScrollPane();
		JPanel newsfeed = new JPanel();
		newsfeed.setPreferredSize(new Dimension(1150, 400));
		newsfeed.setBackground(Color.BLACK);
		newsfeed.setBorder(new EmptyBorder(0,50,90,50));
		newsfeed.setLayout(new BoxLayout(newsfeed, BoxLayout.Y_AXIS));
		newsfeed.add(news);
		JPanel indexes = new JPanel();
		indexes.setPreferredSize(new Dimension(1150, 720));
		indexes.setBorder(new EmptyBorder(0,50,50,50));
		indexes.setBackground(Color.BLACK);
		
		//Set up indexes
		try {
			GraphPanel dow = StockUtil.getGraph(yahoofinance.YahooFinance.get("DIA"));
			dow.setBorder(new EmptyBorder(0, 0, 0, 100));
			dow.setPreferredSize(new Dimension(400, 400));
			GraphPanel sp = StockUtil.getGraph(yahoofinance.YahooFinance.get("NDAQ"));
			sp.setBorder(new EmptyBorder(0, 0, 0, 0));
			sp.setPreferredSize(new Dimension(400, 400));
			
			indexes.setBorder(new EmptyBorder(0,50,50,50));
			indexes.add(dow, BorderLayout.EAST);
			
			indexes.add(sp, BorderLayout.WEST);
			
		} catch (IOException e) {
			//no need to do anything. stockUtil will take care of exceptions and logging them.
		}
			
        //Add components
        HomeSection.homeMainPanel.add(green);
        HomeSection.homeMainPanel.add(red);
        HomeSection.homeMainPanel.add(indexes);
        HomeSection.homeMainPanel.add(newsfeed);
    }
}

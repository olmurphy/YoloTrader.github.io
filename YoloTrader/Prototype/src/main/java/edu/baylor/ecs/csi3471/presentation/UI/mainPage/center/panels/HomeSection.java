package edu.baylor.ecs.csi3471.presentation.ui.mainPage.center.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

import edu.baylor.ecs.csi3471.api.StockUtil;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.presentation.ui.stockPage.GraphPanel;

/**
 * @author Prince Kalu
 */
public class HomeSection {

    public static JPanel homeMainPanel;

    public static JScrollPane getHomeMainPanel() {
    	
    	JScrollPane feed = new JScrollPane(homeMainPanel);

		UIManager.put("ScrollBar.thumb", new ColorUIResource(CenterPanelController.centerPanelColor));
		UIManager.put("ScrollBar.track", new ColorUIResource(CenterPanelController.centerPanelColor));
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
        HomeSection.homeMainPanel.setBackground(CenterPanelController.centerPanelColor);

        homeMainPanel.setPreferredSize(new Dimension(1000, 2000));
        HomeSection.homeMainPanel.setBackground(CenterPanelController.centerPanelColor);

        //Set up the top winners
        HomeSection.homeMainPanel.setBackground(CenterPanelController.centerPanelColor);
        JLabel todaysWins = new JLabel();
        todaysWins.setForeground(Color.WHITE);
        todaysWins.setText("[ Today's Best Performing Stocks ]");
        todaysWins.setFont(new Font("Futura", Font.PLAIN, 22));

        JScrollPane winners = StockUtil.getTopWinners().getFeed();
        
        JPanel green = new JPanel();
        green.setLayout(new BoxLayout(green, BoxLayout.Y_AXIS));

        green.setBackground(CenterPanelController.centerPanelColor);
        green.setBorder(new EmptyBorder(5,50,50,50));

        green.setBackground(Color.BLACK);
        green.setBorder(new EmptyBorder(40,50,80,50));

        JPanel temp1 = new JPanel();
        temp1.setSize(new Dimension(900,20));
        temp1.setLayout(new FlowLayout(FlowLayout.LEFT));
        temp1.add(todaysWins);
        temp1.setBackground(CenterPanelController.centerPanelColor);
        
        green.add(temp1);
        green.add(winners);
        green.setSize(new Dimension(900, 140));
        
        //Set up the top losers
        JLabel todaysloss = new JLabel();
        todaysloss.setForeground(Color.WHITE);
        todaysloss.setText("[ Today's Worst Performing Stocks ]");
        todaysloss.setFont(new Font("Futura", Font.PLAIN, 22));
       
        JScrollPane losers = StockUtil.getTopLosers().getFeed();
        
        JPanel temp = new JPanel();
        temp.setLayout(new FlowLayout(FlowLayout.RIGHT));
        temp.setPreferredSize(new Dimension(900,10));
        temp.add(todaysloss);
        temp.setBackground(Color.BLACK);

        JPanel red = new JPanel();
        red.setLayout(new BoxLayout(red, BoxLayout.Y_AXIS));
        red.setBackground(Color.BLACK);
        red.setBorder(new EmptyBorder(0,50,100,50));
        
        red.add(temp);
        red.add(losers);
        
        //Set up the newsFeed.
        JLabel newstitle = new JLabel();
        newstitle.setText("[ Trending News ]");
        newstitle.setForeground(Color.WHITE);
	    newstitle.setFont(new Font("Futura", Font.PLAIN, 35));
	    newstitle.setBorder(new EmptyBorder(0, 0, 40, 0));
		JScrollPane news = StockUtil.getGeneralNews().getNewsScrollPane();
		JPanel newsfeed = new JPanel();

		newsfeed.setPreferredSize(new Dimension(1150, 400));
		newsfeed.setBackground(CenterPanelController.centerPanelColor);
		newsfeed.setBorder(new EmptyBorder(0,50,90,50));

		newsfeed.setPreferredSize(new Dimension(1150, 500));
		newsfeed.setBackground(CenterPanelController.centerPanelColor);
		newsfeed.setBorder(new EmptyBorder(150,50,90,50));

		newsfeed.setLayout(new BoxLayout(newsfeed, BoxLayout.Y_AXIS));
		newsfeed.add(newstitle);
		newsfeed.add(news);

		//Set up indicators
		JPanel indicators = new JPanel();
		indicators.setLayout(new BoxLayout(indicators, BoxLayout.Y_AXIS));
		indicators.setPreferredSize(new Dimension(1150, 500));
		indicators.setBackground(CenterPanelController.centerPanelColor);
		
		JPanel indicateTitle = new JPanel();
		indicateTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		indicateTitle.setBackground(CenterPanelController.centerPanelColor);
		indicateTitle.setPreferredSize(new Dimension(1150, 160));
		
		JLabel indicate = new JLabel();
		indicate.setText("[ Market Indicators ]");
		indicate.setForeground(Color.WHITE);
	    indicate.setFont(new Font("Futura", Font.PLAIN, 50));
	    indicate.setBorder(new EmptyBorder(50, 0, 0, 0));
	    indicateTitle.add(indicate);
	    
	    JPanel indexes = new JPanel();
		indexes.setPreferredSize(new Dimension(1000, 720));
		indexes.setBorder(new EmptyBorder(0,0,50,0));
		indexes.setBackground(CenterPanelController.centerPanelColor);
		indexes.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JPanel dowJones = new JPanel();
		dowJones.setPreferredSize(new Dimension(500, 400));
		dowJones.setBackground(Color.BLACK);
		dowJones.setLayout(new BoxLayout(dowJones, BoxLayout.Y_AXIS));

		JPanel nasdaq = new JPanel();
		nasdaq.setBackground(Color.BLACK);
		nasdaq.setPreferredSize(new Dimension(500, 400));
		nasdaq.setLayout(new BoxLayout(nasdaq, BoxLayout.Y_AXIS));
		
		JPanel space = new JPanel();
		space.setBackground(Color.BLACK);
		space.setPreferredSize(new Dimension(140,400));
		JPanel space2 = new JPanel();
		space2.setBackground(Color.BLACK);
		space2.setPreferredSize(new Dimension(50,400));

		try {
			
			indicators.add(indicateTitle);


			yahoofinance.Stock dia = yahoofinance.YahooFinance.get("DIA");
			yahoofinance.Stock ndaq = yahoofinance.YahooFinance.get("NDAQ");
			
			GraphPanel dow = StockUtil.getGraph(dia);
			
			dow.setPreferredSize(new Dimension(300, 300));
			
			JLabel dowtitle = new JLabel();
			dowtitle.setText("[ "+ dia.getSymbol() +" ]");
			dowtitle.setForeground(dow.getLineColor());
			dowtitle.setFont(new Font("Futura", Font.PLAIN, 22));
			
			dowJones.add(dowtitle);
			dowJones.add(dow);

			GraphPanel sp = StockUtil.getGraph(ndaq);
			
			sp.setPreferredSize(new Dimension(300, 300));

			JLabel ndaqtitle = new JLabel();
			ndaqtitle.setText("[ "+ ndaq.getSymbol() +" ]");
			ndaqtitle.setForeground(sp.getLineColor());
			ndaqtitle.setFont(new Font("Futura", Font.PLAIN, 22));
			//nasdaq.setBorder(new EmptyBorder(100,0,0,100));
			nasdaq.add(ndaqtitle);
			nasdaq.add(sp);

			indexes.setBorder(new EmptyBorder(40,0,50,0));
			indexes.add(space2);
			indexes.add(nasdaq);
			indexes.add(space);
			indexes.add(dowJones);

			indicators.add(indexes);

		} catch (IOException ignored) { }

		//Add components	
		HomeSection.homeMainPanel.add(green);
		HomeSection.homeMainPanel.add(red);
		HomeSection.homeMainPanel.add(indicators);
		HomeSection.homeMainPanel.add(newsfeed);
    }
}

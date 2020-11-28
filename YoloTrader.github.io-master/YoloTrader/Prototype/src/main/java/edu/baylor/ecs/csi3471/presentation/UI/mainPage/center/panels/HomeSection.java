package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import edu.baylor.ecs.csi3471.API.StockUtil;
import edu.baylor.ecs.csi3471.presentation.UI.stockPage.NewsPanel;

public class HomeSection {

    public static JPanel homeMainPanel;

    public static JPanel getHomeMainPanel() {
        return homeMainPanel;
    }

    public static void setHomeMainPanel() {
        HomeSection.homeMainPanel = new JPanel(new FlowLayout());

        //Set up the top winners
        HomeSection.homeMainPanel.setBackground(Color.BLACK);
        JLabel todaysWins = new JLabel();
        todaysWins.setForeground(Color.WHITE);
       
        todaysWins.setText("Today's Best Performing Stocks");
        todaysWins.setFont(new Font("Futura", Font.PLAIN, 22));
        todaysWins.setBorder(new EmptyBorder(40, 0, 20, 0));
        JScrollPane winners = StockUtil.getTopWinners().getFeed();
        winners.setPreferredSize(new Dimension(1150, 100));
        
        JPanel green = new JPanel();
        green.setLayout(new BoxLayout(green, BoxLayout.PAGE_AXIS));
        green.setBackground(Color.BLACK);
        
        green.add(todaysWins, BorderLayout.NORTH);
        green.add(winners, BorderLayout.SOUTH);
        
        
        
        
        
        //Set up the top losers
        JLabel todaysloss = new JLabel();
        todaysloss.setForeground(Color.WHITE);
        todaysloss.setText("Today's Worst Performing Stocks");
        todaysloss.setFont(new Font("Futura", Font.PLAIN, 22));
        todaysloss.setBorder(new EmptyBorder(40, 0, 20, 0));
        JScrollPane losers = StockUtil.getTopLosers().getFeed();
        losers.setPreferredSize(new Dimension(1150, 100));
        JPanel temp = new JPanel();
        temp.setLayout(new FlowLayout(FlowLayout.RIGHT));
        temp.add(todaysloss);
        temp.setBackground(Color.BLACK);
        
        
        JPanel red = new JPanel();
        red.setLayout(new BoxLayout(red, BoxLayout.PAGE_AXIS));
        red.setBackground(Color.BLACK);
        
        red.add(temp);
        red.add(losers);
        red.setBorder(new EmptyBorder(15,0,15,0));
        
        
        
        //Set up the newsFeed.
       
		NewsPanel news = StockUtil.getGeneralNews();
		
		HomeSection.homeMainPanel.add(green, BorderLayout.NORTH);
		HomeSection.homeMainPanel.add(red, BorderLayout.CENTER);
      HomeSection.homeMainPanel.add(news.getJPanel(), BorderLayout.SOUTH);
        
        
        
        
        
        
        
        
        
       
    }
}

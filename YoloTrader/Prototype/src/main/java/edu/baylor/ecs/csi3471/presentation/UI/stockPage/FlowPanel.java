package edu.baylor.ecs.csi3471.presentation.UI.stockPage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * The FlowPanel class is responsible for displaying
 * Components in a horizontal flow.
 * <p>
 * @author      Prince Kalu
 */
public class FlowPanel {

	
	private JScrollPane feed;
	private JPanel view;
	
	
	
	
	/**
     * Constructor.
     * 
     */
	public FlowPanel(){
		view = new JPanel();
		view.setBackground(Color.BLACK);
		view.setLayout(new FlowLayout());
		feed = new JScrollPane(view);
		feed.setBackground(Color.BLACK);
		feed.setPreferredSize(new Dimension(900, 120));
		
		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.WHITE));
		UIManager.put("ScrollBar.track", new ColorUIResource(Color.BLACK));
		UIManager.put("ScrollBar.width", 5);
		
		feed.getVerticalScrollBar().setUI(new BasicScrollBarUI() );
		feed.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
		feed.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		feed.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); 
		
		
	}

	
	/**
     * The getFeed function returns a JPanel containing the feed.
     * <p>
     * @return ${@link JPanel}
     */
	public JScrollPane getFeed() {
		return feed;
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

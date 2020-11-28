package edu.baylor.ecs.csi3471.presentation.UI.stockPage;

import java.awt.Component;
import java.awt.FlowLayout;


import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
     */
	public FlowPanel(){
		view = new JPanel();
		view.setLayout(new FlowLayout());
		feed = new JScrollPane(view);
		feed.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		feed.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		
		
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

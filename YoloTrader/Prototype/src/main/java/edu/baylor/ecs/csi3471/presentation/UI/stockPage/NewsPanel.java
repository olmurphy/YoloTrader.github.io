package edu.baylor.ecs.csi3471.presentation.UI.stockPage;
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
		
		view.setBackground(Color.BLACK);
		newsFeed = new JScrollPane(view);
		
		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.WHITE));
		UIManager.put("ScrollBar.track", new ColorUIResource(Color.BLACK));
		UIManager.put("ScrollBar.width", 5);
		
		newsFeed.getVerticalScrollBar().setUI(new BasicScrollBarUI() );
		newsFeed.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
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
		//view.validate();
		
	}
	
}

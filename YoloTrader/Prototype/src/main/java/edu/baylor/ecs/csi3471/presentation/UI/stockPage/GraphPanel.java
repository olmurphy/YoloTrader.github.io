

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 * The GraphPanel class is responsible for displaying
 * a graph for tracking daily stock movement.
 * <p>
 * @author      Prince Kalu
 */
public class GraphPanel extends JPanel {
	
    private int width = 800;
    private int height = 400;
    private int padding = 30;
    private int labelPadding = 30;
    private JFrame frame;
    private Color lineColor = new Color(44, 102, 230, 180);
    private Color pointColor = Color.MAGENTA.darker().darker();
    private Color gridColor = Color.BLACK;
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    private int pointWidth = 4;
    private int numberYDivisions = 5;
    private Vector<Double> prices;

    /**
     * Constructor.
     * <p>
     * @param costs		${@link List<Double>} : the price values for the day.
     * @param title		${@link String} : the title for the new window.
     */
    public GraphPanel(Vector<Double> costs, String title) {
        this.prices = costs;
        frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(900, 700));
        this.setBackground(Color.BLACK);
    }
    
    /**
     * the setLineColor function changes the preset line color to paint.
     * <p>
     * @param paint		${@link Color} 
     */
    public void setLineColor(Color paint) { lineColor = paint; }

    /**
     * the getLineColor function returns the current line color.
     * <p>
     */
    public Color getLineColor() { return lineColor; }
    
    /**
     * the changeLineColor function changes the preset line color to paint,
     * and visually updates the color change.
     * <p>
     * @param paint		${@link Color} 
     */
    public void changeLineColor(Color paint) {
    	this.setLineColor(paint);
    	this.paint(this.getGraphics());
    	this.validate();
    	frame.validate();
    	frame.repaint();
    }

    /**
     * the paintComponent function draws the graph onto g.
     * <p>
     * @param g		${@link Graphics} 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double xScale = ((double) getWidth() - (2 * padding) - labelPadding) / (prices.size() - 1);
        double yScale = ((double) getHeight() - 2 * padding - labelPadding) / (getMaxPrice() - getMinPrice());

        List<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            int x1 = (int) (i * xScale + padding + labelPadding);
            int y1 = (int) ((getMaxPrice() - prices.get(i)) * yScale + padding);
            graphPoints.add(new Point(x1, y1));
        }

        // draw black background
        g2.setColor(Color.BLACK);
        g2.fillRect(padding + labelPadding, padding, getWidth() - (2 * padding) - labelPadding, getHeight() - 2 * padding - labelPadding);

        // create hatch marks and grid lines for y axis.
        for (int i = 0; i < numberYDivisions + 1; i++) {
            int x0 = padding + labelPadding;
            int x1 = pointWidth + padding + labelPadding;
            int y0 = getHeight() - ((i * (getHeight() - padding * 2 - labelPadding)) / numberYDivisions + padding + labelPadding);
            int y1 = y0;
            if (prices.size() > 0) {
                g2.setColor(gridColor);
                g2.drawLine(padding + labelPadding + 1 + pointWidth, y0, getWidth() - padding, y1);
                g2.setColor(Color.WHITE);
                String yLabel = ((int) ((getMinPrice() + (getMaxPrice() - getMinPrice()) * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
                FontMetrics metrics = g2.getFontMetrics();
                int labelWidth = metrics.stringWidth(yLabel);
                g2.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 32 + padding);
            }
            g2.drawLine(x0, y0, x1, y1);
        }
        int time = 8;
 
        boolean everyother = true;
        // and for x axis
        for (int i = 0; i < prices.size(); i++) {
            if (prices.size() > 1) {
                int x0 = i * (getWidth() - padding * 2 - labelPadding) / (prices.size() - 1) + padding + labelPadding;
                int y0 = getHeight() - padding ;
                int y1 = y0 - pointWidth;
                if ((i % ((int) ((prices.size() / 20.0)) + 1)) == 0) {
                    g2.setColor(gridColor);
                    g2.drawLine(x0, getHeight() - padding - labelPadding - 1 - pointWidth, x0, padding);
                    g2.setColor(Color.WHITE);
                    String xLabel = time + ":30";
                    FontMetrics metrics = g2.getFontMetrics();
                    int labelWidth = metrics.stringWidth(xLabel);
                    if(time < 23) {
                    	if(everyother) {
                    		g2.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);
                    		everyother = false;
                    		time++;
                    		
                    	}
                    	else {
                    		everyother = true;
                    	}
                    }
                }
                g2.drawLine(x0, y0, x0, y1);
            }
        }

        // create x and y axes 
        g2.drawLine(padding + labelPadding, getHeight() - padding , padding + labelPadding, padding);
        g2.drawLine(padding + labelPadding, getHeight() - (padding), getWidth() - padding, getHeight() - (padding));

        Stroke oldStroke = g2.getStroke();
        g2.setColor(lineColor);
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y + padding;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y + padding;

            g2.drawLine(x1, y1, x2, y2);
        }

       /* g2.setStroke(oldStroke);
        g2.setColor(lineColor);
        for (Point graphPoint : graphPoints) {
            int x = graphPoint.x - pointWidth / 2;
            int y = graphPoint.y - pointWidth / 2 + padding;
            int ovalW = pointWidth;
            int ovalH = pointWidth;
            g2.fillOval(x, y, ovalW, ovalH);
        }*/
    }

    /**
     * the getMinPrice function returns the lowest price of the day.
     * <p>
     * @return	${@link Double}
     */
    private double getMinPrice() {
        double minPrice = Double.MAX_VALUE;

        for (Double price : prices) {
            minPrice = Math.min(minPrice, price);
        }
        return minPrice;
    }

    /**
     * the getMaxPrice function returns the highest price of the day.
     * <p>
     * @return	${@link Double}
     */
    private double getMaxPrice() {
        double maxPrice = Double.MIN_VALUE;
        for (Double price : prices) {
            maxPrice = Math.max(maxPrice, price);
        }
        return maxPrice;
    }

    /**
     * the setPrices function sets the values for the y values to costs.
     * <p>
     * @param costs	
     */
    public void setPrices(Vector<Double> costs) {
        this.prices = costs;
        this.revalidate();
        this.repaint();
    }

    /**
     * the getPrices function sets the y values to costs.
     * <p>
     */
    public Vector<Double> getPrices() { return prices; }

    /**
     * the getJrame function returns the JFrame object housing the 
     * GraphPanel.
     * <p>
     */
    public JFrame getJFrame() { return frame; }
    
    /**
     * the createAndShowGUI launches a new JFrame containing the
     * GraphPanel.
     * 
     * <p>
     */
    public void createAndShowGui() {
        this.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
    
   

package view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The program will display top five automobiles using this icon as a graphic
 * The icon contains relevant data to the vehicle, formatted in the desired
 * fashion; the data are given from the model.
 * 
 * @author Vyome Kishore
 * @author Nolan Slade
 * @author Areeb Malik
 * @version 3.0
 */
public class ResultIcon {
	private JLabel MM;//make model
	private JLabel FC;//fuel consumption label
	private JLabel FC1;//fuel consumption value
	private JLabel PA;//fuel cost label
	private JLabel PA1;//fuel cost value
	private JLabel CS;//consumer satisfaction label	
	private JLabel CS1;//consumer satisfaction value
	private String makeModelsub;//substring for make model for longer vehicle names
	private boolean isLong = false;//boolean if model name is long

	/**
	 * Takes four string inputs and generates an icon for the vehicle to be
	 * displayed on UI
	 * 
	 * @param p The JPanel we are utilizing
	 * @param makeModel The vehicle's make and model
	 * @param fuelConsumption The vehicles L/100km fuel consumption (according to driver type)
	 * @param fuelSpending The predicted annual fuel spending (according to region, fuel type and driver type)
	 * @param consumerSatisfaction The computed satisfaction with the vehicle's manufacturer
	 * @param x The x coordinate to offset
	 * @param y The y coordinate to offset
	 * 
	 * @return The icon corresponding to the given information
	 */
	public ResultIcon(final JPanel p, final String makeModel, String fuelConsumption, String fuelSpending,
			String consumerSatisfaction, int x, int y) {

		if (makeModel.length() > 17) {
			makeModelsub = makeModel.substring(0, 15) + "...";
			isLong = true;
		} else {
			makeModelsub = makeModel;
		}

		// Make and model text
		MM = new JLabel(makeModelsub);
		MM.setFont(new Font("Serif", Font.BOLD, 15));
		MM.setBounds(35 + x, 0 + y, 150, 30);
		p.add(MM);

		if (isLong) {
			MM.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					JOptionPane.showMessageDialog(p.getParent(), makeModel);
				}
			});
		}

		// Fuel consumption text
		FC = new JLabel("Fuel Consumption:");
		FC.setFont(new Font("Serif", Font.BOLD, 17));
		FC.setBounds(40 + x, 50 + y, 250, 30);
		p.add(FC);

		// Fuel consumption in L/100km
		FC1 = new JLabel(fuelConsumption + " L/100km");
		FC1.setFont(new Font("Serif", Font.PLAIN, 15));
		FC1.setBounds(65 + x, 75 + y, 250, 30);
		p.add(FC1);

		// Fuel spending text
		PA = new JLabel("Annual Fuel Cost:");
		PA.setFont(new Font("Serif", Font.BOLD, 17));
		PA.setBounds(40 + x, 150 + y, 250, 30);
		p.add(PA);

		// Fuel spending in $
		PA1 = new JLabel("$ " + fuelSpending);
		PA1.setFont(new Font("Serif", Font.PLAIN, 15));
		PA1.setBounds(70 + x, 175 + y, 250, 30);
		p.add(PA1);

		// Consumer satisfaction text
		CS = new JLabel("Consumer Satisfaction:");
		CS.setFont(new Font("Serif", Font.BOLD, 17));
		CS.setBounds(22 + x, 250 + y, 250, 30);
		p.add(CS);

		// Consumer satisfaction %
		CS1 = new JLabel(consumerSatisfaction + " %");
		CS1.setFont(new Font("Serif", Font.PLAIN, 15));
		CS1.setBounds(80 + x, 275 + y, 250, 30);
		p.add(CS1);
	}

	/**
	 * Used to remove a given icon from the panel, so that we may restart the
	 * computation
	 * 
	 * @param p The associated JPanel to erase from
	 */
	public void erase(JPanel p) {
		p.remove(MM);
		p.remove(FC);
		p.remove(FC1);
		p.remove(PA);
		p.remove(PA1);
		p.remove(CS);
		p.remove(CS1);
	}
}

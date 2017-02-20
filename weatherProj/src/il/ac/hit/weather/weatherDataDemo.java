package il.ac.hit.weather;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

public class weatherDataDemo {

	private JFrame frmWeatherData;
	private JLabel lbMessage;
	private JTextField textFieldID;
	private JTextField textFieldCity;
	private JTextField textFieldAnswer;
	private JLabel lblSearchByCity;
	private JLabel lblSearchById;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnCleanCity;
	private JButton btnCleanCityId;
//try 12345667
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				weatherDataDemo window = new weatherDataDemo();
				window.frmWeatherData.setVisible(true);
			}
		});
	}

	/**
	 * Create the application.
	 */
	public weatherDataDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWeatherData = new JFrame();
		frmWeatherData.setTitle("weather data");
		frmWeatherData.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Dowloads new\\images.png"));
		frmWeatherData.setBounds(100, 100, 997, 362);
		frmWeatherData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWeatherData.getContentPane().setLayout(null);
		
		JButton btnGoOn = new JButton("search by CITY");
		btnGoOn.setForeground(Color.DARK_GRAY);
		btnGoOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cityName;
				OpenWeatherMap mapAnswer = OpenWeatherMap.creatOpenWeatherMap();
				WeatherData answerToScreen;
				Location location;
				cityName = textFieldCity.getText();
				if(cityName.matches("[0-9]+")){
					JOptionPane.showMessageDialog(null, "YOU HAVE TO WRITE LETTERS");
					textFieldCity.setText("");
					}
					
				try 
				{
					location = new Location(cityName);
					answerToScreen = mapAnswer.getWeatherData(location);
					textFieldAnswer.setText(answerToScreen.toString());
					textFieldCity.setText("");
				} catch (WeatherDataServiceException e) {
					JOptionPane.showMessageDialog(null, "YOUR CITY NAME IS NOT VALID");
				}
			}
		});
		btnGoOn.setBackground(Color.WHITE);
		btnGoOn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		btnGoOn.setBounds(789, 100, 160, 33);
		frmWeatherData.getContentPane().add(btnGoOn);
		
		lbMessage = new JLabel("the weather data:");
		lbMessage.setFont(new Font("Viner Hand ITC", Font.PLAIN, 30));
		lbMessage.setBounds(10, 167, 305, 41);
		frmWeatherData.getContentPane().add(lbMessage);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(155, 56, 160, 33);
		frmWeatherData.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(733, 56, 160, 33);
		frmWeatherData.getContentPane().add(textFieldCity);
		textFieldCity.setColumns(10);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldAnswer.setBounds(20, 207, 939, 41);
		frmWeatherData.getContentPane().add(textFieldAnswer);
		textFieldAnswer.setColumns(10);
		
		lblSearchByCity = new JLabel("search by CITY:");
		lblSearchByCity.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		lblSearchByCity.setBounds(614, 59, 135, 24);
		frmWeatherData.getContentPane().add(lblSearchByCity);
		
		lblSearchById = new JLabel("search by ID:");
		lblSearchById.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		lblSearchById.setBounds(56, 59, 135, 24);
		frmWeatherData.getContentPane().add(lblSearchById);
		
		btnNewButton = new JButton("search by ID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cityId;
				OpenWeatherMap mapAnswer = OpenWeatherMap.creatOpenWeatherMap();
				WeatherData answerToScreen;
				Location location;
				if (textFieldID.getText().matches("[a-zA-Z]+")){
					JOptionPane.showMessageDialog(null, "YOU HAVE TO WRITE ONLY NUMBERS");
					textFieldID.setText("");
				}
					cityId = Integer.parseInt(textFieldID.getText());
				try 
				{
					location = new Location(cityId);
					answerToScreen = mapAnswer.getWeatherData(location);
					textFieldAnswer.setText(answerToScreen.toString());
					textFieldID.setText("");
				} catch (WeatherDataServiceException e2) {
					JOptionPane.showMessageDialog(null, "YOUR ID IS NOT VALID");
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		btnNewButton.setBounds(242, 100, 160, 33);
		frmWeatherData.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("CLEAN DATA MSG");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldAnswer.setText("");
				}
		});
		btnNewButton_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		btnNewButton_1.setBounds(742, 279, 214, 33);
		frmWeatherData.getContentPane().add(btnNewButton_1);
		
		btnCleanCity = new JButton("clean city name area");
		btnCleanCity.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		btnCleanCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCity.setText("");
			}
		});
		btnCleanCity.setBounds(555, 100, 222, 30);
		frmWeatherData.getContentPane().add(btnCleanCity);
		
		btnCleanCityId = new JButton("clean city ID area");
		btnCleanCityId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldID.setText("");
			}
		});
		btnCleanCityId.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		btnCleanCityId.setBounds(10, 100, 222, 30);
		frmWeatherData.getContentPane().add(btnCleanCityId);
	}
}

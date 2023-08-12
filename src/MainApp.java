import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.rest.*;
import io.forecast.*;
import io.misc.*;

public class MainApp 
{

	private JFrame frmWeatherapp;
	private JTextField textLat;
	private JTextField textLong;
	private JTextField textTZ;
	private JTextField textEleve;
	private JTextField textTemp;
	private JTextField textWS;
	private JTextField textWindS;
	private JTextField textWindD;
	private String latitude;
	private String longitude;
	private APIRest api = new APIRest();
	private JTextField textTZA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainApp window = new MainApp();
					window.frmWeatherapp.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmWeatherapp = new JFrame();
		frmWeatherapp.setTitle("WeatherApp");
		frmWeatherapp.setResizable(false);
		frmWeatherapp.setBounds(100, 100, 390, 450);
		frmWeatherapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWeatherapp.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 375, 22);
		frmWeatherapp.getContentPane().add(menuBar);
		
		JMenu mnOptionsMenu = new JMenu("Options");
		menuBar.add(mnOptionsMenu);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mnOptionsMenu.add(mntmExport);
		
		JSeparator separator = new JSeparator();
		mnOptionsMenu.add(separator);
		
		JMenuItem mntmPreferences = new JMenuItem("Preferences");
		mnOptionsMenu.add(mntmPreferences);
		
		JSeparator separator_1 = new JSeparator();
		mnOptionsMenu.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnOptionsMenu.add(mntmExit);
		
		JMenu mnHelpMenu = new JMenu("Help");
		menuBar.add(mnHelpMenu);
		
		JMenuItem mntmOMA = new JMenuItem("Open-Meteo API");
		mnHelpMenu.add(mntmOMA);
		
		JMenuItem mntmAbout = new JMenuItem("About WeatherApp");
		mnHelpMenu.add(mntmAbout);
		
		JLabel lblLat = new JLabel("Latitude");
		lblLat.setBounds(10, 36, 46, 14);
		frmWeatherapp.getContentPane().add(lblLat);
		
		JLabel lblLong = new JLabel("Longitude");
		lblLong.setBounds(10, 67, 56, 14);
		frmWeatherapp.getContentPane().add(lblLong);
		
		JFormattedTextField x_latitude = new JFormattedTextField();
		x_latitude.setBounds(66, 34, 112, 20);
		frmWeatherapp.getContentPane().add(x_latitude);
		
		JFormattedTextField y_longitude = new JFormattedTextField();
		y_longitude.setBounds(76, 64, 102, 20);
		frmWeatherapp.getContentPane().add(y_longitude);
		
		JButton btnGetButton = new JButton("Get/Update");
		
		btnGetButton.setFont(new Font("Dialog", Font.BOLD, 10));
		btnGetButton.setToolTipText("Fills/Update the current weather information");
		btnGetButton.setBounds(190, 33, 89, 51);
		frmWeatherapp.getContentPane().add(btnGetButton);
		
		JButton btnClearButton = new JButton("Clear");
		btnClearButton.setToolTipText("Clears all the information below");
		btnClearButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnClearButton.setBounds(286, 33, 79, 51);
		frmWeatherapp.getContentPane().add(btnClearButton);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLocation.setBounds(154, 95, 65, 14);
		frmWeatherapp.getContentPane().add(lblLocation);
		
		JLabel lblClat = new JLabel("Latitude");
		lblClat.setBounds(10, 125, 46, 14);
		frmWeatherapp.getContentPane().add(lblClat);
		
		JLabel lblClong = new JLabel("Longitude");
		lblClong.setBounds(10, 150, 56, 14);
		frmWeatherapp.getContentPane().add(lblClong);
		
		textLat = new JTextField();
		textLat.setEditable(false);
		textLat.setBounds(66, 122, 299, 20);
		frmWeatherapp.getContentPane().add(textLat);
		textLat.setColumns(10);
		
		textLong = new JTextField();
		textLong.setEditable(false);
		textLong.setBounds(76, 147, 289, 20);
		frmWeatherapp.getContentPane().add(textLong);
		textLong.setColumns(10);
		
		JLabel lblTZ = new JLabel("Timezone");
		lblTZ.setBounds(10, 175, 56, 14);
		frmWeatherapp.getContentPane().add(lblTZ);
		
		textTZ = new JTextField();
		textTZ.setEditable(false);
		textTZ.setBounds(76, 172, 222, 20);
		frmWeatherapp.getContentPane().add(textTZ);
		textTZ.setColumns(10);
		
		JLabel lblElevation = new JLabel("Elevation");
		lblElevation.setBounds(10, 200, 56, 14);
		frmWeatherapp.getContentPane().add(lblElevation);
		
		textEleve = new JTextField();
		textEleve.setEditable(false);
		textEleve.setBounds(66, 197, 299, 20);
		frmWeatherapp.getContentPane().add(textEleve);
		textEleve.setColumns(10);
		
		JLabel lblCW = new JLabel("Current Weather");
		lblCW.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCW.setBounds(124, 228, 125, 14);
		frmWeatherapp.getContentPane().add(lblCW);
		
		JLabel lblTemp = new JLabel("Temperature");
		lblTemp.setBounds(10, 260, 79, 14);
		frmWeatherapp.getContentPane().add(lblTemp);
		
		JLabel lblWS = new JLabel("Weather State");
		lblWS.setBounds(10, 285, 89, 14);
		frmWeatherapp.getContentPane().add(lblWS);
		
		JLabel lblWindS = new JLabel("Wind Speed");
		lblWindS.setBounds(10, 310, 79, 14);
		frmWeatherapp.getContentPane().add(lblWindS);
		
		JLabel lblWindD = new JLabel("Wind Direction");
		lblWindD.setBounds(10, 335, 89, 14);
		frmWeatherapp.getContentPane().add(lblWindD);
		
		textTemp = new JTextField();
		textTemp.setEditable(false);
		textTemp.setBounds(91, 257, 274, 20);
		frmWeatherapp.getContentPane().add(textTemp);
		textTemp.setColumns(10);
		
		textWS = new JTextField();
		textWS.setEditable(false);
		textWS.setColumns(10);
		textWS.setBounds(101, 282, 264, 20);
		frmWeatherapp.getContentPane().add(textWS);
		
		textWindS = new JTextField();
		textWindS.setEditable(false);
		textWindS.setColumns(10);
		textWindS.setBounds(91, 307, 274, 20);
		frmWeatherapp.getContentPane().add(textWindS);
		
		textWindD = new JTextField();
		textWindD.setEditable(false);
		textWindD.setColumns(10);
		textWindD.setBounds(101, 332, 264, 20);
		frmWeatherapp.getContentPane().add(textWindD);
		
		textTZA = new JTextField();
		textTZA.setEditable(false);
		textTZA.setBounds(300, 172, 65, 20);
		frmWeatherapp.getContentPane().add(textTZA);
		textTZA.setColumns(10);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(9, 363, 355, 14);
		frmWeatherapp.getContentPane().add(progressBar);
		
		JLabel lblDC = new JLabel("Weather Information provided by Open-Meteo.com");
		lblDC.setForeground(UIManager.getColor("Button.darkShadow"));
		lblDC.setBounds(44, 388, 285, 14);
		frmWeatherapp.getContentPane().add(lblDC);
		
		JLabel lblMismatch = new JLabel("Incorrect coordinates input");
		lblMismatch.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblMismatch.setForeground(Color.RED);
		lblMismatch.setBounds(10, 97, 134, 14);
		lblMismatch.setVisible(false);
		frmWeatherapp.getContentPane().add(lblMismatch);
		
		JLabel lblConnErr = new JLabel("Error: Connection Failed");
		lblConnErr.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblConnErr.setForeground(Color.RED);
		lblConnErr.setBounds(240, 95, 125, 16);
		lblConnErr.setVisible(false);
		frmWeatherapp.getContentPane().add(lblConnErr);
		
		//Get/Update button Action
		btnGetButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				lblMismatch.setVisible(false);
				lblConnErr.setVisible(false);
				progressBar.setValue(0);
				StringBuilder url = new StringBuilder("https://api.open-meteo.com/v1/forecast?latitude=");
				latitude = x_latitude.getText();
				longitude = y_longitude.getText();
				progressBar.setValue(25);
				url.append(latitude).append("&longitude=");
				url.append(longitude);
				url.append("&current_weather=true&timezone=America%2FDenver&past_days=1&forecast_days=1");
				
				try
				{
					//Catch API GET Null Pointer Exception
					String data = api.get(url.toString());
					try 
					{
						//Catch IOException
						WeatherInfo wInfo = Converter.fromJsonString(data);
						//Fills "Location" section
						textLat.setText(wInfo.getLatitude().toString());
						textLong.setText(wInfo.getLongitude().toString());
						textTZ.setText(wInfo.getTimezone());
						textTZA.setText(wInfo.getTimezoneAbbreviation());
						textEleve.setText(wInfo.getElevation().toString());
						//Fills "Current Weather" section
						textTemp.setText(wInfo.getCurrentWeather().getTemperature());
						textWS.setText(wInfo.getCurrentWeather().getWeathercode());
						textWindS.setText(wInfo.getCurrentWeather().getWindspeed().toString() + " km/h");
						textWindD.setText(wInfo.getCurrentWeather().getWinddirection());
					} 
					catch (IOException e1 ) 
					{
						System.err.println(e1.getMessage());
					}
					finally
					{
						progressBar.setValue(50);
					}
				}
				catch (NullPointerException en)
				{
					lblMismatch.setVisible(true);
					lblConnErr.setVisible(true);
					System.err.println(en.getMessage());
				}
				finally
				{
					progressBar.setValue(100);
				}
			}
		});
		//Clear button Action
		btnClearButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				lblMismatch.setVisible(false);
				lblConnErr.setVisible(false);
				progressBar.setValue(0);
				//Deletes the typed coordinates
				x_latitude.setText(null);
				y_longitude.setText(null);
				//Deletes the Location Info
				textLat.setText(null);
				textLong.setText(null);
				textTZ.setText(null);
				textTZA.setText(null);
				textEleve.setText(null);
				//Deletes the Current weather Info
				textTemp.setText(null);
				textWS.setText(null);
				textWindS.setText(null);
				textWindD.setText(null);
			}
		});
		//Export | Preferences Option Meno (Not implemented)
		mntmExport.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				NotimpMsg NI = new NotimpMsg();
				NI.setVisible(true);
			}
		});
		mntmPreferences.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				NotimpMsg NI = new NotimpMsg();
				NI.setVisible(true);
			}
		});
		
		//Exit menu option
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		//Open-Meteo API help menu
		mntmOMA.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Desktop desk = Desktop.getDesktop();
				try 
				{
					desk.browse(new URI("https://open-meteo.com/en/docs"));
				} 
				catch (IOException | URISyntaxException e1) 
				{
					e1.printStackTrace();
				}
			}
		});
		//About option menu
		mntmAbout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				AboutApp ab = new AboutApp();
				ab.setVisible(true);
			}
		});
	}
}

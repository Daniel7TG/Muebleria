package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class TitleFrame extends JFrame implements ActionListener, MouseListener {

	public Color buttonStaticColor = new Color(0, 193, 172);
	public Color buttonHoverColor = new Color(25, 176, 161);
	public Color contentBackgroundColor = new Color(199, 231, 227); 
	public Color titleBackgroundColor = new Color(197, 241, 236); 
	public Color extraBackgroundColor = new Color(199, 231, 227); 
	
	public JPanel titlePanel = new JPanel();
	public JPanel contentPanel = new JPanel();
	public Font textFont = new Font("Maiandra GD", Font.PLAIN, 25);
	public Font tableTextFont = new Font("Maiandra GD", Font.PLAIN, 15);
	public Font titleFont = new Font("Century SchoolBook", Font.BOLD, 40);

	private JLabel titleLabel = new JLabel();
	public JButton titleButton = new JButton();
	public GridBagLayout contentLayout = new GridBagLayout();
	
	private ImageIcon buttonIcon;
	private ImageIcon buttonIconHover;
	
	int frameHeight = 630;
	int panelHeight = 75;
	private int frameWidth = 930;
	
	public Calendar calendario = Calendar.getInstance();

	TitleFrame(String texto){


		buttonIcon = new ImageIcon("D:/Users/D-TG/EclipseProgramas/Muebleria/src/UI/image.png");
		buttonIconHover = new ImageIcon("D:/Users/D-TG/EclipseProgramas/Muebleria/src/UI/imageSorprendido.png");

		titleButton = StaticUtilities.createButton(this, this, null, new Dimension(panelHeight, 0), null, titleBackgroundColor);
		titleButton.setIcon(buttonIcon);
		titleButton.setBorder(null);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBackground(titleBackgroundColor);
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		titlePanel.add(titleButton, BorderLayout.WEST);
		titlePanel.setPreferredSize(new Dimension(0, panelHeight));

		titleLabel.setText(texto);		
		titleLabel.setPreferredSize(new Dimension(frameWidth - panelHeight, 0));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(titleFont);
		
		this.setResizable(false);
		this.setTitle("Muebleria");
		this.getContentPane().setBackground(contentBackgroundColor);
		this.setLayout(new BorderLayout());
		this.add(titlePanel, BorderLayout.NORTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(frameWidth, frameHeight));
		
		
		contentPanel.setBackground(null);
		contentPanel.setLayout(contentLayout);
		
	}

	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == titleButton ) {
//			System.out.println(StaticUtilities.returnButton.toString());
//			System.out.println("Gato");
			JFrame frame = StaticUtilities.returnButton.pop();
			frame.setVisible(true);
			this.dispose();
//			StaticUtilities.returnButton.push(this);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == titleButton) {
			titleButton.setIcon(buttonIconHover);
		}
		if(e.getSource().getClass().equals(JButton.class)) {
			e.getComponent().setBackground(buttonStaticColor);			
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == titleButton) {
			titleButton.setBackground(titleBackgroundColor);
			titleButton.setIcon(buttonIcon);

		}
		else if(e.getSource().getClass().equals(JButton.class)) {
			e.getComponent().setBackground(buttonHoverColor);
		}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {		
	}
	@Override
	public void mousePressed(MouseEvent e) {		
	}
	@Override
	public void mouseReleased(MouseEvent e) {		
	}
}

package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentListener;

import Clases.Cliente;
import Clases.Venta;

public class StaticUtilities {
	
	public static Stack<JFrame> returnButton = new Stack<>();
	
	public static void temporalMessage(JLabel label, String text, Color color) {
		
		if(!label.getText().equals("")) {
			return;
		}
		label.setForeground(color);
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			int time = 2;
			@Override
			public void run() {
				label.setText(text);
				if(time <= 0) {
					label.setText("");
					this.cancel();
				}
				time--;
			}
			
		}, 0, 1000);
	}
	public static void time(JTextArea textArea) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				String fecha = Calendar.getInstance().getTime().toLocaleString();
				textArea.setText(fecha);
			}
			
		}, 0, 1000);
		
	}
	
	public static void stylesLabels(TitleFrame contentFrame, JLabel[] labelArray, Font font, Dimension size, int alignment) {
		for(JLabel label : labelArray) {
			label.setFont(font);
			label.setPreferredSize(size);
			label.setHorizontalAlignment(alignment);
		}
	}
	public static void stylesTextAreas(TitleFrame contentFrame, JTextArea[] textAreaArray, Font font, Dimension size) {
		for(JTextArea textArea : textAreaArray) {
			textArea.setFont(font);
			textArea.setPreferredSize(size);
		}
	}

	
	public static JButton createButton(ActionListener action, MouseListener mouse, String text, Dimension size, Font font, Color rest) {
		JButton newButton = new JButton();
		newButton.setBackground(rest);
		newButton.setText(text);
		newButton.setPreferredSize(size);
		newButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		newButton.addActionListener(action);
		newButton.addMouseListener(mouse);
		newButton.setFont(font);
		newButton.setFocusable(false);
		return newButton;	
	}
	
	public static boolean registerTest(boolean bool) {
		return bool;
	}

}

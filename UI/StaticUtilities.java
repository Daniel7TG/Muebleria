package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
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

import Clases.Cliente;
import Clases.Venta;

public class StaticUtilities {
	
	public static Stack<JFrame> returnButton = new Stack<>();
	
	public static void temporalMessage(JLabel label, String text, Color color) {
		
//		label.setPreferredSize(new Dimension(200, 200));
//		GridBagConstraints grid = new GridBagConstraints();
//		
//		grid.gridx = x;
//		grid.gridy = y;
//		contentFrame.contentPanel.add(label, grid);
		label.setForeground(color);
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			int time = 5;
			@Override
			public void run() {
				label.setText(text);
				System.out.println("todavia no");
				if(time <= 0) {
//					contentFrame.repaint();
					System.out.println("listo");
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
//	public static DefaultTableModel editable() {
//		
//		DefaultTableModel model = new DefaultTableModel(){
//			@Override
//		    public boolean isCellEditable(int row, int column) {
//		        return false; // Deshabilitar la edición de todas las celdas
//		    }
//		};
//		return model;
//	}
}

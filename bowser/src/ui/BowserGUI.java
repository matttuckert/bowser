/**
 * 
 */
package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * @author mattt
 *
 */
public class BowserGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField addressBar;
	private JEditorPane display;
	
	public BowserGUI() {
		super("BOWSER");
		
		addressBar = new JTextField();
		addressBar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadPage(e.getActionCommand());
				}
			});
		
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
			new HyperlinkListener() {
				public void hyperlinkUpdate(HyperlinkEvent e) {
					if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
						loadPage(e.getURL().toString());
					}
				}
			});
		
		add(addressBar, BorderLayout.NORTH);
		add(new JScrollPane(display), BorderLayout.CENTER);
		
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void loadPage(String str) {
		try {
			display.setPage(str);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRRRROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BowserGUI();
	}

}

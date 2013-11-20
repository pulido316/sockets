package guiServidor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaServidor extends JFrame {

	private JLabel nombre;
	private JLabel ip;
	private JPanel panel1;

	public VentanaServidor(String entradaNombre) {
		super("SERVIDOR");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel1 = new JPanel(new FlowLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("DATOS DEL SERVIDOR"));
		nombre = new JLabel(entradaNombre);
		ip = new JLabel("IP");

		panel1.add(nombre);
		panel1.add(ip);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel1, BorderLayout.NORTH);
		pack();
	}

}

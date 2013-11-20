package guiAministrador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaAdministrar extends JFrame {

	private JButton crearServidor;
	private JPanel panel1;

	public VentanaAdministrar() {
		super("ADMINISTRADOR");
		this.setResizable(false);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel1 = new JPanel(new FlowLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("CREAR SERVIDOR"));

		crearServidor = new JButton("crear servidor");
		panel1.add(crearServidor);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel1, BorderLayout.NORTH);
		pack();

	}

	public static void main(String[] args) {
		VentanaAdministrar v = new VentanaAdministrar();
		v.setSize(400, 400);
		v.setVisible(true);

	}

}

package guiAministrador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logica.Administrador;

public class VentanaAdministrar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// botones
	private JButton jBtnCrearServidor;
	// lebel
	private JLabel jLNombre;
	//caja textos
	private JTextField jTexNombre;
	private JTextField jTPuerto;
	
	private JPanel panel1;
	
	private Administrador administrador;

	public VentanaAdministrar() {
		super("ADMINISTRADOR");
		this.setResizable(false);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		administrador= new Administrador();

		panel1 = new JPanel(new FlowLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("CREAR SERVIDOR"));
		
		jLNombre = new JLabel("NOMBRE DEL SERVIDOR:");
		
		jBtnCrearServidor = new JButton("crear servidor");
		
		jTexNombre= new JTextField(10);
		
		jTexNombre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(jTexNombre.getText());
				
			}
		});
		
		jTPuerto= new JTextField(5);
		
		jTPuerto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(jTexNombre.getText());
				
			}
		});

		jBtnCrearServidor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				administrador.crarServidor( Integer.parseInt(jTPuerto.getText()),jTexNombre.getText());
				jTPuerto.setText("");
				jTexNombre.setText("");
			}
		});		
		panel1.add(jLNombre);
		panel1.add(jTexNombre);
		panel1.add(jTPuerto);
		panel1.add(jBtnCrearServidor);
		

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel1, BorderLayout.NORTH);
		pack();

	}

	public static void main(String[] args) {
		VentanaAdministrar v = new VentanaAdministrar();
		v.setSize(500, 400);
		v.setVisible(true);

	}

}

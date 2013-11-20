package logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * 
 * @author deybi pulido
 * 
 */
public class Cliente implements Runnable {

	private Socket socketCliente;
	private DataInputStream inputStreamCliente;
	private DataOutputStream outputStreamCliente;
	private String ip;
	private int puerto;
	
	private int opcion;
	
	private boolean pause;
	private boolean stop;
	private Thread thread;
	private long speed;

	

	
	public Cliente() {
		thread() ;
		try {
			
			socketCliente = new Socket("192.168.1.2", 4000);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"no se encuentra el servidor");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			inputStreamCliente= new DataInputStream(socketCliente.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			outputStreamCliente = new DataOutputStream(
					socketCliente.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void thread() {
		pause = false;
		stop = false;
		thread = new Thread(this);
		speed = 0;
	}
	
	@Override
	public void run() {
		while (!stop) {
			try {
				opcion=inputStreamCliente.readInt();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			switch (opcion) {
			case 1:
				try {
					System.out.println(inputStreamCliente.readUTF());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
			}
		}
		
		

	}
	public void start() {
		thread.start();	
	}

	synchronized void stop() {
		stop = true;
		pause = false;
		notify();
	}
	synchronized void suspend() {
		pause = true;

	}
	
	public void cerrarConexion() {
		  
		try {
			inputStreamCliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			outputStreamCliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			socketCliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

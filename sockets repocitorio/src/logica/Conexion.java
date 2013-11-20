package logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Conexion implements Runnable {

	private Socket socketConexion;
	private DataInputStream inputStreamConexion;
	private DataOutputStream outputStreamConexion;

	private int opcion;

	private boolean pause;
	private boolean stop;
	private Thread thread;
	private long speed;

	public Conexion(Socket socket) {
		this.socketConexion = socket;
		thread() ;

		try {
			outputStreamConexion = new DataOutputStream(
					socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("error entrada");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			inputStreamConexion = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			System.out.println("error salida ");
			e.printStackTrace();
		}
		iniciarConexion();
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
				opcion = inputStreamConexion.readInt();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			switch (opcion) {
			case 1:
				try {
					System.out.println(inputStreamConexion.readUTF());
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
		// TODO Auto-generated method stub
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
			outputStreamConexion.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			inputStreamConexion.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			socketConexion.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void iniciarConexion(){
		
		System.out.println("entroooooo");
		try {
			
			outputStreamConexion.writeInt(1);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			outputStreamConexion.writeUTF("este msn se envio corectamente");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

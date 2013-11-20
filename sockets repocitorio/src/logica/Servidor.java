package logica;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * 
 * @author deybi pulido
 * 
 */
public class Servidor implements Runnable {
    private String nombre;
	
	private ServerSocket serverSocket;
	private ArrayList<Conexion> listaConexion;

	private Socket socket;

	private int puerto;
	

	
	private boolean pause;
	private boolean stop;
	private Thread thread;
	private long speed;
	
	private InetAddress direccion;

	public Servidor(int puerto,String nombre) {
		this.puerto=puerto;
		thread= new Thread(this);
		listaConexion = new ArrayList<Conexion>();
		this.nombre = nombre;
		// TODO Auto-generated constructor stub
	}
	
	



	@Override
	public void run() {
		
		System.out.println(puerto);
		
	    try {
			direccion = InetAddress.getLocalHost();
			
			System.out.println(direccion+"__________"+nombre);
			
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			
	
		
		while (!stop) {
			System.out.println("esperando conexion");
			try {
				socket=serverSocket.accept();
				listaConexion.add(new Conexion(socket));
				System.out.println("nueva conexion aceptada");
		 	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (this) {
				while (pause)

					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				if (stop)
					break;
			}
		}
		
		
	}
	public void start() {
		thread.start();
		iniciarServidor();
	}

	synchronized void stop() {
		stop = true;
		pause = false;
		notify();
	}
	synchronized void suspend() {
		pause = true;

	}

	public void iniciarServidor() {
		if (serverSocket == null) {
			try {
				serverSocket = new ServerSocket(puerto);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("no se creo");
				e.printStackTrace();
			}

		}

	}
	/**
	 * public void cerrarConexion() {
		  
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
	 */
	
public void cerrarConexion(){
	
	for (int i = 0; i < listaConexion.size(); i++) {
		
		}
	}
public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

}


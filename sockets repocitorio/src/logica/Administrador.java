package logica;

public class Administrador {
	
	private Servidor servidor;
	
	
	public Administrador() {
		
		
	}
	
	public void crarServidor(int puerto, String nombre){
		
		servidor= new Servidor(puerto,nombre);
		servidor.start();
		
	}
	

}

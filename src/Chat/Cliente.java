package Chat;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Cliente extends Thread {
	private Socket socketCliente;
	
	
	private String mensagem;
	Controle controle;
	
	public Cliente(String mensagem,Controle controle){
		setMensagem(mensagem);
		this.controle= controle;
	}
	
	
	public void run(){		
						
			Mensagem();
			
			
		
	}

	
	public void Mensagem(){
		try {
			System.out.println("Fazendo conexão");
			socketCliente = new Socket(controle.getIp(),controle.getPorta());
			
			
			PrintWriter escritor = new PrintWriter(socketCliente.getOutputStream());
			System.out.println("Enviando...");
			escritor.write(mensagem);
			escritor.close();
			
			
			socketCliente.close();
			escritor.close();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro de Envio","Erro de Envio",2);
			
		}
	}
	
	
	
	



	public String getMensagem() {
		return mensagem;
	}




	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}

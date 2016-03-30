package Chat;

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Servidor extends Thread {

	private ServerSocket socketServidor;

	Janela janela;
	Controle controle;
	
	
	public Servidor(Janela janela,Controle controle){
		
		this.janela = janela;
		this.controle = controle;
		
	}

	public void run() {
		rMensagem();
		
		
		

	}
	
	public void rMensagem(){
		
		try {

			System.out.println("Iniciando servidor");

			socketServidor = new ServerSocket(controle.getPorta());

			while (true) {
				
				System.out.println("Recebendo Mensagens...");
				Socket socketEscuta = socketServidor.accept();
				InputStreamReader streamReader = new InputStreamReader(socketEscuta.getInputStream());
				BufferedReader reader = new BufferedReader(streamReader);
				String textoEnviado = reader.readLine();

				 

				if (textoEnviado == "") {
					janela.AparecerTexto("vazio");
					break;
				}

				reader.close();

				janela.AparecerTexto(controle.getIp() +": "+textoEnviado);
				
				
				socketEscuta.close();
				
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Erro de conexão, reinicie o programa","Erro de conexão, reinicie o programa",3);
		}
		
	}
	
	
	
	
	
	
	

}

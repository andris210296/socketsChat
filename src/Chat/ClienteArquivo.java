package Chat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ClienteArquivo extends Thread{
	
	private Socket socketCliente;
	
	
	
	Controle controle;
	
	public ClienteArquivo(Controle controle){
		
		this.controle = controle;
	}
	
	
	public void run(){		
						
			Arquivo();
			
			
		
	}
	
	public void Arquivo(){
		try {
			
			
			
			socketCliente = new Socket(controle.getIp(),controle.getPorta());

			JFileChooser arquivo = new JFileChooser();		
			
			arquivo.setDialogTitle("Escolha o arquivo que você deseja enviar");
			arquivo.setCurrentDirectory(new File("C:\\"));			
			arquivo.setAcceptAllFileFilterUsed(false);
			arquivo.setMultiSelectionEnabled(false);

			int retorno = arquivo.showOpenDialog(null);

			if (retorno == JFileChooser.APPROVE_OPTION) {
				
				
				// pegando o arquivo em forma de bytes para mandar para o servidor
				
				@SuppressWarnings("resource")
				FileInputStream arquivoByte = new FileInputStream(arquivo.getSelectedFile());
				
				
				System.out.println(arquivo.getSelectedFile());
				// o que sera enviado pelo socket
				OutputStream enviando = socketCliente.getOutputStream(); // byte
				
				OutputStreamWriter escrevendo = new OutputStreamWriter(enviando); // byte
				
				
				// pega todo o conteudo do arquivo para mandar td de uma vez
				BufferedWriter guardando = new BufferedWriter(escrevendo); // byte
				
				
				guardando.write(arquivo.getName() + "\n");
				guardando.flush(); // envia todo o conteudo do arquivo de uma vez
				int c;
				while ((c = arquivoByte.read()) != -1) {
					enviando.write(c);
				}
				System.out.println("Arquivo enviado com sucesso!!!");
				
				enviando.close();
				

			}
			else arquivo.hide();
			
			
			socketCliente.close();

		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Não foi possível Enviar", "",	2);
			
		}
		
		
		
	}
	
}

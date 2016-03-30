package Chat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ServidorArquivo extends Thread {

	private ServerSocket socketServidor;

	Janela janela;
	Controle controle;

	public ServidorArquivo(Janela janela, Controle controle) {

		this.janela = janela;
		this.controle = controle;

	}

	public void run() {
		rArquivo();

	}

	public void rArquivo() {

		try {
			System.out.println("Servidor Arquivo...");

			socketServidor = new ServerSocket(controle.getPorta());

			System.out.println("Recebendo Arquivos...");
			
			while (true) {
			Socket socketEscuta = socketServidor.accept();
			InputStreamReader streamReader = new InputStreamReader(socketEscuta.getInputStream());

			
				BufferedReader juntando = new BufferedReader(streamReader);

				String fName = juntando.readLine();

				System.out.println("aqui" + fName);
				
			      

				JFileChooser fChooser = new JFileChooser();
				fChooser.setDialogTitle("Escolha o local que você deseja salvar");
				fChooser.setCurrentDirectory(new File("C:\\"));
				fChooser.setAcceptAllFileFilterUsed(false);
				fChooser.setMultiSelectionEnabled(false);

				int retorno = fChooser.showSaveDialog(null);

				if (retorno == JFileChooser.APPROVE_OPTION) {
					

					System.out.println(fChooser.getSelectedFile().getAbsolutePath());
					@SuppressWarnings("resource")
					FileOutputStream recebendo = new FileOutputStream(fChooser.getSelectedFile().getAbsolutePath());
					
					
					
					byte[] buf = new byte[1024];  
					int c;
					while ((c = socketEscuta.getInputStream().read(buf)) != -1) {
						recebendo.write(c);

					}


					

					// http://www.guj.com.br/java/203036-transferencia-de-arquivos-txt-pdf-tiff-via-sockets-upload-and-download

				} else
					fChooser.hide();
				
				socketEscuta.close();

				
			}
		} catch (IOException e) {
			System.out.println("Nenhum Arquivo Recebido");
		}

	}
}

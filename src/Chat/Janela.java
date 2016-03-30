package Chat;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Janela extends JFrame implements ActionListener{
	
	JFrame janela;
	
	JButton btnEnviar = new JButton("Texto");
	JButton btnArquivo = new JButton("Arquivo");
	JLabel lblResposta = new JLabel();
	JTextField txtTexto = new JTextField();
	
	Controle controle;
	
	
	
	Servidor servidor;
	ServidorArquivo sArquivo;
	
	
	
	
	public Janela(Controle controle) throws Exception{
		this.controle = controle;
		
		
		servidor = new Servidor(this,controle);
		Thread tServidor = new Thread(servidor);
		tServidor.start();
		
		sArquivo = new ServidorArquivo(this, controle);
		Thread tSArquivo = new Thread(sArquivo);
		tSArquivo.start();
		
		
		
		
		
		janela = new JFrame("Chat");
		
		janela.setSize(800,800);
		
		Container container = getContentPane();
		container.setLayout(new GridLayout(2, 4));
		
		JLabel lblVazio1 = new JLabel("");
		JLabel lblVazio2 = new JLabel("");
		JLabel lblVazio3 = new JLabel("");
		JLabel lblTexto = new JLabel("Texto:");
		
		
		
		
		
		
		
		
		container.add(lblResposta);container.add(lblVazio1);container.add(lblVazio2);container.add(lblVazio3);
		container.add(lblTexto);container.add(txtTexto);container.add(btnEnviar);container.add(btnArquivo);
		
		btnEnviar.addActionListener(this);
		btnArquivo.addActionListener(this);
		
		pack();

		setDefaultCloseOperation(3);
		
		
	}

   public void AparecerTexto(String texto){
	   lblResposta.setText(texto);
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Cliente cliente = new Cliente(txtTexto.getText(), controle);
		Thread tCliente = new Thread(cliente);
		
		ClienteArquivo cArquivo = new ClienteArquivo(controle);
		Thread tCArquivo = new Thread(cArquivo);

		
		
		if (e.getSource() == btnEnviar) {
			tCliente.start();
			
		}
		if (e.getSource() == btnArquivo) {
			tCArquivo.start();		

		}

	}
	

}

package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Controle {

	Janela janela;
	JanelaIP jIP;

	private String ip;
	private int porta;

	

	public Controle() throws Exception {

		janela = new Janela(this);
		jIP = new JanelaIP(this);		
		

	}

	public void JanelaPrincipal() throws Exception {

		janela = new Janela(this);
		janela.setVisible(true);
		jIP.setVisible(false);

	}

	public void JanelaIP() {
		janela.setVisible(false);
		jIP.setVisible(true);

	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

}

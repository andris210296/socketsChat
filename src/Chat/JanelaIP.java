package Chat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JanelaIP extends JFrame implements ActionListener {
	
	Controle controle;
	
	JFrame jIP;
	
	
	JTextField txt1 = new JTextField();	
	JTextField txt2 = new JTextField();
	JTextField txt3 = new JTextField();
	JTextField txt4 = new JTextField();
	
	JTextField txtPorta = new JTextField();
	JButton btnEntrar = new JButton("Entrar");
	
	
	
	
	public JanelaIP(Controle controle){
		this.controle= controle;
		
				
		
		jIP = new JFrame("IP");
		
		
		
		jIP.setSize(100,200);
		
		Container container = getContentPane();
		
		container.setLayout(new GridLayout(3,4));
		
		JLabel lbl1 = new JLabel("Conectar-se a:");
		JLabel lbl2 = new JLabel("127.0.0.1");
		JLabel lbl3 = new JLabel("Porta:");
		JLabel lblVazio1 = new JLabel("");
		JLabel lblVazio2 = new JLabel("");
		JLabel lblVazio3 = new JLabel("");
		
		
		
		
		container.add(lbl1);container.add(lblVazio1);container.add(lblVazio2);container.add(lbl2);
		container.add(txt1);container.add(txt2);container.add(txt3);container.add(txt4);
		container.add(lbl3);container.add(txtPorta);container.add(lblVazio3);container.add(btnEntrar);
		
		
		btnEntrar.addActionListener(this);
		
		
		
		
		pack();
		
		setDefaultCloseOperation(3);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnEntrar){			
			
			try {

				controle.setIp(txt1.getText() +"."+txt2.getText()+"."+txt3.getText()+"."+txt4.getText());
				String porta = txtPorta.getText();
				
				int porta2 = Integer.parseInt(porta); 
				
				controle.setPorta(porta2);
				
				controle.JanelaPrincipal();
				
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

}

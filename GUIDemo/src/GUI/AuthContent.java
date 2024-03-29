package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import DB.TrainSQL;


public class AuthContent  implements ActionListener{

	Container contentArea;
	JPanel panel = new JPanel();
	
	JPanel mainPanel;
	
	JLabel jpwd = new JLabel("新密碼：");
	JPasswordField inputPass = new JPasswordField();
	
	JLabel juser = new JLabel("使用者帳號：");
	JLabel jnewpwd = new JLabel("密碼：");
	
	JTextField user = new JTextField();
	JPasswordField Pass = new JPasswordField();
		
	
	JButton add = new JButton("新增使用者");
	JButton update = new JButton("修改密碼");
	JButton back = new JButton("返回");
	
	public AuthContent(Container contentArea,JPanel mainPanel) {
		this.contentArea = contentArea;
		this.mainPanel = mainPanel;
		
		//密碼修改
		jpwd.setBounds(100,100,50,20);		
		inputPass.setBounds(170,100,100,20);		
		inputPass.setColumns(20);
		
		update.setBounds(130,140,75,20);
		update.addActionListener(this);
				
		
		//新增使用者
		juser.setBounds(400,100,50,20);
		jnewpwd.setBounds(400,130,50,20);
		
		user.setBounds(460,100,100,20);
		user.setColumns(30);

		Pass.setBounds(460,130,100,20);
		Pass.setColumns(30);
		add.setBounds(500,120,75,20);
		
		
		
		panel.add(jpwd);
		panel.add(inputPass);
		panel.add(update);	
		
		
		panel.add(juser);
		panel.add(user);
		panel.add(jnewpwd);		
		panel.add(Pass);
		
		
		add.addActionListener(this);
		panel.add(add);
			
		back.addActionListener(this);
		panel.add(back);
		
		
		contentArea.add(panel);
		contentArea.repaint(); //  重新整理				
		
	}

	
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if (event.getSource() == back) {
			
			contentArea.remove(panel);
			
			contentArea.revalidate();
			contentArea.repaint();
			
			contentArea.add(mainPanel);
			contentArea.repaint();
			
		}
		
		if(event.getSource() == add) {
			
			String acc = user.getText();
			String pwd = String.valueOf(Pass.getPassword());
			try {
				TrainSQL TS = new TrainSQL();
				TS.AddUser(acc,pwd);
				
			}catch(Exception e) {
				e.printStackTrace();
			}			
			
			
		}
		if(event.getSource() == update) {
			String newP = String.valueOf(inputPass.getPassword());
			try {
				TrainSQL TS = new TrainSQL();
				TS.UpdatePwd(Login.userAcc,newP);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
}
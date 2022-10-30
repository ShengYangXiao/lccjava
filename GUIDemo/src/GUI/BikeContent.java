package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Web.GetTNBike;
import javax.swing.*;

public class BikeContent implements ActionListener{
	
	Container contentArea;
	JPanel panel = new JPanel();
	JScrollPane scroll;
	JPanel mainPanel;
	JTable table;
	Object[][] data;
	JButton back = new JButton("返回");
	
	public BikeContent(Container contentArea,JPanel mainPanel) {
		
		this.contentArea = contentArea;
		this.mainPanel = mainPanel;
		
		GetTNBike bike = new GetTNBike();
		try {
			data = bike.getBike();
		}catch(Exception e) {
			e.printStackTrace();
		}
		String[] columes = {"站名","可借","可停"};
		table = new JTable(data,columes);
		scroll = new JScrollPane(table);
		
		
		table.setRowHeight(30);
		back.addActionListener(this);
		panel.add(back);
		
		contentArea.add(panel);
		contentArea.add(scroll);
		contentArea.repaint();//重新整理
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() == back) {
			contentArea.remove(scroll);
			contentArea.remove(panel);
			
			contentArea.revalidate(); //重新整理畫面
			contentArea.repaint();
			
			contentArea.add(mainPanel);
			contentArea.repaint();
		
		
		
	}

}
}	

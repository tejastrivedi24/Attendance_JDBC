import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Registration extends JFrame implements ActionListener
{ 
	JLabel l1, l2, l3, l4, l5;
	JTextField tf2, tf3;
	JButton btn1, btn2;
	JPasswordField p1;

	Registration()
	{
		setVisible(true);
		setSize(600	, 500);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("TEACHER REGISTRATION");

		l1 = new JLabel("Registration for Teacher's Database");
		l1.setForeground(Color.blue);
		l1.setFont(new Font("Serif", Font.BOLD, 25));
		
		l2 = new JLabel("Name:");
		l4 = new JLabel("Email-ID:");
		l5 = new JLabel("Password:");
		l2.setFont(new Font("Serif", Font.BOLD, 16));
		l4.setFont(new Font("Serif", Font.BOLD, 16));
		l5.setFont(new Font("Serif", Font.BOLD, 16));
		tf2 = new JTextField();
		tf3 = new JTextField();
		p1 = new JPasswordField();	//for accepting pw from l5 
		
		btn1 = new JButton("Submit");
		btn2 = new JButton("Clear");

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		l1.setBounds(100, 30, 400, 30);
		l2.setBounds(80, 70, 200, 30);
		l4.setBounds(80, 110, 200, 30);
		l5.setBounds(80, 150, 200, 30);
		tf2.setBounds(300, 70, 200, 30);
		tf3.setBounds(300, 110, 200, 30);
		p1.setBounds(300, 150, 200, 30);
		btn1.setBounds(100, 250, 100, 30);
		btn2.setBounds(220
				, 250, 100, 30);
		add(l1);
		add(l2);
		add(tf2);
		add(tf3);
		add(l4);
		add(p1);
		add(l5);
		add(btn1);
		add(btn2);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == btn1)
		{
			String s2 = tf2.getText();		//name
			String s4 = tf3.getText();		//email 
			char[] s5 = p1.getPassword();	
			String s6 = new String(s5);		//pw string
			
			
			if (true)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oopmfinal","root",""); 
					PreparedStatement ps = con.prepareStatement("INSERT INTO tchr VALUES(?,?,?)");
					ps.setString(1, s2);
					ps.setString(2, s4);
					ps.setString(3, s6);
					if(!s4.contains("@somaiya.edu"))
					{
						JOptionPane.showMessageDialog(btn1, "Invalid Email address\n Try again!");

					}
					else
					{
							if (true)  
							{
								int x = ps.executeUpdate();
								if(x>0)
								{

									JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
									Attendance a=new Attendance();
									a.setVisible(true);
								}
							}
					}
				}
				catch (Exception ex) 
				{
					System.out.println(ex);
				}
			}
		}
		else
		{
			tf2.setText("");
			tf3.setText("");
			p1.setText("");
			
		}
	} 
	public static void main(String args[])
	{
		new Registration();
	}
}

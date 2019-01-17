import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Attendance extends JFrame implements ActionListener
{
  JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
  JTextField t1, t2, t3, t4, t5;
  JButton btn1, btn2, btn3;
  int m1, m2, m3, m4, m5, q1, q2, q3, q4, q5;
  Statement stmt;

  public Attendance()
  {
    super("My Frame");

    //you can set the content pane of the frame 
    //to your custom class.
    setContentPane(new DrawPane());

    setVisible(true);
    setSize(1100, 700);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Registration Form in Java");

    //l1 = new JLabel("Registration in our Database");
    //l1.setForeground(Color.blue);
    //l1.setFont(new Font("Serif", Font.BOLD, 25));
    
    l1 = new JLabel("OOPM"); 
    l2 = new JLabel("AM-III");
    l3 = new JLabel("COA");
    l4 = new JLabel("DS");
    l5 = new JLabel("ROLL NO");
    l6 = new JLabel("AVERAGE ATTENDANCE");
    l7 = new JLabel("* Total number of lectures per subject is 100");
    l8 = new JLabel("No.lectures present");
    l9 = new JLabel("No. lectures absent");
    l1.setFont(new Font("Serif", Font.BOLD, 16));
    l2.setFont(new Font("Serif", Font.BOLD, 16));
    l3.setFont(new Font("Serif", Font.BOLD, 16));
    l4.setFont(new Font("Serif", Font.BOLD, 16));
    l5.setFont(new Font("Serif", Font.BOLD, 18));
    l6.setFont(new Font("Serif", Font.BOLD, 19));


    t1 = new JTextField();		//for DS
    t2 = new JTextField();		//for OOPM
    t3 = new JTextField();		//for AM 3
    t4 = new JTextField();		//for COA
    t5 = new JTextField();		//for rollno
    
    btn1 = new JButton("Submit");
    btn2 = new JButton("Clear");
    btn3 = new JButton("Send Chart");

    btn1.addActionListener(this);
    btn2.addActionListener(this);
	btn3.addActionListener(this);
    //l1.setBounds(100, 30, 400, 30);
    /*l1.setBounds(80, 110, 200, 30);
    l2.setBounds(80, 150, 200, 30);
    l3.setBounds(80, 190, 200, 30);
    l4.setBounds(80, 235, 200, 30);
    l5.setBounds(80, 70, 200, 30);

    t1.setBounds(320, 110, 100, 30);
    t2.setBounds(320, 150, 100, 30);
    t3.setBounds(320, 190, 100, 30);
    t4.setBounds(320, 235, 100, 30);
    t5.setBounds(320, 70, 100, 30);*/

    l7.setBounds(420,120,300,30);
    l1.setBounds(20,40,140,20);
    t1.setBounds(100,40,100,20);
    l2.setBounds(260,40,140,20);
    t2.setBounds(340,40,100,20);
    l3.setBounds(500,40,140,20);
    t3.setBounds(580,40,100,20);
    l4.setBounds(720,40,140,20);
    t4.setBounds(800,40,100,20);
    l5.setBounds(20,5,140,20);		//roll no text
    t5.setBounds(120,5,80,20);
    l6.setBounds(50,460,300,20);
    l8.setBounds(900,350,150,20);
    l9.setBounds(900,380,150,20);

    btn1.setBounds(250,100,140,20);
    btn2.setBounds(450,100,140,20);
    btn3.setBounds(620,100,140,20);

    add(l1);
    add(l2);
    add(l3);
    add(l4);
    add(l5);
    add(l6);    //adding all JLabels 
    add(t1);
    add(l7);
    add(t2);
    add(t3);
    add(t4);
    add(t5);    //adding all JTextFields
    add(btn1);
    add(btn2);    //adding both JButtons
    add(btn3);
  }
  //create a component that you can actually draw on.
  class DrawPane extends JPanel
  {
    public void paintComponent(Graphics g)
    {
    		//draw on g here e.g.
    	g.setColor(Color.YELLOW);
    	g.fillRect(880,390,15,15);

      g.setColor(Color.RED);
      g.fillRect(880,420,15,15);
      g.setColor(Color.BLACK);

      g.drawString("Attended", 905, 400);
      g.drawString("Absent", 905, 430);
      g.drawString("Enter Subjectwise attendances out of 100", 240 , 25);



      Color customColor = new Color(100,115,75);
      this.setBackground(customColor);
      
      //Att 1
      g.setColor(Color.YELLOW);
      g.fillArc(50,175,200,200,0,q1);
      g.setColor(Color.RED);
      g.fillArc(50,175,200,200,q1,360-q1);

      //Att 2
      g.setColor(Color.YELLOW);
      g.fillArc(300,175,200,200,0,q2);
      g.setColor(Color.RED);
      g.fillArc(300,175,200,200,q2,360-q2);

      //Att 3
      g.setColor(Color.YELLOW);
      g.fillArc(545,175,200,200,0,q3);
      g.setColor(Color.RED);
      g.fillArc(545,175,200,200,q3,360-q3);

      //Att 4
      g.setColor(Color.YELLOW);
      g.fillArc(800,175,200,200,0,q4);
      g.setColor(Color.RED);
      g.fillArc(800,175,200,200,q4,360-q4);

      //Att 5
      g.setColor(Color.GREEN);
      g.fillArc(380,500,200,200,0,q5);
      g.setColor(Color.RED);
      g.fillArc(380,500,200,200,q5,360-q5);
    }
  }

  public void actionPerformed(ActionEvent e) 
  {
    if (e.getSource() == btn1)
    {
      String s1 = t5.getText();   //Roll no
      String s2 = t2.getText();   //Attendance 1
      String s3 = t3.getText();   //Attendance 2
      String s4 = t4.getText();   //Attendance 3
      String s5 = t1.getText();   //Attendance 4
      m1=Integer.parseInt(s5);
      m2=Integer.parseInt(s2);
      m3=Integer.parseInt(s3);
      m4=Integer.parseInt(s4);
      q1=((m1*360)/100);
      q2=((m2*360)/100);
      q3=((m3*360)/100);
      q4=((m4*360)/100);
      m5=(m1+m2+m3+m4)/4;
      q5=((m5*360)/100);
      if (m1<=100 & m2 <=100 & m3<=100 & m4<=100)
      {
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oopmfinal","root",""); 
          stmt=con.createStatement();
          //execute query in table 'marks'
          int j = stmt.executeUpdate("INSERT INTO attsem VALUES('"+s1+ "', '"+s2+"','"+s3+"', '"+s4+ "','"+ s5+ "','" +m5+ "')");

          if (j > 0)    //query returns 1 if successful
          {
            JOptionPane.showMessageDialog(btn1, "Data Saved Successfully\n Average stored: "+m5);
          }
          else
          {
        	  JOptionPane.showMessageDialog(btn1, "Error storing given values! \nTry again");
          }
        }
        catch (Exception ex) 
        {
          System.out.println(ex);
        }
      }
      else
      {
    	  JOptionPane.showMessageDialog(btn1, "Either attendance more than 100% \nTry again");

      }
    }
    else if(e.getSource()==btn2)
    {
      t1.setText("");
      t2.setText("");
      t3.setText("");
      t4.setText("");
      t5.setText("");
    }
    else
    {
    	JOptionPane.showMessageDialog(btn3, "Chart statistics sent to Students!\n (Mailing group: SY_COMP_B)");
    }
  }

  public static void main(String args[])
  {
    new Attendance();
  }
}

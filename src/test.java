import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
class user implements Serializable{
String branch;
String name;
static bookie d;
String roll;
ArrayList<String> book = new ArrayList<String>();
ArrayList<String> tim = new ArrayList<String>();
ArrayList<String> code = new ArrayList<String>();
public int setBook(String s,JTextField f)
{
try{d= new bookie();
FileInputStream ft = new FileInputStream("Books.ser");
ObjectInputStream o = new ObjectInputStream(ft);
d= (bookie) o.readObject();
o.close();
ft.close();}
catch(FileNotFoundException e){try{d= new bookie();
String fe = "Books.ser";
File fi = new File(fe);
FileOutputStream fy = new FileOutputStream(fi);
ObjectOutputStream o = new ObjectOutputStream(fy);
o.writeObject(d);
o.close();}
catch(IOException e3){}}
catch(IOException e1){}
catch(ClassNotFoundException e2){}
finally{if(book.size()<5){
if(d.lib_books.containsKey(s)){
code.add(s);
book.add(d.lib_books.get(s));
f.setText(d.lib_books.get(s));
return 0;}else{return 2;}}
else{return 1;}
}}
public int removeBook(String s){
if(book.size()>=0)
{if(book.contains(s)){int a =book.indexOf(s);book.remove(a);tim.remove(a);
return 0;}
else{return 1;}}
else{return 2;}
}
public void setTime(String s)
{
tim.add(s);
}
public void setName(String s){
name = s;
}
public void setBranch(String a){
branch = a;
}
public void setRoll(String a){
roll = a;
}
public String getName(){
return name;
}
public String getBranch()
{
return branch;
}
public String getRoll()
{
return roll;
}
}






class Std extends test{
Font font= new Font("Verdana",Font.ITALIC,15);
Font font2= new Font("Verdana",Font.BOLD,20);
JFrame frame;
JFrame frame2;
JTextField f1;
JTextField f2;
JTextField f3;
JButton b1;
JButton b2;
public void go(int a){
try{
super.go();
}
catch(NullPointerException e)
{}
}
public void go(){
try{
u[count]= new user();
frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel p1 = new JPanel();
p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
f1 = new JTextField(20);
f1.setPreferredSize(new Dimension(50,70));
f1.setMaximumSize(f1.getPreferredSize());
f1.addActionListener(new f1Listener());
f2 = new JTextField(20);
f2.setPreferredSize(new Dimension(50,70));
f2.setMaximumSize(f2.getPreferredSize());
f2.addActionListener(new f2Listener());
f3 = new JTextField(20);
f3.setPreferredSize(new Dimension(50,70));
f3.setMaximumSize(f3.getPreferredSize());
f3.addActionListener(new f3Listener());
f1.setFont(font);
f1.setForeground(Color.BLACK);
f2.setFont(font);
f2.setForeground(Color.BLACK);
f3.setFont(font);
f3.setForeground(Color.BLACK);
p1.add(f1);
p1.add(f2);
p1.add(f3);
JPanel p2 = new JPanel();
p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
JLabel l1 = new JLabel("Enter name: ");
l1.setPreferredSize(new Dimension(50,84));
l1.setMinimumSize(l1.getPreferredSize());
JLabel l2 = new JLabel("Enter branch: ");
l2.setPreferredSize(new Dimension(50,84));
l2.setMinimumSize(l2.getPreferredSize());
JLabel l3 = new JLabel("Enter Roll no: ");
l3.setPreferredSize(new Dimension(50,84));
l3.setMinimumSize(l3.getPreferredSize());
p2.add(l1);
p2.add(l2);
p2.add(l3);
JPanel p3 = new JPanel();
JLabel l4 = new JLabel("STUDENT");
l4.setFont(font2);
l4.setForeground(Color.BLACK);
JPanel p4 = new JPanel();
b1 = new JButton("Save");
b1.addActionListener(new SListener());
b2 = new JButton("Return to Main");
b2.addActionListener(new RListener());
b1.setFont(font);
b1.setForeground(Color.WHITE);
b1.setBackground(Color.BLUE);
b2.setFont(font);
b2.setForeground(Color.WHITE);
b2.setBackground(Color.BLUE);
p4.add(b1);
p4.add(b2);
JPanel p5 = new JPanel();
p5.add(l4);
frame.getContentPane().add(BorderLayout.WEST,p3);
frame.getContentPane().add(BorderLayout.EAST,p1);
frame.getContentPane().add(BorderLayout.CENTER,p2);
frame.getContentPane().add(BorderLayout.SOUTH,p4);
frame.getContentPane().add(BorderLayout.NORTH,p5);
frame.setSize(500,350);
frame.setLocationRelativeTo(null);
frame.setVisible(true);
}
catch(NullPointerException e)
{}
}
class SListener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(u[count].getRoll()!=null){
String fe = u[count].getRoll() +".ser";
File fi = new File(fe);
FileOutputStream f = new FileOutputStream(fi);
ObjectOutputStream o = new ObjectOutputStream(f);
o.writeObject(u[count]);
o.close();
count++;
std.go();
}
else if (u[count].getRoll()==null){
f3.setText("PLEASE ENTER ROLL NO.");
}
}
catch(FileNotFoundException e1)
{}
catch(IOException e2)
{}
}
}

class RListener implements ActionListener{
public void actionPerformed(ActionEvent ev){
std.go(1);
}
}

class f1Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(f1.getText()!=null){
u[count].setName(f1.getText());
f2.requestFocus();
}
}
catch(NullPointerException e){
}
}
}
class f2Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(f2.getText()!=null){
u[count].setBranch(f2.getText());
f3.requestFocus();
}
}
catch(NullPointerException e)
{}
}
}
class f3Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(f3.getText()!=null){
u[count].setRoll(f3.getText());
b1.requestFocus();
}
}
catch(NullPointerException e)
{}
}
}
}


class Login extends test{
Font font= new Font("Verdana",Font.ITALIC,15);
Font font2= new Font("Verdana",Font.BOLD,20);
String name;
Info info;
JFrame frame;
JTextField f9;
JPanel p;
JPanel P;
JLabel cl;
FileInputStream f;
ObjectInputStream o;

public void go(){
frame = new JFrame("Login");
p = new JPanel();
P= new JPanel();
P.setLayout(new FlowLayout());
p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
cl = new JLabel("Please enter your roll no. and press Enter:");
cl.setFont(font2);
cl.setForeground(Color.BLACK);
JLabel c4 = new JLabel(" ");
c4.setPreferredSize(new Dimension(100,100));
c4.setMinimumSize(c4.getPreferredSize());
f9 = new JTextField(50);
f9.setPreferredSize(new Dimension(200,50));
f9.setMaximumSize(f9.getPreferredSize());
f9.setFont(font);
f9.setForeground(Color.BLACK);
f9.requestFocus();
JButton b1= new JButton("Login");
b1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){try{name = f9.getText() + ".ser";f = new FileInputStream(name);o = new ObjectInputStream(f);v= (user) o.readObject();o.close();f.close();info.doit(v,p,P,frame);}catch(FileNotFoundException evv){f9.setText("Wrong Roll Number");}catch(IOException ev){}catch(ClassNotFoundException evvv){}}});
b1.setFont(font);
b1.setForeground(Color.WHITE);
b1.setBackground(Color.BLUE);
p.add(cl);
p.add(f9);
p.add(c4);
p.add(b1);
frame.getContentPane().add(BorderLayout.CENTER,p);
frame.getContentPane().add(BorderLayout.SOUTH,P);
frame.setSize(500,350);
frame.setLocationRelativeTo(null);
frame.setVisible(true);
info = new Info();
v= new user();
}

}





class Info extends Login{
Font font= new Font("Verdana",Font.ITALIC,15);
static Books b;
static Returns r;
public void doit(user v, JPanel p, JPanel P, JFrame frame){
p.removeAll();
p.setFont(font);
p.setForeground(Color.BLACK);
p.add(new JLabel("Name: "));
p.add(new JLabel(v.getName()));
p.add(new JLabel("Branch: "));
p.add(new JLabel(v.getBranch()));
p.add(new JLabel("Roll number: "));
p.add(new JLabel(v.getRoll()));
JTextArea text = new JTextArea(20,10);
text.setEditable(false);
text.setFont(font);
text.setForeground(Color.WHITE);
text.setBackground(Color.BLACK);
p.add(text);
JButton b1= new JButton("ISSUE");
b1.addActionListener(new IssueListener());
JButton b2 = new JButton("RETURN");
b2.addActionListener(new ReturnListener());
JButton b3 = new JButton("To main");
b3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ev){play.go();}});
b1.setFont(font);
b1.setForeground(Color.WHITE);
b1.setBackground(Color.BLUE);
b2.setFont(font);
b2.setForeground(Color.WHITE);
b2.setBackground(Color.BLUE);
b3.setFont(font);
b3.setForeground(Color.WHITE);
b3.setBackground(Color.BLUE);
P.add(b1);
P.add(b2);
P.add(b3);
if(!v.book.isEmpty()){
for(int i=0;i<v.book.size();i++)
{
text.append((i+1)+">>  "+v.code.get(i)+": "+v.book.get(i)+v.tim.get(i)+"\n");
}
if(v.book.size()==5){
b1.setEnabled(false);
}
}
else{text.append("No Books Issued!!");
b2.setEnabled(false);
}
p.revalidate();
frame.repaint();
}
class IssueListener implements ActionListener{
public void actionPerformed(ActionEvent ev){
b = new Books();
b.play(v);
}
}
class ReturnListener implements ActionListener{
public void actionPerformed(ActionEvent evs){
r = new Returns();
r.play(v);
}
}
}



class Books extends Info{
JFrame frame2;
Font font= new Font("Verdana",Font.ITALIC,15);
JTextField f2;
JTextField f3;
JTextField f4;
JTextField f5;
JTextField f6;
JButton b1;

public void play(user v)
{
frame2 = new JFrame("Issue a Book");
JPanel p3 = new JPanel();
p3.add(new JLabel("Name: "));
p3.add(new JLabel(v.getName()));
p3.add(new JLabel("Branch: "));
p3.add(new JLabel(v.getBranch()));
p3.add(new JLabel("Roll number: "));
p3.add(new JLabel(v.getRoll()));
frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f6 = new JTextField(20);
f6.setPreferredSize(new Dimension(50,70));
f6.setMaximumSize(f6.getPreferredSize());
f6.addActionListener(new f6Listener());
f2 = new JTextField(20);
f2.setPreferredSize(new Dimension(50,70));
f2.setMaximumSize(f2.getPreferredSize());
f2.addActionListener(new f2Listener());
f3 = new JTextField(20);
f3.setPreferredSize(new Dimension(50,70));
f3.setMaximumSize(f3.getPreferredSize());
f3.addActionListener(new f3Listener());
f4 = new JTextField(20);
f4.setPreferredSize(new Dimension(50,70));
f4.setMaximumSize(f4.getPreferredSize());
f4.addActionListener(new f4Listener());
f5 = new JTextField(20);
f5.setPreferredSize(new Dimension(50,70));
f5.setMaximumSize(f5.getPreferredSize());
f5.addActionListener(new f5Listener());
f6.setFont(font);
f2.setFont(font);
f3.setFont(font);
f4.setFont(font);
f5.setFont(font);
JPanel p1 = new JPanel();
p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
p1.add(f6);
p1.add(f2);
p1.add(f3);
p1.add(f4);
p1.add(f5);
JPanel p2 = new JPanel();
p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
JLabel l1 = new JLabel("Enter Book 1: ");
l1.setPreferredSize(new Dimension(50,84));
l1.setMinimumSize(l1.getPreferredSize());
JLabel l2 = new JLabel("Enter Book 2: ");
l2.setPreferredSize(new Dimension(50,84));
l2.setMinimumSize(l2.getPreferredSize());
JLabel l3 = new JLabel("Enter Book 3: ");
l3.setPreferredSize(new Dimension(50,84));
l3.setMinimumSize(l3.getPreferredSize());
JLabel l4 = new JLabel("Enter Book 4: ");
l4.setPreferredSize(new Dimension(50,84));
l4.setMinimumSize(l3.getPreferredSize());
JLabel l5 = new JLabel("Enter Book 5: ");
l5.setPreferredSize(new Dimension(50,84));
l5.setMinimumSize(l3.getPreferredSize());
p2.add(l1);
p2.add(l2);
p2.add(l3);
p2.add(l4);
p2.add(l5);
JPanel p4 = new JPanel();
b1 = new JButton("Save");
b1.addActionListener(new SListener());
p4.add(b1);
b1.setFont(font);
b1.setForeground(Color.WHITE);
b1.setBackground(Color.BLUE);
frame2.getContentPane().add(BorderLayout.EAST,p1);
frame2.getContentPane().add(BorderLayout.CENTER,p2);
frame2.getContentPane().add(BorderLayout.SOUTH,p4);
frame2.getContentPane().add(BorderLayout.NORTH,p3);
frame2.setSize(500,500);
frame2.setLocationRelativeTo(null);
frame2.setVisible(true);
}
class SListener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
String fe = v.getRoll() +".ser";
File fi = new File(fe);
FileOutputStream f = new FileOutputStream(fi);
ObjectOutputStream o = new ObjectOutputStream(f);
o.writeObject(v);
o.close();
b.go();
}
catch(FileNotFoundException e1)
{}
catch(IOException e2)
{}
}
}
class f6Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(v.setBook(f6.getText(),f6)==0)
{
Calendar c = Calendar.getInstance();
v.setTime("   Issued On: "+c.get(c.DATE)+"/"+c.get(c.MONTH)+"/"+c.get(c.YEAR)+"  "+c.get(c.HOUR)+":"+c.get(c.MINUTE)+":"+c.get(c.SECOND));
f2.requestFocus();
}else if(v.setBook(f6.getText(),f6)==2){f6.setText("Wrong Book Code");}
else{
f6.setText("SORRY CART FULL!!");
}
}
catch(NullPointerException e)
{}
}
}
class f2Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(v.setBook(f2.getText(),f2)==0)
{
Calendar c = Calendar.getInstance();
v.setTime("   Issued On: "+c.get(c.DATE)+"/"+c.get(c.MONTH)+"/"+c.get(c.YEAR)+"  "+c.get(c.HOUR)+":"+c.get(c.MINUTE)+":"+c.get(c.SECOND));
f3.requestFocus();
}else if(v.setBook(f2.getText(),f2)==2){f2.setText("Wrong Book Code");}
else{
f2.setText("SORRY CART FULL!!");
}
}
catch(NullPointerException e)
{}
}
}
class f3Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(v.setBook(f3.getText(),f3)==0)
{
Calendar c = Calendar.getInstance();
v.setTime("   Issued On: "+c.get(c.DATE)+"/"+c.get(c.MONTH)+"/"+c.get(c.YEAR)+"  "+c.get(c.HOUR)+":"+c.get(c.MINUTE)+":"+c.get(c.SECOND));
f4.requestFocus();
}else if(v.setBook(f3.getText(),f3)==2){f3.setText("Wrong Book Code");}
else{
f3.setText("SORRY CART FULL!!");
}
}
catch(NullPointerException e)
{}
}
}
class f4Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(v.setBook(f4.getText(),f4)==0)
{
Calendar c = Calendar.getInstance();
v.setTime("   Issued On: "+c.get(c.DATE)+"/"+c.get(c.MONTH)+"/"+c.get(c.YEAR)+"  "+c.get(c.HOUR)+":"+c.get(c.MINUTE)+":"+c.get(c.SECOND));
f5.requestFocus();
}else if(v.setBook(f4.getText(),f4)==2){f4.setText("Wrong Book Code");}
else{
f4.setText("SORRY CART FULL!!");
}
}
catch(NullPointerException e)
{}
}
}
class f5Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(v.setBook(f5.getText(),f5)==0)
{
Calendar c = Calendar.getInstance();
v.setTime("   Issued On: "+c.get(c.DATE)+"/"+c.get(c.MONTH)+"/"+c.get(c.YEAR)+"  "+c.get(c.HOUR)+":"+c.get(c.MINUTE)+":"+c.get(c.SECOND));
b1.requestFocus();
}else if(v.setBook(f5.getText(),f5)==2){f5.setText("Wrong Book Code");}
else{
f5.setText("SORRY CART FULL!!");
}
}
catch(NullPointerException e)
{}
}
}
}




class Returns extends Info{
JFrame frame2;
JTextField f2;
JTextField f3;
JTextField f4;
JTextField f5;
JTextField f6;
JButton b1;
Font font= new Font("Verdana",Font.ITALIC,15);

public void play(user v)
{
frame2 = new JFrame("Return a Book");
JPanel p3 = new JPanel();
p3.add(new JLabel("Name: "));
p3.add(new JLabel(v.getName()));
p3.add(new JLabel("Branch: "));
p3.add(new JLabel(v.getBranch()));
p3.add(new JLabel("Roll number: "));
p3.add(new JLabel(v.getRoll()));
frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f6 = new JTextField(20);
f6.setPreferredSize(new Dimension(50,70));
f6.setMaximumSize(f6.getPreferredSize());
f6.addActionListener(new f6Listener());
f2 = new JTextField(20);
f2.setPreferredSize(new Dimension(50,70));
f2.setMaximumSize(f2.getPreferredSize());
f2.addActionListener(new f2Listener());
f3 = new JTextField(20);
f3.setPreferredSize(new Dimension(50,70));
f3.setMaximumSize(f3.getPreferredSize());
f3.addActionListener(new f3Listener());
f4 = new JTextField(20);
f4.setPreferredSize(new Dimension(50,70));
f4.setMaximumSize(f4.getPreferredSize());
f4.addActionListener(new f4Listener());
f5 = new JTextField(20);
f5.setPreferredSize(new Dimension(50,70));
f5.setMaximumSize(f5.getPreferredSize());
f5.addActionListener(new f5Listener());
JPanel p1 = new JPanel();
p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
f6.setFont(font);
f2.setFont(font);
f3.setFont(font);
f4.setFont(font);
f5.setFont(font);
p1.add(f6);
p1.add(f2);
p1.add(f3);
p1.add(f4);
p1.add(f5);
JPanel p2 = new JPanel();
p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
JLabel l1 = new JLabel("Enter Book 1: ");
l1.setPreferredSize(new Dimension(50,84));
l1.setMinimumSize(l1.getPreferredSize());
JLabel l2 = new JLabel("Enter Book 2: ");
l2.setPreferredSize(new Dimension(50,84));
l2.setMinimumSize(l2.getPreferredSize());
JLabel l3 = new JLabel("Enter Book 3: ");
l3.setPreferredSize(new Dimension(50,84));
l3.setMinimumSize(l3.getPreferredSize());
JLabel l4 = new JLabel("Enter Book 4: ");
l4.setPreferredSize(new Dimension(50,84));
l4.setMinimumSize(l3.getPreferredSize());
JLabel l5 = new JLabel("Enter Book 5: ");
l5.setPreferredSize(new Dimension(50,84));
l5.setMinimumSize(l3.getPreferredSize());
p2.add(l1);
p2.add(l2);
p2.add(l3);
p2.add(l4);
p2.add(l5);
JPanel p4 = new JPanel();
b1 = new JButton("Save");
b1.addActionListener(new SListener());
b1.setFont(font);
b1.setForeground(Color.WHITE);
b1.setBackground(Color.BLUE);
p4.add(b1);
frame2.getContentPane().add(BorderLayout.EAST,p1);
frame2.getContentPane().add(BorderLayout.CENTER,p2);
frame2.getContentPane().add(BorderLayout.SOUTH,p4);
frame2.getContentPane().add(BorderLayout.NORTH,p3);
frame2.setSize(500,500);
frame2.setLocationRelativeTo(null);
frame2.setVisible(true);
}
class SListener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
String fe = v.getRoll() +".ser";
File fi = new File(fe);
FileOutputStream f = new FileOutputStream(fi);
ObjectOutputStream o = new ObjectOutputStream(f);
o.writeObject(v);
o.close();
r.go();
}
catch(FileNotFoundException e1)
{}
catch(IOException e2)
{}
}
}
class f6Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(v.removeBook(f6.getText())==0)
{
f2.requestFocus();
}
else if(v.removeBook(f6.getText())==1){
f6.setText("NO SUCH BOOKS ISSUED");
}
else{
f6.setText("SORRY CART EMPTY!!");
}
}
catch(NullPointerException e)
{}
}
}
class f2Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(v.removeBook(f2.getText())==0)
{
f3.requestFocus();
}else if(v.removeBook(f6.getText())==1){
f2.setText("NO SUCH BOOKS ISSUED");
}
else{
f2.setText("SORRY CART EMPTY!!");
}
}
catch(NullPointerException e)
{}
}
}
class f3Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(v.removeBook(f3.getText())==0)
{
f4.requestFocus();
}else if(v.removeBook(f6.getText())==1){
f3.setText("NO SUCH BOOKS ISSUED");
}
else{
f3.setText("SORRY CART EMPTY!!");
}
}
catch(NullPointerException e)
{}
}
}
class f4Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(v.removeBook(f4.getText())==0)
{
f5.requestFocus();
}else if(v.removeBook(f6.getText())==1){
f4.setText("NO SUCH BOOKS ISSUED");
}
else{
f4.setText("SORRY CART EMPTY!!");
}
}
catch(NullPointerException e)
{}
}
}
class f5Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
if(v.removeBook(f5.getText())==0)
{
b1.requestFocus();
}else if(v.removeBook(f6.getText())==1){
f5.setText("NO SUCH BOOKS ISSUED");
}
else{
f5.setText("SORRY CART EMPTY!!");
}
}
catch(NullPointerException e)
{}
}
}
}


class bookie implements Serializable{
Hashtable<String, String> lib_books= new Hashtable<String, String>();
}

class Lib extends test{
JFrame frame2;
Font font= new Font("Verdana",Font.ITALIC,15);
Font font2= new Font("Verdana",Font.BOLD,13);
Font font3= new Font("Verdana",Font.BOLD,15);
JTextField f2;
JTextField f3;
JTextField f4;
JTextField f5;
JTextField f6;
JTextField f7;
JTextField f8;
JTextField f9;
JButton b1;
static bookie d;

public void go(){
try{d= new bookie();
FileInputStream f = new FileInputStream("Books.ser");
ObjectInputStream o = new ObjectInputStream(f);
d= (bookie) o.readObject();
o.close();
f.close();}
catch(FileNotFoundException e){try{d= new bookie();
String fe = "Books.ser";
File fi = new File(fe);
FileOutputStream f = new FileOutputStream(fi);
ObjectOutputStream o = new ObjectOutputStream(f);
o.writeObject(d);
o.close();}
catch(IOException e3){}}
catch(IOException e1){}
catch(ClassNotFoundException e2){}
finally{
frame2 = new JFrame("Save a Book");
frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f6 = new JTextField(17);
f6.setPreferredSize(new Dimension(30,30));
f6.setMaximumSize(f6.getPreferredSize());
f6.addActionListener(new f6Listener());
f2 = new JTextField(5);
f2.setPreferredSize(new Dimension(30,30));
f2.setMaximumSize(f2.getPreferredSize());
f2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){f6.requestFocus();}});
f3 = new JTextField(5);
f3.setPreferredSize(new Dimension(30,30));
f3.setMaximumSize(f3.getPreferredSize());
f3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){f7.requestFocus();}});
f4 = new JTextField(5);
f4.setPreferredSize(new Dimension(30,30));
f4.setMaximumSize(f4.getPreferredSize());
f4.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){f8.requestFocus();}});
f5 = new JTextField(5);
f5.setPreferredSize(new Dimension(30,30));
f5.setMaximumSize(f5.getPreferredSize());
f5.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){f9.requestFocus();}});
f7 = new JTextField(17);
f7.setPreferredSize(new Dimension(30,30));
f7.setMaximumSize(f7.getPreferredSize());
f7.addActionListener(new f7Listener());
f8 = new JTextField(17);
f8.setPreferredSize(new Dimension(30,30));
f8.setMaximumSize(f8.getPreferredSize());
f8.addActionListener(new f8Listener());
f9 = new JTextField(17);
f9.setPreferredSize(new Dimension(30,30));
f9.setMaximumSize(f9.getPreferredSize());
f9.addActionListener(new f9Listener());
f6.setFont(font);
f2.setFont(font);
f3.setFont(font);
f4.setFont(font);
f5.setFont(font);
f7.setFont(font);
f8.setFont(font);
f9.setFont(font);
JPanel p1 = new JPanel();
p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
p1.add(f2);
p1.add(f3);
p1.add(f4);
p1.add(f5);
JPanel p3 = new JPanel();
p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
p3.add(f6);
p3.add(f7);
p3.add(f8);
p3.add(f9);
JPanel p2 = new JPanel();
p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
JLabel l1 = new JLabel("Enter Book 1: ");
JLabel l2 = new JLabel("Enter Book 2: ");
JLabel l3 = new JLabel("Enter Book 3: ");
JLabel l4 = new JLabel("Enter Book 4: ");
JLabel ll1 = new JLabel("  ");
JLabel ll2 = new JLabel("  ");
JLabel ll3 = new JLabel("  ");
l1.setFont(font2);
l2.setFont(font2);
l3.setFont(font2);
l4.setFont(font2);
p2.add(l1);
p2.add(ll1);
p2.add(l2);
p2.add(ll2);
p2.add(l3);
p2.add(ll3);
p2.add(l4);
JPanel p4 = new JPanel();
b1 = new JButton("Save");
b1.addActionListener(new SListener());
p4.add(b1);
b1.setFont(font);
b1.setForeground(Color.WHITE);
b1.setBackground(Color.BLUE);
JPanel p5 = new JPanel();
p5.add(p1);
p5.add(p3);
JPanel p6 = new JPanel();
JLabel pl1= new JLabel("Book Code");
JLabel pl3= new JLabel("   ");
JLabel pl2= new JLabel("Book Name");
p6.add(pl1);
p6.add(pl3);
p6.add(pl2);
pl1.setFont(font3);
pl2.setFont(font3);
frame2.getContentPane().add(BorderLayout.NORTH,p6);
frame2.getContentPane().add(BorderLayout.EAST,p5);
frame2.getContentPane().add(BorderLayout.SOUTH,p4);
frame2.getContentPane().add(BorderLayout.CENTER,p2);
frame2.setSize(500,300);
frame2.setLocationRelativeTo(null);
frame2.setVisible(true);
}
}
class SListener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
String fe = "Books.ser";
File fi = new File(fe);
FileOutputStream f = new FileOutputStream(fi);
ObjectOutputStream o = new ObjectOutputStream(f);
o.writeObject(d);
o.close();
System.out.println(d.lib_books.keySet());
play.go();

}
catch(FileNotFoundException e1)
{}
catch(IOException e2)
{}
}
}
class f6Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
try{
if(Integer.parseInt(f2.getText()+"1")==1){
f2.setText("Error");}
else if(Integer.parseInt(f6.getText()+"1")==1){
f6.setText("Error");}
}
catch(NumberFormatException e1)
{
d.lib_books.put(f2.getText(),f6.getText());
f3.requestFocus();
}
}
catch(NullPointerException e)
{}
}
}
class f7Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
try{
if(Integer.parseInt(f3.getText()+"1")==1){
f3.setText("Error");}
else if(Integer.parseInt(f7.getText()+"1")==1){
f7.setText("Error");}
}
catch(NumberFormatException e1)
{
d.lib_books.put(f3.getText(),f7.getText());
f4.requestFocus();
}
}
catch(NullPointerException e)
{}
}
}
class f8Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
try{
if(Integer.parseInt(f4.getText()+"1")==1){
f4.setText("Error");}
else if(Integer.parseInt(f8.getText()+"1")==1){
f8.setText("Error");}
}
catch(NumberFormatException e1)
{
d.lib_books.put(f4.getText(),f8.getText());
f5.requestFocus();
}
}
catch(NullPointerException e)
{}
}
}
class f9Listener implements ActionListener{
public void actionPerformed(ActionEvent ev){
try{
try{
if(Integer.parseInt(f5.getText()+"1")==1){
f5.setText("Error");}
else if(Integer.parseInt(f9.getText()+"1")==1){
f9.setText("Error");}
}
catch(NumberFormatException e1)
{
d.lib_books.put(f5.getText(),f9.getText());
b1.requestFocus();
}
}
catch(NullPointerException e)
{}
}
}
}



public class test{
static Std std;
static Login login;
static Lib lib; 
static int j =150;
static int count=0;
static user[] u;
static String choice;
static user v;
static test play;
JTextField ch;
Font font= new Font("Verdana",Font.BOLD,12);
Font font2= new Font("Verdana",Font.BOLD,20);

public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
play = new test();
play.welcome();
}
public void welcome(){
JFrame base = new JFrame("Welcome");
base.setFont(font);
base.setForeground(Color.RED);
final JPanel ps = new JPanel();
ps.setLayout(new BoxLayout(ps,BoxLayout.Y_AXIS));
base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JLabel c1 = new JLabel("<<Library Software version 2.0>>");
c1.setHorizontalAlignment(SwingConstants.CENTER);
c1.setFont(font2);
c1.setForeground(Color.BLACK);
JLabel c7 = new JLabel(" ");
JLabel c8 = new JLabel(" ");
JLabel c2 = new JLabel("Developed by:");
c2.setFont(font);
c2.setForeground(Color.BLACK);
JLabel c3 = new JLabel("CHINMAY JAIN");
c3.setFont(font2);
c3.setForeground(Color.BLUE);
JLabel c4 = new JLabel(" ");
JLabel c5 = new JLabel(" ");
JLabel c6 = new JLabel(" ");
JPanel ps1= new JPanel();
JButton ch = new JButton("Enter");
ch.setFont(font);
ch.setForeground(Color.WHITE);
ch.setBackground(Color.BLUE);
JLabel c9 = new JLabel("   ");
ps.add(c1);
ps.add(c7);
ps.add(c8);
ps.add(c2);
ps.add(c3);
ps.add(c4);
ps.add(c5);
ps.add(c6);
ps1.add(c9);
ps1.add(ch);
ps.add(ps1);
ch.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){play.go();}});
base.getContentPane().add(ps);
base.setSize(500,350);
base.setLocationRelativeTo(null);
base.setVisible(true);
}
public void go(){
Font font= new Font("Verdana",Font.BOLD,14);
Font font2= new Font("Verdana",Font.BOLD,16);
Font font3= new Font("Verdana",Font.BOLD,10);
JFrame base = new JFrame("Library Software");
base.setFont(font);
base.setForeground(Color.RED);
JPanel ps = new JPanel();
ps.setLayout(new BoxLayout(ps,BoxLayout.Y_AXIS));
base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel ps2 = new JPanel();
JLabel c1 = new JLabel("Please select your choice:");
c1.setFont(font2);
c1.setForeground(Color.BLACK);
JPanel ps1= new JPanel(new GridLayout(1,2));
JButton b1= new JButton("Register");
b1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){std= new Std();u=new user[j];std.go();}});
JButton b2= new JButton("Login");
b1.setFont(font);
b1.setForeground(Color.WHITE);
b1.setBackground(Color.BLUE);
b2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){login= new Login();login.go();}});
b2.setFont(font);
b2.setForeground(Color.WHITE);
b2.setBackground(Color.BLUE);
JButton b3= new JButton("Book");
b3.setFont(font);
b3.setForeground(Color.WHITE);
b3.setBackground(Color.BLUE);
b3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){lib= new Lib();lib.go();}});
JLabel c4 = new JLabel(" ");
JLabel c5 = new JLabel("CopyRight by Chinmay. All Rights Reserved");
c4.setPreferredSize(new Dimension(50,120));
c4.setMinimumSize(c4.getPreferredSize());
c5.setPreferredSize(new Dimension(50,120));
c5.setMinimumSize(c5.getPreferredSize());
c5.setFont(font3);
ps1.add(b3);
ps1.add(b1);
ps1.add(b2);
ps2.add(c1);
ps.add(ps2);
ps.add(c4);
ps.add(ps1);
ps.add(c5);
base.getContentPane().add(ps);
base.setSize(550,350);
base.setLocationRelativeTo(null);
base.setVisible(true);
}
}
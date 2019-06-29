/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell-pc
 */

    import java.awt.*; 
import javax.swing.*; 
import java.io.*; 
import java.awt.event.*; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.text.AttributedString;
import javafx.scene.control.Alert;
import javax.swing.plaf.metal.*; 
import javax.swing.text.*; 
import javax.swing.text.StyledDocument;
import javax.swing.text.Highlighter.HighlightPainter;
class textEditor extends JFrame implements ActionListener { 
    
  
    // define a text area for the frame used. 
    JTextPane t; 
    // also adding a scroll bar in case the text is more that of the text area.
    JScrollPane scroll;
     JFrame square=new JFrame();
    JFrame rectangle=new JFrame();
    JFrame circle=new JFrame();
    JFrame oval=new JFrame();
    JFrame triangle=new JFrame();
    
  
    // Declare a Frame 
    JFrame f; 
  
    // we creat a constructor for the textEditor class 
    textEditor() 
    { 
        // we create a frame 
        f = new JFrame("Text Editor"); 
       // declaring a try catch block in case of errors
        try { 
            // we use the UIManager to set the looks of the entire bar 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
  
             
        } 
        catch (Exception eve) { 
        } 
        t = new JTextPane();
         scroll = new JScrollPane(t);
        // we define the textarea declares earlier
        
       
  
        // we create a menubar to hold all the menu items 
        JMenuBar menuBar = new JMenuBar(); 
  
        // Create amenu for menu 
        JMenu file = new JMenu("File"); 
  
        // Create menu items 
        JMenuItem ne = new JMenuItem("New"); 
        JMenuItem open = new JMenuItem("Open"); 
        JMenuItem save = new JMenuItem("Save"); 
        JMenuItem print= new JMenuItem("Print"); 
  
        // Add action listener to the menuitems created
        ne.addActionListener(this); 
        open.addActionListener(this); 
        save.addActionListener(this); 
        print.addActionListener(this); 
  
        file.add(ne); 
        file.add(open); 
        file.add(save); 
        file.add(print); 
  
        // Create a menu for menu 
        JMenu edit = new JMenu("Edit"); 
  
        // Create menu items 
        JMenuItem cut = new JMenuItem("Cut"); 
        JMenuItem copy = new JMenuItem("Copy"); 
        JMenuItem paste= new JMenuItem("Paste"); 
  
        // Add action listener to the menuitems created
        cut.addActionListener(this); 
        copy.addActionListener(this); 
        paste.addActionListener(this); 
  
        edit.add(cut); 
        edit.add(copy); 
        edit.add(paste); 
        JMenuItem find = new JMenuItem("Find"); 
        JMenuItem remove= new JMenuItem("Remove Highlights"); 
        JMenuItem replace = new JMenuItem("Replace"); 
        JMenuItem replaceA = new JMenuItem("Replace all"); 
        JMenuItem count = new JMenuItem("Count"); 
  
        // Add action listener to the menuitems created
        find.addActionListener(this); 
        remove.addActionListener(this); 
        replace.addActionListener(this); 
        replaceA.addActionListener(this); 
        count.addActionListener(this);
        edit.add(count);
        edit.add(find); 
        edit.add(replace); 
        edit.add(replaceA);
        edit.add(remove);
        
         JMenu format= new JMenu("Format");
        JMenuItem font= new JMenuItem("Font Type");
        JMenuItem size=new JMenuItem("Font Size");
        
        JMenuItem changeCase= new JMenuItem("Font Case");
        font.addActionListener(this);
        
        changeCase.addActionListener(this);
        size.addActionListener(this);
       
        format.add(font);
        format.add(changeCase);
        format.add(size);
  
  
       
        JMenu shapes= new JMenu("Shapes");
        JMenuItem circle= new JMenuItem("Add Circle");
        JMenuItem square= new JMenuItem("Add Square");
        JMenuItem triangle= new JMenuItem("Add Triangle");
        JMenuItem rectangle= new JMenuItem("Add Rectangle");
        JMenuItem polygon= new JMenuItem("Add Oval");
       
        
       
        
        
        
                shapes.add(circle);
                shapes.add(square);
                shapes.add(triangle);
                shapes.add(rectangle);
                shapes.add(polygon);
                
                
                //add action listener to the menuitems created
        circle.addActionListener(this);
        square.addActionListener(this);
        triangle.addActionListener(this);
        rectangle.addActionListener(this);
        polygon.addActionListener(this);
       
                
        
  
        menuBar.add(file); 
        menuBar.add(edit);
        menuBar.add(format);
        menuBar.add(shapes);
        
        
       //add the menubar to the frame
       // we also set the size of the frame
  
        f.setJMenuBar(menuBar); 
        
        f.getContentPane().add(scroll, BorderLayout.CENTER);
       
        f.setSize(600, 600); 
        f.setVisible(rootPaneCheckingEnabled);
    } 
     // If a button is pressed 
    public void actionPerformed(ActionEvent e) 
    { 
        square.setSize(300, 300);
        rectangle.setSize(300, 300);
        circle.setSize(300, 300);
        oval.setSize(300,300);
        triangle.setSize(300,300);
        oval.setLocationRelativeTo(null);
        circle.setLocationRelativeTo(null);
        rectangle.setLocationRelativeTo(null);
        square.setLocationRelativeTo(null);
        triangle.setLocationRelativeTo(null);
        
        String find = "";
        String k="";
        String k1="";
        int ss;
        String str1="";
        String str2="";
        String s = e.getActionCommand(); 
        int p0=0;

//when we find for a word, then it is highlighted
        Highlighter highlighter = t.getHighlighter();
  
  
        if (s.equals("Cut")) { 
            t.cut(); 
        } 
        else if (s.equals("Copy")) { 
            t.copy(); 
        } 
        else if (s.equals("Paste")) { 
            t.paste(); 
        } 
        else if (s.equals("Save")) { 
            // we create an object of JFileChooser class 
            JFileChooser fc = new JFileChooser("f:"); 
  
            // we use the showsSaveDialog function to show the save dialog 
            int a = fc.showSaveDialog(null); 
  
            if (a == JFileChooser.APPROVE_OPTION) { 
  
                // Set the label to the path of the selected directory 
                File fi = new File(fc.getSelectedFile().getAbsolutePath()); 
  
                try { 
                    // Create a new file writer in order to save the file
                    FileWriter wr = new FileWriter(fi, false); 
  
                    //we would require a buffered writer to write the file. thus we create one. 
                    BufferedWriter bw = new BufferedWriter(wr); 
  
                    //we then write to it 
                    bw.write(t.getText()); 
  
                    bw.flush(); 
                    bw.close(); 
                } 
                catch (Exception eve) { 
                    JOptionPane.showMessageDialog(f, eve.getMessage()); 
                } 
            } 
            //if we choose to cancel the operation 
            else
                JOptionPane.showMessageDialog(f, "You chose to cancel the operation"); 
        } 
        else if (s.equals("Print")) { 
            try { 
                //we can directly print the file 
                t.print(); 
            } 
            catch (Exception eve) { 
                JOptionPane.showMessageDialog(f, eve.getMessage()); 
            } 
        } 
        else if (s.equals("Open")) { 
             
            // we create an object of JFileChooser class since we choose a file when we open a file 
            JFileChooser j = new JFileChooser("f:"); 
  
            // we call the showsOpenDialog function to show the save dialog box. 
            int r = j.showOpenDialog(null); 
  
            // we create an if, for the user when he selects a file
            if (r == JFileChooser.APPROVE_OPTION) { 
                // we then set the label to the path of the selected directory in the dialog box
                File fi = new File(j.getSelectedFile().getAbsolutePath()); 
  
                try { 
                    
                    String string1 = "", string2 = ""; 
  
                    //we create a  file reader 
                    FileReader fileR = new FileReader(fi); 
  
                    // e wuld require a Buffered reader for this
                    BufferedReader bufferR = new BufferedReader(fileR); 
  
                    // we intitailize a string string1 
                    string2 = bufferR.readLine(); 
  
                    // Take the input from the file 
                    while ((string1 = bufferR.readLine()) != null) { 
                        string2 = string2 + "\n" + string1; 
                    } 
  
                    // we then set this text to the text of textArea 
                    t.setText(string2); 
                } 
                catch (Exception eve) { 
                    JOptionPane.showMessageDialog(f, eve.getMessage()); 
                } 
            } 
            // If we chose to cancel the operation 
            else
                JOptionPane.showMessageDialog(f, "the user cancelled the operation"); 
        } 
        else if (s.equals("New")) { 
            t.setText(""); 
        } 
        else if (s.equals("Close")) { 
            f.setVisible(false); 
        } 
 else if(s.equals("Font Type"))
          {
            
            JFrame f=new JFrame();
          GraphicsEnvironment ge= GraphicsEnvironment.getLocalGraphicsEnvironment();
          String[] fontNames= ge.getAvailableFontFamilyNames();
          JComboBox type= new JComboBox(fontNames);
          
          
          type.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String Name_Of_Font=String.valueOf(type.getSelectedItem());
                Action typeAction=new StyledEditorKit.FontFamilyAction(String.valueOf(Name_Of_Font),Name_Of_Font);
                typeAction.actionPerformed(e);
            }
            
        });
          JOptionPane.showMessageDialog(f,type,"Font type",JOptionPane.QUESTION_MESSAGE);
         
          }
         
          
          else if(s.equals("Font Size")){
             String fontSize[]={"10","12","14","16","18","20","25","30","35","40"};      
         
          JComboBox FontSize= new JComboBox(fontSize);
          
            
          FontSize.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                  int size= Integer.parseInt((String)FontSize.getSelectedItem());
                  Action fontAction= new StyledEditorKit.FontSizeAction(String.valueOf(size), size);
                  fontAction.actionPerformed(e);
              }
          });
          JOptionPane.showMessageDialog(f,FontSize,"Font Size",JOptionPane.QUESTION_MESSAGE);
          
          
          
          
          
         
        }
        
            
           
        else if(s.equals("Find")) 
        {
            try{
            find = (String)JOptionPane.showInputDialog(null,"Enter the text to be found");
            // No text was entered
            if(find.isEmpty())
            {
               throw new NullPointerException();
                
            }
            
            String text=t.getText();
            //Highlighter is created to highlight the text to be found
             HighlightPainter painter = 
             new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
            //To search in the whole file
             while((p0=text.toUpperCase().indexOf(find.toUpperCase(),p0))>=0)
             {
              
              highlighter.addHighlight(p0, p0+find.length(), painter);
              p0+=find.length();
             }
             
            }
            catch(BadLocationException ae)
            {
                JOptionPane.showMessageDialog(null, "Bad Location");
            }
            catch(NullPointerException ae1)
            {
                JOptionPane.showMessageDialog(null, "No text was entered");
            }
        }
        
        else if(s.equals("Replace all"))
        {   
            
         
           
         
            k=t.getText();
            k1=t.getText();
            ss=k.length();
            String finalCase=k;
            
            if(k.isEmpty() || k.trim().isEmpty() )
                JOptionPane.showMessageDialog(null, "There is no text.");
            else{
            try{
            str1=(String)JOptionPane.showInputDialog(null,"Enter the word to be replaced");
            str2=(String)JOptionPane.showInputDialog(null,"Enter the word to be placed instead");
            
           
            
            if(!k.contains(str1))
                JOptionPane.showMessageDialog(null, "There is no "+str1+" in the text."); 
            
             k=k.replaceAll(str1, str2);
             if(k.equals(k1))
                 JOptionPane.showMessageDialog(null, "Text remains the same.");  
           t.setText(k);
            
             }
            
            
            catch(NullPointerException aae)
            {
                JOptionPane.showMessageDialog(null,"Not a valid text");
            }
               
            }  
        }
        
        
        else if(s.equals("Replace"))
        {
            
            String repl=(String)JOptionPane.showInputDialog(null,"Enter the new text");
            int n=JOptionPane.showConfirmDialog(null,"Replace selected text ?","OK",JOptionPane.YES_NO_OPTION);
            if(n==JOptionPane.YES_OPTION)
               t.replaceSelection(repl);  // This is used to directly replace the selected text with the passed parameter
            
        }
    
        else if(s.equals("Count"))
        {  
           k=t.getText();
                
           int y1=t.getSelectionStart();  //Gives starting point of selection
           int y2=t.getSelectionEnd();  //Gives ending point of selection
           String y3=k.substring(y1, y2);
          
           String[] wordArray = y3.trim().split("\\s+"); //Words are splitted to fit in an array
           int word = wordArray.length; // Then the array length is counted
           
    
           int chr=0;
          
           for (int ik = 0; ik < y3.length(); ik++) {
            if (Character.isLetterOrDigit(y3.charAt(ik))) // A letter or digit is counted as a text character
            chr++;
           }  
           JOptionPane.showMessageDialog(null, "Number of words are "+word+" and characters are "+chr);
            
        } 
    
        
            
         else if (s.equals("Remove Highlights"))
         {
             highlighter.removeAllHighlights();  // Use to remove highlights from the text
         }
        

        else if(s.equals("Font Case")){
            String a= t.getText();
            
            int a1= t.getSelectionStart();
            int a2=t.getSelectionEnd();
            String a3=a.substring(a1,a2).toUpperCase();
            String finalString=null;
           
             String[] buttons = { "To Upper case","To lower case " };

        int rc = JOptionPane.showOptionDialog(null, "select the case the text has to be changed to", "Change Case",
        JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons[1]);
        if(rc==0){
            finalString= a.substring(0,(a1))+a3+a.substring(a2,a.length());
             t.setText(finalString);
        }
       
        else
            
        {
             a3=a.substring(a1,a2).toLowerCase();
            finalString= a.substring(0,(a1))+a3+a.substring(a2,a.length());
            
        } 
            
        t.setText(finalString); 
    

        System.out.println(rc);
           
            
        }
        else if(s.equals("Add Circle")){
        circle.add(new ResizeCircle());
          circle.setVisible(true);
            square.dispose();
            rectangle.dispose();
            oval.dispose();
            triangle.dispose();
     }
         else if(s.equals("Add Square")){
             square.add(new ResizeSquare());
           square.setVisible(true);
           rectangle.dispose();
            circle.dispose();
            oval.dispose();
            triangle.dispose();
        
        
    }
         else if(s.equals("Add Triangle")){
             triangle.add(new ResizeTriangle());
            circle.dispose();
            square.dispose();
            rectangle.dispose();
            oval.dispose();
            triangle.setVisible(true); 
            
    }
          else if(s.equals("Add Rectangle")){
              rectangle.add(new ResizeRectangle());
         square.dispose();
           rectangle.setVisible(true);
            circle.dispose();
            oval.dispose();
            triangle.dispose();
         }
         else if(s.equals("Add Oval")){
             oval.add(new ResizeOval());
           square.dispose();
           rectangle.dispose();
            circle.dispose();
            triangle.dispose();
            oval.setVisible(true);
           
            
        
         
    }
    }
    public class ResizeRectangle extends JPanel {
   int WEIGHT = 8;
  //we have made three points, markedPoints[0] and [1] and top-left and bottom-right of the shape.
  //one point is the center of the shape
   Rectangle2D[] markedPoints = { new Rectangle2D.Double(50, 50,WEIGHT, WEIGHT), 
                                   new Rectangle2D.Double(150, 100,WEIGHT, WEIGHT),
                                   new Rectangle2D.Double(100, 75,WEIGHT, WEIGHT)};
  Rectangle2D s = new Rectangle2D.Double();

  ShapeResizeHandler ada = new ShapeResizeHandler();

  public ResizeRectangle() {
  
    addMouseListener(ada);
    addMouseMotionListener(ada);
  
  }

  public void paintComponent(Graphics g) {
     
   super.paintComponent(g);
 
    Graphics2D g2D = (Graphics2D) g;

    for (int i = 0; i < markedPoints.length; i++) {
      g2D.fill(markedPoints[i]);
    }
    s.setFrame(markedPoints[0].getCenterX(), markedPoints[0].getCenterY(),
        Math.abs(markedPoints[1].getCenterX()-markedPoints[0].getCenterX()),
        Math.abs(markedPoints[1].getCenterY()- markedPoints[0].getCenterY()));
    g2D.draw(s);
     repaint(); 
  
    
  
  }

  class ShapeResizeHandler extends MouseAdapter {

    Point2D[] lastPoints = new Point2D[3];
     int pos = -1;
    public void mousePressed(MouseEvent eve) {
      Point p = eve.getPoint();

      for (int i = 0; i < markedPoints.length; i++) {
        if (markedPoints[i].contains(p)) {
          pos = i;
          // initialize preDrag markedPoints
          for(int j = 0; j < 3; j++){
              lastPoints[j] = new Point2D.Double(markedPoints[j].getX(), markedPoints[j].getY());
          }
          return;
        }
      }
    }

    public void mouseReleased(MouseEvent eve) {
      pos = -1;
    }

    public void mouseDragged(MouseEvent eve) {
      if (pos == -1)
        return;
      if(pos != 2){ //if 2, it's a shape drag
          markedPoints[pos].setRect(eve.getPoint().x,eve.getPoint().y,markedPoints[pos].getWidth(),
              markedPoints[pos].getHeight());
          int otherEnd = (pos==1)?2:1; //this will enable us to get to the end of the point being dragged(top-left or bottom-right)
          //we obtain the coordinates of the line joing the 2 new diagonal vertices of the new shape which will be new markedPoints[2]
          double newPoint2X = markedPoints[otherEnd].getX() + (markedPoints[pos].getX() - markedPoints[otherEnd].getX())/2;
          double newPoint2Y = markedPoints[otherEnd].getY() + (markedPoints[pos].getY() - markedPoints[otherEnd].getY())/2;
          markedPoints[2].setRect(newPoint2X, newPoint2Y, markedPoints[2].getWidth(), markedPoints[2].getHeight());
      }
      else{ //Shape drag, 1,2,3 markedPoints/marker all of them need to move by same amount
          Double deltaX = eve.getPoint().x - lastPoints[2].getX();
          Double deltaY = eve.getPoint().y - lastPoints[2].getY();
          for(int j = 0; j < 3; j++)
              markedPoints[j].setRect((lastPoints[j].getX() + deltaX),(lastPoints[j].getY() + deltaY),markedPoints[j].getWidth(),
                  markedPoints[j].getHeight());

      }
      repaint();
    }
  }
   }
   
   public class ResizeCircle extends JPanel {
     
   int WEIGHT = 5;
  //we create 3 points, these would be used to resize the shape created markedPoints[0] and [1] and top-left and bottom-right of the shape.
  //one point is the center of the shape
  Rectangle2D[] markedPoints = { new Rectangle2D.Double(100, 100,WEIGHT, WEIGHT), 
                                   new Rectangle2D.Double(200, 200,WEIGHT, WEIGHT),
                                   new Rectangle2D.Double(150, 150,WEIGHT, WEIGHT)};
  Ellipse2D s = new Ellipse2D.Double();

  ShapeResizeHandler srh = new ShapeResizeHandler();

  public ResizeCircle() {
       
    addMouseListener(srh);
    addMouseMotionListener(srh);
  
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2D = (Graphics2D) g;

    for (int i = 0; i < markedPoints.length; i++) {
      g2D.fill(markedPoints[i]);
    }
    s.setFrame(markedPoints[0].getCenterX(), markedPoints[0].getCenterY(),
        Math.abs(markedPoints[1].getCenterX()-markedPoints[0].getCenterX()),
        Math.abs(markedPoints[1].getCenterY()- markedPoints[0].getCenterY()));
    g2D.draw(s);
    
    
  
  }

  class ShapeResizeHandler extends MouseAdapter {

     Point2D[] lastPoints = new Point2D[3];
     int pos = -1;
    public void mousePressed(MouseEvent eve) {
      Point p = eve.getPoint();

      for (int i = 0; i < markedPoints.length; i++) {
        if (markedPoints[i].contains(p)) {
          pos = i;
          // initialize preDrag markedPoints
          for(int j = 0; j < 3; j++){
              lastPoints[j] = new Point2D.Double(markedPoints[j].getX(), markedPoints[j].getY());
          }
          return;
        }
      }
    }
    public void mouseReleased(MouseEvent eve) {
      pos = -1;
    }

    public void mouseDragged(MouseEvent eve) {
      if (pos == -1)
        return;
      if(pos != 2){ //if 2, it's a shape drag
          markedPoints[pos].setRect(eve.getPoint().x,eve.getPoint().y,markedPoints[pos].getWidth(),
              markedPoints[pos].getHeight());
          int otherEnd = (pos==1)?2:1; //this will enable us to get to the end of the point being dragged(top-left or bottom-right)
          //we obtain the coordinates of the line joing the 2 new diagonal vertices of the new shape which will be new markedPoints[2]
          double newPoint2X = markedPoints[otherEnd].getX() + (markedPoints[pos].getX() - markedPoints[otherEnd].getX())/2;
          double newPoint2Y = markedPoints[otherEnd].getY() + (markedPoints[pos].getY() - markedPoints[otherEnd].getY())/2;
          markedPoints[2].setRect(newPoint2X, newPoint2Y, markedPoints[2].getWidth(), markedPoints[2].getHeight());
      }
      else{ //Shape drag, 1,2,3 markedPoints/marker all of them need to move by same amount
          Double deltaX = eve.getPoint().x - lastPoints[2].getX();
          Double deltaY = eve.getPoint().y - lastPoints[2].getY();
          for(int j = 0; j < 3; j++)
              markedPoints[j].setRect((lastPoints[j].getX() + deltaX),(lastPoints[j].getY() + deltaY),markedPoints[j].getWidth(),
                  markedPoints[j].getHeight());

      }
     
      repaint();
      
    }
  }
 }
   public class ResizeSquare extends JPanel {
  int WEIGHT = 8;
  //we have made three points, markedPoints[0] and [1] and top-left and bottom-right of the shape.
  //one point is the center of the shape
   Rectangle2D[] markedPoints = { new Rectangle2D.Double(50, 50,WEIGHT, WEIGHT), 
                                   new Rectangle2D.Double(150, 150,WEIGHT, WEIGHT),
                                   new Rectangle2D.Double(100, 100,WEIGHT, WEIGHT)};
  Rectangle2D s = new Rectangle2D.Double();

  ShapeResizeHandler ada = new ShapeResizeHandler();

  public ResizeSquare() {
    addMouseListener(ada);
    addMouseMotionListener(ada);
  }
  

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2D = (Graphics2D) g;

    for (int i = 0; i < markedPoints.length; i++) {
      g2D.fill(markedPoints[i]);
    }
    s.setFrame(markedPoints[0].getCenterX(), markedPoints[0].getCenterY(),
        Math.abs(markedPoints[1].getCenterX()-markedPoints[0].getCenterX()),
        Math.abs(markedPoints[1].getCenterY()- markedPoints[0].getCenterY()));
    g2D.draw(s);
     repaint();
  }
  
  class ShapeResizeHandler extends MouseAdapter {

  Point2D[] lastPoints = new Point2D[3];
    int pos = -1;
    public void mousePressed(MouseEvent eve) {
      Point p = eve.getPoint();

      for (int i = 0; i < markedPoints.length; i++) {
        if (markedPoints[i].contains(p)) {
          pos = i;
          // initialize preDrag points
          for(int j = 0; j < 3; j++){
              lastPoints[j] = new Point2D.Double(markedPoints[j].getX(), markedPoints[j].getY());
          }
          return;
        }
      }
    }

    public void mouseReleased(MouseEvent eve) {
      pos = -1;
     
    }

    public void mouseDragged(MouseEvent eve) {
      if (pos == -1)
        return;
      if(pos != 2){ //if 2, it's a shape drag
          markedPoints[pos].setRect(eve.getPoint().x,eve.getPoint().y,markedPoints[pos].getWidth(),
              markedPoints[pos].getHeight());
          int otherEnd = (pos==1)?2:1; //this will enable us to get to the end of the point being dragged(top-left or bottom-right)
          //we obtain the coordinates of the line joing the 2 new diagonal vertices of the new shape which will be new markedPoints[2]
          double newPoint2X = markedPoints[otherEnd].getX() + (markedPoints[pos].getX() - markedPoints[otherEnd].getX())/2;
          double newPoint2Y = markedPoints[otherEnd].getY() + (markedPoints[pos].getY() - markedPoints[otherEnd].getY())/2;
          markedPoints[2].setRect(newPoint2X, newPoint2Y, markedPoints[2].getWidth(), markedPoints[2].getHeight());
      }
      else{ //Shape drag, 1,2,3 points/marker all of them need to move by same amount
          Double deltaX = eve.getPoint().x - lastPoints[2].getX();
          Double deltaY = eve.getPoint().y - lastPoints[2].getY();
          for(int j = 0; j < 3; j++)
              markedPoints[j].setRect((lastPoints[j].getX() + deltaX),(lastPoints[j].getY() + deltaY),markedPoints[j].getWidth(),
                  markedPoints[j].getHeight());

      }
      repaint();
      
    }
  }
 }
   
  public class ResizeOval extends JPanel {
 int WEIGHT = 8;
  //here there are three points, markedPoints[0] and [1] and top-left and bottom-right of the shape.
  //one point is the center of the shape
  Rectangle2D[] markedPoints = { new Rectangle2D.Double(50, 50,WEIGHT, WEIGHT), 
                                   new Rectangle2D.Double(150, 100,WEIGHT, WEIGHT),
                                   new Rectangle2D.Double(100, 75,WEIGHT, WEIGHT)};
  Ellipse2D s = new Ellipse2D.Double();

  ShapeResizeHandler ada = new ShapeResizeHandler();

  public ResizeOval() {
    addMouseListener(ada);
    addMouseMotionListener(ada);
  
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2D = (Graphics2D) g;

    for (int i = 0; i < markedPoints.length; i++) {
      g2D.fill(markedPoints[i]);
    }
    s.setFrame(markedPoints[0].getCenterX(), markedPoints[0].getCenterY(),
        Math.abs(markedPoints[1].getCenterX()-markedPoints[0].getCenterX()),
        Math.abs(markedPoints[1].getCenterY()- markedPoints[0].getCenterY()));
    g2D.draw(s);
    repaint();
  
  }

  class ShapeResizeHandler extends MouseAdapter {

    Point2D[] lastPoints = new Point2D[3];
     int pos = -1;
    public void mousePressed(MouseEvent eve) {
      Point p = eve.getPoint();

      for (int i = 0; i < markedPoints.length; i++) {
        if (markedPoints[i].contains(p)) {
          pos = i;
          // initialize preDrag markedPoints
          for(int j = 0; j < 3; j++){
              lastPoints[j] = new Point2D.Double(markedPoints[j].getX(), markedPoints[j].getY());
          }
          return;
        }
      }
    }

    public void mouseReleased(MouseEvent eve) {
      pos = -1;
    }

    public void mouseDragged(MouseEvent eve) {
      if (pos == -1)
        return;
      if(pos != 2){ //if 2, it's a shape drag
          markedPoints[pos].setRect(eve.getPoint().x,eve.getPoint().y,markedPoints[pos].getWidth(),
              markedPoints[pos].getHeight());
          int otherEnd = (pos==1)?2:1; //this will enable us to get to the end of the point being dragged(top-left or bottom-right)
          //we obtain the coordinates of the line joing the 2 new diagonal vertices of the new shape which will be new markedPoints[2]
          double newPoint2X = markedPoints[otherEnd].getX() + (markedPoints[pos].getX() - markedPoints[otherEnd].getX())/2;
          double newPoint2Y = markedPoints[otherEnd].getY() + (markedPoints[pos].getY() - markedPoints[otherEnd].getY())/2;
          markedPoints[2].setRect(newPoint2X, newPoint2Y, markedPoints[2].getWidth(), markedPoints[2].getHeight());
      }
      else{ //Shape drag, 1,2,3 markedPoints/marker all of them need to move by same amount
          Double deltaX = eve.getPoint().x - lastPoints[2].getX();
          Double deltaY = eve.getPoint().y - lastPoints[2].getY();
          for(int j = 0; j < 3; j++)
              markedPoints[j].setRect((lastPoints[j].getX() + deltaX),(lastPoints[j].getY() + deltaY),markedPoints[j].getWidth(),
                  markedPoints[j].getHeight());

      }
      repaint();
      
    }
  }
 }
  
    public class ResizeTriangle extends JPanel {
   int WEIGHT = 8;
  //we have made three points, markedPoints[0] and [1] and top-left and bottom-right of the shape.
  //one point is the center of the shape
   Rectangle2D[] markedPoints = { new Rectangle2D.Double(50, 50,WEIGHT, WEIGHT), 
                                   new Rectangle2D.Double(150, 100,WEIGHT, WEIGHT),
                                   new Rectangle2D.Double(100, 75,WEIGHT, WEIGHT)};
  
 Rectangle2D s = new Rectangle2D.Double();
  ShapeResizeHandler ada = new ShapeResizeHandler();

  public ResizeTriangle() {
  
    addMouseListener(ada);
    addMouseMotionListener(ada);
  
  }

  public void paintComponent(Graphics g) {
       
     
   super.paintComponent(g);
 
    Graphics2D g2D = (Graphics2D) g;

    for (int i = 0; i < markedPoints.length; i++) {
      g2D.fill(markedPoints[i]);
    }
    s.setFrame(markedPoints[0].getCenterX(), markedPoints[0].getCenterY(),
        Math.abs(markedPoints[1].getCenterX()-markedPoints[0].getCenterX()),
        Math.abs(markedPoints[1].getCenterY()- markedPoints[0].getCenterY()));
    g2D.draw(s);
     repaint(); 
  
    
  
  }

  class ShapeResizeHandler extends MouseAdapter {

    Point2D[] lastPoints = new Point2D[3];
     int pos = -1;
    public void mousePressed(MouseEvent eve) {
      Point p = eve.getPoint();

      for (int i = 0; i < markedPoints.length; i++) {
        if (markedPoints[i].contains(p)) {
          pos = i;
          // initialize preDrag markedPoints
          for(int j = 0; j < 3; j++){
              lastPoints[j] = new Point2D.Double(markedPoints[j].getX(), markedPoints[j].getY());
          }
          return;
        }
      }
    }

    public void mouseReleased(MouseEvent eve) {
      pos = -1;
    }

    public void mouseDragged(MouseEvent eve) {
      if (pos == -1)
        return;
      if(pos != 2){ //if 2, it's a shape drag
          markedPoints[pos].setRect(eve.getPoint().x,eve.getPoint().y,markedPoints[pos].getWidth(),
              markedPoints[pos].getHeight());
          int otherEnd = (pos==1)?2:1; //this will enable us to get to the end of the point being dragged(top-left or bottom-right)
          //we obtain the coordinates of the line joing the 2 new diagonal vertices of the new shape which will be new markedPoints[2]
          double newPoint2X = markedPoints[otherEnd].getX() + (markedPoints[pos].getX() - markedPoints[otherEnd].getX())/2;
          double newPoint2Y = markedPoints[otherEnd].getY() + (markedPoints[pos].getY() - markedPoints[otherEnd].getY())/2;
          markedPoints[2].setRect(newPoint2X, newPoint2Y, markedPoints[2].getWidth(), markedPoints[2].getHeight());
      }
      else{ //Shape drag, 1,2,3 markedPoints/marker all of them need to move by same amount
          Double deltaX = eve.getPoint().x - lastPoints[2].getX();
          Double deltaY = eve.getPoint().y - lastPoints[2].getY();
          for(int j = 0; j < 3; j++)
              markedPoints[j].setRect((lastPoints[j].getX() + deltaX),(lastPoints[j].getY() + deltaY),markedPoints[j].getWidth(),
                  markedPoints[j].getHeight());

      }
      repaint();
    }
  }
   }
   
   

public static void main(String args[]) 
    { 
        textEditor editor = new textEditor(); 
    }
}












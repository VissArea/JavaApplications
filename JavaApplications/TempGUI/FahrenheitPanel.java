//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// @author Drew Visser
//FahrenheitPanel.java
//Demonstrates a graphical user interface
//with use of text fields.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FahrenheitPanel extends JPanel{
  private JLabel inputLabel, outputLabel, resultLabel;
  private JTextField fahrenheit;
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  // Constructor: sets up the main GUI components.
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public FahrenheitPanel(){
    inputLabel = new JLabel("Enter Fahrenheit Tempeture: ");
    outputLabel = new JLabel("Tempeture in Celcius: ");
    resultLabel = new JLabel("--");
    fahrenheit = new JTextField(5);
    fahrenheit.addActionListener(new TempListener());
    add(inputLabel);
    add(fahrenheit);
    add(outputLabel);
    add(resultLabel);

    setPreferredSize(new Dimension(300, 75));
    setBackground(Color.gray);
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  // Represents an action listener for the temp input field.
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private class TempListener implements ActionListener{
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //Coverts once button is presed
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void actionPerformed(ActionEvent event){
      int fahrenheitTemp, celciusTemp;
      String txt = fahrenheit.getText();
      fahrenheitTemp = Integer.parseInt(txt);
      celciusTemp = (fahrenheitTemp - 32) * 5/9;
      resultLabel.setText(Integer.toString(celciusTemp));
    }
  }
}

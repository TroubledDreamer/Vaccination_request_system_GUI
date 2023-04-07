import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonEntry extends JFrame
{
    private JTextField  txtName;       //name
    private JTextField  txtAge;        //age
    private JCheckBox boxPublish;
    private JButton     cmdSave;
    private JButton     cmdClose;
    private JButton     cmdClearAll;

    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;

    private PersonListing personListing;

  
    
    public PersonEntry(PersonListing personListing)
    {

        this.personListing = personListing;


        setTitle("Entering new person");
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("Name:")); 
        txtName = new JTextField(20);
        pnlDisplay.add(txtName);
        pnlDisplay.add(new JLabel("Age:"));
        txtAge = new JTextField(3);
        pnlDisplay.add(txtAge);
        pnlDisplay.add(new JLabel("Will publish?"));
        boxPublish = new JCheckBox();
        pnlDisplay.add(boxPublish);


        pnlDisplay.setLayout(new GridLayout(3,4));
       
        cmdSave      = new JButton("Save");
        cmdClose   = new JButton("Close");

        cmdClose.addActionListener(new VisibleButtonListener());
        cmdSave.addActionListener(new SaveButtonListener());

        pnlCommand.add(cmdSave);
        pnlCommand.add(cmdClose);
        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }

    private class VisibleButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            cmdClose.setVisible(false);
        }

    }


    private class SaveButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String name = txtName.getText();
            String age = txtAge.getText();

            System.out.println("works");



            String[] nameFL = splitName(name);
            if (validName(nameFL) && validAge(age)){

                Person person = new Person(name, Integer.parseInt(age), boxPublish.isSelected());
                personListing.addPerson(person);  
                personListing.colorChange++;

                setVisible(false);


            }


        }

    }

    public String[] splitName(String name){

        System.out.println("works 1");

        return name.split("");

    }

    public boolean validName(String[] nameFL){
        System.out.println("works2");

        return nameFL[1].length() >= 1;

    }


    public boolean validAge(String Age){

        try{
            int number = Integer.valueOf(Age);
            System.out.println("works 3");

            return 5 > 1;
        }
        catch (NumberFormatException ex){
            System.out.println("error");
            return 1 > 5;
        }
    }



}
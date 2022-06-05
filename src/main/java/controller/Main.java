package controller;


import model.entities.books.BooksNumber;
import model.entities.humans.Human;
import model.generators.containers.RegistryGenerator;
import model.generators.humans.HumanGenerator;
import model.generators.humans.ProfessorGenerator;
import model.generators.humans.StudentGenerator;
import model.parsers.Parser;

public class Main {

    public static void main(String[] args){
        Parser parser = new Parser("C:\\Library-main\\src\\main\\resources\\excel\\library.xlsx");
        parser.parse();
        //
        RegistryGenerator registryGenerator = new RegistryGenerator();
        registryGenerator.generate(5);
        System.out.println(registryGenerator.getRegistry());
    }

}

       /* JFrame frame = new JFrame();
        frame.setContentPane(new NewGUI().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300,150,500,550);
        frame.setVisible(true);*/



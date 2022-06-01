package controller;

import model.entities.Library;
import model.generators.Generator;
import model.generators.books.EnglishLiteratureGenerator;
import model.generators.humans.HumanGenerator;
import model.generators.humans.ProfessorGenerator;
import model.generators.humans.StudentGenerator;
import model.parsers.Parser;

import javax.swing.*;

public class Controller{

    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setContentPane(new NewGUI().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300,150,500,550);
        frame.setVisible(true);
    }

}

package controller;

import model.entities.Library;
import model.generators.Generator;
import model.generators.books.EnglishLiteratureGenerator;
import model.generators.humans.HumanGenerator;
import model.generators.humans.ProfessorGenerator;
import model.generators.humans.StudentGenerator;
import model.parsers.Parser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class NewGUI extends JFrame{
    private JPanel panel1;
    private JButton InputButton;
    private JButton genBButton;
    private JButton genStButton;
    private JButton genPrButton;
    private JButton outputButton;
    private JTextPane textPane1;
    HumanGenerator generatorProfessor = new ProfessorGenerator();
    HumanGenerator generatorStudent = new StudentGenerator();
    JFileChooser fileChooser = new JFileChooser("C:\\Library-main\\src\\main\\resources\\excel");


    public NewGUI() {
        InputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int returnvalue = fileChooser.showOpenDialog(NewGUI.this);
                    if (returnvalue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                Parser parser = new Parser(selectedFile.getAbsolutePath());
                parser.parse();
                JOptionPane.showMessageDialog(null,"Файл загружен","Message",JOptionPane.PLAIN_MESSAGE);
            }
                }
                catch (java.awt.HeadlessException HeadlessException) {
                    JOptionPane.showMessageDialog(null, "Файл не загружен", "Error", JOptionPane.PLAIN_MESSAGE);
                }}
            });

        genBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Generator generatorBook = new EnglishLiteratureGenerator();
                generatorBook.generate(2);
                JOptionPane.showMessageDialog(null,"Книги созданы","Message",JOptionPane.PLAIN_MESSAGE);
            }
        });

        genStButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatorStudent.generateWithBooks(2, 6);
                JOptionPane.showMessageDialog(null,"Студенты созданы","Message",JOptionPane.PLAIN_MESSAGE);
            }
        });

        genPrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatorProfessor.generateWithBooks(3, 3);
                JOptionPane.showMessageDialog(null,"Преподаватели созданы","Message",JOptionPane.PLAIN_MESSAGE);
            }
        });

        outputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Library library = new Library();
                library.setStudents(generatorStudent.convert());
                library.setProfessors(generatorProfessor.convert());
                textPane1.setText(String.valueOf(library));
            }
        });
    }
    public JPanel getPanel(){
        return panel1;
    }

}

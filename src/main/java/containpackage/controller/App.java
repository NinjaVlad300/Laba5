package containpackage.controller;

import containpackage.model.entities.books.Book;
import containpackage.model.entities.humans.Human;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import containpackage.model.entities.containers.Record;
import containpackage.model.parsers.Parser;
import containpackage.model.generators.containers.RegistryGenerator;
import org.apache.poi.ss.formula.functions.T;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;

public class App extends Application {

    private TreeView<String> treeView = new TreeView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextArea textAreaImp = new TextArea();
        textAreaImp.setEditable(false);
        Group groupTextAreaImp = new Group(textAreaImp);
        textAreaImp.setPrefSize(300, 20);
        Button buttonImpDir = new Button("...");
        buttonImpDir.setPrefSize(30, 37);
        buttonImpDir.setOnAction(actionEvent -> {
            textAreaImp.clear();
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                textAreaImp.appendText(file.getAbsolutePath());
            }
        });
        Group groupButtonImpDir = new Group(buttonImpDir);
        Button buttonImp = new Button("Import");
        buttonImp.setPrefSize(80, 37);
        buttonImp.setOnAction(actionEvent -> {

            try {
                Parser parser = new Parser(textAreaImp.getText());
                parser.parse();

                RegistryGenerator registryGenerator = new RegistryGenerator();
                registryGenerator.generate(5);
                createTreeView(registryGenerator.getStudentList());

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Good job!");
                alert.setHeaderText(null);
                alert.setContentText("Done");
                alert.showAndWait();
            } catch (Exception exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Warning!!!");
                alert.setHeaderText(null);
                alert.setContentText("Something went wrong and we didn't find a file");
                alert.showAndWait();
                exception.printStackTrace();
            }
        });
        Group groupButtonImp = new Group(buttonImp);
        treeView = new TreeView<>();
        treeView.setPrefSize(850, 500);
        HBox treeHBox = new HBox();
        treeHBox.getChildren().addAll(treeView);


        HBox importChild = new HBox(groupButtonImpDir, groupTextAreaImp, groupButtonImp);
        VBox root = new VBox(importChild, treeHBox);
        Scene scene = new Scene(root, 850, 550);
        primaryStage.setScene(scene);
        primaryStage.setTitle("let's do something!");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void createTreeView(List<Human> humanList) {
        TreeItem<String> rootItem = new TreeItem<>("Records");
        for (Human human : humanList) {
            TreeItem<String> branchItem = new TreeItem<>(human.getLastName());
            for (Book book : human.getBooks()) {
                TreeItem<String> leafItem = new TreeItem<>(book.getAuthor() + " " + book.getTitle());
                branchItem.getChildren().add(leafItem);
            }
            rootItem.getChildren().add(branchItem);
        }

//        for (Record record : humanList) {
//            TreeItem<String> leafItem = new TreeItem<>(record.toString());
//            rootItem.getChildren().add(leafItem);
//        }
        treeView.setRoot(rootItem);
        treeView.setShowRoot(true);
    }

}

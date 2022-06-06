module containpackage {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;
    requires commons.math3;
    requires java.desktop;
    requires org.apache.commons.compress;

//    opens containpackage to javafx.fxml;
    exports containpackage.controller;
    exports containpackage.model.entities.containers;
    exports containpackage.model.entities.books;
    exports containpackage.model.entities.humans;
    exports containpackage.model.generators;
    exports containpackage.model.parsers;
}
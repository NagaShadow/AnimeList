module com.example.animelist {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.xml;
    requires java.sql;


    opens com.example.animelist to javafx.fxml;
    exports com.example.animelist;
    exports com.example.animelist.Controleur;
    opens com.example.animelist.Controleur to javafx.fxml;
}
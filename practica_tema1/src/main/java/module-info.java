module com.mycompany.practica_tema1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.practica_tema1 to javafx.fxml;
    exports com.mycompany.practica_tema1;
}

module com.example.appstage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires itextpdf;
    requires java.desktop;
    //requires org.xerial.sqlitejdbc;

    opens com.example.appstage to javafx.fxml;
    exports com.example.appstage;
    exports com.example.appstage.modeles;
    opens com.example.appstage.modeles to javafx.fxml;
    exports com.example.appstage.dao;
    opens com.example.appstage.dao to javafx.fxml;
    exports com.example.appstage.services;
    opens com.example.appstage.services to javafx.fxml;
    exports test;
    opens test to javafx.fxml;
}

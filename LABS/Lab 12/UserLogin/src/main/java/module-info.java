module com.example.userlogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.userlogin to javafx.fxml;
    exports com.example.userlogin;
}
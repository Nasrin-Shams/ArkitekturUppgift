module com.example.arkitektuppgit {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.arkitektuppgit to javafx.fxml;
    exports com.example.arkitektuppgit;
}
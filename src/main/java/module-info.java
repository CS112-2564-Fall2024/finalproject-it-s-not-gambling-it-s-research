module edu.miracosta.cs112.finalproject.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens edu.miracosta.cs112.finalproject.finalproject to javafx.fxml;
    exports edu.miracosta.cs112.finalproject.finalproject;
}
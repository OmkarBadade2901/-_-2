module com.Practiceprojects.guessthenumber {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.Practiceprojects.guessthenumber to javafx.fxml;
    exports com.Practiceprojects.guessthenumber;
}

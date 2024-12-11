module com.xhomerly.kartoteka {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.xhomerly.kartoteka to javafx.fxml;
    exports com.xhomerly.kartoteka;
}
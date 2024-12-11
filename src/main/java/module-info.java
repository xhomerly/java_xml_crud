module com.xhomerly.kartoteka {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.xhomerly.kartoteka to javafx.fxml;
    exports com.xhomerly.kartoteka;
}
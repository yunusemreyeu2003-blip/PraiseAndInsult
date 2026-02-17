module com.ovnc {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;

    requires static com.opencsv;

    opens com.ovnc.Data to com.opencsv;

    opens com.ovnc.Interface to javafx.graphics;

    exports com.ovnc;
}
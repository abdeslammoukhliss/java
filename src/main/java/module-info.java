module org.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.pcap4j.core;

    opens org.example.demo1 to javafx.fxml;
    exports org.example.demo1;
}
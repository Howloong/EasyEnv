module com.kangyh.easyenv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires junit;
    requires org.apache.commons.io;
    requires zip4j;
    requires java.desktop;
    requires org.apache.tomcat.embed.core;

    opens com.kangyh.easyenv to javafx.fxml;
    exports com.kangyh.easyenv;
    exports com.kangyh.easyenv.constants;
    opens com.kangyh.easyenv.constants to javafx.fxml;
    exports com.kangyh.easyenv.mod;
    opens com.kangyh.easyenv.mod to javafx.fxml;
}
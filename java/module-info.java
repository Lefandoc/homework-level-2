module ru.gb.onlinechat.client {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.gb.onlinechat.client to javafx.fxml;
    exports ru.gb.onlinechat.client;
}
package org.example.FilesAndNetwork.DataCollector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JsoupConnection connection=new JsoupConnection();
        try {
            connection.connection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

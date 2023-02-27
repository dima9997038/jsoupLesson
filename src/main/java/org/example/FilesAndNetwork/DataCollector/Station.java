package org.example.FilesAndNetwork.DataCollector;

public class Station {
    private String name;
    private String number;
    private String hasConnection;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getHasConnection() {
        return hasConnection;
    }

    public void setHasConnection(String hasConnection) {
        this.hasConnection = hasConnection;
    }

    public Station(String name, String number,  String hasConnection) {
        this.name = name;
        this.number = number;
        this.hasConnection = hasConnection;
    }

    public Station(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", hasConnection=" + hasConnection +
                '}';
    }
}

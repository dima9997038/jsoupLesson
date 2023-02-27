package org.example.FilesAndNetwork.DataCollector;

import java.util.List;

public class Line {
    private String name;
    private String number;
    private List<Station> stations;

    public Line(String name, String number, List<Station> stations) {
        this.name = name;
        this.number = number;
        this.stations = stations;
    }

    public Line(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Line() {
    }

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

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "Line{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", stations=" + stations +
                '}';
    }
}

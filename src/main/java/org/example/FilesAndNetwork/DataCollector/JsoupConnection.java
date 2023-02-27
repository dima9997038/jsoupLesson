package org.example.FilesAndNetwork.DataCollector;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsoupConnection {
    public void connection() throws IOException {
        List<Line> lines = new ArrayList<>();
        String blogUrl = "https://skillbox-java.github.io/";
        try {
            Document doc = Jsoup.connect(blogUrl).get();
            Elements elementLines = doc.getElementsByAttribute("data-line");
            for (Element element : elementLines) {
                Line line = null;
                if (element.attributes().get("class").contains("js-metro-line")) {
                    line = new Line(element.ownText(), element.attributes().get("data-line"));
                }
                List<Station> stations = new ArrayList<>();
                if (element.attributes().get("class").contains("js-metro-station")) {
                    List<Node> nodes = element.childNodes();
                    for (Node node : nodes) {
                        if (node.childNodes().size() != 0) {
                            String name = node.childNodes().get(1).childNodes().get(0).toString();
                            String number = node.childNodes().get(0).childNodes().get(0).toString().split("&")[0];
                            String hasConnection = null;
                            if (node.childNodes().size() > 2) {
                                hasConnection = node.childNodes().get(2).attributes().get("title");
                            }
                            Station station = new Station(name, number, hasConnection);
                            stations.add(station);
                        }
                    }
                }
                if (line != null) {
                    lines.add(line);
                }
                lines.get(lines.size()-1).setStations(stations);
            }
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("lines.json"), lines);
    }
}

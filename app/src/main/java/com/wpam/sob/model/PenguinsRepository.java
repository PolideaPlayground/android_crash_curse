package com.wpam.sob.model;

import java.util.Arrays;
import java.util.List;

public class PenguinsRepository {

    public List<String> fetchAll() {
        return Arrays.asList(
                "Adeli",
                "antarktyczny",
                "białobrewy",
                "białoskrzydły",
                "cesarski",
                "grubodzioby",
                "grzebieniasty",
                "Humboldta",
                "królewski",
                "krótkoczuby",
                "Magellana",
                "mały",
                "przylądkowy",
                "równikowy",
                "skalny",
                "szczotkoczuby",
                "złotoczuby",
                "Adeli",
                "antarktyczny",
                "białobrewy",
                "białoskrzydły",
                "cesarski",
                "grubodzioby",
                "grzebieniasty",
                "Humboldta",
                "królewski",
                "krótkoczuby",
                "Magellana",
                "mały",
                "przylądkowy",
                "równikowy",
                "skalny",
                "szczotkoczuby",
                "złotoczuby",
                "Adeli",
                "antarktyczny",
                "białobrewy",
                "białoskrzydły",
                "cesarski",
                "grubodzioby",
                "grzebieniasty",
                "Humboldta",
                "królewski",
                "krótkoczuby",
                "Magellana",
                "mały",
                "przylądkowy",
                "równikowy",
                "skalny",
                "szczotkoczuby",
                "złotoczuby",
                "żółtooki"
        );
    }

    public String get(int position) {
        return fetchAll().get(position);
    }

    public int getCount() {
        return fetchAll().size();
    }
}

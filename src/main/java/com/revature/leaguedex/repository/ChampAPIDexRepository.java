package com.revature.leaguedex.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.leaguedex.domain.Champion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ChampAPIDexRepository implements DexRepository{
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public Champion getChampion(String name) {
        Champion result = null;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://pokeapi.co/api/v2/pokemon/" + name ))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String httpBody = response.body();
            result = mapper.readValue(httpBody, Champion.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Champion> getPocketChampions() {
        return null;
    }
}

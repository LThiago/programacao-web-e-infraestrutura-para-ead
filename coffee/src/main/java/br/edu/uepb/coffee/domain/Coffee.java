package br.edu.uepb.coffee.domain;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Coffee {

    private String id;
    private String name;

    public Coffee(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}

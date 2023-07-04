package br.com.tech4me.tech4pizza.shared;

import java.util.List;

public record PizzaDto(String sabor, 
                       List<String> ingredientes) {  
}



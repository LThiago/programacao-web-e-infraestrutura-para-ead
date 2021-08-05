package br.edu.uepb.coffee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uepb.coffee.domain.Coffee;
import br.edu.uepb.coffee.repository.CoffeeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/coffees")
@Api(value = "Coffee")
public class CoffeeController {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping
    @ApiOperation(value = "Busca uma lista de todos os cafés")
    public List<Coffee> getCoffees() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca um café pelo seu identificador")
    public Optional<Coffee> getCoffeeById(@PathVariable Long id) {
        return coffeeRepository.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Cria um novo café")
    public Coffee createCoffee(@RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um café a partir do seu identificador")
    public Coffee updateCoffee(@PathVariable("id") Long id, @RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui um café a partir do seu identificador")
    public void deleteCoffee(@PathVariable Long id) {
        coffeeRepository.delete(coffeeRepository.findById(id).get());
    }
}

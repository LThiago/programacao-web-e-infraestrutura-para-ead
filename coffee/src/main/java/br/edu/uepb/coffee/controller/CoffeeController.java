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
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/coffees")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CoffeeController {

    private CoffeeRepository coffeeRepository;

    @GetMapping
    public List<Coffee> getCoffees() {
        return coffeeRepository.getCoffees();
    }

    @GetMapping("/{id}")
    public Optional<Coffee> getCoffeeById(@PathVariable String id) {
        return coffeeRepository.getCoffeeById(id);
    }

    @PostMapping
    public Coffee createCoffee(@RequestBody Coffee coffee) {
        return coffeeRepository.createCoffee(coffee);
    }

    @PutMapping("/{id}")
    public Coffee updateCoffee(@PathVariable("id") String id, @RequestBody Coffee coffee) {
        return coffeeRepository.updateCoffee(id, coffee);
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable String id) {
        coffeeRepository.deleteCoffee(id);
    }
}

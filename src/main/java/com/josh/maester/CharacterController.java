package com.josh.maester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @PostMapping
    public Character createCharacter(@RequestBody Character character) {
        return characterRepository.save(character);
    }

    @PutMapping("/{id}")
    public Character updateCharacter(@PathVariable Long id, @RequestBody Character characterDetails) {
        Character character = characterRepository.findById(id).orElseThrow();
        character.setName(characterDetails.getName());
        character.setHouse(characterDetails.getHouse());
        return characterRepository.save(character);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterRepository.deleteById(id);
    }
}

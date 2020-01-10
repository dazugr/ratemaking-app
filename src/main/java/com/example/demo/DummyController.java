package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DummyController {

    private MatchRepository matchRepository;

    @Autowired
    public DummyController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping(value = "/matches/{id}")
    public Match getMatch(@PathVariable Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    @GetMapping(value = "/matches")
    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    @PostMapping(value = "/matches")
    public Match createMatch(@RequestBody CreateMatchJson createMatchJson) {
        Match match = new Match();
        match.setId(createMatchJson.getId());
        match.setName(createMatchJson.getName());
        return matchRepository.save(match);
    }
}

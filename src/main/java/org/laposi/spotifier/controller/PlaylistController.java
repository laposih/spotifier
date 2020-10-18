package org.laposi.spotifier.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlaylistController {
    @GetMapping("/echo")
    public ResponseEntity<String> greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return ResponseEntity.ok("hello " + name);
    }
}

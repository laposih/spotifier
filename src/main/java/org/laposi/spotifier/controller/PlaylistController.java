package org.laposi.spotifier.controller;

import org.laposi.spotifier.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlaylistController {
    private AuthorizationService authorizationService;

    @Autowired
    public PlaylistController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping("/echo")
    public ResponseEntity<String> greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return ResponseEntity.ok(authorizationService.getAccessToken());
       // return ResponseEntity.ok("hello " + name);
    }
}

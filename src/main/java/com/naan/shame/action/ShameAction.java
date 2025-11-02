package com.naan.shame.action;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShameAction {

    @RequestMapping("/shame")
    public ResponseEntity<String> shame() {
        return ResponseEntity.ok("ok32s");
    }
}

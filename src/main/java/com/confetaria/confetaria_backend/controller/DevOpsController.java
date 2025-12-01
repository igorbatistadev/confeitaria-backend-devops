package com.confetaria.confetaria_backend.controller;

import com.confetaria.confetaria_backend.model.Cliente;
import com.confetaria.confetaria_backend.model.Material;
import com.confetaria.confetaria_backend.service.interfaces.ClienteService;
import com.confetaria.confetaria_backend.service.interfaces.MaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devops")
public class DevOpsController {

    public DevOpsController() {
    }

    @GetMapping
    public String listarClientes() {
        return "Olá Ivo! v1.0";
    }
}
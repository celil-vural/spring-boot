package com.example.springbootapidoc.controller;

import com.example.springbootapidoc.model.dto.PetDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pets")
@Api(value = "Pet Controller", description = "Pet Controller")
public class PerController {
    private List<PetDto> petDtos=new ArrayList<>();
    @PostConstruct
    public void init(){
        petDtos.add(new PetDto(1,"dog",new Date()));
    }
    @PostMapping("/per")
    @ApiOperation(value = "create", notes = "create for pet")
    public ResponseEntity<PetDto> create(@RequestBody @ApiParam(value = "Pet") PetDto petDto) {
        petDtos.add(petDto);
        return ResponseEntity.ok(petDto);
    }
    @GetMapping
    @ApiOperation(value = "getAll", notes = "getAll for pet")
    public ResponseEntity<List<PetDto>> getAll() {
        return ResponseEntity.ok(petDtos);
    }
}

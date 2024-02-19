package com.celakd.ofoservice.controller;

import com.celakd.ofoservice.dto.ProcessDefinitionDTO;
import com.celakd.ofoservice.service.ProcessService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/processes")
@RequiredArgsConstructor
public class ProcessController {
    private final ProcessService processService;

    @PostMapping("/upload")
    public String uploadAttachment(@RequestParam("file") MultipartFile file) {
        processService.deployProcess(file);
        return "Process successfully uploaded and deployed!";
    }

    @GetMapping()
    public List<ProcessDefinitionDTO> getAll(){
        return processService.getAllProcesses();
    }

    @GetMapping("/{id}")
    public ProcessDefinitionDTO getProcess(@PathVariable String id){
        return processService.getProcessById(id);
    }

    @PostMapping("{id}")
    public String startProcess(@PathVariable String id){
        processService.startProcessById(id);
        return "Process started successfully";
    }
}

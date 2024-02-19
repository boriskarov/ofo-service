package com.celakd.ofoservice.service;

import com.celakd.ofoservice.dto.ProcessDefinitionDTO;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProcessService {

    void deployProcess(MultipartFile file);

    List<ProcessDefinitionDTO> getAllProcesses();

    ProcessDefinitionDTO getProcessById(String id);

    void startProcessById(String id);


}

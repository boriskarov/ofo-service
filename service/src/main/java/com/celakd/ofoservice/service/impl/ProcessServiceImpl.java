package com.celakd.ofoservice.service.impl;

import com.celakd.ofoservice.dto.ProcessDefinitionDTO;
import com.celakd.ofoservice.exception.ProcessException;
import com.celakd.ofoservice.service.ProcessService;
import lombok.AllArgsConstructor;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.repository.DeploymentBuilder;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


import static com.celakd.ofoservice.mapper.ProcessDefinitionMapper.processDefMapper;

@Service
@AllArgsConstructor
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;

    @Override
    public void deployProcess(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new ProcessException("Uploaded file is empty!");
            }
            DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().name(file.getOriginalFilename()).addInputStream(file.getOriginalFilename(), file.getInputStream());
            deploymentBuilder.deploy();
        } catch (IOException e) {
            throw new ProcessException("Error deploying file");
        }
    }

    @Override
    public List<ProcessDefinitionDTO> getAllProcesses() {
        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery().latestVersion().list();
        return processDefMapper.allProcessDefinitionsToProcessDefinitionDTO(processDefinitions);
    }

    @Override
    public ProcessDefinitionDTO getProcessById(String id) {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(id).singleResult();
        return processDefMapper.processDefinitionToProcessDefinitionDTO(processDefinition);
    }

    @Override
    public void startProcessById(String id) {
        try {
            runtimeService.startProcessInstanceById(id);
        }
        catch(Exception e){
            throw new ProcessException("Could not start process.");
        }
    }
}

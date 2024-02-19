package com.celakd.ofoservice.mapper;

import com.celakd.ofoservice.dto.ProcessDefinitionDTO;
import org.flowable.engine.repository.ProcessDefinition;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface ProcessDefinitionMapper {
    
    ProcessDefinitionMapper processDefMapper = Mappers.getMapper(ProcessDefinitionMapper.class);
    
    List<ProcessDefinitionDTO> allProcessDefinitionsToProcessDefinitionDTO(List<ProcessDefinition> processDefinitions);

    ProcessDefinitionDTO processDefinitionToProcessDefinitionDTO(ProcessDefinition processDefinition);
}

package com.celakd.ofoservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProcessDefinitionDTO {
    private String id;
    private String key;
    private String name;
    private String deploymentId;
    private int version;
}

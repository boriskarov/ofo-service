package com.celakd.ofoservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
@Getter
@Setter
public class StorageProperties {
    // replace /path with the location you want the file to be uploaded to
    private String location = "/path";
}

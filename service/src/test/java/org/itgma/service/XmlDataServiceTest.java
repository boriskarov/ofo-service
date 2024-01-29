package org.itgma.service;

import static org.mockito.Mockito.*;

import org.itgma.service.service.XmlDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

@ExtendWith(MockitoExtension.class)
public class XmlDataServiceTest {
    @Mock
    private XmlDataRepo xmlDataRepo;

    @InjectMocks
    private XmlDataService xmlDataService;

    @Test
    public void testSave() {
        MultipartFile file = new MockMultipartFile("file", "hello.xml", "text/xml", "xml content".getBytes());
        xmlDataService.save(file);
       verify(xmlDataRepo, times(1)).save(org.mockito.ArgumentMatchers.any(XmlData.class));
    }
}

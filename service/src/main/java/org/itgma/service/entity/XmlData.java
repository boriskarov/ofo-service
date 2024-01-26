package org.itgma.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "XMLData")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class XmlData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] data;

}

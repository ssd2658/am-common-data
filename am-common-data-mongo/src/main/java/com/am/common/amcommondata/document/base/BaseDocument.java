package com.am.common.amcommondata.document.base;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.am.common.amcommondata.document.common.AuditMetadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDocument {
    
    @Id
    private String id;
    
    @Field("status")
    private String status;
    
    @Field("audit")
    private AuditMetadata audit;
    
    private UUID parentId; // Reference to parent document if any
}

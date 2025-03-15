package com.am.common.amcommondata.repository.base;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.am.common.amcommondata.document.base.BaseDocument;

@NoRepositoryBean
public interface BaseRepository<T extends BaseDocument> extends MongoRepository<T, UUID> {
    
    @Query(value = "{'_id': ?0}", sort = "{'audit.version': -1}")
    List<T> findAllVersionsById(UUID id);
}

package com.vietle.angularecommercebackend.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.vietle.angularecommercebackend.domain.MongoUserCustomSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class MongoUserSequenceService {
    @Autowired private MongoOperations mongo;

    public int getNextSequence(String seqName) {
        MongoUserCustomSequence counter = mongo.findAndModify(
                query(where("id").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                MongoUserCustomSequence.class);
        return counter.getSeq();
    }
}

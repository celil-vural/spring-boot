package com.springbootgridfsfileupload.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {
    private final GridFsTemplate gridFsTemplate;

    public FileUploadService(GridFsTemplate gridFsTemplate) {
        this.gridFsTemplate = gridFsTemplate;
    }

    public void fileUpload(MultipartFile file) throws IOException {
        DBObject dbObject =new BasicDBObject();
        dbObject.put("fileName", file.getOriginalFilename());
        dbObject.put("contentType", file.getContentType());
        dbObject.put("size", file.getSize());
        dbObject.put("userId", "123445");
        ObjectId oId= gridFsTemplate.store(file.getInputStream(),file.getOriginalFilename(),dbObject);
        System.out.println("File Id: " + oId.toString());
    }
}

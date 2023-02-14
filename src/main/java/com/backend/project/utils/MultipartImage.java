package com.backend.project.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class MultipartImage implements MultipartFile, Serializable{

    private static final long serialVersionUID = 7417500052547882043L;

    private byte[] bytes;

    String fileName;
    String contentType;
    String fieldName;
    boolean isEmpty;
    long size;

    public MultipartImage(byte[] bytes, String fileName, String fieldName, String contentType, long size) {
        this.bytes = bytes;
        this.fileName = fileName;
        this.fieldName = fieldName;
        this.contentType = contentType;
        this.size = size;
        this.isEmpty = false;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return bytes;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        // TODO Auto-generated method stub

    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return fileName;
    }

    @Override
    public String getOriginalFilename() {
        // TODO Auto-generated method stub
        return fileName;
    }
}

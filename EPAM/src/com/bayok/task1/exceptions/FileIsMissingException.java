package com.bayok.task1.exceptions;

public class FileIsMissingException  extends Exception{
    public FileIsMissingException(String FILENAME)
    {
        super("File was not found or invalid directory provided: "+ FILENAME);
    }
}

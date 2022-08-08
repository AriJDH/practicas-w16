package com.bootcamp.exception;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OneException {

    public void writeToFile() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("myFile.txt"));
        bw.write("Test");
        bw.close();
    }
}

package com.luxoft.service.impl;

import com.luxoft.service.inter.ReadFileServiceInter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFileServiceImpl implements ReadFileServiceInter {

    @Override
    public String readFile(String fileName) throws FileNotFoundException {
        String resultContent = null;
        FileReader fileReader = new FileReader(fileName);
        try(BufferedReader br = new BufferedReader(fileReader)){
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            resultContent = sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultContent;
    }
}

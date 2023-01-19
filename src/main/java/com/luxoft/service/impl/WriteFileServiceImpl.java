package com.luxoft.service.impl;

import com.luxoft.dto.OutputDto;
import com.luxoft.service.inter.WriteFileServiceInter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileServiceImpl implements WriteFileServiceInter {

    @Override
    public void writeFile(String path, List<OutputDto> outputDtoList) throws IOException {

        System.out.println("writeFile impl");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            File file = new File(path);
            if(!file.exists()) file.createNewFile();

            outputDtoList.stream()
                    .forEach(c -> {
                        try {
                            bw.write("({ "+ c.getSet().toString() +" }, ");
                            bw.write( c.getWordLength().toString() +" ), ");
                            bw.write("-> "+ c.getAverage().toString());
                            bw.newLine();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });
        }
    }
}

package com.luxoft.service.impl;

import com.luxoft.dto.OutputDto;
import com.luxoft.service.inter.ReadFileServiceInter;
import com.luxoft.service.inter.RequestHandlerServiceInter;
import com.luxoft.service.inter.WriteFileServiceInter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class RequestHandlerServiceImpl implements RequestHandlerServiceInter {

    private final ReadFileServiceInter readFileServiceInter;
    private final WriteFileServiceInter writeFileServiceInter;
    private final Path INPUT_PATH = Path.of("src/Main/resources/INPUT.TXT");
    private final Path OUTPUT_PATH = Path.of("src/Main/resources/OUTPUT.TXT");

    public RequestHandlerServiceImpl() {
        this.readFileServiceInter = new ReadFileServiceImpl();
        this.writeFileServiceInter = new WriteFileServiceImpl();
    }

    @Override
    public void findAvgNumOfVowels() throws IOException {
        System.out.println("findAvgNumOfVowels");

        String fileContent = readFileHandle(INPUT_PATH);
        if(fileContent.isBlank()) throw new IOException();

        String[] wordArr = fileContent.split(" ");
        List<Character> charList = new ArrayList<>();
        List<OutputDto> outputDtoList = new ArrayList<>();

        for(int i = 0; i < wordArr.length; i++) {
            int count= 0;
            double avg = 1;
            //OutputDto outputDto = null;
            String currentWord = wordArr[i];
            TreeSet<String> treeSet = new TreeSet<>();
            for(int j =0; j< currentWord.length(); j++) {
                switch (currentWord.charAt(j)) {
                    case 'a':
                        charList.add('a'); treeSet.add("a"); count++;
                        break;
                    case 'e':
                        charList.add('e'); treeSet.add("e"); count++;
                        break;
                    case 'i':
                        charList.add('i'); treeSet.add("i"); count++;
                        break;
                    case 'o':
                        charList.add('o'); treeSet.add("o"); count++;
                        break;
                    case 'u':
                        charList.add('u'); treeSet.add("u"); count++;
                        break;
                }
            }

            if(count != 0)  {
                avg = currentWord.length() / count;
            }

            OutputDto outputDto = new OutputDto();
            outputDto.setSet(treeSet);
            outputDto.setWordLength(currentWord.length());
            outputDto.setAverage(avg);

            outputDtoList.add(outputDto);
        }
        writeFileHandle(OUTPUT_PATH.toString(), outputDtoList);
    }

    @Override
    public String readFileHandle(Path path) {
        String fileContent = null;
        try {
            fileContent = readFileServiceInter.readFile(path.toString());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return fileContent;
    }

    @Override
    public void writeFileHandle(String stringPath, List<OutputDto> outputDtoList) {
        try {
            writeFileServiceInter.writeFile(stringPath, outputDtoList);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

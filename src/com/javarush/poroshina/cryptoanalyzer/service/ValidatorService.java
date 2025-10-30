package com.javarush.poroshina.cryptoanalyzer.service;

import com.javarush.poroshina.cryptoanalyzer.constants.AppConstants;
import com.javarush.poroshina.cryptoanalyzer.util.FileManagerUtil;

import java.nio.file.Files;
import java.nio.file.Path;

public class ValidatorService extends CipherService {

    public static Path isValidPath(String filePath) {
        if (!filePath.endsWith(AppConstants.TXT_FORMAT)) {
            System.out.println(AppConstants.TXT_FORMAT_ERROR);
            FileManagerUtil.getFile();
        }

        Path path = Path.of(filePath);
        if (!Files.exists(path)) {
            System.out.println(AppConstants.FILE_NOT_FOUND_ERROR);
            FileManagerUtil.getFile();
        }
        return path;
    }

    public static int isValidShift(int shift) {
        if (shift < MIN_SHIFT || shift > MAX_SHIFT) {
            System.out.println(AppConstants.OUT_OF_BOUNDS_ERROR);
            FileManagerUtil.getShift();
        }

        return shift;
    }
}

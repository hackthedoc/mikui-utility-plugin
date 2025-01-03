package com.hackthedoc.mikuiutility.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hackthedoc.mikuiutility.Plugin;

public class QuestRecordFileUtils {
    private static File file;

    public static void initFile() {
        file = new File(Plugin.getInstance().getDataFolder(), "questrecord.log");
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                MessageUtils.log("could not create questrecord log file :"+e.getMessage());
            }
        }
    }

    public static void logNumber(int number) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(new SimpleDateFormat("ddMMyyyy").format(new Date())+";"+number);
            writer.newLine();
        }
    }
}

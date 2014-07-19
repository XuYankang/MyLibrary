package io;

import java.io.File;

public class FileDirectory {

    public static void main(String[] args) {
        FileDirectory fileDirectory = new FileDirectory();
        fileDirectory.listAllFile(new File("D:/data/appdatas/caj"), 0);
    }

    public void listAllFile(File dirPath, int level) {
        if (!dirPath.isDirectory()) {
            print(dirPath.getName(), level);
        } else {
            //is dir
            print(dirPath.getName(), level);
            File[] files = dirPath.listFiles();
            for (File file : files) {
                listAllFile(file, level + 1);
            }
        }

    }

    public void print(String fileName, int level) {
        while (level > 0) {
            System.out.print("\t");
            level--;
        }
        System.out.println(fileName);
    }

}
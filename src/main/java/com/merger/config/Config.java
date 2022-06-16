package com.merger.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Config {
    String path = System.getProperty("user.dir") + "/config.conf";
    public boolean createConfig(boolean overwrite) {
        try {
            File f = new File(path);
            if (overwrite) {
                if(f.createNewFile()) {
                    return true;
                }else{
                    return false;
                }
            }else{
                if(!f.exists()) {
                    if(f.createNewFile()) {
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }catch (IOException ioexc) {
            return false;
        }
        return false;
    }
    public boolean writeKey(String key, String value) {
        String read = "";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(read.equals("")) {
                    read = data;
                }else{
                    read = "\n" + data;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(read);
            myWriter.write(key + ":" + value);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        boolean contains = false;
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.contains(key)) {
                    contains = true;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return contains;
    }
    public boolean changeKey(String key, String value) {
        String read = "";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(read.equals("")) {
                    read = data;
                }else{
                    read = "\n" + data;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] worker = read.split("\n");
        String newread = "";
        for(String content : worker) {
            if(content.contains(key)) {
            }else{
                if(newread.equals("")) {
                    newread = content;
                }else{
                    newread = "\n" + content;
                }
            }
        }
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(key + ":" + value);
            myWriter.write(newread);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        boolean contains = false;
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.contains(key)) {
                    contains = true;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return contains;
    }
    public boolean removeKey(String key) {
        String read = "";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(read.equals("")) {
                    read = data;
                }else{
                    read = "\n" + data;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] worker = read.split("\n");
        String newread = "";
        for(String content : worker) {
            if(content.contains(key)) {
            }else{
                if(newread.equals("")) {
                    newread = content;
                }else{
                    newread = "\n" + content;
                }
            }
        }
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(newread);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        boolean contains = false;
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.contains(key)) {
                    contains = true;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return contains;
    }
    public String readConfig(String key) {
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.contains(key)) {
                    return data.replace(key + ":", "").replace("/", "\\");
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

}

package com.hekatomsoft.androidcor.bottombarfragment.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class HelperIO {

    //close inputStream
    public static void closeStream(InputStream stream) {
        try {
            stream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    //close OutputStream
    public static void closeStream(OutputStream stream) {
        try {
            stream.flush();
            stream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    //copy a file from one place to another
    public static void copyFile(String inputFileName, String outputFileName) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(inputFileName);
            outputStream = new FileOutputStream(outputFileName);

            copyFile(inputStream, outputStream);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(inputStream);
            closeStream(outputStream);
        }
    }


    //copy a stream to a file
    public static boolean copyFile(InputStream inputStream, String outputFileName) {
        OutputStream outputStream = null;
        boolean copyIsSuccessfull;
        try {
            outputStream = new FileOutputStream(outputFileName);
            copyIsSuccessfull = copyFile(inputStream, outputStream);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            copyIsSuccessfull = false;
        } finally {
            closeStream(inputStream);
//            closeStream(outputStream);
        }
        return copyIsSuccessfull;
    }


    //Core of all method in this class : copy a Stream from one place to another
    public static boolean copyFile(InputStream inputStream, OutputStream outputStream) {
        boolean copyIsSuccessfull;
        try {
            byte[] buffer = new byte[1024 * 8];
            int lenRead = 0;
            while ((lenRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, lenRead);
            }
            copyIsSuccessfull = true;
        }
        catch (IOException e) {
            e.printStackTrace();
            copyIsSuccessfull = false;
        } finally {
            closeStream(inputStream);
            closeStream(outputStream);
        }
        return copyIsSuccessfull;
    }

}

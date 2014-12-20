package gs.app.lib.util;

import gs.app.lib.application.App;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URLDecoder;

public class FileUtil {

    /* read bytes from a file */
    public static byte[] readBytes(File file) {
        try {
            /* get an input stream and create byte array */
            FileInputStream f = new FileInputStream(file);
            byte[] ret = new byte[(int) file.length()];

            /* read and close */
            f.read(ret);
            f.close();

            /* return the written array */
            return ret;

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        /* return null array */
        return null;
    }

    /* reads file from string */
    public static byte[] readBytes(String file) {
        return readBytes(new File(file));
    }

    /* read files and create a new string */
    public static String readString(String file) {
        return new String(readBytes(new File(file)));
    }

    /* read file from string and create it a string from it */
    public static String readString(File file) {
        return new String(readBytes(file));
    }

    /* write bytes to file */
    public static boolean writeBytes(File file, byte[] data, boolean append) {
        try {
            /* create output stream */
            FileOutputStream f = new FileOutputStream(file, append);

            /* write to stream and close */
            f.write(data);
            f.close();

            /* return true */
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        /* return false */
        return false;
    }

    /* write bytes from string */
    public static boolean writeBytes(String file, byte[] data, boolean append) {
        return writeBytes(new File(file), data, append);
    }

    /* write to file from string */
    public static boolean writeString(String file, String data, boolean append) {
        return writeBytes(new File(file), data.getBytes(), append);
    }

    /* write to file from string */
    public static boolean writeString(File file, String data, boolean append) {
        return writeBytes(file, data.getBytes(), append);
    }

    /* check if file exists */
    public static boolean exists(File file){
        return file != null && file.exists();
    }

    /* check if file exists */
    public static boolean exists(String file){
        return file != null && exists(new File(file));
    }

    /* check if is file */
    public static boolean isFile(File file){
        return file != null && file.isFile();
    }

    /* check if is file */
    public static boolean isFile(String file){
        return file != null && isFile(new File(file));
    }

    /* check if is directory */
    public static boolean isDir(File file){
        return file != null && file.isDirectory();
    }

    /* check if is a directory */
    public static boolean isDir(String file){
        return file != null && isDir(new File(file));
    }

    /* create a file */
    public static boolean create(File file){
        try {
            /* attempt to create a file */
            return file != null && file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* tell file couldnt be created */
        throw new NullPointerException("Unable to create file "+ file.getAbsolutePath());
    }

    /* create a file */
    public static boolean create(String file){
        return file != null && create(new File(file));
    }

    /* rename file */
    public static boolean rename(File file, File dest) {
        return file != null && dest != null && file.renameTo(dest);
    }

    /* rename file from string */
    public static boolean rename(String file, String dest){
        return file != null && dest != null && rename(new File(file), new File(dest));
    }

    /* delete a file */
    public static boolean delete(File file) {
        return file != null && file.delete();
    }

    /* delete a file from string */
    public static boolean delete(String file){
        return file != null && delete(new File(file));
    }

    /* get file lenght */
    public static long lenght(File file) {
        return file.length();
    }

    /* get file lenght from string */
    public static long lenght(String file){
        return lenght(new File(file));
    }

    /* make a directory */
    public static boolean mkdir(File file) {
        return file != null && file.mkdir();
    }

    /* make a directory from string */
    public static boolean mkdir(String file){
        return file != null && mkdir(new File(file));
    }

    /* make directories from */
    public static boolean mkdirs(File file) {
        return file != null && file.mkdirs();
    }

    /* make directories from string */
    public static boolean mkdirs(String file){
        return file != null && mkdirs(new File(file));
    }

    /* get URI from file */
    public static java.net.URI URI(File file) {
        return file.toURI();
    }

    /* get URI from string */
    public static java.net.URI URI(String file){
        return URI(new File(file));
    }

    /* get file from string */
    public static File toFile(String file){
        return new File(file);
    }

    /* get folder where the jar files exists */
    public static File getJarFile() throws URISyntaxException {
        /* yet again did a new fix. Hopefully I don't need to come back to this pile of shit anymore */
        return new File(FileUtil.class.getResource(FileUtil.class.getSimpleName() +".class").getFile().split("file:")[0]);
    }

    /* get absolute path of jar file folder */
    public static String getJarFolder() {
        try {
            return getJarFile().getAbsolutePath();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}

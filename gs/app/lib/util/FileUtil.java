package gs.app.lib.util;

import java.io.*;

public class FileUtil {

    public static byte[] readBytes(File file) {
        try {
            FileInputStream f = new FileInputStream(file);
            byte[] ret = new byte[(int) file.length()];

            f.read(ret);
            f.close();
            return ret;

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static byte[] readBytes(String file) {
        return readBytes(new File(file));
    }

    public static String readString(String file) {
        return new String(readBytes(new File(file)));
    }

    public static String readString(File file) {
        return new String(readBytes(file));
    }

    public static boolean writeBytes(File file, byte[] data, boolean append) {
        try {
            FileOutputStream f = new FileOutputStream(file, append);

            f.write(data);
            f.close();
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean writeBytes(String file, byte[] data, boolean append) {
        return writeBytes(new File(file), data, append);
    }

    public static boolean writeString(String file, String data, boolean append) {
        return writeBytes(new File(file), data.getBytes(), append);
    }

    public static boolean writeString(File file, String data, boolean append) {
        return writeBytes(file, data.getBytes(), append);
    }

    public static boolean exists(File file){
        return file != null && file.exists();
    }

    public static boolean exists(String file){
        return file != null && exists(new File(file));
    }

    public static boolean isFile(File file){
        return file != null && file.isFile();
    }

    public static boolean isFile(String file){
        return file != null && isFile(new File(file));
    }

    public static boolean isDir(File file){
        return file != null && file.isDirectory();
    }

    public static boolean isDir(String file){
        return file != null && isDir(new File(file));
    }

    public static boolean create(File file){
        try {
            return file != null && file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new NullPointerException("Unable to create file "+ file.getAbsolutePath());
    }

    public static boolean create(String file){
        return file != null && create(new File(file));
    }

    public static boolean rename(File file, File dest) {
        return file != null && dest != null && file.renameTo(dest);
    }

    public static boolean rename(String file, String dest){
        return file != null && dest != null && rename(new File(file), new File(dest));
    }

    public static boolean delete(File file) {
        return file != null && file.delete();
    }

    public static boolean delete(String file){
        return file != null && delete(new File(file));
    }

    public static long lenght(File file) {
        return file.length();
    }

    public static long lenght(String file){
        return lenght(new File(file));
    }

    public static boolean mkdir(File file) {
        return file != null && file.mkdir();
    }

    public static boolean mkdir(String file){
        return file != null && mkdir(new File(file));
    }

    public static boolean mkdirs(File file) {
        return file != null && file.mkdirs();
    }

    public static boolean mkdirs(String file){
        return file != null && mkdirs(new File(file));
    }

    public static java.net.URI URI(File file) {
        return file.toURI();
    }

    public static java.net.URI URI(String file){
        return URI(new File(file));
    }

    public static File toFile(String file){
        return new File(file);
    }

    public static File getJarFile(){
        return new File(".");
    }

    public static String getJarFolder(){
        return getJarFile().getAbsolutePath();
    }
}

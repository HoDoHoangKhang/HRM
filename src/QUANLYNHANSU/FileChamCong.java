/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QUANLYNHANSU;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;



public class FileChamCong {
    private static final String CHAMCONG_FILE_NAME = "FileChamCong.txt";
    
    public void write(CHAMCONG[] ccList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new java.io.File(CHAMCONG_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(ccList);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            closeStream(fos);
            closeStream(oos);
        }
    }
    public CHAMCONG[] read() {
        CHAMCONG[] ccList = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new java.io.File(CHAMCONG_FILE_NAME));
            ois = new ObjectInputStream(fis);
            ccList = (CHAMCONG[]) ois.readObject();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            closeStream(fis);
            closeStream(ois);
        }
        return ccList;
    }
    
    private void closeStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void closeStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

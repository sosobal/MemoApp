package com.example.user.myapplication;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Utilities {

    public static  final String FILE_EXTENSION = ".bin";

    public static boolean saveNote(Context context, Note note) {

        String fileName = String.valueOf(note.getDateTime()) + FILE_EXTENSION;

        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            fos = context.openFileOutput(fileName, context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(note);
            oos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
            return  false; //tell the user something went wrong
        }

        return true;
    }
}

package com.amine.controller;

import com.amine.hellofirebase.App;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AMINE IT
 */
public class DefaultController {

    private final DatabaseReference ref;

    public DefaultController() {
        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setServiceAccount(new FileInputStream("helloword-11fdca87bbae.json"))
                    .setDatabaseUrl("https://helloword-c3791.firebaseio.com/")
                    .build();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        FirebaseApp.initializeApp(options);
        // As an admin, the app has access to read and write all data, regardless of Security Rules
        this.ref = FirebaseDatabase
                .getInstance()
                .getReference();
    }

    public DatabaseReference getRef() {
        return ref;
    }

}

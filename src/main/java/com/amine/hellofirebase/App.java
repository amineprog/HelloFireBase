/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amine.hellofirebase;

import com.amine.model.Category;
import com.amine.model.Course;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author AMINE IT
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference();
        ref.removeValue();
        DatabaseReference catRef = ref.child("category").push();
        Category cat = new Category(catRef.getKey(), "Informatique");
        catRef.setValue(cat);
        DatabaseReference courseRef = ref.child("course").push();
        Course c = new Course(courseRef.getKey(), "C++ Pdf", cat);
        courseRef.setValue(c);
        System.out.println(c);
        /*for (int i = 912; i <= 25520; i++) {
            DatabaseReference newPostRef = postsRef.push();
            System.out.println("Key => " + newPostRef.getKey());
            newPostRef.setValue(new Category((long) 446453 + (i * 3), "tesst_" + i));
        }*/
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*
                Iterator<DataSnapshot> Icourses = dataSnapshot.child("course").getChildren().iterator();
                Iterator<DataSnapshot> Icategory = dataSnapshot.child("category").getChildren().iterator();

                if (dataSnapshot.hasChildren()) {
                    while (Icourses.hasNext()) {
                        ObjectMapper mapper = new ObjectMapper();
                        DataSnapshot dtCourses = (DataSnapshot) Icourses.next();
                        Course course = dtCourses.getValue(Course.class);
                        Category cat = dataSnapshot.child("category/" + course.getCategory()).getValue(Category.class);
                        System.out.println("Course : => " + course);
                        System.out.println("Category : => " + cat);
                        try {
                            System.out.println("Course As Json =>" + mapper.writeValueAsString(course));
                        } catch (IOException ex) {
                            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                 */
                //Category cat = dataSnapshot.getValue(Category.class);
//                System.out.println(cat);
            }

            @Override
            public void onCancelled(DatabaseError de) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

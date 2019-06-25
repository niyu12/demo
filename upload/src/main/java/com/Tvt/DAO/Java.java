package com.Tvt.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions; 

public class Java  
{ 
     static void RecursivePrint(File[] arr, int level)  
     { 
         // for-each loop for main directory files 
         for (File f : arr)  
         { 
        	 
             // tabs for internal levels 
             for (int i = 0; i < level; i++) 
                 System.out.print("\t"); 
             
              
             if(f.isFile())  
                 System.out.println(f.getName());
                   
             else if(f.isDirectory())  
             {  
				/*
				 * System.out.println("[" + f.getName() + "]");
				 */
                 // recursion for sub-directories 
                 RecursivePrint(f.listFiles(), level + 1); 
                 
             } 
         } 
    } 
      
    // Driver Method 
    public static void main(String[] args) throws FileNotFoundException, IOException 
    { 
    	
    	
        // Provide full path for directory(change accordingly)   
    	
        String maindirpath = "D:\\image"; 
                  
        // File object 
        File maindir = new File(maindirpath); 
           
        if(maindir.exists() && maindir.isDirectory()) 
        { 
            // array for files and sub-directories  
            // of directory pointed by maindir 
            File arr[] = maindir.listFiles(); 

    	
          System.out.println("Files from main directory : " + maindir); 
              
            // Calling recursive method 
            RecursivePrint(arr, 0);  
       }  
    } 
} 

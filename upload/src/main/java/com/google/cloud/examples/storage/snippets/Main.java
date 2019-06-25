package com.google.cloud.examples.storage.snippets;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class Main {

	



	/**
	 * A snippet for Google Cloud Storage showing how to create a bucket and a blob in it. The snippet
	 * also shows how to get a blob's content, list buckets and list blobs.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[]  args) throws FileNotFoundException, IOException {
	    // Create a service object
	    // Credentials are inferred from the environment.
/*	    Storage storage = StorageOptions.getDefaultInstance().getService();

	   */ 
	    Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:/Users/user/Downloads/myproject-237811-5d5c04d552e2.json"));
	    Storage storage = StorageOptions.newBuilder().setCredentials(credentials) .setProjectId("myproject-237811").build().getService();

	    	
	    
	    
	  /*  Storage storage = StorageOptions.newBuilder()
	    	    .setCredentials(GoogleCredentials.create(new AccessToken(accessToken, expirationTime)))
	    	    .build()
	    	    .getService();
	
	  */	

/* 		String bucketName = "jimitjani_bucket"; // Change this to something unique
	    Bucket bucket = storage.create(BucketInfo.of(bucketName));
*/ 
	    	
	    System.out.println("My buckets:");
	    for (Bucket currentBucket : storage.list().iterateAll()) {
	    	
	    	System.out.println(currentBucket);
	  
	   System.out.println("My blobs:");
	    for (Blob currentBlob : currentBucket.list().iterateAll()) {
	      System.out.println(currentBlob);
	    }

	    
	    }

	    
	  
	    // List all your buckets
	  
	    	
	  
	  
	  }
	

	
	
}

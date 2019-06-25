package com.Tvt.DAO;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.examples.storage.snippets.CreateBlob;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket.BlobWriteOption;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;

public class BusinessLogic {

//upload image facility

	/**
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		try {

			Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("D:/GOOGLE CLOUD/STORAGE/GoogleCloudKey/enduring-sweep-244011-6957b3d34ff1.json"));
			Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

			
			try {
				
				
				 

					File file = new File("D:\\GOOGLE CLOUD\\Sample Pictures\\Done work\\01-03\\pl");
					File[] files = file.listFiles();
					for(File f: files)
					{
						System.out.println(f.getName());
						
					BlobId blobId = BlobId.of("cloudgo","D:/GOOGLE CLOUD/Sample Pictures/Done work/01-03/pl/"+f.getName()+".jpg");
						InputStream inputStream = new FileInputStream(new File("D:\\GOOGLE CLOUD\\Sample Pictures\\Done work\\01-03\\pl\\"+f.getName()));
						BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpg").build();
						System.out.println("Sucessfull path set");
						Blob blob = storage.create(blobInfo,inputStream);
						System.out.println("Upload Blob Sucessfull");	
				
					}
			}
			
		
					catch (StorageException e) {
						
						e.printStackTrace();
					}
			
				}	
					catch (Exception e) {
						e.printStackTrace();
		 			}		


	}

}

package com.springdemo.firebase.config;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.FirestoreClient;
import com.springdemo.firebase.utility.ApplicationConstants;

@Configuration
public class FirebaseConfig {

	@Bean
	FirebaseApp firebaseApp() throws IOException {
		FileInputStream serviceAccount = new FileInputStream(ApplicationConstants.FIREBASE_CONFIG_FILE);

		FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();

		return FirebaseApp.initializeApp(options);
	}

	@Bean
	Firestore firestore(final FirebaseApp firebaseApp) {
		return FirestoreClient.getFirestore(firebaseApp);
	}

	@Bean
	Storage storage() throws IOException {
		FileInputStream serviceAccount = new FileInputStream(ApplicationConstants.FIREBASE_CONFIG_FILE);

		return StorageOptions.newBuilder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build()
				.getService();
	}
	
	@Bean
	FirebaseAuth firebaseAuth(final FirebaseApp firebaseApp) {
		return FirebaseAuth.getInstance(firebaseApp);
	}
}

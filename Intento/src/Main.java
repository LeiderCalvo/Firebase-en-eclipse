import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.auth.*;

public class Main {

	public static void main(String[] args) {
		 
		FileInputStream serviceAccount;
		
		try {
			serviceAccount = new FileInputStream("intento-4f2ec-firebase-adminsdk-p78fr-7db3dd68da.json");

				FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setDatabaseUrl("https://intento-4f2ec.firebaseio.com")
				  .build();

				FirebaseApp.initializeApp(options);
				
				
				
				CreateRequest request = new CreateRequest()
					    .setEmail("user@example.com")
					    .setEmailVerified(false)
					    .setPassword("secretPassword")
					    .setPhoneNumber("+11234567890")
					    .setDisplayName("John Doe")
					    .setPhotoUrl("http://www.example.com/12345678/photo.png")
					    .setDisabled(false);

					UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
					System.out.println("Successfully created new user: " + userRecord.getUid());
				
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}

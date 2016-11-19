package com.example.android.visitsemarang;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class kesenian extends AppCompatActivity {

    // Randomly generated number to display random traditional art data
    int kesenianId;

    // Used to check if the same fact is displayed twice, initialized outside of array size
    int oldkesenianId = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kesenian);

    }

    /**
     * Called when "Generate Random Fact" button is pressed, displays  traditional art details and image
     */
    public void displayKesenianInfo(View view) {
        // Declare detailsTextView to update screen with traditional art information
        TextView detailsTextView = (TextView) findViewById(R.id.kesenian_detail_text_view);

        // Declare kesenianImageView to update screen with traditional art image
        ImageView kesenianImageView = (ImageView) findViewById(R.id.kesenian_icon_image_view);

        // Populate the TextView with details on the selected traditional art
        detailsTextView.setText(getKesenianInfo());

        // Display an image based on the selected traditional art
        switch (kesenianId) {
            case 0: kesenianImageView.setImageResource(R.drawable.tari_semarangan);
                break;
            case 1: kesenianImageView.setImageResource(R.drawable.tari_topeng_gecul);
                break;
            case 2: kesenianImageView.setImageResource(R.drawable.gambang_semarang);
                break;
            case 3: kesenianImageView.setImageResource(R.drawable.wayang_kulit);
                break;
            case 4: kesenianImageView.setImageResource(R.drawable.wayang_orang);
                break;
        }
    }

    /**
     * Generate a random traditional art
     *
     * @return String containing details on a traditional art
     */
    public String getKesenianInfo() {
        // Declare array of traditional art details
        Resources res = getResources();
        String[] kesenianDetails = res.getStringArray(R.array.kesenian_details_array);

        // Store length of the array
        int arrayLength = kesenianDetails.length;

        // Generate a random number based on the number of items in traditional art Names array
        kesenianId = randInt(kesenianDetails.length);

        // Check that value isn't the same as previous value
        checkId(arrayLength);

        // Store current kesenianId to compare to next value
        oldkesenianId = kesenianId;

        return kesenianDetails[kesenianId];
    }

    /**
     * Returns a pseudo-random number between 0 and a max number, inclusive.
     *
     * @param max Maximum value.
     * @return Integer between 0 and max, inclusive.
     */
    public static int randInt(int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt(max);
        return randomNum;
    }

    /**
     * Returns if the same fact is not displayed twice
     *
     * @param arrayLength length of the array of traditional art information
     */
    public void checkId(int arrayLength) {
        if (oldkesenianId != kesenianId) {
            return;
        } else {
            while (oldkesenianId== kesenianId) {
                kesenianId = randInt(arrayLength);
            }
            return;
        }
    }

}

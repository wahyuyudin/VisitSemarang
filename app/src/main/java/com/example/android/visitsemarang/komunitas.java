package com.example.android.visitsemarang;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class komunitas extends AppCompatActivity {

    // Randomly generated number to display random traditional art data
    int komunitasId;

    // Used to check if the same fact is displayed twice, initialized outside of array size
    int oldkomunitasId = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komunitas);
    }

    /**
     * Called when "Generate Random Fact" button is pressed, displays  traditional art details and image
     */
    public void displayKomunitasInfo(View view) {
        // Declare detailsTextView to update screen with traditional art information
        TextView detailsTextView = (TextView) findViewById(R.id.komunitas_detail_text_view);

        // Declare komunitasImageView to update screen with traditional art image
        ImageView komunitasImageView = (ImageView) findViewById(R.id.komunitas_icon_image_view);

        // Populate the TextView with details on the selected traditional art
        detailsTextView.setText(getKomunitasInfo());

        // Display an image based on the selected traditional art
        switch (komunitasId) {
            case 0: komunitasImageView.setImageResource(R.drawable.tari_semarangan);
                break;
            case 1: komunitasImageView.setImageResource(R.drawable.tari_topeng_gecul);
                break;
            case 2: komunitasImageView.setImageResource(R.drawable.gambang_semarang);
                break;
            case 3: komunitasImageView.setImageResource(R.drawable.wayang_kulit);
                break;
            case 4: komunitasImageView.setImageResource(R.drawable.wayang_orang);
                break;
        }
    }

    /**
     * Generate a random traditional art
     *
     * @return String containing details on a traditional art
     */
    public String getKomunitasInfo() {
        // Declare array of traditional art details
        Resources res = getResources();
        String[] komunitasDetails = res.getStringArray(R.array.komunitas_details_array);

        // Store length of the array
        int arrayLength = komunitasDetails.length;

        // Generate a random number based on the number of items in traditional art Names array
        komunitasId = randInt(komunitasDetails.length);

        // Check that value isn't the same as previous value
        checkId(arrayLength);

        // Store current komunitasId to compare to next value
        oldkomunitasId = komunitasId;

        return komunitasDetails[komunitasId];
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
        if (oldkomunitasId != komunitasId) {
            return;
        } else {
            while (oldkomunitasId== komunitasId) {
                komunitasId = randInt(arrayLength);
            }
            return;
        }
    }


}

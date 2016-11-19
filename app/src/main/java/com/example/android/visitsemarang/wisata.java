package com.example.android.visitsemarang;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class wisata extends AppCompatActivity {

    // Randomly generated number to display random wisata data
    int wisataId;

    // Used to check if the same fact is displayed twice, initialized outside of array size
    int oldwisataId = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

    }

    /**
     * Called when "Generate Random Fact" button is pressed, displays  wisata details and image
     */
    public void displayWisataInfo(View view) {
        // Declare detailsTextView to update screen with wisata information
        TextView detailsTextView = (TextView) findViewById(R.id.wisata_detail_text_view);

        // Declare wisataImageView to update screen with wisata image
        ImageView wisataImageView = (ImageView) findViewById(R.id.wisata_icon_image_view);

        // Populate the TextView with details on the selected wisata
        detailsTextView.setText(getWisataInfo());

        // Display an image based on the selected wisata
        switch (wisataId) {
            case 0: wisataImageView.setImageResource(R.drawable.tm2);
                break;
            case 1: wisataImageView.setImageResource(R.drawable.majt2);
                break;
            case 2: wisataImageView.setImageResource(R.drawable.vihara);
                break;
            case 3: wisataImageView.setImageResource(R.drawable.spk);
                break;
            case 4: wisataImageView.setImageResource(R.drawable.simpang5);
                break;
            case 5: wisataImageView.setImageResource(R.drawable.lawang);
                break;
        }
    }

    /**
     * Generate a random wisata
     *
     * @return String containing details on a wisata
     */
    public String getWisataInfo() {
        // Declare array of wisata details
        Resources res = getResources();
        String[] wisataDetails = res.getStringArray(R.array.wisata_details_array);

        // Store length of the array
        int arrayLength = wisataDetails.length;

        // Generate a random number based on the number of items in Names array
        wisataId = randInt(wisataDetails.length);

        // Check that value isn't the same as previous value
        checkId(arrayLength);

        // Store current wisataId to compare to next value
        oldwisataId = wisataId;

        return wisataDetails[wisataId];
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
     * @param arrayLength length of the array of information
     */
    public void checkId(int arrayLength) {
        if (oldwisataId != wisataId) {
            return;
        } else {
            while (oldwisataId== wisataId) {
                wisataId = randInt(arrayLength);
            }
            return;
        }
    }


}

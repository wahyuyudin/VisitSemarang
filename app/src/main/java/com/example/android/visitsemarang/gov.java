package com.example.android.visitsemarang;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class gov extends AppCompatActivity {

    // Randomly generated number to display random traditional art data
    int govId;

    // Used to check if the same fact is displayed twice, initialized outside of array size
    int oldgovId = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gov);

    }

    /**
     * Called when "Generate Random Fact" button is pressed, displays  traditional art details and image
     */
    public void displayGovInfo(View view) {
        // Declare detailsTextView to update screen with traditional art information
        TextView detailsTextView = (TextView) findViewById(R.id.gov_detail_text_view);

        // Declare govImageView to update screen with traditional art image
        ImageView govImageView = (ImageView) findViewById(R.id.gov_icon_image_view);

        // Populate the TextView with details on the selected traditional art
        detailsTextView.setText(getGovInfo());

        // Display an image based on the selected traditional art
        switch (govId) {
            case 0: govImageView.setImageResource(R.drawable.kantor_gub);
                break;
            case 1: govImageView.setImageResource(R.drawable.ombuds);
                break;
            case 2: govImageView.setImageResource(R.drawable.bpk);
                break;
            case 3: govImageView.setImageResource(R.drawable.pip);
                break;
            case 4: govImageView.setImageResource(R.drawable.dprd);
                break;
        }
    }

    /**
     * Generate a random traditional art
     *
     * @return String containing details on a traditional art
     */
    public String getGovInfo() {
        // Declare array of traditional art details
        Resources res = getResources();
        String[] govDetails = res.getStringArray(R.array.gov_details_array);

        // Store length of the array
        int arrayLength = govDetails.length;

        // Generate a random number based on the number of items in traditional art Names array
        govId = randInt(govDetails.length);

        // Check that value isn't the same as previous value
        checkId(arrayLength);

        // Store current govId to compare to next value
        oldgovId = govId;

        return govDetails[govId];
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
        if (oldgovId != govId) {
            return;
        } else {
            while (oldgovId== govId) {
                govId = randInt(arrayLength);
            }
            return;
        }
    }

}

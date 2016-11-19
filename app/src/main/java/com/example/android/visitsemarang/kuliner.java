package com.example.android.visitsemarang;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class kuliner extends AppCompatActivity {

    // Randomly generated number to display random kuliner data
    int kulinerId;

    // Used to check if the same fact is displayed twice, initialized outside of array size
    int oldkulinerId = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner);
    }
    /**
     * Called when "Generate Random Fact" button is pressed, displays  kuliner details and image
     */
    public void displayKulinerInfo(View view) {
        // Declare detailsTextView to update screen with kuliner information
        TextView detailsTextView = (TextView) findViewById(R.id.kuliner_detail_text_view);

        // Declare kulinerImageView to update screen with kuliner image
        ImageView kulinerImageView = (ImageView) findViewById(R.id.kuliner_icon_image_view);

        // Populate the TextView with details on the selected kuliner
        detailsTextView.setText(getKulinerInfo());

        // Display an image based on the selected kuliner
        switch (kulinerId) {
            case 0: kulinerImageView.setImageResource(R.drawable.tahu_gimbal);
                break;
            case 1: kulinerImageView.setImageResource(R.drawable.tahu_petis);
                break;
            case 2: kulinerImageView.setImageResource(R.drawable.soto_semarang);
                break;
            case 3: kulinerImageView.setImageResource(R.drawable.lumpia);
                break;
            case 4: kulinerImageView.setImageResource(R.drawable.bandeng_presto);
                break;

        }
    }

    /**
     * Generate a random kuliner
     *
     * @return String containing details on a kuliner
     */
    public String getKulinerInfo() {
        // Declare array of kuliner details
        Resources res = getResources();
        String[] kulinerDetails = res.getStringArray(R.array.kuliner_details_array);

        // Store length of the array
        int arrayLength = kulinerDetails.length;

        // Generate a random number based on the number of items in Names array
        kulinerId = randInt(kulinerDetails.length);

        // Check that value isn't the same as previous value
        checkId(arrayLength);

        // Store current kulinerId to compare to next value
        oldkulinerId = kulinerId;

        return kulinerDetails[kulinerId];
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
        if (oldkulinerId != kulinerId) {
            return;
        } else {
            while (oldkulinerId== kulinerId) {
                kulinerId = randInt(arrayLength);
            }
            return;
        }
    }

}

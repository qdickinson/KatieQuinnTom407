package com.example.labassistant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ElementDetailActivity extends Activity
{

    Integer mCurrentImagePosition = -1;		// Currently displayed image

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementdetail);

        // Get intent data
        Intent i = getIntent();
        // Extract Image ID (position) from the passed intent
        mCurrentImagePosition = i.getExtras().getInt("id");

        // First, set the image user want to be displayed.
        ImageView imageView = (ImageView) findViewById(R.id.image_large);
        imageView.setImageResource(mPics[mCurrentImagePosition]);

        // Set UI controls
        setCaptionUIControls();
    }

    /**
     * Method to set UI related to Image caption.
     */
    public void setCaptionUIControls()
    {
        // See if a caption has already been added for this image.
        LinearLayout captionLinearLayout = (LinearLayout) findViewById(R.id.image_caption_linearlayout);
        TextView captionTextView = (TextView) findViewById(R.id.image_caption_textview);

        String caption = getImageCaption();
        if(caption!= null && !caption.equals(""))
        {
            captionTextView.setVisibility(View.VISIBLE);
            captionTextView.setText(caption);
            captionLinearLayout.setVisibility(View.GONE);
        }
        else
        {
            captionTextView.setVisibility(View.GONE);
            captionLinearLayout.setVisibility(View.VISIBLE);
        }
    }

    // Element Images
    public Integer[] mPics =
            {
                    R.drawable.e1, R.drawable.e2,
                    R.drawable.e3, R.drawable.e4, R.drawable.e5,
                    R.drawable.e6, R.drawable.e7, R.drawable.e8,
                    R.drawable.e9, R.drawable.e10, R.drawable.e11,
                    R.drawable.e12, R.drawable.e13, R.drawable.e14,
                    R.drawable.e15, R.drawable.e16, R.drawable.e17,
                    R.drawable.e18, R.drawable.e19, R.drawable.e20,
                    R.drawable.e21, R.drawable.e22, R.drawable.e23,
                    R.drawable.e24, R.drawable.e25, R.drawable.e26,
                    R.drawable.e27, R.drawable.e28, R.drawable.e29,
                    R.drawable.e30, R.drawable.e31, R.drawable.e32,
                    R.drawable.e33, R.drawable.e34, R.drawable.e35,
                    R.drawable.e36, R.drawable.e37, R.drawable.e38,
                    R.drawable.e39, R.drawable.e40, R.drawable.e41,
                    R.drawable.e42, R.drawable.e43, R.drawable.e44,
                    R.drawable.e45, R.drawable.e46, R.drawable.e47,
                    R.drawable.e48, R.drawable.e49, R.drawable.e50,
                    R.drawable.e51, R.drawable.e52, R.drawable.e53,
                    R.drawable.e54, R.drawable.e55, R.drawable.e56,
                    R.drawable.e57, R.drawable.e58, R.drawable.e59,
                    R.drawable.e60, R.drawable.e61, R.drawable.e62,
                    R.drawable.e63, R.drawable.e64, R.drawable.e65,
                    R.drawable.e66, R.drawable.e67, R.drawable.e68,
                    R.drawable.e69, R.drawable.e70, R.drawable.e71,
                    R.drawable.e72, R.drawable.e73, R.drawable.e74,
                    R.drawable.e75, R.drawable.e76, R.drawable.e77,
                    R.drawable.e78, R.drawable.e79, R.drawable.e80,
                    R.drawable.e81, R.drawable.e82, R.drawable.e83,
                    R.drawable.e84, R.drawable.e85, R.drawable.e86,
                    R.drawable.e87, R.drawable.e88, R.drawable.e89,
                    R.drawable.e90, R.drawable.e91, R.drawable.e92,
                    R.drawable.e93, R.drawable.e94, R.drawable.e95,
                    R.drawable.e96, R.drawable.e97, R.drawable.e98,
                    R.drawable.e99, R.drawable.e100, R.drawable.e101,
                    R.drawable.e102, R.drawable.e103, R.drawable.e104,
                    R.drawable.e105, R.drawable.e106, R.drawable.e107,
                    R.drawable.e108, R.drawable.e109, R.drawable.e110,
                    R.drawable.e111, R.drawable.e112
            };

    private static final String PREFS_NAME = "com.example.Elements.caption";

    /**
     * Method to get the Image Caption (if any) from Shared Preferences.
     *
     * @return	Image caption text
     */
    private String getImageCaption()
    {
        // Check if SharedPreferences has a caption associated for the requested image.
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        //prefs.getString(mCurrentImagePosition.toString(), null)
        return " ";
    }

    /**
     * Method to store Image caption in SharePreferences.
     *
     * @param caption 	Caption text
     */
    private void setImageCaption(String caption)
    {
        // Get Shared Preferences Editor
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        // Edit the value for this particular key (Image position) and commit the change.
        editor.putString(mCurrentImagePosition.toString(), caption);
        editor.commit();
    }

    /**
     * Click callback for 'Add' button on ImageDetail Screen.
     *
     * @param v		View clicked
     */
    public void onButtonClick(View v)
    {
        switch(v.getId())
        {
            case R.id.image_caption_button:

                EditText captionEditText = (EditText) findViewById(R.id.image_caption_edittext);
                String caption = captionEditText.getText().toString();

                if(caption != null && !caption.equals(""))
                {
                    // Store the caption string in Shared Preferences against this image.
                    setImageCaption(caption);

                    // Refresh UI
                    setCaptionUIControls();
                }
                break;

            default:
        }
    }

    /**
     * Click callback for 'TextView' on ImageDetail Screen.
     *
     * @param v		View clicked
     */
    public void onTextViewClick(View v)
    {
        switch(v.getId())
        {
            case R.id.image_caption_textview:

                TextView captionTextView = (TextView) findViewById(R.id.image_caption_textview);
                LinearLayout captionLinearLayout = (LinearLayout) findViewById(R.id.image_caption_linearlayout);
                EditText captionEditText = (EditText) findViewById(R.id.image_caption_edittext);

                // Put the text of TextView in EditText
                String caption = captionTextView.getText().toString();
                captionEditText.setText(caption);

                if(captionEditText.requestFocus())
                    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

                // And, make EditText & Button visible
                captionTextView.setVisibility(View.GONE);
                captionLinearLayout.setVisibility(View.VISIBLE);

                break;

            default:
        }
    }

}





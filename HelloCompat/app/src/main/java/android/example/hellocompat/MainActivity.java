package android.example.hellocompat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private TextView mHelloTextView;

    private String[] mColorArray = {"purple_200", "purple_500", "purple_700",
            "teal_200", "teal_700", "black", "white", "red", "pink",
            "purple", "deep_purple", "indigo", "blue", "light_blue",
            "cyan", "teal", "green", "light_green", "lime", "yellow",
            "amber", "orange", "deep_orange", "brown", "grey", "blue_grey", "black"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelloTextView = (TextView) findViewById(R.id.hello_textview);
        if (savedInstanceState != null) {
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    public void changeColor(View view) {
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(27)];

        int colorResourceName = getResources().getIdentifier(colorName,
                "color", getApplicationContext().getPackageName());
        int colorRes =
                getResources().getColor(colorResourceName);

        mHelloTextView.setTextColor(colorRes);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //save the current text color
        outState.putInt("color", mHelloTextView.getCurrentTextColor());
    }
}
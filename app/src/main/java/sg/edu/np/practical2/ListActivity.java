package sg.edu.np.practical2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        View img = findViewById(R.id.imageView2);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(ListActivity.this);
                builder1.setMessage("MADness");
                builder1.setTitle("Profile");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "View",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Random rand = new Random();
                                int number = rand.nextInt();
                                Intent goToMainActivity = new Intent(ListActivity.this, MainActivity.class);
                                goToMainActivity.putExtra("randomInt", number);
                                startActivity(goToMainActivity);
                            }
                        });
                builder1.setNegativeButton(
                        "Close",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
    }


}
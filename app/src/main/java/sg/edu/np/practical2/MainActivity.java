package sg.edu.np.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView name = findViewById(R.id.nameTxt);
        TextView desc = findViewById(R.id.descriptionTxt);
        Button follow = findViewById(R.id.btnFollow);
        Button message = findViewById(R.id.messageBtn);

        int id = getIntent().getIntExtra("id", 0);
        user clickedUser = ListActivity.obj.get(id);

//        user newUser = new user("Dave", "Description about Dave", 1, false);




        message.setText("MESSAGE");
        name.setText(clickedUser.name);
        desc.setText(clickedUser.desc);



        if (clickedUser.followed == false)
        {
            follow.setText("FOLLOW");
        }
        else
        {
            follow.setText("UNFOLLOW");
        }

        follow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence toastMessage = "";
                int duration = Toast.LENGTH_SHORT;
                if(clickedUser.followed)
                {
                    toastMessage = "Unfollowed";
                    follow.setText("FOLLOW");
                    clickedUser.followed = false;
                }
                else
                {
                    toastMessage = "Followed";
                    follow.setText("UNFOLLOW");
                    clickedUser.followed = true;
                }



                Toast toast = Toast.makeText(context, toastMessage, duration);
                toast.show();
            }
        });

    }



}
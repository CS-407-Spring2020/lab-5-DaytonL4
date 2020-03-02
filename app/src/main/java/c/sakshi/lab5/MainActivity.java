package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","");
        if (!username.equals("")) {
            goToActivity2(username);
        } else {
            setContentView(R.layout.activity_main);
        }


    }

    public void clickFunction(View view) {
        EditText nameField = (EditText) findViewById(R.id.nameEditText);
        String str = nameField.getText().toString();
        if (str.equals("")) {
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        sharedPreferences.edit().putString("username", str).apply();

        goToActivity2(str);
    }

    public void goToActivity2(String str) {
        Intent intent = new Intent(this, Main2Activity.class);

        intent.putExtra("message", str);

        startActivity(intent);
    }
}

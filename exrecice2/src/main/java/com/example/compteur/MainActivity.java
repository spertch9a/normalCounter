package com.example.compteur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView res;
    private Button plusone;
    private Button plusten;
    private Button plushundred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = (TextView) findViewById(R.id.resultat);
        plusone = (Button) findViewById(R.id.addone);
        plusten = (Button) findViewById(R.id.addten);
        plushundred = (Button) findViewById(R.id.addhundred);

        plusone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = Integer.parseInt(res.getText().toString()) + 1;
                res.setText(String.valueOf(total));
            }
        });

        plusten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = Integer.parseInt(res.getText().toString()) + 10;
                res.setText(String.valueOf(total));
            }
        });

        plushundred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = Integer.parseInt(res.getText().toString()) + 100;
                res.setText(String.valueOf(total));
            }
        });





        registerForContextMenu(plusone);
        registerForContextMenu(plusten);
        registerForContextMenu(plushundred);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menufruits, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
          //choosing to reset the result
            case R.id.reset:
                res.setText("0");
                return true;

                //choosing to quit
            case R.id.quit:
                finish();
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
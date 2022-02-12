package com.example.bai11_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnMenuPopUp, btnMenuContext;
    ConstraintLayout manHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenuPopUp = (Button) findViewById(R.id.btnHienMenu);
        btnMenuContext = (Button) findViewById(R.id.btnHienMenuContext);
        manHinh = (ConstraintLayout) findViewById(R.id.ManHinh);


        btnMenuPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowMenu();
            }
        });

        registerForContextMenu(btnMenuContext);

    }

    private void ShowMenu(){
        PopupMenu popupMenu = new PopupMenu(this, btnMenuPopUp);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.menuThem: btnMenuPopUp.setText("Menu Thêm");
                        break;
                    case R.id.menuSua:btnMenuPopUp.setText("Menu Sửa");
                        break;
                    case R.id.menuXoa: btnMenuPopUp.setText("Menu Xoá");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuSetting:
                Toast.makeText(MainActivity.this, "you choose "+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuAbout:
                Toast.makeText(MainActivity.this, "you choose "+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuShare:
                Toast.makeText(MainActivity.this, "you choose "+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuEmail:
                Toast.makeText(MainActivity.this, "you choose "+item.getTitle(), Toast.LENGTH_SHORT).show();

                break;
            case R.id.menuPhone:
                Toast.makeText(MainActivity.this, "you choose "+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context,menu);
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        menu.setHeaderTitle("Select Color");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuRed:
                manHinh.setBackgroundColor(Color.RED);
                break;
            case R.id.menuBlue:
                manHinh.setBackgroundColor(Color.BLUE);
                break;
            case R.id.menuYellow:
                manHinh.setBackgroundColor(Color.YELLOW);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
package com.buzinasgeekbrains.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.buzinasgeekbrains.fragments.ui.NetworkFragment;
import com.google.android.material.navigation.NavigationView;
//          Задание:
//        1. Используйте уведомления или диалоговые окна в своем приложении. К примеру, перед
//          выходом из приложения уточните у пользователя в диалоговом окне, действительно ли он
//          хочет это сделать. И отображайте Toast при закрытии приложения.
//        2. * Возвращайте данные из диалога в активити через интерфейс, но не передавая интерфейс
//          через отдельный метод фрагмента, а приводя контекст к типу этого интерфейса.

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.fragment_container_1, new NotesListFragment())
//                        .commit();
        addFragment(NetworkFragment.newInstance());
    }

    private void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_1, fragment)
                .addToBackStack(null)
                .commit();

    }


    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_draver_open,
                R.string.navigation_draver_close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.action_about) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack("")
                        .replace(R.id.fragment_container_1, new AboutFragment()).commit();
                drawerLayout.closeDrawers();
                return true;
            } else if (id == R.id.action_exit)  {
                new AlertDialog.Builder(this)
                        .setMessage("Вы точно хотите выйти из приложения?")
                        .setTitle("Подтвердите действие")
                        .setPositiveButton("Yes", (dialog, which) -> finish())
                        .setNegativeButton("No", (dialog, which) -> Toast.makeText(this, "Вы остались в приложении", Toast.LENGTH_SHORT).show()).show();

                return true;
            }
            return false;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack("")
                    .replace(R.id.fragment_container_1, new AboutFragment()).commit();
            return true;
        } else if (id == R.id.action_exit)  {

            new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setMessage("Вы точно хотите выйти из приложения?")
                    .setTitle("Подтвердите действие")
                    .setPositiveButton("Yes", (dialog, which) -> finish())
                    .setNegativeButton("No", (dialog, which) -> Toast.makeText(this, "Вы остались в приложении", Toast.LENGTH_SHORT).show()).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getFragments().size() > 0) {
            getSupportFragmentManager().popBackStack();
        } else  {
            super.onBackPressed();
        }

    }
}
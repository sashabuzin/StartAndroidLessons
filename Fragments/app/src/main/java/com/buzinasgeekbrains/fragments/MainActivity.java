package com.buzinasgeekbrains.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
//          Задание:
//        1. Почитайте документацию методов requireActivity(), requireContext(), getActivity(),
//        getContext() и объясните разницу между ними;
//        2. Создайте класс данных со структурой заметок: название заметки, описание заметки,
//        дата создания и т. п.
//        3. Создайте фрагмент для вывода этих данных.
//        4. Встройте этот фрагмент в активити. У вас должен получиться экран с заметками,
//        который мы будем улучшать с каждым новым уроком.
//        5. Добавьте фрагмент, в котором открывается заметка. По аналогии с примером из урока:
//        если нажать на элемент списка в портретной ориентации — открывается новое окно,
//        если нажать в ландшафтной — окно открывается рядом.
//        6. * Разберитесь, как можно сделать, и сделайте корректировку даты создания при
//        помощи DatePicker.

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_1, new NotesListFragment())
                        .commit();
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
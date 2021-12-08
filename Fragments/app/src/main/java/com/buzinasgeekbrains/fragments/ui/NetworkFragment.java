package com.buzinasgeekbrains.fragments.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.buzinasgeekbrains.fragments.NoteDetailFragment;
import com.buzinasgeekbrains.fragments.Notes;
import com.buzinasgeekbrains.fragments.NotesSourceImpl;
import com.buzinasgeekbrains.fragments.R;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NetworkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NetworkFragment extends Fragment {

    private static final int MY_DEFAULT_DURATION = 100;
    private NotesSourceImpl note;
    private NetworkAdapter adapter;
    private RecyclerView recyclerView;

    
    public NetworkFragment() {
    }
    
    public static NetworkFragment newInstance() {
        return new NetworkFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_network, container, false);
//        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_lines);
//        List<Notes> data = Notes.listNotes;
//        initRecyclerView(recyclerView, data);
        note = new NotesSourceImpl().init();
        initView(view);
        setHasOptionsMenu(true);
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view_lines);
        note = new NotesSourceImpl().init();
        initRecyclerView();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            note.addCardData(new Notes("Заголовок " + note.size(), "Описание " + note.size()));
            adapter.notifyItemInserted(note.size() - 1);
            recyclerView.smoothScrollToPosition(note.size() - 1);
            return true;
        } else if (id == R.id.action_clear) {
            note.clearCardData();
            adapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    private void initRecyclerView(RecyclerView recyclerView, List<Notes> data) {
    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new NetworkAdapter(note.getDataSource(), this);
        recyclerView.setAdapter(adapter);

        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setAddDuration(MY_DEFAULT_DURATION);
        animator.setRemoveDuration(MY_DEFAULT_DURATION);
        recyclerView.setItemAnimator(animator);

        adapter.setOnItemClickListener((view, position) -> {
            showDescription(position);

        });
    }

    private void showDescription(int position) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_1, NoteDetailFragment.newInstance(position))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = requireActivity().getMenuInflater();
        inflater.inflate(R.menu.card_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int position = adapter.getMenuPosition();
        int id = item.getItemId();
        if (id == R.id.action_update) {
            note.updateCardData(position,
            new Notes("Заглушка для изменения заметки " + position,
            note.getCardData(position).getDescription()
            ));
            adapter.notifyItemChanged(position);
            return true;
        } else if (id == R.id.action_delete) {
            note.deleteCardData(position);
            adapter.notifyItemRemoved(position);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
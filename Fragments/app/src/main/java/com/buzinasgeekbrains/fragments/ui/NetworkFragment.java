package com.buzinasgeekbrains.fragments.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buzinasgeekbrains.fragments.NoteDetailFragment;
import com.buzinasgeekbrains.fragments.Notes;
import com.buzinasgeekbrains.fragments.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NetworkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NetworkFragment extends Fragment {
    
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
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_lines);
        List<Notes> data = Notes.listNotes;
        initRecyclerView(recyclerView, data);
        return view;
    }

    private void initRecyclerView(RecyclerView recyclerView, List<Notes> data) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        NetworkAdapter adapter = new NetworkAdapter(Notes.listNotes);
        recyclerView.setAdapter(adapter);

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
}
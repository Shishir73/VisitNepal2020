package com.example.visitnepal2020;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.visitnepal2020.Retrofit.Bored;
import com.example.visitnepal2020.ViewModel.Viewmodel;

public class FoodFragment extends Fragment {

    private TextView textView;
    private Viewmodel viewModel;
    private Button searchButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.fragment_foods, container, false);

        textView = vi.findViewById(R.id.textViewThings);

        viewModel = ViewModelProviders.of(this).get(Viewmodel.class);
        viewModel.getActivity().observe(this, new Observer<Bored>() {
            @Override
            public void onChanged(Bored bore) {
                textView.setText(bore.getActivity());
            }
        });

        searchButton = vi.findViewById(R.id.Button_Search);
        searchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                viewModel.updateActivity();
            }
        });

        return vi;
    }
}

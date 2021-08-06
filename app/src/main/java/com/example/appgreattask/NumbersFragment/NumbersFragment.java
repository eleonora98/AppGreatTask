package com.example.appgreattask.NumbersFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appgreattask.R;

public class NumbersFragment extends Fragment  {

    private EditText enteredNumber;
    private Button btnSearch;
    private TextView tvMessage;

    int [] arr = {1,2,4,6,8,12,13,16,20,22,28,34,38,45,56,58,60,61,62,70,
            71,72,74,75,80,85,87,90,99,100};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numbers, container, false);
        initViews(view);

        return view;
    }

    private void initViews(View view){
        enteredNumber = view.findViewById(R.id.number);
        btnSearch = view.findViewById(R.id.btnSearch);
        tvMessage = view.findViewById(R.id.tvNumberMessage);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchNumber(arr);
            }
        });
    }

    private void searchNumber(int [] arr) {
        int iterations;
        int number = Integer.parseInt(enteredNumber.getText().toString());

        for (int i=0; i<arr.length; i++) {
            if ( arr[i] == number){
                iterations = i+1;
                String string = String.format(getString(R.string.found_number), number, iterations);
                tvMessage.setText(string);
                break;
            }
            else {
                tvMessage.setText("Not found");
            }
        }
    }
}
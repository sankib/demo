package com.example.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.textfield.TextInputEditText;

public class FirstFragment extends Fragment {
Button continue_button;
    TextInputEditText fpInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        fpInput = (TextInputEditText) v.findViewById(R.id.fpInput);
        continue_button = (Button) v.findViewById(R.id.continue_button);

        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        fpInput.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                fpInput.setHint("");
                return false;
            }
        });
        fpInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    fpInput.setHint("+254 123 456789");
                }
            }
        });
    }

}
//Removes hint
//    private boolean removeHint() {
//        String passI = (String) fpInput.getText().toString();
//
//            fpInput.setText("");
//            return false;
//        }
//        fpInput.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                removeHint();
//
//
//            }
//
//        });
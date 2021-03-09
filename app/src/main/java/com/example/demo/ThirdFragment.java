package com.example.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.textfield.TextInputEditText;

public class ThirdFragment extends Fragment {
    Button change_password_button;
    TextView conpasserror,passerror;
    TextInputEditText pass,passcon;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        pass = (TextInputEditText) v.findViewById(R.id.newPasswordText);
        change_password_button = (Button) v.findViewById(R.id.change_password_button);
        passcon = (TextInputEditText) v.findViewById(R.id.confirmPasswordText);
        passerror = (TextView) v.findViewById(R.id.passwordError);
        conpasserror = (TextView) v.findViewById(R.id.confirmPasswordError);
        return v;


    }
    private boolean validatePassword() {
        String passI = (String)pass.getText().toString();
        String passconI=(String) passcon.getText().toString().trim();
        if (passI.isEmpty()) {
            passerror.setText("Field can't be empty");
            return false;
        }  if (passI.length()<5) {
            passerror.setText("Password must be at least 5 characters");
            return false;
        }
        if (passI.equals(passconI)) {
            conpasserror.setText("Password Matched");

            return false;
        }else {
            conpasserror.setText("Password Would Not be matched");
            return true;
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);

        change_password_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    validatePassword();
//                    if(validatePassword()==true){
//                    NavHostFragment.findNavController(ThirdFragment.this)
//                            .navigate(R.id.action_ThirdFragment_to_FirstFragment);}
                }

            });
        }


}



//            pass.getText().toString().trim();
//, TextInputEditText pass, TextInputEditText passcon, TextView passerror, TextView conpasserror
//            passcon.getText().toString().trim(
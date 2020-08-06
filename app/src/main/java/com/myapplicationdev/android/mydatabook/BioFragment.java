package com.myapplicationdev.android.mydatabook;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {

    TextView tvBio;
    Button btnFragBio;
    private String message;

    public BioFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
//        String msg = preferences.getString("message", "");
//        if(!msg.equalsIgnoreCase(""))
//        {
//            msg = message ;  /* Edit the value here*/
//        }
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View bioView =  inflater.inflate(R.layout.biofragment, container, false);

        tvBio = bioView.findViewById(R.id.textViewBio);
        btnFragBio = bioView.findViewById(R.id.btnFragBio);

        btnFragBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action

                // Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can be used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                // Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(getActivity());
                myBuilder.setView(viewDialog);   // Set the view of the dialog
                myBuilder.setTitle("Edit Bio");
                myBuilder.setCancelable(false);

                // Configure the 'positive button'
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        message = etInput.getText().toString();

                        // Set the text to the TextView
                        tvBio.setText(message);

//                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
//                        SharedPreferences.Editor editor = preferences.edit();
//                        editor.putString("message",message);
//                        editor.apply();
                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });


        return bioView;
    }

}

package com.myapplicationdev.android.mydatabook;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnniversaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
/**
 * A simple {@link Fragment} subclass.
 */
public class AnniversaryFragment extends Fragment {

    TextView tvAnn;
    Button btnFragAnn;

    public AnniversaryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View anniversaryView =  inflater.inflate(R.layout.anniversaryfragment, container, false);


        tvAnn = anniversaryView.findViewById(R.id.textViewAnn);
        btnFragAnn = anniversaryView.findViewById(R.id.btnFragAnn);

        btnFragAnn.setOnClickListener(new View.OnClickListener() {
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
                                              myBuilder.setTitle("Edit Anniversary");
                                              myBuilder.setCancelable(false);

                                              // Configure the 'positive button'
                                              myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                  @Override
                                                  public void onClick(DialogInterface dialog, int which) {
                                                      // Extract the text entered by the user
                                                      String message = etInput.getText().toString();

                                                      // Set the text to the TextView
                                                      tvAnn.setText(message);
                                                  }
                                              });

                                              myBuilder.setNegativeButton("CANCEL", null);
                                              AlertDialog myDialog = myBuilder.create();
                                              myDialog.show();
                                          }
                                      });


        return anniversaryView;
    }


}
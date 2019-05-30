package com.cgm.checklistfirestore.fragment;


import android.app.DownloadManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cgm.checklistfirestore.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firestore.v1.WriteResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFrag extends Fragment {

    ListView listView;
    EditText editText;

    FirebaseFirestore db;

    public MenuFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_frag, container, false);

        listView = (ListView) view.findViewById(R.id.list_view_frag);
        editText = (EditText) view.findViewById(R.id.editTextMenuFrag);

        db = FirebaseFirestore.getInstance();

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() || actionId == EditorInfo.IME_ACTION_DONE) {
                    String newEntry = editText.getText().toString();
                    if (newEntry.equals("")) {

                        // Inserir a pasta
                        insertFolder(newEntry);

                        return false;
                    } else {

//                        Toast.makeText(getContext(), newEntry, Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
                return false;
            }
        });

        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return view;
    }

    private void insertFolder(String newEntry) {

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        Toast.makeText(getContext(), user.getUid(), Toast.LENGTH_SHORT).show();

//        DocumentReference docRef = db.document("usuários/"+user.getUid());

//        DocumentReference docRef = db.collection("usuários").document("USUÁRIO TESTE")
//                .collection("Pastas").document("puc");

//        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                DocumentSnapshot document = task.getResult();
//                List<String> group = (List<String>) document.get("puc");
//                Toast.makeText(getContext(), group.get(0), Toast.LENGTH_SHORT).show();
//            }
//        });

//        docRef.get()
//                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                    @Override
//                    public void onSuccess(DocumentSnapshot documentSnapshot) {
////                        String nome = documentSnapshot.getString("puc");
//                        String id = documentSnapshot.getId();
//
//
//
//                        Toast.makeText(getContext(), id, Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//
//            }
//        });
    }

}

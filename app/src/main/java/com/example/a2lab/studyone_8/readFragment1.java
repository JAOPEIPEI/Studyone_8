package com.example.a2lab.studyone_8;


import android.app.Dialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link readFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class readFragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View myView;
    JustifiedTextView readtext,text_summary,text_list_vocabulary;

    ArrayList list_vocabulary;
    int  name;
    public readFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment readFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static readFragment1 newInstance(String param1, String param2) {
        readFragment1 fragment = new readFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        list_vocabulary = new ArrayList<>();
        list_vocabulary.add("one");
        list_vocabulary.add("two");
        list_vocabulary.add("three");
        list_vocabulary.add("four");
        list_vocabulary.add("five");
        list_vocabulary.add("six");
        list_vocabulary.add("seven");
        list_vocabulary.add("eight");
        list_vocabulary.add("nine");
        list_vocabulary.add("ten");
        list_vocabulary.add("eleven");
        list_vocabulary.add("twelve");
        list_vocabulary.add("thirteen");
        list_vocabulary.add("fourteen");
        list_vocabulary.add("fifteen");
        list_vocabulary.add("sixteen");
        list_vocabulary.add("seventeen");
        list_vocabulary.add("eighteen");
        list_vocabulary.add("nineteen");
        list_vocabulary.add("twenty");

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedIstanceState) {
        super.onViewCreated(view, savedIstanceState);
        getActivity().setTitle("read1");

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_read1, container, false);
        readtext = (JustifiedTextView) myView.findViewById(R.id.read_article);
        readtext.setText(exam_ques_ans.reading_summary1[0]);//reading

        Button but_summary = (Button) myView.findViewById(R.id.hint_summary);
        final Button but_image = (Button) myView.findViewById(R.id.hint_image);
        Button but_vocabulary = (Button) myView.findViewById(R.id.hint_vocabulary);

        but_image.setOnClickListener(new View.OnClickListener() {//圖片dialog
            @Override
            public void onClick(View v) {
                ImageView img = new ImageView(getContext());
                img.setImageResource(R.drawable.dialog_image1);
                ContextThemeWrapper contextThemeWrapper =new ContextThemeWrapper(getActivity(), R.style.dialog);
                final AlertDialog.Builder dialog_image = new AlertDialog.Builder(contextThemeWrapper);
                dialog_image.setTitle("文章圖片")
                            .setView(img)
                            .setPositiveButton("close",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                                 })
                            .show();
           }
        });
        but_summary.setOnClickListener(new View.OnClickListener() {//文章大綱dialog
            @Override
            public void onClick(View v) {
                LayoutInflater inflaterdialog =getActivity().getLayoutInflater();
                View summary = inflaterdialog.inflate(R.layout.dialog_paragraph,null);
                text_summary=(JustifiedTextView)summary.findViewById(R.id.textView_paragraph);
                text_summary.setText(exam_ques_ans.reading_summary1[1]);
                ContextThemeWrapper contextThemeWrapper =new ContextThemeWrapper(getActivity(), R.style.dialog);
                final AlertDialog.Builder dialog_summary = new AlertDialog.Builder(contextThemeWrapper);
                dialog_summary.setTitle("中文大綱")
                        .setView(summary)
                        .setPositiveButton("close",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }
        });

        but_vocabulary.setOnClickListener(new View.OnClickListener() {//單字dialog
            @Override
            public void onClick(View v) {
                ContextThemeWrapper contextThemeWrapper =new ContextThemeWrapper(getActivity(), R.style.dialog);
                final AlertDialog.Builder dialog_vocabulary = new AlertDialog.Builder(contextThemeWrapper);
                dialog_vocabulary.setTitle("單字查詢")
                        .setSingleChoiceItems((String[]) list_vocabulary.toArray(new String[list_vocabulary.size()]),0, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            name= which;
                            }
                        })
                        .setPositiveButton("sure", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                LayoutInflater inflaterdialog =getActivity().getLayoutInflater();
                                View listvocabulary = inflaterdialog.inflate(R.layout.dialog_listvocabulary,null);
                                text_list_vocabulary=(JustifiedTextView)listvocabulary.findViewById(R.id.textView_list_vocabulary);
                                text_list_vocabulary.setText(exam_ques_ans.reading_vocabularychinese[name]);

                                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.dialog);
                                        final AlertDialog.Builder ad = new AlertDialog.Builder(contextThemeWrapper);//抓單字解釋
                                        ad.setTitle(list_vocabulary.get(name).toString())
                                                .setView(listvocabulary)
                                                .setPositiveButton("close",new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            dialog.cancel();
                                                        }
                                                    })
                                                .show();
                                        Log.i("選擇的單字:",list_vocabulary.get(name).toString());
                                }
                        })
                        .setNegativeButton("close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });
        return myView;
    }

}

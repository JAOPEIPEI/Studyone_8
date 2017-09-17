package com.example.a2lab.studyone_8;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.uncopt.android.widget.text.justify.JustifiedTextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link examFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class examFragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View myView,dialog_paragraph;
    TextView  text_answer,text_pp;

    JustifiedTextView text_question;
    Button buttoncheck,b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16,close;
    Button btn_deletewords,btn_paragraph;
    boolean hint_delete=true;
    RadioGroup mRadioGroup;
    RadioButton radiobtn1, radiobtn2, radiobtn3, radiobtn4;


    int Quesnum[] = new int[17];
    int btn_index = 0;
    int i=0;

    String ans_user = "";


    JustifiedTextView text_paragraph;


    public examFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment examFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static examFragment1 newInstance(String param1, String param2) {
        examFragment1 fragment = new examFragment1();
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



    }
    String correct = "Correct";
    String incorrect = "Incorrect";
    View.OnClickListener lis_check = new View.OnClickListener() {//Check按鈕:對答案
        @Override
        public void onClick(View v) {
            if (radiobtn1.isChecked()) {
                ans_user = radiobtn1.getText().toString();
                if (ans_user.equals(exam_ques_ans.ArrayCorrectAns1[btn_index])) {
                    text_answer.setText(correct);
                    draw(btn_index, correct);
                } else {
                    text_answer.setText(incorrect);
                    draw(btn_index, incorrect);
                }
            } else if (radiobtn2.isChecked()) {
                ans_user = radiobtn2.getText().toString();
                if (ans_user.equals(exam_ques_ans.ArrayCorrectAns1[btn_index])) {
                    text_answer.setText(correct);
                    draw(btn_index, correct);
                } else {
                    text_answer.setText(incorrect);
                    draw(btn_index, incorrect);
                }
            } else if (radiobtn3.isChecked()) {
                ans_user = radiobtn3.getText().toString();
                if (ans_user.equals(exam_ques_ans.ArrayCorrectAns1[btn_index])) {
                    text_answer.setText(correct);
                    draw(btn_index, correct);
                } else {
                    text_answer.setText(incorrect);
                    draw(btn_index, incorrect);
                }
            } else if (radiobtn4.isChecked()) {
                ans_user = radiobtn4.getText().toString();
                if (ans_user.equals(exam_ques_ans.ArrayCorrectAns1[btn_index])) {
                    text_answer.setText(correct);
                    draw(btn_index, correct);
                } else {
                    text_answer.setText(incorrect);
                    draw(btn_index, incorrect);
                }
            }

        }
    };


    public void draw(int btn_index, String ci) {//在按鈕中畫OX
        switch (btn_index) {
            case 0:
                if (ci.equals(correct)) {
                    b1.setText("O");
                    Quesnum[0] = 1;
                    b1.setTextColor(0xFFFF0000);
                } else if (ci.equals(incorrect)) {
                    b1.setText("X");
                    Quesnum[0] = 2;
                    b1.setTextColor(0xFF0000FF);
                }
                b1.setEnabled(false);
                break;

            case 1:
                if (ci.equals(correct)) {
                    b2.setText("O");
                    Quesnum[1] = 1;
                    b2.setTextColor(0xFFFF0000);
                } else if (ci.equals(incorrect)) {
                    b2.setText("X");
                    Quesnum[1] = 2;
                    b2.setTextColor(0xFF0000FF);
                }
                b2.setEnabled(false);
                break;
            case 2:
                if (ci.equals(correct)) {
                    b3.setText("O");
                    Quesnum[2] = 1;
                    b3.setTextColor(0xFFFF0000);
                } else if (ci.equals(incorrect)) {
                    b3.setText("X");
                    Quesnum[2] = 2;
                    b3.setTextColor(0xFF0000FF);
                }
                b3.setEnabled(false);
                break;
            case 3:
                if (ci.equals(correct)) {
                    b4.setText("O");
                    Quesnum[3] = 1;
                    b4.setTextColor(0xFFFF0000);
                } else if (ci.equals(incorrect)) {
                    b4.setText("X");
                    Quesnum[3] = 2;
                    b4.setTextColor(0xFF0000FF);
                }
                b4.setEnabled(false);
                break;
            case 4:
                if (ci.equals(correct)) {
                    b5.setText("O");
                    b5.setTextColor(0xFFFF0000);
                    Quesnum[4] = 1;
                } else if (ci.equals(incorrect)) {
                    b5.setText("X");
                    Quesnum[4] = 2;
                    b5.setTextColor(0xFF0000FF);
                }
                b5.setEnabled(false);
                break;
            case 5:
                if (ci.equals(correct)) {
                    b6.setText("O");
                    b6.setTextColor(0xFFFF0000);
                    Quesnum[5] = 1;
                } else if (ci.equals(incorrect)) {
                    b6.setText("X");
                    Quesnum[5] = 2;
                    b6.setTextColor(0xFF0000FF);
                }
                b6.setEnabled(false);
                break;
            case 6:
                if (ci.equals(correct)) {
                    b7.setText("O");
                    b7.setTextColor(0xFFFF0000);
                    Quesnum[6] = 1;
                } else if (ci.equals(incorrect)) {
                    b7.setText("X");
                    Quesnum[6] = 2;
                    b7.setTextColor(0xFF0000FF);
                }
                b7.setEnabled(false);
                break;

            case 7:
                if (ci.equals(correct)) {
                    b8.setText("O");
                    Quesnum[7] = 1;
                    b8.setTextColor(0xFFFF0000);

                } else if (ci.equals(incorrect)) {
                    b8.setText("X");
                    Quesnum[7] = 2;
                    b8.setTextColor(0xFF0000FF);
                }
                b8.setEnabled(false);
                break;
            case 8:
                if (ci.equals(correct)) {
                    b9.setText("O");
                    b9.setTextColor(0xFFFF0000);
                    Quesnum[8] = 1;
                } else if (ci.equals(incorrect)) {
                    b9.setText("X");
                    Quesnum[8] = 2;
                    b9.setTextColor(0xFF0000FF);
                }
                b9.setEnabled(false);
                break;
            case 9:
                if (ci.equals(correct)) {
                    b10.setText("O");
                    Quesnum[9] = 1;
                    b10.setTextColor(0xFFFF0000);
                } else if (ci.equals(incorrect)) {
                    b10.setText("X");
                    Quesnum[9] = 2;
                    b10.setTextColor(0xFF0000FF);
                }
                b10.setEnabled(false);
                break;
            case 10:
                if (ci.equals(correct)) {
                    b11.setText("O");
                    Quesnum[10] = 1;
                    b11.setTextColor(0xFFFF0000);
                } else if (ci.equals(incorrect)) {
                    b11.setText("X");
                    Quesnum[10] = 2;
                    b11.setTextColor(0xFF0000FF);
                }
                b11.setEnabled(false);
                break;
            case 11:
                if (ci.equals(correct)) {
                    b12.setText("O");
                    b12.setTextColor(0xFFFF0000);
                    Quesnum[11] = 1;
                } else if (ci.equals(incorrect)) {
                    b12.setText("X");
                    Quesnum[11] = 2;
                    b12.setTextColor(0xFF0000FF);
                }
                b12.setEnabled(false);
                break;
            case 12:
                if (ci.equals(correct)) {
                    b13.setText("O");
                    Quesnum[12] = 1;
                    b13.setTextColor(0xFFFF0000);
                } else if (ci.equals(incorrect)) {
                    b13.setText("X");
                    Quesnum[12] = 2;
                    b13.setTextColor(0xFF0000FF);
                }
                b13.setEnabled(false);
                break;
            case 13:
                if (ci.equals(correct)) {
                    b14.setText("O");
                    Quesnum[13] = 1;
                    b14.setTextColor(0xFFFF0000);
                } else if (ci.equals(incorrect)) {
                    b14.setText("X");
                    Quesnum[13] = 2;
                    b14.setTextColor(0xFF0000FF);
                }
                b14.setEnabled(false);
                break;
            case 14:
                if (ci.equals(correct)) {
                    b15.setText("O");
                    Quesnum[14] = 1;
                    b15.setTextColor(0xFFFF0000);
                } else if (ci.equals(incorrect)) {
                    b15.setText("X");
                    Quesnum[14] = 2;
                    b15.setTextColor(0xFF0000FF);
                }
                b15.setEnabled(false);
                break;
            case 15:
                if (ci.equals(correct)) {
                    b16.setText("O");
                    Quesnum[15] = 1;
                    b16.setTextColor(0xFFFF0000);
                } else if (ci.equals(incorrect)) {
                    b16.setText("X");
                    Quesnum[15] = 2;
                    b16.setTextColor(0xFF0000FF);
                }
                b16.setEnabled(false);
                break;
        }
        if (Quesnum[0] == Quesnum[1] && Quesnum[1] == Quesnum[2] && Quesnum[2] == Quesnum[3] && Quesnum[0] == 1)//橫判斷
        {
            showDialog();
            disableButtons();
        } else if (Quesnum[4] == Quesnum[5] && Quesnum[5] == Quesnum[6] && Quesnum[6] == Quesnum[7] && Quesnum[4] == 1) {
            showDialog();
            disableButtons();
        } else if (Quesnum[8] == Quesnum[9] && Quesnum[9] == Quesnum[10] && Quesnum[10] == Quesnum[11] && Quesnum[11] == 1) {
            showDialog();
            disableButtons();
        } else if (Quesnum[12] == Quesnum[13] && Quesnum[13] == Quesnum[14] && Quesnum[14] == Quesnum[15] && Quesnum[15] == 1) {
            showDialog();
            disableButtons();
        } else if (Quesnum[0] == Quesnum[4] && Quesnum[4] == Quesnum[8] && Quesnum[8] == Quesnum[12] && Quesnum[0] == 1) {//直判斷
            showDialog();
            disableButtons();
        } else if (Quesnum[1] == Quesnum[5] && Quesnum[5] == Quesnum[9] && Quesnum[9] == Quesnum[13] && Quesnum[1] == 1) {
            showDialog();
            disableButtons();
        } else if (Quesnum[2] == Quesnum[6] && Quesnum[6] == Quesnum[10] && Quesnum[10] == Quesnum[14] && Quesnum[14] == 1) {
            showDialog();
            disableButtons();
        } else if (Quesnum[3] == Quesnum[7] && Quesnum[7] == Quesnum[11] && Quesnum[11] == Quesnum[15] && Quesnum[15] == 1) {
            showDialog();
            disableButtons();
        } else if (Quesnum[0] == Quesnum[5] && Quesnum[5] == Quesnum[10] && Quesnum[10] == Quesnum[15] && Quesnum[15] == 1) {//斜判斷
            showDialog();
            disableButtons();
        } else if (Quesnum[3] == Quesnum[6] && Quesnum[6] == Quesnum[9] && Quesnum[9] == Quesnum[12] && Quesnum[12] == 1) {
            showDialog();
            disableButtons();
        } else{
//            text_answer.setText("YOU lose!!");
//            showloseDialog();
        }
        radiobtn1.setEnabled(false);
        radiobtn2.setEnabled(false);
        radiobtn3.setEnabled(false);
        radiobtn4.setEnabled(false);
        text_pp.setText("請選下一個格子");
    }
    public void showloseDialog(){//show nextdialog
        ContextThemeWrapper contextThemeWrapper =new ContextThemeWrapper(getActivity(), R.style.dialog);
        AlertDialog.Builder builder = new AlertDialog.Builder(contextThemeWrapper);


        builder.setTitle("Oh..no,you didn't finish the work.\n Keep it up")
                .setIcon(R.drawable.facebook_like)
                .setPositiveButton("next",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setClass(getActivity(), Main2Activity.class);
                        getActivity().finish();//結束Main1Activity
                        getActivity().startActivity(intent);
                        Log.i("next", "main2Activity(dialog) ");
                    }
                }).show();
        builder.setCancelable(true);

    }

    public void showDialog(){//show nextdialog
        ContextThemeWrapper contextThemeWrapper =new ContextThemeWrapper(getActivity(), R.style.dialog);
        AlertDialog.Builder builder = new AlertDialog.Builder(contextThemeWrapper);


        builder.setTitle("Congratulations you finish the job.")
                .setIcon(R.drawable.facebook_like)
                .setPositiveButton("next ",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setClass(getActivity(), Main2Activity.class);
                        getActivity().finish();//結束Main1Activity
                        getActivity().startActivity(intent);
                        Log.i("next", "main2Activity(dialog) ");
                    }
                }).show();
        builder.setCancelable(true);

    }
    private void disableButtons() {//不能按按鈕
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        b10.setEnabled(false);
        b11.setEnabled(false);
        b12.setEnabled(false);
        b13.setEnabled(false);
        b14.setEnabled(false);
        b15.setEnabled(false);
        b16.setEnabled(false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedIstanceState) {
        super.onViewCreated(view, savedIstanceState);
        getActivity().setTitle("exam1");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.fragment_exam1,container,false);//我的畫面


        mRadioGroup = (RadioGroup) myView.findViewById(R.id.radioGroup);

        radiobtn1 = (RadioButton) myView.findViewById(R.id.radiobut1);
        radiobtn2 = (RadioButton) myView.findViewById(R.id.radiobut2);
        radiobtn3 = (RadioButton) myView.findViewById(R.id.radiobut3);
        radiobtn4 = (RadioButton) myView.findViewById(R.id.radiobut4);

        text_question = (JustifiedTextView) myView.findViewById(R.id.text_ques);
        text_answer = (TextView) myView.findViewById(R.id.text_ans);
        buttoncheck = (Button) myView.findViewById(R.id.button_check);
        text_pp = (TextView) myView.findViewById(R.id.text_pp);

        b1 = (Button) myView.findViewById(R.id.button101);//抓id
        b2 = (Button) myView.findViewById(R.id.button102);
        b3 = (Button) myView.findViewById(R.id.button103);
        b4 = (Button) myView.findViewById(R.id.button104);
        b5 = (Button) myView.findViewById(R.id.button105);
        b6 = (Button) myView.findViewById(R.id.button106);
        b7 = (Button) myView.findViewById(R.id.button107);
        b8 = (Button) myView.findViewById(R.id.button108);
        b9 = (Button) myView.findViewById(R.id.button109);
        b10 = (Button) myView.findViewById(R.id.button110);
        b11 = (Button) myView.findViewById(R.id.button111);
        b12 = (Button) myView.findViewById(R.id.button112);
        b13 = (Button) myView.findViewById(R.id.button113);
        b14 = (Button) myView.findViewById(R.id.button114);
        b15 = (Button) myView.findViewById(R.id.button115);
        b16 = (Button) myView.findViewById(R.id.button116);

        buttoncheck.setOnClickListener(lis_check);//check按鈕呼叫

        b1.setOnClickListener(buttonListener);//4X4按下呼叫題目
        b2.setOnClickListener(buttonListener);
        b3.setOnClickListener(buttonListener);
        b4.setOnClickListener(buttonListener);
        b5.setOnClickListener(buttonListener);
        b6.setOnClickListener(buttonListener);
        b7.setOnClickListener(buttonListener);
        b8.setOnClickListener(buttonListener);
        b9.setOnClickListener(buttonListener);
        b10.setOnClickListener(buttonListener);
        b11.setOnClickListener(buttonListener);
        b12.setOnClickListener(buttonListener);
        b13.setOnClickListener(buttonListener);
        b14.setOnClickListener(buttonListener);
        b15.setOnClickListener(buttonListener);
        b16.setOnClickListener(buttonListener);

        btn_deletewords = (Button) myView.findViewById(R.id.hint_deletewords);
        btn_paragraph = (Button) myView.findViewById(R.id.hint_paragraph);



        return myView;
    }

    View.OnClickListener buttonListener = new Button.OnClickListener() {//4X4按鈕按下呼叫對應題目
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.button101: {
                    text_question.setText(exam_ques_ans.ArrayQues1[0]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[0]);//設定radiobutton的字串
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[1]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[2]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[3]);
                    text_answer.setText("");//清除上一題答案畫面
                    btn_index = 0;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn1.setEnabled(false);
                            radiobtn3.setEnabled(false);
                        }
                    }); btn_paragraph.setOnClickListener(new View.OnClickListener() {  //文章
                        @Override
                        public void onClick(View v) {
                            LayoutInflater inflaterdialog =getActivity().getLayoutInflater();
                            View paragraph = inflaterdialog.inflate(R.layout.dialog_paragraph,null);
                            text_paragraph=(JustifiedTextView)paragraph.findViewById(R.id.textView_paragraph);
                            text_paragraph.setText(exam_ques_ans.reading_summary1[0]);
                            ContextThemeWrapper contextThemeWrapper =new ContextThemeWrapper(getActivity(), R.style.dialog);
                            final AlertDialog.Builder dialog_paragraph = new AlertDialog.Builder(contextThemeWrapper);
                            dialog_paragraph.setTitle("文章段落")
                                    .setView(paragraph)
                                    .setPositiveButton("close",new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    })
                                    .show();
                        }
                    });


                    break;
                }
                case R.id.button102: {
                    text_question.setText(exam_ques_ans.ArrayQues1[1]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[4]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[5]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[6]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[7]);
                    text_answer.setText("");

                    btn_index = 1;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    btn_paragraph.setOnClickListener(new View.OnClickListener() {  //文章
                        @Override
                        public void onClick(View v) {
                            LayoutInflater inflaterdialog =getActivity().getLayoutInflater();
                            View paragraph = inflaterdialog.inflate(R.layout.dialog_paragraph,null);
                            text_paragraph=(JustifiedTextView)paragraph.findViewById(R.id.textView_paragraph);
                            text_paragraph.setText(exam_ques_ans.reading_summary1[0]);

                            ContextThemeWrapper contextThemeWrapper =new ContextThemeWrapper(getActivity(), R.style.dialog);
                            final AlertDialog.Builder dialog_paragraph = new AlertDialog.Builder(contextThemeWrapper);
                            dialog_paragraph.setTitle("文章段落")
                                    .setView(paragraph)
                                    .setPositiveButton("close",new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    })
                                    .show();
                        }
                    });


                    break;
                }
                case R.id.button103:
                    text_question.setText(exam_ques_ans.ArrayQues1[2]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[8]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[9]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[10]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[11]);
                    text_answer.setText("");
                    btn_index = 2;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    break;
                case R.id.button104:
                    text_question.setText(exam_ques_ans.ArrayQues1[3]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[12]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[13]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[14]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[15]);
                    text_answer.setText("");
                    btn_index = 3;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    break;
                case R.id.button105:
                    text_question.setText(exam_ques_ans.ArrayQues1[4]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[16]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[17]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[18]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[19]);
                    text_answer.setText("");
                    btn_index = 4;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    break;
                case R.id.button106:
                    text_question.setText(exam_ques_ans.ArrayQues1[5]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[20]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[21]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[22]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[23]);
                    text_answer.setText("");
                    btn_index = 5;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    break;
                case R.id.button107:
                    text_question.setText(exam_ques_ans.ArrayQues1[6]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[24]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[25]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[26]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[27]);
                    text_answer.setText("");
                    btn_index = 6;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    break;
                case R.id.button108:
                    text_question.setText(exam_ques_ans.ArrayQues1[7]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[28]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[29]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[30]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[31]);
                    text_answer.setText("");
                    btn_index = 7;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    break;
                case R.id.button109:
                    text_question.setText(exam_ques_ans.ArrayQues1[8]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[32]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[33]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[34]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[35]);
                    text_answer.setText("");
                    btn_index = 8;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    break;
                case R.id.button110:
                    text_question.setText(exam_ques_ans.ArrayQues1[9]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[36]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[37]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[38]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[39]);
                    text_answer.setText("");
                    btn_index = 9;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    break;
                case R.id.button111:
                    text_question.setText(exam_ques_ans.ArrayQues1[10]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[40]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[41]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[42]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[43]);
                    text_answer.setText("");
                    btn_index = 10;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    break;
                case R.id.button112:
                    text_question.setText(exam_ques_ans.ArrayQues1[11]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[44]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[45]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[46]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[47]);
                    text_answer.setText("");
                    btn_index = 11;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    break;
                case R.id.button113:
                    text_question.setText(exam_ques_ans.ArrayQues1[12]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[48]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[49]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[50]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[51]);
                    text_answer.setText("");
                    btn_index = 12;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    break;
                case R.id.button114:
                    text_question.setText(exam_ques_ans.ArrayQues1[13]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[52]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[53]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[54]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[55]);
                    text_answer.setText("");
                    btn_index = 13;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    break;
                case R.id.button115:
                    text_question.setText(exam_ques_ans.ArrayQues1[14]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[56]);//設定radiobutton的字串
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[57]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[58]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[59]);
                    text_answer.setText("");
                    btn_index = 14;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });

                    break;
                case R.id.button116:
                    text_question.setText(exam_ques_ans.ArrayQues1[15]);
                    radiobtn1.setText(exam_ques_ans.ArrayAns1[60]);
                    radiobtn2.setText(exam_ques_ans.ArrayAns1[61]);
                    radiobtn3.setText(exam_ques_ans.ArrayAns1[62]);
                    radiobtn4.setText(exam_ques_ans.ArrayAns1[63]);
                    text_answer.setText("");
                    btn_index = 15;
                    btn_deletewords.setOnClickListener(new View.OnClickListener() {//刪除選項
                        @Override
                        public void onClick(View v) {
                            radiobtn2.setEnabled(false);
                            radiobtn4.setEnabled(false);
                        }
                    });
                    break;
            }
            radiobtn1.setEnabled(true);
            radiobtn2.setEnabled(true);
            radiobtn3.setEnabled(true);
            radiobtn4.setEnabled(true);
            text_pp.setText("");
        }
    };

}

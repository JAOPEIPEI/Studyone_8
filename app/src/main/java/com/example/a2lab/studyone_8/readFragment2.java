package com.example.a2lab.studyone_8;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link readFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class readFragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View myView;
    TextView text;
    Dialog dialog_image,dialog_summary;
    Button close;

    public readFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment readFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static readFragment2 newInstance(String param1, String param2) {
        readFragment2 fragment = new readFragment2();
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
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedIstanceState) {
        super.onViewCreated(view, savedIstanceState);
        getActivity().setTitle("read2");

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_read1, container, false);
        text = (TextView) myView.findViewById(R.id.read_article);
        text.setText(" The uncanny valley is a hypothesis regarding the field of robotics. The theory holds that when robots or other copies of humans look and act almost like actual humans, it causes a response of revulsion among observers.\n" +
                "The term was coined by a roboticist Masahiro Mori. Mori states that as a robot is made ever-increasingly humanlike in its appearance and motion, the emotional response from an individual to the robot will become increasingly positive and empathic, until a point is reached beyond which the response quickly becomes that of strong disgust. However, as the appearance and motion continue to become less distinguishable from an individual, the emotional response becomes positive once more and approaches human-to-human empathy levels.\n" +
                "The truth of the uncanny valley was examined with one recent study. A group of five monkeys were shown three images: two different 3D monkey faces (realistic, unrealistic), and a real photo of a monkey's face. The time of eye-gazing was used as a proxy for the result. Since the realistic 3D monkey face had been looked for lesser time than the others, this indicated that the monkey participants found the realistic 3D face aversive, or otherwise preferred the other two images.\n" +
                "The concept of the uncanny valley is taken seriously by the film industry due to negative audience reactions to the animated humans. To avoid the uncanny valley as much as possible, animators will take some measures. For example, design elements should match in human realism. That is to say, if an animated character looks more human than its movement, this gives a negative impression. Animated humans may look uncanny when human and nonhuman elements are mixed, which are what animators must subside so that they can ensure most of the audience a pleasant experience of going to the movies.");

        text.setMovementMethod(new ScrollingMovementMethod());

        Button but_summary = (Button) myView.findViewById(R.id.hint_summary);
        Button but_image = (Button) myView.findViewById(R.id.hint_image);
        Button but_vocabulary = (Button) myView.findViewById(R.id.hint_vocabulary);


        return myView;
    }

}

package net.sandi.luyeechon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.sandi.luyeechon.LuYeeChonApp;
import net.sandi.luyeechon.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 9/18/2016.
 */
public class QuizActivity extends AppCompatActivity {

    final String[][] QandAns = {
            {"အာမထိလၽွာမထိၿမိဳ႕\n(စကားလံုးတစ္လံုးထက္ပိုရမည္)", "ဟဲဟိုး", "ooo", "ooo"},
            {"အဝတ္အစားမပါတဲ့ပိုးေကာင္", "ပိုးတံုးလံုး", "ပိုးတိုးလံုး", "ooo"},
            {"အမည္မွာက ခါးပါတယ္တဲ့၊\nစားၾကည့္ေတာ့ မခါးပါဘူး။\nအဲ့ဒါဘာမုန္႔လဲ?", "မုန္႔ဟင္းခါး", "ooo", "ooo"},
            {"ေရကို ဘယ္အခ်ိန္ျခင္းေတာင္းထဲ\nထည့္သယ္လို႔ရမလဲ?", "ေရခဲေနတဲ့အခ်ိန္", "ခဲေနတဲ့အခ်ိန္", "ေရခဲ"},
            {"ေယာက်္ားျဖစ္ပါလၽွက္နဲ႔ \nနာမည္ေရွ႕မွာ 'မ' ပါေနတဲ့ \nေရွးေခတ္ပညာရွိ တစ္ေယာက္ကို\nသိပါသလား?", "မေဟာ္သဓာပညာရွိ", "မေဟာ္သဓာ", "ooo"}
    };

    int randomNum;

    @BindView(R.id.txt_question)
    TextView txtQuestion;

    @BindView(R.id.et_answer)
    EditText etAnswer;

    @BindView(R.id.txt_result)
    TextView txtResult;

    @BindView(R.id.btn_done)
    Button btnDone;

    @BindView(R.id.btn_skip)
    Button btnSkip;

    @Override
    protected void onStart() {
        super.onStart();
        setData();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ButterKnife.bind(this, this);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans = etAnswer.getText().toString();

                if (btnDone.getText().toString().equalsIgnoreCase("next")) {
                    setData();
                } else {
                    if (check(ans)) {
                        btnSkip.setVisibility(View.INVISIBLE);
                        txtResult.setVisibility(View.VISIBLE);
                        txtResult.setText("Your answer is true");
                        btnDone.setText("Next");

                    } else {
                        //  txtResult.setText("Your answer is false,\nPlease Try Again");

                        btnSkip.setVisibility(View.VISIBLE);

                        etAnswer.setText("");
                        etAnswer.setHint("Your answer is false");
                        Animation shake = AnimationUtils.loadAnimation(QuizActivity.this, R.anim.shake);
                        etAnswer.startAnimation(shake);

                    }
                }
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSkip.setVisibility(View.INVISIBLE);
                etAnswer.setHint(R.string.et_hint);
                setData();
            }
        });


    }

    public void setData() {
        etAnswer.setText("");
        randomNum = new Random().nextInt(4 - 0 + 1) + 0;
        txtQuestion.setText(QandAns[randomNum][0]);
        btnDone.setText(R.string.btn_done);
        txtResult.setVisibility(View.INVISIBLE);
    }

    public boolean check(String ans) {

        String s1 = QandAns[randomNum][1];
        String s2 = QandAns[randomNum][2];
        String s3 = QandAns[randomNum][3];

        if (ans.equalsIgnoreCase(s1) || ans.equalsIgnoreCase(s2) || ans.equalsIgnoreCase(s3)) {
            return true;
        }
        return false;
    }
    public static Intent newIntent() {
        Intent intent = new Intent(LuYeeChonApp.getContext(), QuizActivity.class);
        return intent;
    }

}
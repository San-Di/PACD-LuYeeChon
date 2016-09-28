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
import net.sandi.luyeechon.data.models.QuizModel;
import net.sandi.luyeechon.data.vos.QuizVO;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 9/18/2016.
 */
public class QuizActivity extends AppCompatActivity {

    private static List<QuizVO> quizVOList;
<<<<<<< HEAD
    /* private JokeAdapter mJokeAdpater;
        private JokeViewHolder.ControllerJokeItem mControllerJoke;
    */
    // List<QuizVO> quizVOList;
    /*public QuizActivity() {
       // quizVOList= //QuizModel.getInstance().getJokeVOList();
    }*/
=======
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54

    public static Intent newIntent() {
        quizVOList = QuizModel.getInstance().getQuizList();
        Intent intent = new Intent(LuYeeChonApp.getContext(), QuizActivity.class);
        return intent;
    }

<<<<<<< HEAD
   /* final String[][] QandAns = {
            {"အာမထိလၽွာမထိၿမိဳ႕\n(စကားလံုးတစ္လံုးထက္ပိုရမည္)", "ဟဲဟိုး", "ooo"},
            {"အဝတ္အစားမပါတဲ့ပိုးေကာင္", "ပိုးတံုးလံုး", "ပိုးတိုးလံုး"},
            {"အမည္မွာက ခါးပါတယ္တဲ့၊\nစားၾကည့္ေတာ့ မခါးပါဘူး။\nအဲ့ဒါဘာမုန္႔လဲ?", "မုန္႔ဟင္းခါး", "ooo"},
            {"ေရကို ဘယ္အခ်ိန္ျခင္းေတာင္းထဲ\nထည့္သယ္လို႔ရမလဲ?", "ေရခဲေနတဲ့အခ်ိန္", "ေရခဲ"},
            {"ေယာက်္ားျဖစ္ပါလၽွက္နဲ႔ \nနာမည္ေရွ႕မွာ 'မ' ပါေနတဲ့ \nေရွးေခတ္ပညာရွိ တစ္ေယာက္ကို\nသိပါသလား?", "မေဟာ္သဓာပညာရွိ", "မေဟာ္သဓာ"}
    };
*/

    //String [][] QandAns=quizVOList.toArray();

    int randomNum;
=======

    int randomNum = 0;
    int trueCount = 0;
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54

    @BindView(R.id.txt_question)
    TextView txtQuestion;

    @BindView(R.id.et_answer)
    EditText etAnswer;

    @BindView(R.id.txt_answer)
    TextView txtAnswer;

    @BindView(R.id.txt_result)
    TextView txtResult;

    @BindView(R.id.btn_done)
    Button btnDone;

    @BindView(R.id.btn_show)
    Button btnShow;

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

<<<<<<< HEAD
//        ScreenUtils keyborUtils = ScreenUtils.getObjInstance();
//
//        keyborUtils.showSoftKeyboard(etAnswer);
=======
        randomNum = new Random().nextInt(quizVOList.size() - 0 + 1) + 0;
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans = etAnswer.getText().toString();

                if (btnDone.getText().toString().equalsIgnoreCase("next")) {
                    setData();
                } else {
                    if (check(ans)) {
                        btnShow.setVisibility(View.INVISIBLE);
                        txtResult.setVisibility(View.VISIBLE);
                        txtResult.setText(R.string.txt_true);
                        btnDone.setText(R.string.btn_next);

                    } else {
<<<<<<< HEAD
                        //  txtResult.setText("Your answer is false,\nPlease Try Again");
=======
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54

                        btnShow.setVisibility(View.VISIBLE);

                        etAnswer.setHint(R.string.txt_false);
                        etAnswer.setText("");
                        Animation shake = AnimationUtils.loadAnimation(QuizActivity.this, R.anim.shake);
                        etAnswer.startAnimation(shake);

                    }
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnShow.setVisibility(View.INVISIBLE);
                etAnswer.setVisibility(View.INVISIBLE);
                txtAnswer.setVisibility(View.VISIBLE);

<<<<<<< HEAD
                txtAnswer.setText("Answer: "+quizVOList.get(randomNum).getAnswer());
=======
                txtAnswer.setText("Answer: " + quizVOList.get(randomNum).getAnswer());
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
                etAnswer.setHint(R.string.et_hint);
                btnDone.setText(R.string.btn_next);
            }
        });

    }

    public void setData() {
        txtAnswer.setVisibility(View.INVISIBLE);
        etAnswer.setVisibility(View.VISIBLE);

        etAnswer.setText("");
        etAnswer.setHint(R.string.et_hint);
<<<<<<< HEAD
        randomNum = new Random().nextInt(quizVOList.size() - 0 + 1) + 0;
=======
        if (randomNum == quizVOList.size() - 1) {
            randomNum = 0;
        } else {
            randomNum++;
        }
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
        txtQuestion.setText(quizVOList.get(randomNum).getQuestion());
        btnDone.setText(R.string.btn_done);
        txtResult.setVisibility(View.INVISIBLE);
    }

    public boolean check(String ans) {

<<<<<<< HEAD
        String s1 = quizVOList.get(randomNum).getAnswer();
        String s2 = quizVOList.get(randomNum).getContain();
        ;

        if (ans.equalsIgnoreCase(s1) || ans.contains(s2)) {
=======
        String answer = quizVOList.get(randomNum).getAnswer();
        String contain = quizVOList.get(randomNum).getContain();


        if (ans.equalsIgnoreCase(answer) || ans.contains(contain)) {
            trueCount++;
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
            return true;
        }
        return false;
    }
<<<<<<< HEAD

=======
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        new AlertDialog.Builder(this)
//                .setTitle("Scroe Point")
//                .setMessage("point")
//                .show();
//        try {
//            Thread.sleep(10000);
//        } catch (Exception e) {
//        }
//    }
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
}

package com.be.msu.resto.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.be.msu.resto.R;
import com.be.msu.resto.adapter.QuestionAnswerAdapter;
import com.be.msu.resto.model.QuestionAnswer;

import java.util.ArrayList;

public class QuestionAnswerActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewQueAns;
    QuestionAnswerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);
        mRecyclerViewQueAns = (RecyclerView) findViewById(R.id.recycler_que_ans);
        mAdapter = new QuestionAnswerAdapter(getDummyData());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerViewQueAns.setLayoutManager(layoutManager);

        mRecyclerViewQueAns.setAdapter(mAdapter);
    }


    private ArrayList<QuestionAnswer> getDummyData() {
        ArrayList<QuestionAnswer> list = new ArrayList<>();

        QuestionAnswer q1 = new QuestionAnswer();
        q1.setQuestion("What do you know about Java?");
        q1.setAnswer("Java is a high-level programming language originally developed by Sun Microsystems and released in 1995. " +
                "Java runs on a variety of platforms, such as Windows, Mac OS, and the various versions of UNIX.");
        list.add(q1);

        QuestionAnswer q2 = new QuestionAnswer();
        q2.setQuestion("What are the supported platforms by Java Programming Language?");
        q2.setAnswer("Java runs on a variety of platforms, such as Windows, Mac OS, " +
                "and the various versions of UNIX/Linux like HP-Unix, Sun Solaris, Redhat Linux, Ubuntu, CentOS, etc.");
        list.add(q2);


        QuestionAnswer q3 = new QuestionAnswer();
        q3.setQuestion("List any five features of Java?");
        q3.setAnswer("Some features include Object Oriented, Platform Independent, Robust, Interpreted, Multi-threaded");
        list.add(q3);


        return list;
    }
}

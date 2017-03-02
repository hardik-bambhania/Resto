package com.be.msu.resto.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.be.msu.resto.R;
import com.be.msu.resto.model.QuestionAnswer;

import java.util.ArrayList;

public class QuestionAnswerAdapter extends RecyclerView.Adapter<QuestionAnswerAdapter.QesAnsHolder> {

    ArrayList<QuestionAnswer> mList;

    public QuestionAnswerAdapter(ArrayList<QuestionAnswer> list) {
        mList = list;
    }


    @Override
    public QesAnsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_que_and, parent, false);
        return new QesAnsHolder(view);
    }

    @Override
    public void onBindViewHolder(final QesAnsHolder holder, int position) {
        holder.mTxtQuestion.setText(mList.get(position).getQuestion());
        holder.mTxtAnswer.setText(mList.get(position).getAnswer());

        holder.mImgArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.mLayoutAnswer.getVisibility() == View.VISIBLE) {
                    holder.mLayoutAnswer.setVisibility(View.GONE);
                    holder.mImgArrow.setImageResource(R.drawable.ic_down_arrow);
                } else {
                    holder.mLayoutAnswer.setVisibility(View.VISIBLE);
                    holder.mImgArrow.setImageResource(R.drawable.ic_up_arrow);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class QesAnsHolder extends RecyclerView.ViewHolder {

        TextView mTxtQuestion;
        TextView mTxtAnswer;
        ImageView mImgArrow;
        RelativeLayout mLayoutQuestion;
        RelativeLayout mLayoutAnswer;

        public QesAnsHolder(View itemView) {
            super(itemView);
            mTxtQuestion = (TextView) itemView.findViewById(R.id.txt_question);
            mTxtAnswer = (TextView) itemView.findViewById(R.id.txt_answer);
            mLayoutQuestion = (RelativeLayout) itemView.findViewById(R.id.layout_question);
            mLayoutAnswer = (RelativeLayout) itemView.findViewById(R.id.layout_answer);
            mImgArrow = (ImageView) itemView.findViewById(R.id.img_down_arrow);
        }
    }

}

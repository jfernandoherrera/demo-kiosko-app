package com.jeduca.plantilla.activities.utils.common.views;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jeduca.plantilla.R;

import java.util.ArrayList;

public class AccordionListView extends RelativeLayout{

    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Button button;
    private ArrayList<String> objects;

    public interface OnItemSelected{

        void onItemSelected(int position);

    }

    public interface OnButtonPressed{

        void onButtonPressed();

    }

    public AccordionListView(Context context, AttributeSet attrs) {

        super(context, attrs);

        inflate(context, R.layout.view_accordion_list, this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        button = (Button) findViewById(R.id.button);

        objects = new ArrayList<>();

        button.setVisibility(GONE);

        layoutManager = new LinearLayoutManager(context);

        recyclerView.setLayoutManager(layoutManager);

    }

    public void setListeners(final OnItemSelected onItemSelected, final  OnButtonPressed onButtonPressed) {

        adapter = new RecyclerView.Adapter() {

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

                TextHolder textHolder = new TextHolder(v);

                return textHolder;

            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

                ((TextHolder)holder).textView.setText(objects.get(position));

                ((TextHolder)holder).textView.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        recyclerView.setVisibility(GONE);

                        onItemSelected.onItemSelected(position);

                    }

                });

            }

            @Override
            public int getItemCount() {

                return objects.size();

            }

            class TextHolder extends RecyclerView.ViewHolder {

                AppTextView textView;

                public TextHolder(View itemView) {

                    super(itemView);

                    textView = (AppTextView) itemView.findViewById(R.id.textList);

                }

            }

        };

        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                recyclerView.setVisibility(VISIBLE);

                button.setVisibility(GONE);

                onButtonPressed.onButtonPressed();

            }

        });

    }

    public void setObjects(ArrayList<String> objects) {

            this.objects.clear();

            this.objects.addAll(objects);

    }

    public void setButtonVisibility(boolean visibility) {

        if(visibility) {

            button.setVisibility(VISIBLE);

        }else {

            button.setVisibility(GONE);

        }

    }

}

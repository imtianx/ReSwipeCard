package com.lin.reswipecard;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lin.cardlib.CardLayoutManager;
import com.lin.cardlib.CardSetting;
import com.lin.cardlib.CardTouchHelperCallback;
import com.lin.cardlib.OnSwipeCardListener;
import com.lin.cardlib.utils.ReItemTouchHelper;

import java.util.List;

public class NormalActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView mRecyclerView;
    Button mChangeBtn, mLeftBtn, mRightBtn;
    ReItemTouchHelper mReItemTouchHelper;
    CardAdapter cardAdapter;
    CardTouchHelperCallback helperCallback;

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.turn_left:
                mReItemTouchHelper.swipeManually(ReItemTouchHelper.LEFT);
                break;
            case R.id.turn_right:
                mReItemTouchHelper.swipeManually(ReItemTouchHelper.RIGHT);
                break;
            case R.id.change_type:
                cardAdapter.getData().addAll(CardMaker.getNewCards());
                cardAdapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        List<CardBean> list = CardMaker.initCards();
//        List<CardBean> list = new ArrayList<>();
        CardSetting setting = new CardSetting.Builder()
                .setSwipeDirection(ReItemTouchHelper.LEFT | ReItemTouchHelper.RIGHT)
                .setSwipeOutDirection(ReItemTouchHelper.LEFT | ReItemTouchHelper.RIGHT)
                .setLoopCard(false)
                .build();
        setting.setSwipeListener(new OnSwipeCardListener<CardBean>() {
            @Override
            public void onSwiping(RecyclerView.ViewHolder viewHolder, float dx, float dy, int direction) {
                switch (direction) {
                    case ReItemTouchHelper.DOWN:
                        Log.e("aaa", "swiping direction=down");
                        break;
                    case ReItemTouchHelper.UP:
                        Log.e("aaa", "swiping direction=up");
                        break;
                    case ReItemTouchHelper.LEFT:
                        Log.e("aaa", "swiping direction=left");
                        break;
                    case ReItemTouchHelper.RIGHT:
                        Log.e("aaa", "swiping direction=right");
                        break;
                }
            }

            @Override
            public void onSwipedOut(RecyclerView.ViewHolder viewHolder, CardBean o, int direction) {
                switch (direction) {
                    case ReItemTouchHelper.DOWN:
                        Toast.makeText(NormalActivity.this, "swipe down out", Toast.LENGTH_SHORT).show();
                        break;
                    case ReItemTouchHelper.UP:
                        Toast.makeText(NormalActivity.this, "swipe up out ", Toast.LENGTH_SHORT).show();
                        break;
                    case ReItemTouchHelper.LEFT:
                        Toast.makeText(NormalActivity.this, "swipe left out", Toast.LENGTH_SHORT).show();
                        break;
                    case ReItemTouchHelper.RIGHT:
                        Toast.makeText(NormalActivity.this, "swipe right out", Toast.LENGTH_SHORT).show();
                        break;
                }
                if (helperCallback.getData().size() < 2) {
                    cardAdapter.getData().addAll(CardMaker.getNewCards());
                    cardAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onSwipedClear() {
                Toast.makeText(NormalActivity.this, "cards are consumed", Toast.LENGTH_SHORT).show();
            }
        });
        helperCallback = new CardTouchHelperCallback(mRecyclerView, list, setting);
        mReItemTouchHelper = new ReItemTouchHelper(helperCallback);
        CardLayoutManager layoutManager = new CardLayoutManager(mReItemTouchHelper, setting);
        mRecyclerView.setLayoutManager(layoutManager);
        cardAdapter = new CardAdapter(list);
        mRecyclerView.setAdapter(cardAdapter);

        mLeftBtn = findViewById(R.id.turn_left);
        mRightBtn = findViewById(R.id.turn_right);
        mChangeBtn = findViewById(R.id.change_type);
        mLeftBtn.setOnClickListener(this);
        mChangeBtn.setOnClickListener(this);
        mRightBtn.setOnClickListener(this);
    }
}

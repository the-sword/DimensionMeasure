package com.example.hui.dimensionmeasure;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.longID)
    EditText longID;
    @Bind(R.id.heightID)
    EditText heightID;
    @Bind(R.id.confirmID)
    Button confirmID;
    @Bind(R.id.cancleID)
    Button cancleID;
    @Bind(R.id.rectID)
    Button rectID;

    private double rectLong;
    private double rectHeight;
    private double rectLongToPx;
    private double rectHeightToPx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.confirmID, R.id.cancleID, R.id.rectID})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirmID:
                rectLong=Double.parseDouble(String.valueOf(longID.getText()));
                rectHeight=Double.parseDouble(String.valueOf(heightID.getText()));
                Resources r = getResources();
                int rectLongToPx = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, (float) (rectLong/2.54*160), r.getDisplayMetrics());
                int rectHeightToPx = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, (float) (rectHeight/2.54*160), r.getDisplayMetrics());
//                rectLongToPx=rectLong/2.54*160;
//                rectHeightToPx=rectHeight/2.54*160;
                Log.e("xxx", String.valueOf(rectLongToPx));
                Log.e("xxx", String.valueOf(rectHeightToPx));
                ViewGroup.LayoutParams lp=rectID.getLayoutParams();
                lp.width= rectLongToPx;
                lp.height=rectHeightToPx;
                rectID.setLayoutParams(lp);
                rectID.setText("长度"+String.valueOf(longID.getText())+"*"+"宽度"+String.valueOf(heightID.getText()));
//                rectID.setWidth((int) rectLongToPx);
//                rectID.setHeight((int) rectHeightToPx);
                break;
            case R.id.cancleID:
                break;
        }
    }
}

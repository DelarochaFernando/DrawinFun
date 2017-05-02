package com.example.jmata.drawinfun;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    private DrawingView Dv;
    private LinearLayout paintlayout;
    private ImageButton currPaint, drawBtn, eraseBtn, newBtn;
    private float smallbrush, mediumbrush, largebrush;
    private String tool;
    private boolean erase = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dv = (DrawingView)findViewById(R.id.drawingPane);
        paintlayout = (LinearLayout) findViewById(R.id.paint_colors);
        currPaint = (ImageButton) paintlayout.getChildAt(0);
        drawBtn = (ImageButton)findViewById(R.id.draw_btn);
        eraseBtn = (ImageButton)findViewById(R.id.erase_btn);
        newBtn = (ImageButton)findViewById(R.id.new_btn);

        smallbrush = getResources().getDimension(R.dimen.small_brush);
        mediumbrush = getResources().getDimension(R.dimen.medium_brush);
        largebrush = getResources().getDimension(R.dimen.large_brush);

        Dv.setBrushSize(mediumbrush);
        currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
        currPaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton imgView = (ImageButton)v;
                String color = v.getTag().toString();
                Dv.setColor(color);
                Dv.setErase(false);
                Dv.setBrushSize(Dv.getLastBrushSize());
                imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                currPaint = (ImageButton)v;
            }
        });

        drawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tool = "brush";
                showDialog(tool);
            }
        });

        eraseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tool = "eraser";
                showDialog(tool);
            }
        });

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dv.startNew();
            }
        });

    }

    public void showDialog(String tool) {

        final Dialog brushDialog = new Dialog(this);
        brushDialog.setContentView(R.layout.brush_chooser);

        if(tool.equals("brush")){
        brushDialog.setTitle("Brush Size: ");
        }else {
            brushDialog.setTitle("Eraser Size");
        }

        ImageButton smallBtn = (ImageButton)brushDialog.findViewById(R.id.small_brush);
        ImageButton mediumBtn = (ImageButton)brushDialog.findViewById(R.id.medium_brush);
        ImageButton largeBtn = (ImageButton)brushDialog.findViewById(R.id.large_brush);

        smallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dv.setBrushSize(smallbrush);
                Dv.setLastBrushSize(smallbrush);
                Dv.setErase(false);
                brushDialog.dismiss();
            }
        });
        mediumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dv.setBrushSize(mediumbrush);
                Dv.setLastBrushSize(mediumbrush);
                Dv.setErase(false);
                brushDialog.dismiss();
            }
        });
        largeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dv.setBrushSize(largebrush);
                Dv.setLastBrushSize(largebrush);
                Dv.setErase(false);
                brushDialog.dismiss();
            }
        });

        brushDialog.show();
    }
}

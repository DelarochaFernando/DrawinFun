package com.example.jmata.drawinfun;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
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
        /*currPaint.setOnClickListener(new View.OnClickListener() {
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
        });*/

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

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("New Drawing");
                dialog.setMessage("Start new drawing (you will lose the current drawing)?");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dv.startNew();
                        dialog.dismiss();
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
            }
        });

    }

    public void paintClicked(View view){

        ImageButton imgView = (ImageButton)view;
        String color = view.getTag().toString();
        Dv.setColor(color);
        Dv.setErase(false);
        Dv.setBrushSize(Dv.getLastBrushSize());
        imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
        currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
        currPaint = (ImageButton)view;
    }

    public void showDialog(String tool) {

        final String toolSelected = tool;
        final Dialog brushDialog = new Dialog(this);
        brushDialog.setContentView(R.layout.brush_chooser);

        ImageButton smallBtn = (ImageButton)brushDialog.findViewById(R.id.small_brush);
        ImageButton mediumBtn = (ImageButton)brushDialog.findViewById(R.id.medium_brush);
        ImageButton largeBtn = (ImageButton)brushDialog.findViewById(R.id.large_brush);

        if(tool.equals("brush")){

            brushDialog.setTitle("Brush Size: ");
            smallBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dv.setErase(false);
                    //Dv.setColor("#FFFFFF");
                    Dv.setBrushSize(smallbrush);
                    Dv.setLastBrushSize(smallbrush);
                    brushDialog.dismiss();
                }
            });
            mediumBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dv.setErase(false);
                    //Dv.setColor("#FFFFFF");
                    Dv.setBrushSize(mediumbrush);
                    Dv.setLastBrushSize(mediumbrush);
                    brushDialog.dismiss();
                }
            });
            largeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dv.setErase(false);
                    //Dv.setColor("#FFFFFF");
                    Dv.setBrushSize(largebrush);
                    Dv.setLastBrushSize(largebrush);
                    brushDialog.dismiss();
                }
            });

            brushDialog.show();


        }else {
            brushDialog.setTitle("Eraser Size");

            smallBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dv.setErase(false);
                    //Dv.setColor("#FFFFFF");
                    Dv.setBrushSize(smallbrush);
                    Dv.setLastBrushSize(smallbrush);
                    brushDialog.dismiss();
                }
            });
            mediumBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dv.setErase(false);
                    //Dv.setColor("#FFFFFF");
                    Dv.setBrushSize(mediumbrush);
                    Dv.setLastBrushSize(mediumbrush);
                    brushDialog.dismiss();
                }
            });
            largeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dv.setErase(false);
                    //Dv.setColor("#FFFFFF");
                    Dv.setBrushSize(largebrush);
                    Dv.setLastBrushSize(largebrush);
                    brushDialog.dismiss();
                }
            });

            brushDialog.show();
        }

    }
}

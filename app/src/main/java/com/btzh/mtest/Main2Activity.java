package com.btzh.mtest;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Main2Activity extends AppCompatActivity  {
    private String TAG = "Main2Activity";
    private ViewFlipper viewFlipper;
    private GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
        System.out.println("-------->"+TAG);

    }

    void initViews(){
        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                //MotionEvent.ACTION_DOWN;
                System.out.println("-------onDown"+e.getAction());
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                System.out.println("-------onShowPress"+e.getAction());
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                System.out.println("-------onSingleTapUp"+e.getAction());
                View item = viewFlipper.getCurrentView();
                switch (item.getId()) {
                    case R.id.image1:
                        Toast.makeText(Main2Activity.this, "我是image1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.image2:
                        Toast.makeText(Main2Activity.this, "我是image2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.image3:
                        Toast.makeText(Main2Activity.this, "我是image3", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.image4:
                        Toast.makeText(Main2Activity.this, "我是image4", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }



                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                System.out.println("-------onScroll"+e1.getAction()+e2.getAction());
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                System.out.println("-------onLongPress"+e.getAction());
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                System.out.println("-------onFling"+e1.getAction());
                if (viewFlipper.isFlipping()){
                    viewFlipper.stopFlipping();
                }
                if (e1.getX() - e2.getX() > 120) {
                    viewFlipper.setInAnimation(AnimationUtils.loadAnimation(Main2Activity.this,
                            R.anim.push_left_in));
                    viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(Main2Activity.this,
                            R.anim.push_left_out));
                    viewFlipper.showNext();

//                    viewFlipper.startFlipping();
                    return true;
                } else if (e1.getX() - e2.getX() < -120) {
                    viewFlipper.setInAnimation(AnimationUtils.loadAnimation(Main2Activity.this,
                            R.anim.push_right_in));
                    viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(Main2Activity.this,
                            R.anim.push_right_out));
                    viewFlipper.showPrevious();

//                    viewFlipper.startFlipping();
                    return true;
                }
                return false;
            }
        });

        viewFlipper = findViewById(R.id.viewFlipper);
//        viewFlipper.startFlipping();
//        viewFlipper.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View item = viewFlipper.getCurrentView();
//                switch (item.getId()){
//                    case R.id.image1:
//                        Toast.makeText(Main2Activity.this, "我是image1", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.image2:
//                        Toast.makeText(Main2Activity.this, "我是image2", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.image3:
//                        Toast.makeText(Main2Activity.this, "我是image3", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.image4:
//                        Toast.makeText(Main2Activity.this, "我是image4", Toast.LENGTH_SHORT).show();
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            viewFlipper.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//                @Override
//                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//
//                }
//            });
//        }





    }

//    @Override
//    public boolean onDown(MotionEvent e) {
//        return false;
//    }
//
//    @Override
//    public void onShowPress(MotionEvent e) {
//
//    }
//
//    @Override
//    public boolean onSingleTapUp(MotionEvent e) {
//        return false;
//    }
//
//    @Override
//    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        return false;
//    }
//
//    @Override
//    public void onLongPress(MotionEvent e) {
//
//    }
//
//    @Override
//    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        if (e1.getX() - e2.getX() > 120) {
//            viewFlipper.setInAnimation(AnimationUtils.loadAnimation(Main2Activity.this,
//                    R.anim.push_left_in));
//            viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(Main2Activity.this,
//                    R.anim.push_left_out));
//            viewFlipper.showNext();
//            return true;
//        } else if (e1.getX() - e2.getX() < -120) {
//            viewFlipper.setInAnimation(AnimationUtils.loadAnimation(Main2Activity.this,
//                    R.anim.push_right_in));
//            viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(Main2Activity.this,
//                    R.anim.push_right_out));
//            viewFlipper.showPrevious();
//            return true;
//        }
//        return false;
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    //    @Override
//    public boolean onDown(MotionEvent e) {
//        return false;
//    }
//
//    @Override
//    public void onShowPress(MotionEvent e) {
//
//    }
//
//    @Override
//    public boolean onSingleTapUp(MotionEvent e) {
//        return false;
//    }
//
//    @Override
//    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        return false;
//    }
//
//    @Override
//    public void onLongPress(MotionEvent e) {
//
//    }
//
//    @Override
//    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        return false;
//    }
}

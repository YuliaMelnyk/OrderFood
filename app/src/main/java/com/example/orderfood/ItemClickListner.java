package com.example.orderfood;

import android.view.View;

/**
 * @author yuliiamelnyk on 16/09/2020
 * @project OrderFood
 */
public interface ItemClickListner {
    void  onClick(View view, int position, boolean islongClick);
}

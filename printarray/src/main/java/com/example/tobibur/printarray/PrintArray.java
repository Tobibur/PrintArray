package com.example.tobibur.printarray;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class PrintArray {
    private static boolean[] checkedItems;
    private static ArrayList<Integer> mUserItems;
    private static String title_default = "Please select the items";

    private static String singleChoiceValue = null;
    private static int singleCheckedItem = 0;

    private static final String TAG = "PrintArray";

    // setting AlertDialog title
    public static void setBoxTitle(String title){
        title_default = title;
    }

    // AlertDialog with CheckBox method
    public static void diaCheckBox(final Button button, final String[] listItems, Context context){
        checkedItems = new boolean[listItems.length];
        mUserItems = new ArrayList<>();
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
        mBuilder.setTitle(title_default);
        mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                if(isChecked){
                    mUserItems.add(position);
                }else{
                    mUserItems.remove((Integer.valueOf(position)));
                }
            }
        });

        mBuilder.setCancelable(false);
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                String item="";
                String no="";
                for (int i = 0; i < mUserItems.size(); i++) {
                    item = item + listItems[mUserItems.get(i)];
                    no = no + mUserItems.get(i);
                    if (i != mUserItems.size() - 1) {
                        item = item + ", ";
                        no = no + ", ";
                    }
                }
                button.setText(item);
            }
        });

        mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        mBuilder.setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                for (int i = 0; i < checkedItems.length; i++) {
                    checkedItems[i] = false;
                    mUserItems.clear();
                    button.setText("");
                }
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    // AlertDialog with RadioButton method
    public static void diaRadioBox(final Button button, final String[] listItems, Context context){

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
        mBuilder.setTitle(title_default);
        mBuilder.setSingleChoiceItems(listItems,singleCheckedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                singleCheckedItem = i;
                Log.d(TAG, "onClick: "+listItems[i]);
                singleChoiceValue =  listItems[i];
                button.setText(singleChoiceValue);
            }
        });
        mBuilder.setCancelable(false);
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                button.setText(singleChoiceValue);
            }
        });

        mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        mBuilder.setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                singleCheckedItem = 0;
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }
}
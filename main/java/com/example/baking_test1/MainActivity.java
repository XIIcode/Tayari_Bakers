package com.example.baking_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ApplicationExitInfo;
import android.media.ExifInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText small_number_count,medium_number_count,large_number_count;
    int total_cost;
    EditText mpesa_amount,cash_amount,cheque_amount;
    Button Price,Res,sub,exit;
    TextView balance_text,submission;

    CheckBox small_chk_status, medium_chk_status, large_chk_status,mpesa_chk_status,cash_chk_status,cheque_chk_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sub = findViewById(R.id.btn_submit);
        Res = findViewById(R.id.btn_reset);
        Price = findViewById(R.id.btn_price);
        exit = findViewById(R.id.btn_exit);

        small_chk_status = findViewById(R.id.small_input_checkbox);
        medium_chk_status = findViewById(R.id.medium_input_checkbox);
        large_chk_status = findViewById(R.id.large_input_checkbox);
        mpesa_chk_status = findViewById(R.id.mpesa_checkbox);
        cash_chk_status = findViewById(R.id.cash_checkbox);
        cheque_chk_status = findViewById(R.id.cheque_checkbox);


        small_number_count = findViewById(R.id.small_input);
        small_number_count.setText("0");

        medium_number_count = findViewById(R.id.medium_input);
        medium_number_count.setText("0");

        large_number_count = findViewById(R.id.large_input);
        large_number_count.setText("0");

         mpesa_amount = findViewById(R.id.mpesa_entry);
         mpesa_amount.setText("0");

        cash_amount = findViewById(R.id.cash_entry);
        cash_amount.setText("0");

        cheque_amount = findViewById(R.id.cheque_entry);
        cheque_amount.setText("0");

    small_chk_status.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(small_chk_status.isChecked())
            {
                small_number_count.setEnabled(true);
            }
            else
            {
                small_number_count.setEnabled(false);
            }
        }
    });

    medium_chk_status.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(medium_chk_status.isChecked())
            {
                medium_number_count.setEnabled(true);
            }
            else
            {
                medium_number_count.setEnabled(false);
            }
        }
    });

    large_chk_status.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(large_chk_status.isChecked())
            {
                large_number_count.setEnabled(true);
            }
            else
            {
                large_number_count.setEnabled(false);
            }
        }
    });
    mpesa_chk_status.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(mpesa_chk_status.isChecked())
            {
                mpesa_amount.setEnabled(true);
            }
            else
            {
                mpesa_amount.setEnabled(false);
            }
        }
    });

    cash_chk_status.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(cash_chk_status.isChecked())
            {
                cash_amount.setEnabled(true);
            }
            else
            {
                cash_amount.setEnabled(false);
            }
        }
    });

    cheque_chk_status.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(cheque_chk_status.isChecked())
            {
                cheque_amount.setEnabled(true);
            }
            else
            {
                cheque_amount.setEnabled(false);
            }
        }
    });
    //exit button
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

//        //Reset button
        Res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
//
////        Price button
        Price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateOrderPrice();

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            submit();
            }
        });
    }


  void calculateOrderPrice()
  {
      balance_text = findViewById(R.id.txt_balance);

      try{
          int small_count = Integer.parseInt(small_number_count.getText().toString());
          int medium_count = Integer.parseInt(medium_number_count.getText().toString());
          int large_count = Integer.parseInt(large_number_count.getText().toString());
          total_cost = (small_count * 100) + (medium_count * 200) + (large_count * 300);
          balance_text.setText("Balance is  : " + Integer.toString(total_cost) + " KSH");}
      catch (Exception ex)
      {
          balance_text.setText("Balance is  invalid, check your input");

  }

   }
//
   void submit() {
       TextView status = findViewById(R.id.substatus);
        try {

            int mpesa_count = Integer.parseInt(mpesa_amount.getText().toString());
            int cash_count = Integer.parseInt(cash_amount.getText().toString());
            int cheque_count = Integer.parseInt(cheque_amount.getText().toString());
            int entered_amount = mpesa_count + cash_count + cheque_count;
            if(entered_amount > total_cost || entered_amount < total_cost)
            {
                status.setText("Error ! Amount is incorrect");
            }
            else
            {
                status.setText("Submitted Succeffully !!");
            }
        }
        catch(Exception ex)
        {
            status.setText("Amount is  invalid, check your input ");
        }


   }

    void reset()
    {
        EditText entry = findViewById(R.id.mpesa_entry);
        TextView balance;
        entry.setText("");
        entry = findViewById(R.id.cheque_entry);
        entry.setText("");
        entry = findViewById(R.id.cash_entry);
        entry.setText("");
        entry = findViewById(R.id.medium_input);
        entry.setText("");
        entry = findViewById(R.id.small_input);
        entry.setText("");
        entry = findViewById(R.id.large_input);
        entry.setText("");
        balance = findViewById(R.id.txt_balance);
        balance.setText("Balance is : 0ksh");
        balance = findViewById(R.id.substatus);
        balance.setText("Pending submission");

    }

}
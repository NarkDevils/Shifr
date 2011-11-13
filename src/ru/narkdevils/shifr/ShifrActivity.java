package ru.narkdevils.shifr;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShifrActivity extends Activity implements OnClickListener {
	
	EditText editText1;
	TextView textView1;
	Button button1;
	Button button2;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        editText1 = (EditText) findViewById(R.id.editText1);
        textView1 = (TextView) findViewById(R.id.textView1);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        
    }

	public void onClick(View v) {
		switch (v.getId()) {
			//case R.id.radio0:editText2.setText("Нажата кнопка ОК");
			//break;
			//case R.id.radio1:editText2.setText("Нажата кнопка Cancel");
			//break;
			case R.id.button1:
	  			char[] cText = Crypt(editText1.getText().toString().toCharArray());
	  			CharSequence seq1 = new String(cText);
	  			textView1.setText(seq1);
			break;
			case R.id.button2:
	  			char[] dcText = Decrypt(editText1.getText().toString().toCharArray());
	  			CharSequence seq2 = new String(dcText);
	  			textView1.setText(seq2);
			break;
		}
		
	}

	private char[] Crypt(char[] text) {
		
		int i = 0, j = 0, ij; char ch;

    	for(int k = 0, ki = 0; k < text.length; k++, ki++)
    	{
    		 if(ki == key.length) ki=0;
             for(ij = 0, ch = 'a'; ch <= 'z'; ch++, ij++)
             {
            	 if(text[k] == ch) i = ij;
                 if(key[ki] == ch) j = ij;
             }
             if(text[k] != ' ') text[k] = table[i][j];
    	}
		return text;
	}
	
	private char[] Decrypt(char[] text) {
		
		return text;
	}
}
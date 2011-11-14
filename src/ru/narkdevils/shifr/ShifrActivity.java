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
    
    private char[][] table = {
    		{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'},
    		{'b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a'},
    		{'c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b'},
    		{'d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c'},
    		{'e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d'},
    		{'f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e'},
    		{'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f'},
    		{'h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g'},
    		{'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h'},
    		{'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i'},
    		{'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j'},
    		{'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k'},
    		{'m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l'},
    		{'n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m'},
    		{'o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n'},
    		{'p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o'},
    		{'q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'},
    		{'r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q'},
    		{'s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r'},
    		{'t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s'},
    		{'u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t'},
    		{'v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u'},
    		{'w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v'},
    		{'x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w'},
    		{'y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x'},
    		{'z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y'}
    		};
    
    private char[] key = {'n', 'a', 'r', 'k', 'd', 'e', 'v', 'i', 'l', 's'};

	public void onClick(View v) {
		switch (v.getId()) {
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
		
		int j = 0, ij; char ch;

		for(int k = 0, ki = 0; k != text.length; k++, ki++)
		{
	         if(ki == key.length) ki = 0; 
			 for(ij = 0, ch = 'a'; ch <= 'z'; ch++, ij++)
	              if(key[ki] == ch) j = ij;
	         for(ij = 0, ch = 'a'; ch <= 'z'; ch++, ij++)
	              if(text[k] == table[ij][j]) { text[k] = ch; break; }
		}
		
		return text;
	}
}
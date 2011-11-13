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
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        editText1 = (EditText) findViewById(R.id.editText1);
        textView1 = (TextView) findViewById(R.id.textView1);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        
    }

	public void onClick(View v) {
		switch (v.getId()) {
			//case R.id.radio0:editText2.setText("������ ������ ��");
			//break;
			//case R.id.radio1:editText2.setText("������ ������ Cancel");
			//break;
			case R.id.button1:
	  			char[] csText = Crypt(editText1.getText().toString().toCharArray());
	  			CharSequence seq = new String(csText);
	  			textView1.setText(seq);
			break;
		}
		
	}

	private char[] Crypt(char[] charArray) {
		// TODO Auto-generated method stub
		return null;
	}
}
package com.example.app;

import com.example.app.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private float size1=0;
	//定义变量来接收甲乙丙丁活鸟的�??
	private int hn1=0;
	private int hn2=0;
	private int hn3=0;
	private int hn4=0;
	//定义变量来接收甲乙丙丁拖鸟的�??
	private int tn1=0;
	private int tn2=0;
	private int tn3=0;
	private int tn4=0;
	//定义变量来接收甲乙丙丁胡息的�??
	private int hx1=0;
	private int hx2=0;
	private int hx3=0;
	private int hx4=0;
	//定义甲乙丙丁的�?拖鸟输赢
	int jjstn1=0;
	int jjstn2=0;
	int jjstn3=0;
	int jjstn4=0;
	
	//定义甲乙丙丁的�?活鸟输赢
	float jjshn1=0;
	float jjshn2=0;
	float jjshn3=0;
	float jjshn4=0;
	//定义甲乙丙丁的�?输赢=总活�??总拖�??
	float js1=0;
	float js2=0;
	float js3=0;
	float js4=0;
	//获取结果中要显示的控件的id
	private TextView res1,res2,res3,res4;
	//定义输入的控件id
	private EditText 
	xi,
	hntext1,
	hntext2,
	hntext3,
	hntext4,
	tntext1,
	tntext2,
	tntext3,
	tntext4,
	hxtext1,
	hxtext2,
	hxtext3,
	hxtext4;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		res1=(TextView)findViewById(R.id.result1);
		res2=(TextView)findViewById(R.id.result2);
		res3=(TextView)findViewById(R.id.result3);
		res4=(TextView)findViewById(R.id.result4);
		xi=(EditText)findViewById(R.id.Sizexi);
	 hntext1=(EditText)findViewById(R.id.hn1);
	 hntext2=(EditText)findViewById(R.id.hn2);
	 hntext3=(EditText)findViewById(R.id.hn3);	
	 hntext4=(EditText)findViewById(R.id.hn4);
	 tntext1=(EditText)findViewById(R.id.tn1);
	 tntext2=(EditText)findViewById(R.id.tn2);
	 tntext3=(EditText)findViewById(R.id.tn3);
	 tntext4=(EditText)findViewById(R.id.tn4);
	 hxtext1=(EditText)findViewById(R.id.hx1);
	 hxtext2=(EditText)findViewById(R.id.hx2);
	 hxtext3=(EditText)findViewById(R.id.hx3);
	 hxtext4=(EditText)findViewById(R.id.hx4);
	}
	
	//通过点击计算来计算�?输赢
	public void getResult(View view){
	//获取输赢大小
	size1= Float.parseFloat(xi.getText().toString());
	
//获取甲乙丙丁的活�??
	hn1=Integer.parseInt(hntext1.getText().toString());	
	hn2=Integer.parseInt(hntext2.getText().toString());
	hn3=Integer.parseInt(hntext3.getText().toString());
	hn4=Integer.parseInt(hntext4.getText().toString());
	
//获取甲乙丙丁拖鸟的�?
	tn1=Integer.parseInt(tntext1.getText().toString());
	tn2=Integer.parseInt(tntext2.getText().toString());
	tn3=Integer.parseInt(tntext3.getText().toString());
	tn4=Integer.parseInt(tntext4.getText().toString());
	
//获取甲乙丙丁的胡�??
	hx1=Integer.parseInt(hxtext1.getText().toString());
	hx2=Integer.parseInt(hxtext2.getText().toString());
	hx3=Integer.parseInt(hxtext3.getText().toString());
	hx4=Integer.parseInt(hxtext4.getText().toString());
	
	//定义数组来接收活鸟，方便循环
	int []hn={hn1,hn2,hn3,hn4};
	//定义b数组来接收拖鸟的值，方便循环
	int []tn= {tn1,tn2,tn3,tn4};
	//定义c数组来接收胡息的值，方便循环
	int []hx={hx1,hx2,hx3,hx4};
	//定义甲乙丙丁总拖鸟的输赢
	int []jstn={jjstn1,jjstn2,jjstn3,jjstn4};
	//定义甲乙丙丁总活鸟的输赢
	float []jshn={jjshn1,jjshn2,jjshn3,jjshn4};
			
			
	//将胡息四舍五�??
	for(int i=0;i<4;i++){
		if(hx[i]%10<5){
			hx[i]=hx[i]/10*10;
		}
		else {if(hx[i]<0){
			hx[i]=(hx[i]/10-1)*10;
		}else{
			hx[i]=(hx[i]/10+1)*10;
			}
		}
	}
	
	//计算甲乙丙丁依次的�?活鸟�??
	for(int j=0;j<4;j++){
		for(int i=0;i<4;i++){
			jshn[j]+=(hx[j]-hx[i])*size1*(hn[j]+1)*(hn[i]+1);
		}
	}
//计算甲乙丙丁依次的�?拖鸟�??
	for(int j=0;j<4;j++){
		for(int i=0;i<4;i++){
			if(tn[j]-tn[i]<0){
				jstn[j]+=-tn[j]-tn[i];
			}else if(tn[j]-tn[i]>0){
				jstn[j]+=tn[j]+tn[i];
			}else continue;
			}
		}
	
	//甲的总输�??
	js1=jshn[0]+jstn[0];
	//乙的总输�??
		js2=jshn[1]+jstn[1];
		//丙的总输�??
		js3=jshn[2]+jstn[2];
		//丁的总输�??
		js4=jshn[3]+jstn[3];
	/*	System.out.println(js1);
		System.out.println(js2);
		System.out.println(js3);
		System.out.println(js4);*/
		res1.setText(js1+"");
		res2.setText(js2+"");
		res3.setText(js3+"");
		res4.setText(js4+"");
	}
	
	//清空�??��编辑框的内容
	public void clean(View view){
		xi.setText("0");
		hntext1.setText("0");
		hntext2.setText("0");
		hntext3.setText("0");
		hntext4.setText("0");
		tntext1.setText("0");
		tntext2.setText("0");
		tntext3.setText("0");
		tntext4.setText("0");
		hxtext1.setText("0");
		hxtext2.setText("0");
		hxtext3.setText("0");
		hxtext4.setText("0");
		res1.setText("0");
		res2.setText("0");
		res3.setText("0");
		res4.setText("0");
	}
	//�??��按钮的调�??
	public void exit(View view){
		finish();
	}

}

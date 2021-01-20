package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity
{
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,badd,bsub,bmul,bdiv,bpoint,bclr,bequ;
    EditText t1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        class MyFunc
        {
            //This function will check the precedence
            public  boolean checkP(char v1, char v2)
            {
                if ((v1 == '*' || v1 == '/') && (v2 == '+' || v2 == '-'))
                    return false;
                else
                    return true;
            }
            //This function will calculate the ans on the basis of operator
            public double CalAns(char op, double val1, double val2)
            {
                switch (op)
                {
                    case '+':
                        return val2 + val1;
                    case '-':
                        return val2 - val1;
                    case '*':
                        return val2 * val1;
                    case '/':
                        if (val1 == 0)
                            t1.setText("Cannot divided by zero");
                        return val2 / val1;
                }
                return 0;
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*from b1 to bdiv , findViewById will find the value on the click of any button it will just get the previous string from textview and
         concatenate it with the button that will press and again set it in text view. All the functionality will perform when we click on equal button*/
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"1");
            }
        });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"2");
            }
        });
        b3=(Button)findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"3");
            }
        });
        b4=(Button)findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"4");
            }
        });
        b5=(Button)findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"5");
            }
        });
        b6=(Button)findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"6");
            }
        });
        b7=(Button)findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"7");
            }
        });
        b8=(Button)findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"8");
            }
        });
        b9=(Button)findViewById(R.id.b9);
        b9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"9");
            }
        });
        b0=(Button)findViewById(R.id.bzero);
        b0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"0");
            }
        });
        bpoint=(Button)findViewById(R.id.bpoint);
        bpoint.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+".");
            }
        });
        badd=(Button)findViewById(R.id.add);
        badd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"+");

            }
        });
        bsub=(Button)findViewById(R.id.bsub);
        bsub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"-");

            }
        });
        bmul=(Button)findViewById(R.id.bmul);
        bmul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"*");

            }
        });
        bdiv=(Button)findViewById(R.id.bdiv);
        bdiv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText(t1.getText().toString()+"/");

            }
        });
        bequ=(Button)findViewById(R.id.bequ);
        bequ.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String expr1;
                // expr1 will get the expression from TextView
                expr1 = t1.getText().toString() + "";
                Stack<Double> operands = new Stack<Double>();
                Stack<Character> operators = new Stack<Character>();
                double ans=0;
                boolean flag=true;
                String ans1=null;
                int count=0;
                MyFunc fun=new MyFunc();
                //This loop will check whether the expression is valid or invalid
                for (int i = 0; i <  expr1.length(); i++)
                {
                    //this will check whether two operator comes consuctively
                    if((i!=0) && (expr1.charAt(i) == '*' || expr1.charAt(i) == '/') && (expr1.charAt(i-1) == '+' || expr1.charAt(i-1) == '-' || expr1.charAt(i-1) == '*' || expr1.charAt(i-1) == '/'))
                    {
                        t1.setText("INVALID EXPRESSION");
                        flag=false;
                        break;
                    }
                    //this will check if the 1st operator is * or / then it will give invalid input like *3+4 or /3+4
                    if((i==0) && (expr1.charAt(i) == '*' || expr1.charAt(i) == '/'))
                    {
                        t1.setText("INVALID EXPRESSION");
                        flag=false;
                        break;
                    }
                    //it will check if two points come consectively then it will give invalid input like 2..4+5
                    if(expr1.charAt(i) == '.' && expr1.charAt(i-1)=='.')
                    {
                        t1.setText("INVALID EXPRESSION");
                        flag=false;
                        break;
                    }
                }
                //if the expression is not invalid then we will come in this condition
                if(flag==true)
                {
					boolean minus=false;
					boolean plus=true;

                    for (int i = 0; i <  expr1.length(); i++)
                    {
                        /*it will check if the expression contain the blank space then ignore the space or if the 1st operator is plus then ignore it like +2-3 is valid ans=-1*/
                        if ( expr1.charAt(i) == ' ' || (i==0)&&expr1.charAt(i)=='+')
                        {
                            continue;
                        }
                        /*it will check if the ist index of expression is -  then it will multiply operand with -1 before push it to stack*/
						if(i==0 && expr1.charAt(i) == '-')
						{
							minus=true;
							continue;
						}
						/*this will check if two operator in string come consecutive and if the 2nd oprator is minus then will multiply the 2nd operand with -1 before push it to stack */
                        if((i!=0)  && (expr1.charAt(i) == '-') && (expr1.charAt(i-1) == '+' || expr1.charAt(i-1) == '-' || expr1.charAt(i-1) == '*' || expr1.charAt(i-1) == '/'))
                        {
                            minus=true;
                            continue;
                        }
                        /*this will check if two operator in string come consecutive and if the 2nd oprator is plus then it will multiply the 2nd operand with +1 before push it to stack */
                        if((i!=0)  && (expr1.charAt(i) == '+') && (expr1.charAt(i-1) == '+' || expr1.charAt(i-1) == '-' || expr1.charAt(i-1) == '*' || expr1.charAt(i-1) == '/'))
                        {
                            plus=true;
                            continue;
                        }
                        //this will check if expression contains digits or points
                        if ( expr1.charAt(i) >= '0' &&  expr1.charAt(i)<= '9' || expr1.charAt(i)=='.')
                        {
                            StringBuffer strBuf = new StringBuffer();
                            while (i <  expr1.length() &&   expr1.charAt(i) >= '0' && expr1.charAt(i) <= '9'|| (i < expr1.length() && expr1.charAt(i)=='.'))
                            {
                                //this will append the operator in strbuf
                                strBuf.append( expr1.charAt(i++));
                            }
                            i--;

							if(minus==true||plus==true)
							{
							    if(minus==true)
                                {
                                    operands.push(Double.valueOf(strBuf.toString())*(-1));
                                    minus=false;
                                }
							    else if(plus==true)
                                {
                                    operands.push(Double.valueOf(strBuf.toString())*(1));
                                    minus=false;
                                }

							}
							else
							{
								operands.push(Double.valueOf(strBuf.toString()));
							}
                        }
                        //it will check if there is any operators push it in operator stack check precedence and calculate ans
                        else if (expr1.charAt(i) == '+' ||  expr1.charAt(i) == '-' ||expr1.charAt(i) == '*' ||  expr1.charAt(i) == '/')
                        {
                            while (!operators.empty() && fun.checkP( expr1.charAt(i), operators.peek()))
                            {
                                operands.push(fun.CalAns(operators.pop(),operands.pop(),operands.pop()));
                            }
                            operators.push( expr1.charAt(i));
                        }
                    }
                    /*This while loop will sipmly calculate all the remaining values like expression is 2+3-1*3/4 there is no prcedence then it will simply calculate the ans*/
                    while (!operators.empty())
                    {
                        operands.push(fun.CalAns(operators.pop(), operands.pop(), operands.pop()));
                    }
                    ans = operands.pop();
                    ans1 = String.valueOf(ans);
                    t1.setText(ans1);

                }
            }

        });
        //this will clear screen
        bclr=(Button)findViewById(R.id.bclr);
        bclr.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText("");
            }
        });
        t1=(EditText)findViewById(R.id.val);
    }
}
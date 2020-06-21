package com.example.tic_tak_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //0:cross
    //1:circle
    //2:empty
    int activePlayer=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winposition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameover=false;

    public void dropIn(View view){
        ImageView counter=(ImageView) view;
        int tappedcounter=Integer.parseInt(counter.getTag().toString());
        if(gamestate[tappedcounter]==2 && gameover==false){
            gamestate[tappedcounter]=activePlayer;
            if(activePlayer==0){
                counter.setTranslationX(-1000);
                counter.setImageResource(R.drawable.cross);
                counter.animate().translationXBy(1000).rotation(3600).setDuration(500);
                activePlayer=1;
            }
            else{
                counter.setTranslationX(1000);
                counter.setImageResource(R.drawable.circle);
                counter.animate().translationXBy(-1000).rotation(3600).setDuration(500);
                activePlayer=0;
            }
            for(int[] winposition:winposition){
                if(gamestate[winposition[0]]==gamestate[winposition[1]]&&gamestate[winposition[1]]==gamestate[winposition[2]]&&gamestate[winposition[0]]!=2){
                    String winner="";
                    gameover=true;
                    if(activePlayer==1){
                        winner="Player 1";
                    }
                    else{
                        winner="Player 2";
                    }
                    Button playAgain=(Button)findViewById(R.id.button);
                    TextView winnerText=(TextView)findViewById(R.id.textView3);
                    TextView winnerName=(TextView)findViewById(R.id.textView4);
                    winnerName.setText(winner);
                    playAgain.setVisibility(View.VISIBLE);
                    winnerText.setVisibility(View.VISIBLE);
                    winnerName.setVisibility(View.VISIBLE);
                }
            }
        }
        else{
            Toast.makeText(this,"GAME OVER",Toast.LENGTH_SHORT).show();
        }
    }
    public void playagain(View view){
        Button playAgain=(Button)findViewById(R.id.button);
        TextView winnerText=(TextView)findViewById(R.id.textView3);
        TextView winnerName=(TextView)findViewById(R.id.textView4);
        playAgain.setVisibility(View.INVISIBLE);
        winnerText.setVisibility(View.INVISIBLE);
        winnerName.setVisibility(View.INVISIBLE);
        /*GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLayout);
        for (int i=0;i<=gridLayout.getChildCount();i++){
            ImageView counter=(ImageView)gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }*/
        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        activePlayer=0;
        gameover=false;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

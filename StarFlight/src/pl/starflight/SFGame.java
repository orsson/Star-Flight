package pl.starflight;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

public class SFGame extends Activity 
{
	final SFEngine gameEngine = new SFEngine();
	private SFGameView gameView;
    	
	@Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        gameView = new SFGameView(this);
        setContentView(gameView);
    }
	
    @Override
    protected void onResume() 
    {
       super.onResume();
       gameView.onResume();
    }

    @Override
    protected void onPause() 
    {
       super.onPause();
       gameView.onPause();
    }

   	@Override
   	public boolean onTouchEvent(MotionEvent event) 
   	{
   		
   		DisplayMetrics displaymetrics = new DisplayMetrics();
   		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
   		int height = (displaymetrics.heightPixels/4);
   		
   		float x = event.getX();
        float y = event.getY();
        
        int playableArea =  displaymetrics.heightPixels - height;
        if (y > playableArea){
        	switch (event.getAction()){
        	case MotionEvent.ACTION_DOWN:
        		
        		
        		if(x < (displaymetrics.widthPixels/2))
        		{
        			SFEngine.playerFlightAction = SFEngine.PLAYER_BANK_LEFT_1;
        		}
        		else
        		{
        			SFEngine.playerFlightAction = SFEngine.PLAYER_BANK_RIGHT_1;
        		}
        		break;
        		
        		
        		
        	case MotionEvent.ACTION_UP:
        		SFEngine.playerFlightAction = SFEngine.PLAYER_RELASE_1;
        		break;
        	}
        	
        }

		return false;
    }
}

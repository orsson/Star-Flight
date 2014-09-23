package pl.starflight;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class SFMainMenu extends Activity 
{
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		
		SFEngine.display=((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_screen);
		SFEngine.context = getApplicationContext();
		
		final SFEngine engine = new SFEngine();
		final ImageButton start =(ImageButton) findViewById(R.id.btnStart);
		final ImageButton exit =(ImageButton) findViewById(R.id.btnExit);
		final ImageButton select =(ImageButton) findViewById(R.id.btnSelect);
		
	//	start.getBackground().setAlpha(SFEngine.MENU_BUTTON_ALPHA);
    //  exit.getBackground().setAlpha(SFEngine.MENU_BUTTON_ALPHA);
		
		start.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//rozpocznij gre
				start.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                if(SFEngine.Control_Choose==false)
                {
				Intent game= new Intent(getApplicationContext(),SFGame.class);
				SFMainMenu.this.startActivity(game);
                }
                if(SFEngine.Control_Choose==true)
                {
                	Intent game= new Intent(getApplicationContext(),SFGame2.class);
    				SFMainMenu.this.startActivity(game);
                }
                
			}
		});
		
		select.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				select.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                if(SFEngine.Control_Choose==false)
                {
                	SFEngine.Control_Choose=true;
                	Toast.makeText(getBaseContext(), (CharSequence) "Accelerometer controls", 
                            Toast.LENGTH_LONG).show();
                }
                
                else
                {
                	SFEngine.Control_Choose=false;
                	Toast.makeText(getBaseContext(), (CharSequence) "On screen cotnrols", 
                            Toast.LENGTH_LONG).show();
                }
                
			}
		});
		
		
		exit.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				exit.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
				
				boolean clean=false;
				clean=engine.onExit(v);
				if(clean)
				{
					int pid=android.os.Process.myPid();
					android.os.Process.killProcess(pid);
				}
			}
		});

		
	}

}

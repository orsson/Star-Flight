package pl.starflight;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class FirstScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.slashscreen);
		
		new Handler().postDelayed(new Thread()
		{
			@Override
			public void run()
			{
				Intent mainMenu = new Intent(FirstScreen.this,SFMainMenu.class);
				FirstScreen.this.startActivity(mainMenu);
				FirstScreen.this.finish();
				overridePendingTransition(R.layout.fadein,R.layout.fadeout);

			}
		}, SFEngine.GAME_THREAD_DELAY);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_screen, menu);
		return true;
	}

}

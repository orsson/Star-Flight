package pl.starflight;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class SFGame2 extends Activity implements SensorEventListener
{
	final SFEngine gameEngine = new SFEngine();
	private SFGameView gameView;
    
	private float mLastX, mLastY, mLastZ;
	private boolean mInitialized;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private final float NOISE = (float) 2.0;
	
	@Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        gameView = new SFGameView(this);
        setContentView(gameView);

        mInitialized = false;
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
	
    @Override
    protected void onResume()
    {
       super.onResume();
       gameView.onResume();

       mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
       super.onPause();
       gameView.onPause();

       mSensorManager.unregisterListener(this);

    }


	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) 
	{
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
	
		float x = event.values[0];
		float y = event.values[1];
		float z = event.values[2];
		if (!mInitialized)
		{
		mLastX = x;
		mLastY = y;
		mLastZ = z;
		mInitialized = true;
		}
		
		else 
		{
		float deltaX = Math.abs(mLastX - x);
		float deltaY = Math.abs(mLastY - y);
		float deltaZ = Math.abs(mLastZ - z);
		if (deltaX < NOISE) deltaX = (float)0.0;
		if (deltaY < NOISE) deltaY = (float)0.0;
		if (deltaZ < NOISE) deltaZ = (float)0.0;
		mLastX = x;
		mLastY = y;
		mLastZ = z;

		if (x> 1.4f) //lewo
		{
			SFEngine.playerFlightAction = SFEngine.PLAYER_BANK_LEFT_1;
		}
		else if (-1.4f > x) //prawo
		{
			SFEngine.playerFlightAction = SFEngine.PLAYER_BANK_RIGHT_1;
		} 
		else //stoj
		{
			SFEngine.playerFlightAction = SFEngine.PLAYER_RELASE_1;
		}
		
		}
		
	}

}

package pl.starflight;

import android.content.Context;
import android.view.Display;
import android.view.View;

public class SFEngine 
{	
public static final int GAME_THREAD_DELAY=4000;
public static final int MENU_BUTTON_ALPHA=0;
public static final boolean HAPTIC_BUTTON_FEEDBACK=true;
public static final int BACKGROUND_LAYER_ONE = R.drawable.backgroundstars;
public static final int BACKGROUND_LAYER_TWO = R.drawable.debris1;
public static Context context;
public static float SCROLL_BACKGROUND_1 = .002f;
public static float SCROLL_BACKGROUND_2 = .007f;
public static final int GAME_THREAD_FPS_SLEEP=(1000/60);
public static int playerFlightAction=0;
public static final int PLAYER_BANK_LEFT_1=1;
public static final int PLAYER_BANK_RIGHT_1=4;
public static final int PLAYER_RELASE_1=3;
public static final int PLAYER_FRAMES_BETWEEN_ANI=9;
public static final float PLAYER_BANK_SPEED= .1f;
public static float playerBankPosX=1.75f;
public static Boolean Control_Choose=true; // true accelerometr //false on screen
public static Display display;
public static  int Loop=0; //do kontrolowania ranodmizacji tla
public static  int  Random_Background_Translate=0;
public static int CHARACTER_SHEET=R.drawable.character_sprite;
//Przeciwnicy
public static int TOTAL_INTERCEPTORS=10;
public static int TOTAL_SCOUTS=15;
public static int TOTAL_WARPSHIPS=5;
public static float INTERCEPTOR_SPEED=SCROLL_BACKGROUND_1 *4f;
public static float SCOUT_SPEED=SCROLL_BACKGROUND_1 *6f;
public static float WARPSHIP_SPEED=SCROLL_BACKGROUND_2 *4f;

public static final int TYPE_INCEPTOR=1;
public static final int TYPE_SCOUT=2;
public static final int TYPE_WARPSHIP=3;
public static final int ATTACK_RANDOM=0;
public static final int ATTACK_RIGHT=1;
public static final int ATTACK_LEFT=2;
public static final float BEZIER_X_1=0f;
public static final float BEZIER_X_2=1f;
public static final float BEZIER_X_3=2.5f;
public static final float BEZIER_X_4=3f;
public static final float BEZIER_Y_1=0f;
public static final float BEZIER_Y_2=2.4f;
public static final float BEZIER_Y_3=1.5f;
public static final float BEZIER_Y_4=2.6f;
//weapons
public static final int WEAPONS_SHEET=R.drawable.destruction;
public static final int PLAYER_SHIELDS=5;
public static final int SCOUT_SHIELDS=3;
public static final int INCEPTOR_SHIELDS=5;
public static final int WARSHIP_SHIELDS=5;
public static final float PLAYER_BULLET_SPEED=.125f;

public boolean onExit(View v)
{
	
	try
	{
		return true;
	}
	catch (Exception e)
	{
		return false;
	}
}

}

package com.aboplanet.android;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
  int dp(float n){ return (int)(n*getResources().getDisplayMetrics().density+.5f); }
  TextView text(String value,float size,int color){ TextView t=new TextView(this); t.setText(value); t.setTextSize(size); t.setTextColor(color); return t; }
  @Override public void onCreate(Bundle b){ super.onCreate(b); showHome(); }
  void showHome(){
    int ink=Color.rgb(25,25,45), muted=Color.rgb(103,104,125), purple=Color.rgb(91,92,226);
    ScrollView scroll=new ScrollView(this); LinearLayout page=new LinearLayout(this); page.setOrientation(LinearLayout.VERTICAL); page.setPadding(dp(24),dp(30),dp(24),dp(28)); page.setBackgroundColor(Color.rgb(247,247,252)); scroll.addView(page);
    TextView mark=text("ABO PLANET",14,purple); mark.setTypeface(Typeface.DEFAULT,Typeface.BOLD); page.addView(mark,new LinearLayout.LayoutParams(-1,dp(30)));
    TextView title=text("Your world,\nin one place.",34,ink); title.setTypeface(Typeface.DEFAULT,Typeface.BOLD); title.setPadding(0,dp(20),0,dp(12)); page.addView(title);
    TextView intro=text("A calm, focused space to discover what matters and keep your everyday orbit moving.",17,muted); intro.setLineSpacing(0,1.15f); page.addView(intro);
    LinearLayout card=new LinearLayout(this); card.setOrientation(LinearLayout.VERTICAL); card.setPadding(dp(20),dp(20),dp(20),dp(20)); card.setBackgroundColor(Color.WHITE); LinearLayout.LayoutParams cp=new LinearLayout.LayoutParams(-1,dp(180)); cp.setMargins(0,dp(28),0,dp(22)); page.addView(card,cp);
    TextView ct=text("A better starting point",20,ink); ct.setTypeface(Typeface.DEFAULT,Typeface.BOLD); card.addView(ct); TextView cb=text("Set an intention, explore a new idea, or simply take a breath. Abo Planet gives you a small, useful moment every day.",15,muted); cb.setPadding(0,dp(10),0,0); card.addView(cb);
    Button action=new Button(this); action.setText("Begin your journey  →"); action.setTextColor(Color.WHITE); action.setTextSize(15); action.setAllCaps(false); action.setBackgroundColor(purple); LinearLayout.LayoutParams ap=new LinearLayout.LayoutParams(-1,dp(52)); ap.setMargins(0,dp(4),0,dp(20)); page.addView(action,ap);
    TextView foot=text("Available on Android",13,muted); foot.setGravity(Gravity.CENTER); page.addView(foot,new LinearLayout.LayoutParams(-1,dp(28)));
    ImageView badge=new ImageView(this); badge.setImageResource(com.aboplanet.android.R.drawable.googleplay); badge.setAdjustViewBounds(true); badge.setContentDescription("Get Abo Planet on Google Play"); LinearLayout.LayoutParams bp=new LinearLayout.LayoutParams(dp(190),dp(129)); bp.gravity=Gravity.CENTER; page.addView(badge,bp);
    action.setOnClickListener(v -> Toast.makeText(this,"Welcome to Abo Planet",Toast.LENGTH_SHORT).show()); setContentView(scroll);
  }
}

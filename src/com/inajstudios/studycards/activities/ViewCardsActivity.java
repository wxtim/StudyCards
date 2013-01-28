package com.inajstudios.studycards.activities;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.inajstudios.studycards.R;
import com.inajstudios.studycards.adapters.CardFragmentStatePagerAdapter;
import com.inajstudios.studycards.fragments.CardPagerFragment;
import com.inajstudios.studycards.models.Card;

public class ViewCardsActivity extends SherlockFragmentActivity{

	ViewPager vpCards;
	List<Card> cards;;
	FragmentManager fragmentManager = getSupportFragmentManager();
	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

	CardPagerFragment cardPagerFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewcards);
		
		// Actionbar stuff
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		// Debug values
		cards = new ArrayList<Card>();
		cards.add(new Card("What are activities?", "IDK DONT FIRE ME PLZ"));
		cards.add(new Card("What is the Android Manifest?", "Activities, Intent Filters, App Version"));
		cards.add(new Card("What are the four layout densities?", "hdpi mdpi ldpi xhdpi"));
		cards.add(new Card("Do you stink?", "Only on Thursdays"));
		cards.add(new Card("U GON' GET IT", "oh god no not again"));

	}
	
	
	
	@Override
	protected void onResume() {
		super.onResume();

		cardPagerFragment = (CardPagerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_cardpagerview);
		CardFragmentStatePagerAdapter cardAdapter = new CardFragmentStatePagerAdapter(getSupportFragmentManager(), cards);
		cardPagerFragment.setAdapter(cardAdapter);
	}
	
}

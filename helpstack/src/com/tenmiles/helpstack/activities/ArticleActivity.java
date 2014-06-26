package com.tenmiles.helpstack.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import com.tenmiles.helpstack.R;
import com.tenmiles.helpstack.fragments.ArticleFragment;
import com.tenmiles.helpstack.fragments.HSFragmentManager;
import com.tenmiles.helpstack.model.HSKBItem;

public class ArticleActivity extends HSActivityParent {

	public static final String EXTRAS_ARTICLE_ITEM = "item";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_article);

		if (savedInstanceState == null) {
			
			HSKBItem kbItem = (HSKBItem)getIntent().getSerializableExtra("item");
			ArticleFragment sectionFragment = HSFragmentManager.getArticleFragment(this, kbItem);
			HSFragmentManager.putFragmentInActivity(this, R.id.container, sectionFragment, "Article");
			getHelpStackActionBar().setTitle(kbItem.getSubject());
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.article, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
    public void configureActionBar(ActionBar actionBar) {
    	super.configureActionBar(actionBar);
    	actionBar.setDisplayHomeAsUpEnabled(true);
    }

}
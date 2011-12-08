package com.maccha.PersistentFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class PersistentFragment extends Fragment{
	
	protected View view = null;
	
	abstract protected int getXmlResource();
	abstract protected void onInitViews();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(view != null) {
			View oldParent = (View) view.getParent();
			if(oldParent != container) {
				((ViewGroup) oldParent).removeView(view);
			}
		} else {
			view = inflater.inflate(getXmlResource(), null);
		}
		onInitViews();
		return view;
	}
}

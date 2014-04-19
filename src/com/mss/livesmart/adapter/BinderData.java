package com.mss.livesmart.adapter;

import java.util.HashMap;
import java.util.List;

import com.mss.livesmart.R;
import com.mss.livesmart.R.id;
import com.mss.livesmart.R.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BinderData extends BaseAdapter {

	// XML node keys
	static final String KEY_TAG = "recommendations"; // parent node
	static final String KEY_ID = "id";
	static final String KEY_HEADING = "heading";
	static final String KEY_SUBTITLE = "subtitle";
	static final String KEY_DESCRIPTION = "description";
	static final String KEY_DATE = "date";
	static final String KEY_ICON = "icon";

	LayoutInflater inflater;
	ImageView thumb_image;
	List<HashMap<String, String>> recommendationCollection;
	ViewHolder holder;

	public BinderData() {

	}

	public BinderData(Activity act, List<HashMap<String, String>> map) {

		this.recommendationCollection = map;

		inflater = (LayoutInflater) act
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {

		return recommendationCollection.size();
	}

	@Override
	public Object getItem(int arg0) {

		return null;
	}

	@Override
	public long getItemId(int position) {

		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View vi = convertView;
		if (convertView == null) {

			vi = inflater.inflate(R.layout.list_row, null);
			holder = new ViewHolder();

			holder.rmdHeading = (TextView) vi.findViewById(R.id.rmdHeading); // recommendation
																				// heading
			holder.rmdSubtitle = (TextView) vi.findViewById(R.id.rmdSubtitle); // recommendation
																				// subtitle
			holder.rmdIcon = (ImageView) vi.findViewById(R.id.list_image); // thumb
																			// image

			vi.setTag(holder);
		} else {

			holder = (ViewHolder) vi.getTag();
		}

		// Setting all values in listview
		holder.rmdHeading.setText(recommendationCollection.get(position).get(
				KEY_HEADING));
		holder.rmdSubtitle.setText(recommendationCollection.get(position).get(
				KEY_SUBTITLE));

		// Setting an image
		String uri = "drawable/"
				+ recommendationCollection.get(position).get(KEY_ICON);
		int imageResource = vi
				.getContext()
				.getApplicationContext()
				.getResources()
				.getIdentifier(
						uri,
						null,
						vi.getContext().getApplicationContext()
								.getPackageName());
		Drawable image = vi.getContext().getResources()
				.getDrawable(imageResource);
		holder.rmdIcon.setImageDrawable(image);

		return vi;
	}

	static class ViewHolder {

		TextView rmdHeading;
		TextView rmdSubtitle;
		ImageView rmdIcon;
	}
}

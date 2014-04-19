package com.mss.livesmart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.mss.livesmart.adapter.BinderData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MessageCenterActivity extends Activity {

	// XML node keys
	static final String KEY_TAG = "recommendation_item"; // parent node
	static final String KEY_ID = "id";
	static final String KEY_HEADING = "heading";
	static final String KEY_SUBTITLE = "subtitle";
	static final String KEY_DESCRIPTION = "description";
	static final String KEY_DATE = "date";
	static final String KEY_ICON = "icon";

	// List items
	ListView list;
	BinderData adapter = null;
	List<HashMap<String, String>> recommendationCollection;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message_center);
		try {

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(getAssets().open(
					"sample_recommendations.xml"));

			if (doc != null) {
				Log.d("ok...", "something in doc");
			}
			recommendationCollection = new ArrayList<HashMap<String, String>>();

			// normalize text representation
			doc.getDocumentElement().normalize();

			NodeList recommendationList = doc
					.getElementsByTagName("recommendation_item");

			HashMap<String, String> map = null;

			for (int i = 0; i < recommendationList.getLength(); i++) {

				map = new HashMap<String, String>();

				Node firstRecommendationNode = recommendationList.item(i);

				if (firstRecommendationNode.getNodeType() == Node.ELEMENT_NODE) {

					Element firstRecommendationElement = (Element) firstRecommendationNode;
					// -------
					NodeList idList = firstRecommendationElement
							.getElementsByTagName(KEY_ID);
					Element firstIdElement = (Element) idList.item(0);
					NodeList textIdList = firstIdElement.getChildNodes();
					// --id
					map.put(KEY_ID, ((Node) textIdList.item(0)).getNodeValue()
							.trim());

					// 2.-------
					NodeList headingList = firstRecommendationElement
							.getElementsByTagName(KEY_HEADING);
					Element firstHeadingElement = (Element) headingList.item(0);
					NodeList textHeadingList = firstHeadingElement
							.getChildNodes();
					// --heading
					map.put(KEY_HEADING, ((Node) textHeadingList.item(0))
							.getNodeValue().trim());

					// 3.-------
					NodeList subtitleList = firstRecommendationElement
							.getElementsByTagName(KEY_SUBTITLE);
					Element firstSubtiteElement = (Element) subtitleList
							.item(0);
					NodeList textSubtitleList = firstSubtiteElement
							.getChildNodes();
					// --subtitle
					map.put(KEY_SUBTITLE, ((Node) textSubtitleList.item(0))
							.getNodeValue().trim());

					// 4.-------
					NodeList descriptionList = firstRecommendationElement
							.getElementsByTagName(KEY_DESCRIPTION);
					Element firstDescriptionElement = (Element) descriptionList
							.item(0);
					NodeList textDescriptionList = firstDescriptionElement
							.getChildNodes();
					// --description
					map.put(KEY_DESCRIPTION, ((Node) textDescriptionList
							.item(0)).getNodeValue().trim());

					// 5.-------
					NodeList dateList = firstRecommendationElement
							.getElementsByTagName(KEY_DATE);
					Element firstDateElement = (Element) dateList.item(0);
					NodeList textDateList = firstDateElement.getChildNodes();
					// --date
					map.put(KEY_DATE, ((Node) textDateList.item(0))
							.getNodeValue().trim());

					// 6.-------
					NodeList iconList = firstRecommendationElement
							.getElementsByTagName(KEY_ICON);
					Element firstIconElement = (Element) iconList.item(0);
					NodeList textIconList = firstIconElement.getChildNodes();
					// --icon
					map.put(KEY_ICON, ((Node) textIconList.item(0))
							.getNodeValue().trim());

					// Add to the Arraylist
					recommendationCollection.add(map);
				}
			}

			BinderData bindingData = new BinderData(this,
					recommendationCollection);

			// list = (ListView) findViewById(R.id.list);
			list = (ListView) findViewById(R.id.listView1);

			Log.i("BEFORE", "<<------------- Before SetAdapter-------------->>");

			list.setAdapter(bindingData);

			Log.i("AFTER", "<<------------- After SetAdapter-------------->>");

			// Click event for single list row
			list.setOnItemClickListener(new OnItemClickListener() {

				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {

					Intent i = new Intent();
					i.setClass(MessageCenterActivity.this,
							RecommendationDetailActivity.class);

					// parameters
					i.putExtra("position", String.valueOf(position + 1));

					/*
					 * selected item parameters 1. Heading 2. Subtitle 3.
					 * Description 4. Date 5. Icon
					 */
					i.putExtra("heading", recommendationCollection
							.get(position).get(KEY_HEADING));
					i.putExtra(
							"subtitle",
							recommendationCollection.get(position).get(
									KEY_SUBTITLE));
					i.putExtra(
							"description",
							recommendationCollection.get(position).get(
									KEY_DESCRIPTION));
					i.putExtra("date", recommendationCollection.get(position)
							.get(KEY_DESCRIPTION));
					i.putExtra("icon", recommendationCollection.get(position)
							.get(KEY_ICON));

					// start the sample activity
					startActivity(i);
				}
			});

		}

		catch (IOException ex) {

			Log.e("IO Error", ex.getMessage());
		} catch (Exception ex) {

			Log.e("other Error", ex.getMessage());
		}

	}

	// Not sure if it's needed
	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	//
	// }

}

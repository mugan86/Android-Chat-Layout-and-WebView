package anartzmuxika.chatmessagelayoutapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import anartzmuxika.chatmessagelayoutapp.model.Message;
import anartzmuxika.chatmessagelayoutapp.R;
import anartzmuxika.chatmessagelayoutapp.adapter.ChatMessageAdapter;

/****************************************************
 * References:
 * Android TextView with Clickable Links: how to capture clicks? ---> http://stackoverflow.com/questions/12418279/android-textview-with-clickable-links-how-to-capture-clicks
 * Android Webview gives net::ERR_CACHE_MISS message: http://stackoverflow.com/questions/30637654/android-webview-gives-neterr-cache-miss-message
 *****************************************************/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView channel_listRecyclerView = (RecyclerView) findViewById(R.id.channel_listRecyclerView);

        //Initialize Channel chat  messages
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message("<h1> 2016-07-01 Firebase – Integrating Analytics</h1>\n" +
                "<p>Another interesting feature that firebase offers is the Firebase Analytics. Free, simple and unlimited. Sounds like a scam? Luckily google is not joking. Analytics integrates across Firebase features and provides you with unlimited reporting for up to 500 distinct events that you can define using the Firebase SDK.</p>" +
                "\n" +
                "<p>Firebase Analytics reports help you understand clearly how your users behave, which enables you to make informed decisions regarding app marketing and performance optimizations. Firebase Analytics helps you understand how people use your app.</p>\n" +
                "<a href=\"chatwebview://www.androidhive.info/2016/06/android-firebase-integrate-analytics/\">Source</a></div>"));
        messages.add(new Message("<h1> 2016-06-22 Firebase – Login / Register</h1>\n" +
                "<p>With the latest news from Google I/O comes the new and upgraded Firebase. To demonstrate how simplified and easy to use firebase is, we will build a simple login / register (Firebase Authentication) demo using the Firebase Email & Password authentication.</p>" +
                "\n" +
                "<p>Firebase provides a full set of authentication options out-of-the-box. Firebase automatically stores your users’ credentials securely (using bcrypt) and redundantly (with replication and daily off-site backups). This separates sensitive user credentials from your application data, and lets you focus on the user interface and experience for your app.</p>\n" +
                "<a href=\"chatwebview://www.androidhive.info/2016/06/android-getting-started-firebase-simple-login-registration-auth/\">Source</a></div>"));
        messages.add(new Message("<h1> 2016-06-21 Tips Android</h1>\n" +
                "<p>Tips on Android to get to better projects.</p>\n" +
                "<a href=\"chatwebview://tips.androidhive.info\">Source</a></div>"));
        messages.add(new Message("<h1> Info about Summer Olympic Games</h1>\n" +
                "<p>London is the capital city of England. It is the most populous city in the United Kingdom,\n" +
                "with a metropolitan area of over 13 million inhabitants.</p>\n" +
                "<p>Standing on the River Thames, London has been a major settlement for two millennia,\n" +
                "its history going back to its founding by the Romans, who named it Londinium.</p>\n" +
                "<a href=\"chatwebview://en.m.wikipedia.org/wiki/2016_Summer_Olympics\">Source</a></div>"));
        messages.add(new Message("<h1> #5 London</h1>\n" +
                "<p>London is the capital city of England. It is the most populous city in the United Kingdom,\n" +
                "with a metropolitan area of over 13 million inhabitants.</p>\n" +
                "<p>Standing on the River Thames, London has been a major settlement for two millennia,\n" +
                "its history going back to its founding by the Romans, who named it Londinium.</p>\n" +
                "<a href=\"chatwebview://es.m.wikipedia.org/wiki/London\">Source</a></div>"));
        messages.add(new Message("<h1> #6 London</h1>\n" +
                "<p>London is the capital city of England. It is the most populous city in the United Kingdom,\n" +
                "with a metropolitan area of over 13 million inhabitants.</p>\n" +
                "<p>Standing on the River Thames, London has been a major settlement for two millennia,\n" +
                "its history going back to its founding by the Romans, who named it Londinium.</p>\n" +
                "<a href=\"chatwebview://es.m.wikipedia.org/wiki/London\">Source</a></div>"));

        ChatMessageAdapter adapter = new ChatMessageAdapter(messages, MainActivity.this);


        channel_listRecyclerView = getRecyclerViewConfig(channel_listRecyclerView, MainActivity.this, true);
        channel_listRecyclerView.setAdapter( adapter );


        adapter.notifyDataSetChanged();

    }

    public static RecyclerView getRecyclerViewConfig(RecyclerView recyclerView, Context context, boolean nested_scrollview)
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        if (!nested_scrollview)
        {
            recyclerView.setNestedScrollingEnabled(false);
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return recyclerView;
    }
}

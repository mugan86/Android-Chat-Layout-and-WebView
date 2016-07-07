package anartzmuxika.chatmessagelayoutapp.model;

import android.text.Html;
import android.text.Spanned;

/******************************************
 * Created by anartzmugika on 7/7/16.
 *
 * Manage messages in this object in
 * channel Recycler View
 ******************************************/

public class Message {

    public Spanned getMessageContent() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) return Html.fromHtml(getContent(),0);
        return Html.fromHtml(getContent());
    }

    public String getContent()
    {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    private String content;

    public Message(String content)
    {
        setContent(content);
    }

}

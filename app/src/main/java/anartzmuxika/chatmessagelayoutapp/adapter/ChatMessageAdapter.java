package anartzmuxika.chatmessagelayoutapp.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import anartzmuxika.chatmessagelayoutapp.model.Message;
import anartzmuxika.chatmessagelayoutapp.R;


/*****************************************************
 * Created by Anartz Muxika on 7/7/16.
 *****************************************************/

public class ChatMessageAdapter
        extends RecyclerView.Adapter<ChatMessageAdapter.ChatMessageAdapterViewHolder>
        implements View.OnClickListener {

    private View.OnClickListener listener;
    private ArrayList<Message> datos;
    private static Activity activity;


    public static class ChatMessageAdapterViewHolder
            extends RecyclerView.ViewHolder {

        private TextView text_message_contentTextView;

        private ImageView profileImageView;


        public ChatMessageAdapterViewHolder(View itemView)
        {
            super(itemView);

            //Initialize components

            text_message_contentTextView = (TextView) itemView.findViewById(R.id.text_message_contentTextView);
            profileImageView = (ImageView) itemView.findViewById(R.id.profileImageView);
        }

        public void bindMessage(final Message message) {

            //Add Spanned text type
            text_message_contentTextView.setText(message.getMessageContent());

            //Active to use html individual links to redirect
            text_message_contentTextView.setMovementMethod(LinkMovementMethod.getInstance());
            text_message_contentTextView.setLinksClickable(true);
            text_message_contentTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public ChatMessageAdapter(ArrayList<Message> datos, Activity activity) {
        this.datos = datos;
        this.activity = activity;
        System.out.println("Total items: " + this.datos.size());
    }

    @Override
    public ChatMessageAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_message, viewGroup, false);

        itemView.setOnClickListener(this);
        ChatMessageAdapterViewHolder tvh = new ChatMessageAdapterViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(ChatMessageAdapterViewHolder viewHolder, int pos) {
        Message item = datos.get(pos);

        viewHolder.bindMessage(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }

}
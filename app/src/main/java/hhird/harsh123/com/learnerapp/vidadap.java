package hhird.harsh123.com.learnerapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.List;

public class vidadap extends RecyclerView.Adapter<vidadap.VideoViewHolder> {

    List<ytvid>ytvidList;

    public vidadap(){

    }

    public vidadap(List<ytvid>ytvidList)
    {
        this.ytvidList=ytvidList;
    }


    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent,int ViewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_view,parent,false);
        return new VideoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder,int position){
        holder.videoweb.loadData(ytvidList.get(position).getVidurl(),"text/html","utf-8");
    }

    @Override
    public int getItemCount(){return ytvidList.size();}

    public class VideoViewHolder extends RecyclerView.ViewHolder{
     WebView videoweb;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            videoweb=(WebView)itemView.findViewById(R.id.vwv);
            videoweb.getSettings().setJavaScriptEnabled(true);
            videoweb.setWebChromeClient(new WebChromeClient());

        }
    }
}

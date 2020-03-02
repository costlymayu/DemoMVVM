package com.example.myapplication.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.api.MyApi;
import com.example.myapplication.api.MyClient;
import com.example.myapplication.model.MyList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyListViewModel extends ViewModel {
    public String id="";
    public String artistname="";
    public String artistimage="";
    public String moviename="";
    public MutableLiveData<ArrayList<MyListViewModel>> mutableLiveData=new MutableLiveData<>();
    private ArrayList<MyListViewModel>arrayList;
    //private UserReposin userReposin;
    private ArrayList<MyList>myList;
    public String getImageurl(){
        return artistimage;
    }

    @BindingAdapter({"imageUrl"})
    public static void loadimage(ImageView imageView, String imageUrl){
        Glide.with(imageView.getContext()).load(imageUrl).apply(RequestOptions.circleCropTransform()).into(imageView);
        //Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    public MyListViewModel(){

    }

    public MyListViewModel(MyList myList){
        this.id=myList.id;
        this.artistname=myList.artistname;
        this.artistimage=myList.artistimage;
        this.moviename=myList.moviename;
    }

    public MutableLiveData<ArrayList<MyListViewModel>> getMutableLiveData() {

        arrayList=new ArrayList<>();

        MyApi api= MyClient.getInstance().getMyApi();
        Call<ArrayList<MyList>> call=api.getartistdata();
        call.enqueue(new Callback<ArrayList<MyList>>() {
            @Override
            public void onResponse(Call<ArrayList<MyList>> call, Response<ArrayList<MyList>> response) {
                myList=new ArrayList<>();
                myList=response.body();
                for (int i=0; i<myList.size(); i++){
                    MyList myk=myList.get(i);
                    MyListViewModel myListViewModel=new MyListViewModel(myk);
                    arrayList.add(myListViewModel);
                    mutableLiveData.setValue(arrayList);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<MyList>> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}

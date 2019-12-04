package com.wpam.sob.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.wpam.sob.MainActivity;
import com.wpam.sob.R;
import com.wpam.sob.model.StackOverflowRepository;
import com.wpam.sob.room.IssueEntity;
import com.wpam.sob.stackoverflow.Issue;
import com.wpam.sob.stackoverflow.StackOverflowSearchResponse;
import com.wpam.sob.view.issues.IssuesAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    private IssuesAdapter issuesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView penguinsRecycleView = view.findViewById(R.id.penguins_recycle_view);
        issuesAdapter = new IssuesAdapter();
        penguinsRecycleView.setAdapter(issuesAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        StackOverflowRepository stackOverflowRepository = new StackOverflowRepository();
        stackOverflowRepository.search("Kotlin",
                new Callback<StackOverflowSearchResponse>() {
                    @Override
                    public void onResponse(Call<StackOverflowSearchResponse> call, Response<StackOverflowSearchResponse> response) {
                        Log.d("callback", "Gotrespmce");
                        Log.d("callback", "size: " + response.body().getItems());
                        issuesAdapter.updateIssues(response.body().getItems());
                    }

                    @Override
                    public void onFailure(Call<StackOverflowSearchResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}



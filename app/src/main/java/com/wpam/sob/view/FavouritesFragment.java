package com.wpam.sob.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

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

public class FavouritesFragment extends Fragment {

    private IssuesAdapter issuesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();

        RecyclerView penguinsRecycleView = view.findViewById(R.id.penguins_recycle_view);
        issuesAdapter = new IssuesAdapter();
        penguinsRecycleView.setAdapter(issuesAdapter);

//        List<IssueEntity> issueEntities = MainActivity.appDatabase.issueDao().getAll();
//        List<Issue> issues = new ArrayList<>();
//        issueEntities.forEach(issueEntity -> issues.add(new Issue(issueEntity)));
//        issuesAdapter.updateIssues(issues);
    }

    @Override
    public void onResume() {
        super.onResume();
        List<IssueEntity> issueEntities = MainActivity.appDatabase.issueDao().getAll();
        List<Issue> issues = new ArrayList<>();
        issueEntities.forEach(issueEntity -> issues.add(new Issue(issueEntity)));
        issuesAdapter.updateIssues(issues);
    }
}



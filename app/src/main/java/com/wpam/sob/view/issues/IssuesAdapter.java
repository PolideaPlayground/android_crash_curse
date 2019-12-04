package com.wpam.sob.view.issues;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wpam.sob.R;
import com.wpam.sob.stackoverflow.Issue;

import java.util.ArrayList;
import java.util.List;

public class IssuesAdapter extends RecyclerView.Adapter<IssueViewHolder> {

    private List<Issue> issues = new ArrayList<>();

    public IssuesAdapter() {
    }

    @NonNull
    @Override
    public IssueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IssueViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.penguin, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IssueViewHolder holder, int position) {
        holder.bind(issues.get(position));
    }

    @Override
    public int getItemCount() {
        return issues.size();
    }

    public void updateIssues(List<Issue> issues) {
        this.issues = issues;
        notifyDataSetChanged();
    }
}

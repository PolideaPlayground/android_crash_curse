package com.wpam.sob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wpam.sob.model.PenguinsRepository;
import com.wpam.sob.model.StackOverflowRepository;
import com.wpam.sob.stackoverflow.Issue;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView penguinsRecycleView = findViewById(R.id.penguins_recycle_view);
        IssuesAdapter issuesAdapter = new IssuesAdapter();
        penguinsRecycleView.setAdapter(issuesAdapter);

        StackOverflowRepository stackOverflowRepository = new StackOverflowRepository();
        try {
            issuesAdapter.updateIssues(stackOverflowRepository.search("Kotlin"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class IssueViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public IssueViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text);
    }

}

class IssuesAdapter extends RecyclerView.Adapter<IssueViewHolder> {

    private List<Issue> issues;

    public IssuesAdapter() {
    }

    @NonNull
    @Override
    public IssueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IssueViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.penguin, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IssueViewHolder holder, int position) {
        holder.textView.setText(issues.get(position).getTitle());

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

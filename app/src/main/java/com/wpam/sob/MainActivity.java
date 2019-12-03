package com.wpam.sob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wpam.sob.model.PenguinsRepository;
import com.wpam.sob.model.StackOverflowRepository;
import com.wpam.sob.stackoverflow.Issue;
import com.wpam.sob.stackoverflow.StackOverflowSearchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
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

class IssueViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    TextView score;
    TextView userName;
    TextView answerCount;

    public IssueViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        score = itemView.findViewById(R.id.score);
        userName = itemView.findViewById(R.id.user_name);
        answerCount = itemView.findViewById(R.id.answers_count);
    }

}

class IssuesAdapter extends RecyclerView.Adapter<IssueViewHolder> {

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
        holder.title.setText(issues.get(position).getTitle());
        holder.answerCount.setText(issues.get(position).getAnswerCount() + "");
        holder.score.setText(issues.get(position).getScore() + "");
        holder.userName.setText(issues.get(position).getOwner().getName());

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

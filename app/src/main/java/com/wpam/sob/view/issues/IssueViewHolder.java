package com.wpam.sob.view.issues;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.wpam.sob.MainActivity;
import com.wpam.sob.R;
import com.wpam.sob.room.IssueEntity;
import com.wpam.sob.stackoverflow.Issue;

public class IssueViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    TextView score;
    TextView userName;
    TextView answerCount;
    ImageView imageView;
    Button saveButton;

    public IssueViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        score = itemView.findViewById(R.id.score);
        userName = itemView.findViewById(R.id.user_name);
        answerCount = itemView.findViewById(R.id.answers_count);
        imageView = itemView.findViewById(R.id.avatar);
        saveButton = itemView.findViewById(R.id.save_button);
    }

    public void bind(Issue issue) {
        title.setText(issue.getTitle());
        answerCount.setText(issue.getAnswerCount() + "");
        score.setText(issue.getScore() + "");
        userName.setText(issue.getOwner().getName());
        Picasso.get().load(issue.getOwner().getAvatarUrl()).into(imageView);
        IssueEntity issueEntity = MainActivity.appDatabase.issueDao().findByQuestionId(issue.getQuestionId());
        markAsSaved(issueEntity != null);
        saveButton.setOnClickListener(createIssueSavingListener(issue));
    }

    private View.OnClickListener createIssueSavingListener(Issue issue) {
        return v -> {
            IssueEntity issueEntity = MainActivity.appDatabase.issueDao().findByQuestionId(issue.getQuestionId());
            markAsSaved(issueEntity == null);
            if (issueEntity != null) {
                MainActivity.appDatabase.issueDao().delete(issueEntity);
            } else {
                MainActivity.appDatabase.issueDao().insertAll(new IssueEntity(issue));
            }
        };
    }

    private void markAsSaved(boolean isSaved) {
        if (isSaved) {
            saveButton.setText("SAVED");
        } else {
            saveButton.setText("Save");
        }
    }



}

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView penguinsRecycleView = findViewById(R.id.penguins_recycle_view);
        penguinsRecycleView.setAdapter(new PenguinsAdapter(new PenguinsRepository()));
    }
}

class PenguinViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public PenguinViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text);
    }

}

class PenguinsAdapter extends RecyclerView.Adapter<PenguinViewHolder> {

    private PenguinsRepository penguinsRepository;

    public PenguinsAdapter(PenguinsRepository penguinsRepository) {
        this.penguinsRepository = penguinsRepository;
    }

    @NonNull
    @Override
    public PenguinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PenguinViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.penguin, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PenguinViewHolder holder, int position) {
        holder.textView.setText(penguinsRepository.get(position));

    }

    @Override
    public int getItemCount() {
        return penguinsRepository.getCount();
    }
}
